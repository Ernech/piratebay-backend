package com.ernesto.backend.model;

import java.sql.Date;

public class OrderModel {

    private Integer orderId;
    private String providerName;
    private Date dateRequested;
    private String receipt;
    private String concept;
    private Integer productId;
    private String productName;
    private Double unitPrice;
    private Integer qttyRequested;
    private Integer qttyCommit;

    public OrderModel() {
    }

    public OrderModel(Integer orderId, String providerName, Date dateRequested, String receipt, String concept, Integer productId, String productName, Double unitPrice, Integer qttyRequested, Integer qttyCommit) {
        this.orderId = orderId;
        this.providerName = providerName;
        this.dateRequested = dateRequested;
        this.receipt = receipt;
        this.concept = concept;
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.qttyRequested = qttyRequested;
        this.qttyCommit = qttyCommit;
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

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQttyRequested() {
        return qttyRequested;
    }

    public void setQttyRequested(Integer qttyRequested) {
        this.qttyRequested = qttyRequested;
    }

    public Integer getQttyCommit() {
        return qttyCommit;
    }

    public void setQttyCommit(Integer qttyCommit) {
        this.qttyCommit = qttyCommit;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "orderId=" + orderId +
                ", providerName='" + providerName + '\'' +
                ", dateRequested=" + dateRequested +
                ", receipt='" + receipt + '\'' +
                ", concept='" + concept + '\'' +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", unitPrice=" + unitPrice +
                ", qttyRequested=" + qttyRequested +
                ", qttyCommit=" + qttyCommit +
                '}';
    }
}
