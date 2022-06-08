package com.works.domain;

public class Order {

   private Integer orderID;
   private Integer id;
   private String flightNum;
   private String username;
   private String userID;
   private String orderDate;
   private String flightClass;
   private String phone;
   private String departure;
   private String destination;
   private Integer flightPrice;
   private Integer flightID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlightID() {
        return flightID;
    }

    public void setFlightID(Integer flightID) {
        this.flightID = flightID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(Integer flightPrice) {
        this.flightPrice = flightPrice;
    }



    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", id=" + id +
                ", flightNum='" + flightNum + '\'' +
                ", username='" + username + '\'' +
                ", userID='" + userID + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", flightClass='" + flightClass + '\'' +
                ", phone='" + phone + '\'' +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", flightPrice=" + flightPrice +
                ", flightID=" + flightID +
                '}';
    }
}
