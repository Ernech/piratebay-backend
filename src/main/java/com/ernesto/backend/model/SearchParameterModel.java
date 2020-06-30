package com.ernesto.backend.model;

public class SearchParameterModel {

    private Integer warehouseId;
    private String searchParameter;

    public SearchParameterModel() {
    }

    public SearchParameterModel(Integer warehouseId, String searchParameter) {
        this.warehouseId = warehouseId;
        this.searchParameter = searchParameter;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getSearchParameter() {
        return searchParameter;
    }

    public void setSearchParameter(String searchParameter) {
        this.searchParameter = searchParameter;
    }

    @Override
    public String toString() {
        return "SearchParameterModel{" +
                "warehouseId=" + warehouseId +
                ", searchParameter='" + searchParameter + '\'' +
                '}';
    }
}
