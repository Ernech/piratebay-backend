package com.ernesto.backend.dao;

import com.ernesto.backend.model.KardexInformationModel;
import com.ernesto.backend.model.KardexModel;
import com.ernesto.backend.model.MovieModel;
import com.ernesto.backend.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class MovieDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArrayList<MovieModel> selectMoviesFromWarehouse (int warehouseId){
        //Implementamos SQL variable binding para evitar SQL injection
        String query = "SELECT prod.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name, sum(prod_or.qtty_received)\n" +
                        "FROM product prod JOIN product_order prod_or\n" +
                        "                       on prod.product_id = prod_or.product_id\n" +
                        "                  JOIN \"order\" ord on ord.order_id = prod_or.order_id\n" +
                        "                  JOIN provider prov on prov.provider_id = ord.provider_id\n" +
                        "                  JOIN warehouse wrh on wrh.warehouse_id = ord.warehouse_id\n" +
                        "WHERE prod.status = 1\n" +
                        "  AND prod_or.status = 1\n" +
                        "  AND ord.status = 1\n" +
                        "  AND prov.status = 1\n" +
                        "  AND wrh.status = 1\n" +
                        "  AND wrh.warehouse_id = ? \n" +
                        "GROUP BY prod.product_id, prod_or.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name\n" +
                        "ORDER BY prod.product_name;";

        ArrayList<MovieModel> movies = null;
        try{
            movies = (ArrayList<MovieModel>) jdbcTemplate.query(query, new Object[]{warehouseId}, new RowMapper<MovieModel>(){
                @Override
                public MovieModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new MovieModel(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDate(5),
                            resultSet.getString(6),
                            resultSet.getInt(7));
                }
            });
        }catch (Exception e){
            throw new RuntimeException();
        }
        return movies;
    }

    public ArrayList<MovieModel> searchMoviesByName (int warehouseId, String searchParameter){
        //Implementamos SQL variable binding para evitar SQL injection
        String query = "SELECT prod.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name, sum(prod_or.qtty_received)\n" +
                        "FROM product prod JOIN product_order prod_or\n" +
                        "                       on prod.product_id = prod_or.product_id\n" +
                        "                  JOIN \"order\" ord on ord.order_id = prod_or.order_id\n" +
                        "                  JOIN provider prov on prov.provider_id = ord.provider_id\n" +
                        "                  JOIN warehouse wrh on wrh.warehouse_id = ord.warehouse_id\n" +
                        "WHERE prod.status = 1\n" +
                        "  AND prod_or.status = 1\n" +
                        "  AND ord.status = 1\n" +
                        "  AND prov.status = 1\n" +
                        "  AND wrh.status = 1\n" +
                        "  AND wrh.warehouse_id = ? \n" +
                        "  AND UPPER(prod.product_name) like UPPER('%' || ? || '%')\n" +
                        "GROUP BY prod.product_id, prod_or.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name\n" +
                        "ORDER BY product_name;";

        ArrayList<MovieModel> movies = null;
        try{
            movies = (ArrayList<MovieModel>) jdbcTemplate.query(query, new Object[]{warehouseId, searchParameter}, new RowMapper<MovieModel>(){
                @Override
                public MovieModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new MovieModel(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDate(5),
                            resultSet.getString(6),
                            resultSet.getInt(7));
                }
            });

        }catch (Exception e){
            throw new RuntimeException();
        }
        return movies;
    }

    public ArrayList<MovieModel> searchAndSortMovies (int warehouseId, String searchParameter, String sortParameter){
        //Implementamos SQL variable binding para evitar SQL injection
        String query = null;
        if ("qtty_received".equals(sortParameter)){
            query = "SELECT prod.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name, sum(prod_or.qtty_received)\n" +
                    "FROM product prod JOIN product_order prod_or\n" +
                    "                       on prod.product_id = prod_or.product_id\n" +
                    "                  JOIN \"order\" ord on ord.order_id = prod_or.order_id\n" +
                    "                  JOIN provider prov on prov.provider_id = ord.provider_id\n" +
                    "                  JOIN warehouse wrh on wrh.warehouse_id = ord.warehouse_id\n" +
                    "WHERE prod.status = 1\n" +
                    "  AND prod_or.status = 1\n" +
                    "  AND ord.status = 1\n" +
                    "  AND prov.status = 1\n" +
                    "  AND wrh.status = 1\n" +
                    "  AND wrh.warehouse_id = ? \n" +
                    "  AND UPPER(prod.product_name) like UPPER('%' || ? || '%')\n" +
                    "GROUP BY prod.product_id, prod_or.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name\n" +
                    "ORDER BY SUM("+sortParameter+") ASC; ";
        } else {
            query = "SELECT prod.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name, sum(prod_or.qtty_received)\n" +
                    "FROM product prod JOIN product_order prod_or\n" +
                    "                       on prod.product_id = prod_or.product_id\n" +
                    "                  JOIN \"order\" ord on ord.order_id = prod_or.order_id\n" +
                    "                  JOIN provider prov on prov.provider_id = ord.provider_id\n" +
                    "                  JOIN warehouse wrh on wrh.warehouse_id = ord.warehouse_id\n" +
                    "WHERE prod.status = 1\n" +
                    "  AND prod_or.status = 1\n" +
                    "  AND ord.status = 1\n" +
                    "  AND prov.status = 1\n" +
                    "  AND wrh.status = 1\n" +
                    "  AND wrh.warehouse_id = ? \n" +
                    "  AND UPPER(prod.product_name) like UPPER('%' || ? || '%')\n" +
                    "GROUP BY prod.product_id, prod_or.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name\n" +
                    "ORDER BY "+sortParameter+" ASC; ";
        }

        ArrayList<MovieModel> movies = null;
        try{
            movies = (ArrayList<MovieModel>) jdbcTemplate.query(query, new Object[]{warehouseId, searchParameter}, new RowMapper<MovieModel>(){
                @Override
                public MovieModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new MovieModel(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDate(5),
                            resultSet.getString(6),
                            resultSet.getInt(7));
                }
            });

        }catch (Exception e){
            throw new RuntimeException();
        }
        return movies;
    }

    public ArrayList<MovieModel> sortMoviesByParameter (int warehouseId, String sortParameter){
        //Implementamos SQL variable binding para evitar SQL injection
        String query = null;
        if("qtty_received".equals(sortParameter)){
            query = "SELECT prod.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name, sum(prod_or.qtty_received)\n" +
                    "FROM product prod JOIN product_order prod_or\n" +
                    "                       on prod.product_id = prod_or.product_id\n" +
                    "                  JOIN \"order\" ord on ord.order_id = prod_or.order_id\n" +
                    "                  JOIN provider prov on prov.provider_id = ord.provider_id\n" +
                    "                  JOIN warehouse wrh on wrh.warehouse_id = ord.warehouse_id\n" +
                    "WHERE prod.status = 1\n" +
                    "  AND prod_or.status = 1\n" +
                    "  AND ord.status = 1\n" +
                    "  AND prov.status = 1\n" +
                    "  AND wrh.status = 1\n" +
                    "  AND wrh.warehouse_id = ? \n" +
                    "GROUP BY prod.product_id, prod_or.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name\n" +
                    "ORDER BY SUM("+sortParameter+") ASC; ";
        } else {
            query = "SELECT prod.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name, sum(prod_or.qtty_received)\n" +
                    "FROM product prod JOIN product_order prod_or\n" +
                    "                       on prod.product_id = prod_or.product_id\n" +
                    "                  JOIN \"order\" ord on ord.order_id = prod_or.order_id\n" +
                    "                  JOIN provider prov on prov.provider_id = ord.provider_id\n" +
                    "                  JOIN warehouse wrh on wrh.warehouse_id = ord.warehouse_id\n" +
                    "WHERE prod.status = 1\n" +
                    "  AND prod_or.status = 1\n" +
                    "  AND ord.status = 1\n" +
                    "  AND prov.status = 1\n" +
                    "  AND wrh.status = 1\n" +
                    "  AND wrh.warehouse_id = ? \n" +
                    "GROUP BY prod.product_id, prod_or.product_id, prod.product_code, prod.product_name, prod.format, prod.creation_date, prov.provider_name\n" +
                    "ORDER BY "+sortParameter+" ASC; ";
        }

        ArrayList<MovieModel> movies = null;
        try{
            movies = (ArrayList<MovieModel>) jdbcTemplate.query(query, new Object[]{warehouseId}, new RowMapper<MovieModel>(){
                @Override
                public MovieModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new MovieModel(resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDate(5),
                            resultSet.getString(6),
                            resultSet.getInt(7));
                }
            });

        }catch (Exception e){
            throw new RuntimeException();
        }
        return movies;
    }
}
