package com.ernesto.backend.model;

public class KardexParameterModel {

    private Integer warehouseId;
    private Integer parameter;

    public KardexParameterModel() {
    }

    public KardexParameterModel(Integer warehouseId, Integer parameter) {
        this.warehouseId = warehouseId;
        this.parameter = parameter;
    }

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
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
