package com.ernesto.backend.bl;

import com.ernesto.backend.dao.KardexDao;
import com.ernesto.backend.dao.MovieDao;
import com.ernesto.backend.model.KardexInformationModel;
import com.ernesto.backend.model.KardexModel;
import com.ernesto.backend.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class KardexBl {

    private KardexDao kardexDao;

    @Autowired
    public KardexBl(KardexDao kardexDao){
        this.kardexDao = kardexDao;
    }

    public KardexInformationModel returnKardexInformationByMovie (int warehouseId, int productId){
        return this.kardexDao.returnKardexInformationByMovie(warehouseId, productId);
    }

    public ArrayList<KardexModel> returnKardexByMovie (int warehouseId, int productId){
        return this.kardexDao.returnKardexByMovie(warehouseId, productId);
    }
}

