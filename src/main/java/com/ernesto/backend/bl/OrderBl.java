package com.ernesto.backend.bl;

import com.ernesto.backend.dao.OrderDao;
import com.ernesto.backend.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderBl {

    private OrderDao orderDao;

    @Autowired
    public OrderBl (OrderDao orderDao) { this.orderDao = orderDao;}

    public ArrayList<OrderModel> returnNotReceivedOrders (int warehouseId, int productId){
        return this.orderDao.returnOrdersByMovie(warehouseId, productId);
    }
}
