package com.ernesto.backend.model;

public class ParameterModel {

    private String parameter;
    private String warehouse;

    public ParameterModel() {
    }

    public ParameterModel(String parameter, String warehouse) {
        this.parameter = parameter;
        this.warehouse = warehouse;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "ParameterModel{" +
                "parameter='" + parameter + '\'' +
                ", warehouse='" + warehouse + '\'' +
                '}';
    }
}
