package com.ernesto.backend.model;

public class UpdateQttyModel {

    private Integer qttyReceived;
    private Integer providerProductId;

    public UpdateQttyModel() {
    }

    public UpdateQttyModel(Integer qttyReceived, Integer providerProductId) {
        this.qttyReceived = qttyReceived;
        this.providerProductId = providerProductId;
    }

    public Integer getQttyReceived() {
        return qttyReceived;
    }

    public void setQttyReceived(Integer qttyReceived) {
        this.qttyReceived = qttyReceived;
    }

    public Integer getProviderProductId() {
        return providerProductId;
    }

    public void setProviderProductId(Integer providerProductId) {
        this.providerProductId = providerProductId;
    }

    @Override
    public String toString() {
        return "UpdateQttyModel{" +
                "qttyReceived=" + qttyReceived +
                ", providerProductId=" + providerProductId +
                '}';
    }
}
