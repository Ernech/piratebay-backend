package com.ernesto.backend.dao;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ernesto.backend.model.KardexParameterModel;
import com.ernesto.backend.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class OrderDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ArrayList<OrderModel> returnOrdersByMovie (int warehouseId, int productId) {
        //Implementamos SQL variable binding para evitar SQL injection
        String query = "SELECT ord.order_id, prov.provider_name, ord.date_requested, ord.date_received, ord.receipt,\n" +
                "       prod_or.qtty_requested, prod_or.qtty_commit\n" +
                "FROM product prod JOIN product_order prod_or\n" +
                "                       on prod.product_id = prod_or.product_id\n" +
                "                  JOIN \"order\" ord on ord.order_id = prod_or.order_id\n" +
                "                  JOIN provider prov on prov.provider_id = ord.provider_id\n" +
                "                  JOIN warehouse wrh on wrh.warehouse_id = ord.warehouse_id\n" +
                "                  JOIN \"user\" usr on usr.user_id = ord.order_user_id\n" +
                "WHERE prod.status = 1\n" +
                "  AND prod_or.status = 1\n" +
                "  AND ord.status = 1\n" +
                "  AND prov.status = 1\n" +
                "  AND wrh.status = 1\n" +
                "  AND prod_or.qtty_received is Null\n" +
                "  AND wrh.warehouse_id = ? \n" +
                "  AND prod.product_id = ? \n" +
                "GROUP BY ord.order_id, prov.provider_name, ord.date_requested, ord.date_received, ord.receipt,\n" +
                "         prod_or.qtty_requested, prod_or.qtty_commit;";

        ArrayList<OrderModel> orders = null;
        try {
            orders = (ArrayList<OrderModel>) jdbcTemplate.query(query, new Object[]{warehouseId, productId},
                    new RowMapper<OrderModel>() {
                        @Override
                        public OrderModel mapRow(ResultSet resultSet, int i) throws SQLException {
                            return new OrderModel(resultSet.getInt(1),
                                    resultSet.getString(2),
                                    resultSet.getDate(3),
                                    resultSet.getDate(4),
                                    resultSet.getString(5),
                                    resultSet.getInt(6),
                                    resultSet.getInt(7));
                        }
                    });

        } catch (Exception e) {
            throw new RuntimeException();
        }
        return orders;
    }
}

