package com.ernesto.backend.model;

import java.sql.Date;

public class OrderModel {

    private Integer orderId;
    private String providerName;
    private Date dateReceived;
    private Date dateRequested;
    private String receipt;
    private Integer qttyOrdered;
    private Integer qttyCommit;
    private Integer qttyReceived;

    public OrderModel() {
    }

    public OrderModel(Integer orderId, String providerName, Date dateReceived, Date dateRequested, String receipt, Integer qttyOrdered, Integer qttyCommit) {
        this.orderId = orderId;
        this.providerName = providerName;
        this.dateReceived = dateReceived;
        this.dateRequested = dateRequested;
        this.receipt = receipt;
        this.qttyOrdered = qttyOrdered;
        this.qttyCommit = qttyCommit;
    }

    public OrderModel(Integer orderId, String providerName, Date dateReceived, Date dateRequested, String receipt, Integer qttyOrdered, Integer qttyCommit, Integer qttyReceived) {
        this.orderId = orderId;
        this.providerName = providerName;
        this.dateReceived = dateReceived;
        this.dateRequested = dateRequested;
        this.receipt = receipt;
        this.qttyOrdered = qttyOrdered;
        this.qttyCommit = qttyCommit;
        this.qttyReceived = qttyReceived;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Date getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(Date dateRequested) {
        this.dateRequested = dateRequested;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public Integer getQttyOrdered() {
        return qttyOrdered;
    }

    public void setQttyOrdered(Integer qttyOrdered) {
        this.qttyOrdered = qttyOrdered;
    }

    public Integer getQttyCommit() {
        return qttyCommit;
    }

    public void setQttyCommit(Integer qttyCommit) {
        this.qttyCommit = qttyCommit;
    }

    public Integer getQttyReceived() {
        return qttyReceived;
    }

    public void setQttyReceived(Integer qttyReceived) {
        this.qttyReceived = qttyReceived;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "orderId=" + orderId +
                ", providerName='" + providerName + '\'' +
                ", dateReceived=" + dateReceived +
                ", dateRequested=" + dateRequested +
                ", receipt='" + receipt + '\'' +
                ", qttyOrdered=" + qttyOrdered +
                ", qttyCommit=" + qttyCommit +
                ", qttyReceived=" + qttyReceived +
                '}';
    }
}
