import com.google.gson.Gson;
import com.smartcar.sdk.AuthClient;
import com.smartcar.sdk.Vehicle;
import com.smartcar.sdk.data.*;

import java.util.ArrayList;

import static spark.Spark.get;
import static spark.Spark.port;

public class Alpha {
    // global variable to save our accessToken
    private static String access;
    private static Gson gson = new Gson();

    private static ArrayList<User> userdb = new ArrayList<>();

    public static void main(String[] args) {

        port(8000);

        String clientId = "031";
        String clientSecret = "fa2";
        String redirectUri = "http://localhost:8000/callback";
        String[] scope = {"required:read_vehicle_info"};
        boolean testMode = false;

        AuthClient client = new AuthClient(
                clientId,
                clientSecret,
                redirectUri,
                scope,
                testMode
        );


        get("/login", (req, res) -> {
            AuthClient.AuthUrlBuilder link = client.authUrlBuilder();
            res.redirect(link.build());
            return null;
        });

        get("/callback", (req, res) -> {
            String code = req.queryMap("code").value();

            Auth auth = client.exchangeCode(code);

            // in a production app you'll want to store this in some kind of persistent storage
            access = auth.getAccessToken();

            String response = client.getUserId(access);

            User user = new User(response, access);
            userdb.add(user);

            for (User theUser : userdb) {
                System.out.println(theUser.toString());
            }

            return "Thank you for registering!";
        });

        get("/vehicle", (req, res) -> {

            SmartcarResponse<VehicleIds> vehicleIdResponse = AuthClient.getVehicleIds(access);
            // the list of vehicle ids
            String[] vehicleIds = vehicleIdResponse.getData().getVehicleIds();

            // instantiate the first vehicle in the vehicle id list

            Vehicle vehicle = new Vehicle(vehicleIds[0], access);

            VehicleInfo info = vehicle.info();

            System.out.println(gson.toJson(info));

            res.type("application/json");

            return gson.toJson(info);
        });

        get("/vehicles", (req, res) -> {
            String bla = "";
            for (User theUser : userdb) {
                SmartcarResponse<VehicleIds> vehicleIdResponse = AuthClient.getVehicleIds(theUser.getToken());
                // the list of vehicle ids
                String[] vehicleIds = vehicleIdResponse.getData().getVehicleIds();
                // instantiate the first vehicle in the vehicle id list
                for (String v : vehicleIds) {
                    Vehicle vehicle = new Vehicle(v, theUser.getToken());
                    VehicleInfo info = vehicle.info();
                    bla = bla + gson.toJson(info);
                    System.out.println(gson.toJson(info));
                }
            }

            res.type("application/json");

            return bla;
        });

    }

}
