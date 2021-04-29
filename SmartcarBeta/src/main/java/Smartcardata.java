package com.sample;


public class Smartcardata {

  private String userId;
  private String vehicleId;
  private java.sql.Timestamp actualdatetime;
  private java.sql.Timestamp pulldatetime;
  private long capacity;
  private double percentRemaining;
  private double range;
  private long isPluggedIn;
  private String state;
  private double latitude;
  private double longitude;
  private double odometer;
  private String make;
  private String model;
  private long year;
  private String vin;


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(String vehicleId) {
    this.vehicleId = vehicleId;
  }


  public java.sql.Timestamp getActualdatetime() {
    return actualdatetime;
  }

  public void setActualdatetime(java.sql.Timestamp actualdatetime) {
    this.actualdatetime = actualdatetime;
  }


  public java.sql.Timestamp getPulldatetime() {
    return pulldatetime;
  }

  public void setPulldatetime(java.sql.Timestamp pulldatetime) {
    this.pulldatetime = pulldatetime;
  }


  public long getCapacity() {
    return capacity;
  }

  public void setCapacity(long capacity) {
    this.capacity = capacity;
  }


  public double getPercentRemaining() {
    return percentRemaining;
  }

  public void setPercentRemaining(double percentRemaining) {
    this.percentRemaining = percentRemaining;
  }


  public double getRange() {
    return range;
  }

  public void setRange(double range) {
    this.range = range;
  }


  public long getIsPluggedIn() {
    return isPluggedIn;
  }

  public void setIsPluggedIn(long isPluggedIn) {
    this.isPluggedIn = isPluggedIn;
  }


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }


  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }


  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }


  public double getOdometer() {
    return odometer;
  }

  public void setOdometer(double odometer) {
    this.odometer = odometer;
  }


  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }


  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }


  public long getYear() {
    return year;
  }

  public void setYear(long year) {
    this.year = year;
  }


  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

}
