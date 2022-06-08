package com.works.domain;

public class Flight {
    private Integer flightID;
    private String flightNum;
    private String departure;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private Integer firstClassPrice;
    private Integer businessClassPrice;
    private Integer economyClassPrice;
    private Integer firstClassNum;
    private Integer businessClassNum;
    private Integer economyClassNum;

    public Integer getFlightID() {
        return flightID;
    }

    public void setFlightID(Integer flightID) {
        this.flightID = flightID;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
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

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getFirstClassPrice() {
        return firstClassPrice;
    }

    public void setFirstClassPrice(Integer firstClassPrice) {
        this.firstClassPrice = firstClassPrice;
    }

    public Integer getBusinessClassPrice() {
        return businessClassPrice;
    }

    public void setBusinessClassPrice(Integer businessClassPrice) {
        this.businessClassPrice = businessClassPrice;
    }

    public Integer getEconomyClassPrice() {
        return economyClassPrice;
    }

    public void setEconomyClassPrice(Integer economyClassPrice) {
        this.economyClassPrice = economyClassPrice;
    }

    public Integer getFirstClassNum() {
        return firstClassNum;
    }

    public void setFirstClassNum(Integer firstClassNum) {
        this.firstClassNum = firstClassNum;
    }

    public Integer getBusinessClassNum() {
        return businessClassNum;
    }

    public void setBusinessClassNum(Integer businessClassNum) {
        this.businessClassNum = businessClassNum;
    }

    public Integer getEconomyClassNum() {
        return economyClassNum;
    }

    public void setEconomyClassNum(Integer economyClassNum) {
        this.economyClassNum = economyClassNum;
    }
}
