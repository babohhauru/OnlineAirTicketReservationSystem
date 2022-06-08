package com.works.dao;

import com.works.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user where username=#{username}")
    public User FindUserByUsername(String username);

    @Select("select * from user where phone=#{phone}")
    public User FindUserByPhone(String phone);

    @Select("select * from user where email=#{email}")
    public User FindUserByEmail(String email);

    @Delete("delete from user where id=#{id}")
    public int deleteUserById(Integer id);

    @Insert("insert into user(username,password,Phone,email) values(#{username},#{password},#{Phone},#{email})")
    public void saveUser(User user);

}
