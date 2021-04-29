package com.sample;


public class Users {

    private String userId;
    private String accessToken;
    private java.sql.Timestamp accessExpiration;
    private String refreshToken;
    private java.sql.Timestamp refreshExpiration;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }


    public java.sql.Timestamp getAccessExpiration() {
        return accessExpiration;
    }

    public void setAccessExpiration(java.sql.Timestamp accessExpiration) {
        this.accessExpiration = accessExpiration;
    }


    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }


    public java.sql.Timestamp getRefreshExpiration() {
        return refreshExpiration;
    }

    public void setRefreshExpiration(java.sql.Timestamp refreshExpiration) {
        this.refreshExpiration = refreshExpiration;
    }

}
