package com.ernesto.backend.model;

public class KardexParameterModel {

    private Integer warehouseId;
    private Integer parameter;

    public KardexParameterModel() {
    }

    public KardexParameterModel(int warehouseId, Integer parameter) {
        this.warehouseId = warehouseId;
        this.parameter = parameter;
    }

    public Integer getWarehouse() {
        return warehouseId;
    }

    public void setWarehouse(Integer warehouseId) {
        this.warehouseId = warehouseId;
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
                "warehouse='" + warehouseId + '\'' +
                ", parameter=" + parameter +
                '}';
    }
}
