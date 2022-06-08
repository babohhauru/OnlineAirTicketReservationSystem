package com.works.mapper;

import com.works.domain.Flight;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FlightMapper {

    @Select("select * from flight")
    public List<Flight> findAll();

    @Select("select * from flight where flightID=#{flightID}")
    public Flight findAllById(Integer flightID);

    @Select("select * from flight where flightNum=#{flightNum}")
    public Flight findAllByFlightNum(String flightNum);

    @Delete("delete from flight where flightID=#{flightID}")
    public void deleteFlight(Integer flightID);

    @Insert("insert into flight(flightNum,departure,destination,departureTime,arrivalTime,firstClassPrice,businessClassPrice,economyClassPrice,firstClassNum,businessClassNum,economyClassNum) " +
            "values(#{flightNum},#{departure},#{destination},#{departureTime},#{arrivalTime},#{firstClassPrice},#{businessClassPrice},#{economyClassPrice},#{firstClassNum},#{businessClassNum},#{economyClassNum})")
    public void saveFlight(Flight flight);

    @Update("UPDATE flight SET firstClassNum=#{firstClassNum},businessClassNum=#{businessClassNum},economyClassNum=#{economyClassNum} " +
            "WHERE flightID=#{flightID}")
    public void updateByFlightClass(Flight flight);
}
