package com.ernesto.backend.bl;

import com.ernesto.backend.dao.MovieDao;
import com.ernesto.backend.model.KardexInformationModel;
import com.ernesto.backend.model.MovieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieBl {

    private MovieDao movieDao;

    @Autowired
    public MovieBl(MovieDao movieDao){
        this.movieDao = movieDao;
    }

    public ArrayList<MovieModel> selectMoviesFromWarehouse(Integer warehouseId){
        return this.movieDao.selectMoviesFromWarehouse(warehouseId);
    }

    public ArrayList<MovieModel> searchMoviesByParameter(String warehouse, String parameter){
        return this.movieDao.searchMoviesByParameter(warehouse, parameter);
    }

    public ArrayList<MovieModel> orderMoviesByParameter(String warehouse, String parameter){
        return this.movieDao.orderMoviesByParameter(warehouse, parameter);
    }
}
