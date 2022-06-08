package com.works.mapper;

import com.works.domain.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {

    @Select("select * from admin where adminUsrName=#{adminUsrName}")
    public Admin FindAdminByName(String adminUsrName);
}
