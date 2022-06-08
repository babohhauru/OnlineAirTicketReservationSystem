package com.works.dao;

import com.works.domain.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDao {

    @Select("select * from orders")
    public List<Order> findAll();

    @Insert("insert into orders (flightNum,username,userID,orderDate,flightClass,phone,flightPrice,flightID,id) VALUES" +
            "(#{flightNum},#{username},#{userID},#{orderDate},#{flightClass},#{phone},#{flightPrice},#{flightID},#{id})")
    public int saveOrder(Order order);

    @Select("select * from orders where username=#{userName}")
    public List<Order> findByUserName(String username);

    @Select("select * from orders where orderID=#{orderID}")
    public Order findByUserOrderId(Integer orderID);

    @Delete("DELETE FROM `orders` WHERE `orderID`=#{orderID}")
    public int returnFlight(Integer orderID);

    @Delete("DELETE FROM orders WHERE orderID=#{orderID}")
    public void deleteOrder(Integer orderID);
}

