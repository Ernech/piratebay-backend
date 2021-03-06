package com.ernesto.backend.model;

public class KardexParameterModel {

    private Integer warehouseId;
    private Integer productId;

    public KardexParameterModel() {
    }

    public KardexParameterModel(Integer warehouseId, Integer productId) {
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
        return "KardexParameterModel{" +
                "warehouseId=" + warehouseId +
                ", productId=" + productId +
                '}';
    }
}
