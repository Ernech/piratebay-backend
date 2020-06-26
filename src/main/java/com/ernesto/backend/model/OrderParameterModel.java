package com.ernesto.backend.model;

public class OrderParameterModel {

    private String orderParameter;
    private String warehouse;

    public OrderParameterModel() {
    }

    public OrderParameterModel(String orderParameter, String warehouse) {
        this.orderParameter = orderParameter;
        this.warehouse = warehouse;
    }

    public String getOrderParameter() {
        return orderParameter;
    }

    public void setOrderParameter(String orderParameter) {
        this.orderParameter = orderParameter;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "OrderParameterModel{" +
                "orderParameter='" + orderParameter + '\'' +
                ", warehouse='" + warehouse + '\'' +
                '}';
    }
}
