package com.ernesto.backend.model;

public class SearchParameterModel {

    private Integer warehouseId;
    private String searchParameter;
    private String orderParameter;

    public SearchParameterModel() {
    }

    public SearchParameterModel(Integer warehouseId, String searchParameter, String orderParameter) {
        this.warehouseId = warehouseId;
        this.searchParameter = searchParameter;
        this.orderParameter = orderParameter;
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

    public String getOrderParameter() {
        return orderParameter;
    }

    public void setOrderParameter(String orderParameter) {
        this.orderParameter = orderParameter;
    }

    @Override
    public String toString() {
        return "SearchParameterModel{" +
                "warehouseId=" + warehouseId +
                ", searchParameter='" + searchParameter + '\'' +
                ", orderParameter='" + orderParameter + '\'' +
                '}';
    }
}
