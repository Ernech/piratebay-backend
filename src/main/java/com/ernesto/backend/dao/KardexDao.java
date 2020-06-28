package com.ernesto.backend.dao;

import com.ernesto.backend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

@Service
public class KardexDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public KardexDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public KardexInformationModel returnKardexInformationByMovie (int warehouseId, int productId) {
        //Implementamos SQL variable binding para evitar SQL injection
        String query = "SELECT prod.product_code, prod.product_name, prod.format, wrh.warehouse_address, prov.provider_name\n" +
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
                        "  AND prod.product_id = ? \n" +
                        "GROUP BY prod.product_code, prod.product_name, prod.format, wrh.warehouse_address, prov.provider_name;";

        KardexInformationModel information = null;
        try {
            information = (KardexInformationModel) jdbcTemplate.queryForObject(query, new Object[]{warehouseId, productId}, new RowMapper<KardexInformationModel>() {
                @Override
                public KardexInformationModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new KardexInformationModel(resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5));
                }
            });

        } catch (Exception e) {
            throw new RuntimeException();
        }
        return information;
    }

    public ArrayList<KardexModel> returnKardexByMovie (int warehouseId, int productId) {
        //Implementamos SQL variable binding para evitar SQL injection
        String query = "SELECT ord.date_received, ord.concept, ord.receipt, prod_or.unit_price as ValorUnitario,\n" +
                        "       prod_or.qtty_received as EntradaCantidad, prod_or.unit_price*prod_or.qtty_received as EntradaValor,\n" +
                        "       SUM(prod_or.qtty_received) over (order by ord.date_received) as SaldoCantidad,\n" +
                        "       SUM(prod_or.unit_price*prod_or.qtty_received) over (order by ord.date_received) as SaldoValor\n" +
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
                        "  AND prod.product_id = ? \n" +
                        "  AND prod_or.qtty_received is not Null \n" +
                        "GROUP BY ord.date_received, ord.concept, ord.receipt, prod_or.unit_price, prod_or.qtty_received\n" +
                        "ORDER BY ord.date_received;";

        ArrayList<KardexModel> kardex = null;
        try {
            kardex = (ArrayList<KardexModel>) jdbcTemplate.query(query, new Object[]{warehouseId, productId}, new RowMapper<KardexModel>() {
                @Override
                public KardexModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new KardexModel(resultSet.getDate(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDouble(4),
                            resultSet.getInt(5),
                            resultSet.getDouble(6),
                            resultSet.getInt(7),
                            resultSet.getDouble(8));
                }
            });

        } catch (Exception e) {
            System.out.println("error: "+e);
            throw new RuntimeException();
        }
        return kardex;
    }

    public Integer updateQttyReceivedByMovie (int qttyReceived, int providerProductId) {
        //Implementamos SQL variable binding para evitar SQL injection
        String query = "UPDATE product_order SET qtty_received = ? where provider_product_id = ?;";

        Integer orderUpdated = null;
        try {
            //orderUpdated = jdbcTemplate.queryForObject(query,new Object[]{qttyReceived, providerProductId},Integer.class);
            orderUpdated = jdbcTemplate.update(query, new Object[]{qttyReceived, providerProductId}, new int[] {Types.INTEGER, Types.INTEGER});

        } catch (Exception e) {
            System.out.print(e);
            //throw new RuntimeException();
        }
        return orderUpdated;
    }
}
