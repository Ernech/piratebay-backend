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

    public ArrayList<MovieModel> searchMoviesByName(Integer warehouseId, String searchParameter){
        return this.movieDao.searchMoviesByName(warehouseId, searchParameter);
    }

    public ArrayList<MovieModel> searchAndSortMovies(Integer warehouseId, String searchParameter, String sortParameter){
        return this.movieDao.searchAndSortMovies(warehouseId, searchParameter, sortParameter);
    }

    public ArrayList<MovieModel> sortMoviesByParameter(Integer warehouseId, String sortParameter){
        return this.movieDao.sortMoviesByParameter(warehouseId, sortParameter);
    }

}
