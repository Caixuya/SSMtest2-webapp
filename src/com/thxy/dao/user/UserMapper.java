package com.thxy.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thxy.pojo.User;

public interface UserMapper {

	//接口
	
	public User findUserById(@Param("id") Integer id);
	public List<User> findByName(String name);
	public int add(User user);
	public int delete(Integer id);
	public int update(User user);
	
}
