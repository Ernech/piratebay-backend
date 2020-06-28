package com.ernesto.backend.bl;

import com.ernesto.backend.dao.WarehouseDao;
import com.ernesto.backend.model.MovieModel;
import com.ernesto.backend.model.WarehouseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WarehouseBI {

    private WarehouseDao warehouseDao;

    @Autowired
    public WarehouseBI (WarehouseDao warehouseDao) { this.warehouseDao = warehouseDao; }

    public ArrayList<WarehouseModel> selectAllWarehouses(){
        return this.warehouseDao.selectAllWarehouses();
    }
}
