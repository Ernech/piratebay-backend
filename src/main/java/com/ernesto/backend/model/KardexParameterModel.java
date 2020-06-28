package com.ernesto.backend.model;

public class KardexParameterModel {

    private String warehouse;
    private Integer parameter;

    public KardexParameterModel() {
    }

    public KardexParameterModel(String warehouse, Integer parameter) {
        this.warehouse = warehouse;
        this.parameter = parameter;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public Integer getParameter() {
        return parameter;
    }

    public void setParameter(Integer parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        return "KardexParameterModel{" +
                "warehouse='" + warehouse + '\'' +
                ", parameter=" + parameter +
                '}';
    }
}
