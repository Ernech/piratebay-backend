package com.ernesto.backend.bl;

import com.ernesto.backend.dao.MovieDao;
import com.ernesto.backend.model.MovieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovieBl {

    private MovieDao movieDao;

    @Autowired
    public MovieBl(MovieDao movieDao){
        this.movieDao=movieDao;
    }

    public ArrayList<MovieModel> selectMoviesFromWarehouse(String warehouse){
        return this.movieDao.selectMoviesFromWarehouse(warehouse);
    }
}
