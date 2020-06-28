package com.ernesto.backend.model;

public class SortParameterModel {

    private Integer warehouseId;
    private String sortParameter;

    public SortParameterModel() {
    }

    public SortParameterModel(Integer warehouseId, String sortParameter) {
        this.warehouseId = warehouseId;
        this.sortParameter = sortParameter;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getSortParameter() {
        return sortParameter;
    }

    public void setSortParameter(String sortParameter) {
        this.sortParameter = sortParameter;
    }

    @Override
    public String toString() {
        return "SortParameterModel{" +
                "warehouseId=" + warehouseId +
                ", sortParameter='" + sortParameter + '\'' +
                '}';
    }
}
