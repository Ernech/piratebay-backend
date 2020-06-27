package com.ernesto.backend.bl;

import com.ernesto.backend.dao.KardexDao;
import com.ernesto.backend.dao.MovieDao;
import com.ernesto.backend.model.KardexInformationModel;
import com.ernesto.backend.model.KardexModel;
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

    public ArrayList<KardexInformationModel> returnKardexInformationByMovie (String warehouse, String parameter){
        return this.kardexDao.returnKardexInformationByMovie(warehouse, parameter);
    }

    public ArrayList<KardexModel> returnKardexModelByMovie (String warehouse, String parameter){
        return this.kardexDao.returnKardexModelByMovie(warehouse, parameter);
    }
}
