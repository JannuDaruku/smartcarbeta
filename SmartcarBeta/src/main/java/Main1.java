import static spark.Spark.*;

import com.google.gson.Gson;
import com.smartcar.sdk.*;
import com.smartcar.sdk.data.*;

public class Main {
    // global variable to save our accessToken
    private static String access;
    private static Gson gson = new Gson();

    public static void main(String[] args) {

        port(8000);

        String clientId = "0";
        String clientSecret = "fa2";
        String redirectUri = "http://localhost:8000/callback";
        String[] scope = {"required:read_vehicle_info"};
        boolean testMode = true;

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

            // {
            //   "id": "36ab27d0-fd9d-4455-823a-ce30af709ffc",
            //   "make": "TESLA",
            //   "model": "Model S",
            //   "year": 2014
            // }

            res.type("application/json");

            return gson.toJson(info);
        });

        get("/vehicles", (req, res) -> {
            SmartcarResponse<VehicleIds> vehicleIdResponse = AuthClient.getVehicleIds(access);
            // the list of vehicle ids
            String[] vehicleIds = vehicleIdResponse.getData().getVehicleIds();

            String bla = "";
            // instantiate the first vehicle in the vehicle id list
            for (String v : vehicleIds) {
                Vehicle vehicle = new Vehicle(v, access);
                VehicleInfo info = vehicle.info();
                bla = bla + gson.toJson(info);
                System.out.println(gson.toJson(info));
            }


            res.type("application/json");

            return bla;
        });

    }
}
