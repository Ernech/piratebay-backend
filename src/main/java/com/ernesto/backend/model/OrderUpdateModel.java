package com.ernesto.backend.model;

import java.sql.Date;
import java.util.ArrayList;

public class OrderUpdateModel {

    private Date dateRequested;
    private Integer orderId;
    private Integer qttyReceived;
    private Integer providerProductId;

    public OrderUpdateModel() {
    }

    public OrderUpdateModel(Date dateRequested, Integer orderId, Integer qttyReceived, Integer providerProductId) {
        this.dateRequested = dateRequested;
        this.orderId = orderId;
        this.qttyReceived = qttyReceived;
        this.providerProductId = providerProductId;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
        return "OrderUpdateModel{" +
                "dateRequested=" + dateRequested +
                ", orderId=" + orderId +
                ", qttyReceived=" + qttyReceived +
                ", providerProductId=" + providerProductId +
                '}';
    }
}
