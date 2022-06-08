package com.works.dao;

import com.works.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminDao {

    @Select("select * from admin where adminUsrName=#{adminUsrName}")
    public Admin FindAdminByName(String adminUsrName);
}
