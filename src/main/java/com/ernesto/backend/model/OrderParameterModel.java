package com.ernesto.backend.model;

public class OrderParameterModel {

    private Integer warehouseId;
    private Integer productId;

    public OrderParameterModel() {
    }

    public OrderParameterModel(Integer warehouseId, Integer productId) {
        this.warehouseId = warehouseId;
        this.productId = productId;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "OrderParameterModel{" +
                "warehouseId=" + warehouseId +
                ", productId=" + productId +
                '}';
    }
}
