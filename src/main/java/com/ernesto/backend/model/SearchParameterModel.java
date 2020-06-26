package com.ernesto.backend.model;

public class SearchParameterModel {

    private String searchParameter;
    private String warehouse;

    public SearchParameterModel() {
    }

    public SearchParameterModel(String searchParameter, String warehouse) {
        this.searchParameter = searchParameter;
        this.warehouse = warehouse;
    }

    public String getSearchParameter() {
        return searchParameter;
    }

    public void setSearchParameter(String searchParameter) {
        this.searchParameter = searchParameter;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "SearchParameterModel{" +
                "searchParameter='" + searchParameter + '\'' +
                ", warehouse='" + warehouse + '\'' +
                '}';
    }
}
