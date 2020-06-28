package com.ernesto.backend.dao;

import com.ernesto.backend.model.MovieModel;
import com.ernesto.backend.model.WarehouseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class WarehouseDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public WarehouseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArrayList<WarehouseModel> selectAllWarehouses (){
        String query = "SELECT wrh.warehouse_id, wrh.warehouse_name\n" +
                "FROM warehouse wrh\n" +
                "  WHERE wrh.status = 1\n" +
                "GROUP BY wrh.warehouse_id, wrh.warehouse_name;";

        ArrayList<WarehouseModel> warehouses = null;
        try{
            warehouses = (ArrayList<WarehouseModel>) jdbcTemplate.query(query, new RowMapper<WarehouseModel>(){
                @Override
                public WarehouseModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new WarehouseModel(resultSet.getInt(1),
                            resultSet.getString(2));
                }
            });
        }catch (Exception e){
            throw new RuntimeException();
        }
        return warehouses;
    }
}
