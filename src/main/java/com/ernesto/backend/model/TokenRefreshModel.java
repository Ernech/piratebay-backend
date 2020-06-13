package com.ernesto.backend.model;

public class TokenRefreshModel {
    private String refreshToken;

    public TokenRefreshModel(){

    }
    public TokenRefreshModel(String refreshModel) {
        this.refreshToken = refreshModel;
    }

    public String getRefreshModel() {
        return refreshToken;
    }

    public void setRefreshModel(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        return "TokenRefreshModel{" +
                "refreshModel='" + refreshToken + '\'' +
                '}';
    }
}
