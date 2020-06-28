package com.ernesto.backend.model;

public class SearchSortParameterModel {

    private Integer warehouseId;
    private String searchParameter;
    private String sortParameter;

    public SearchSortParameterModel() {
    }

    public SearchSortParameterModel(Integer warehouseId, String searchParameter, String sortParameter) {
        this.warehouseId = warehouseId;
        this.searchParameter = searchParameter;
        this.sortParameter = sortParameter;
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

    public String getSortParameter() {
        return sortParameter;
    }

    public void setSortParameter(String sortParameter) {
        this.sortParameter = sortParameter;
    }

    @Override
    public String toString() {
        return "SearchParameterModel{" +
                "warehouseId=" + warehouseId +
                ", searchParameter='" + searchParameter + '\'' +
                ", sortParameter='" + sortParameter + '\'' +
                '}';
    }
}
