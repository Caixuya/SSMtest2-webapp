package com.thxy.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.thxy.pojo.User;

public interface UserMapper {

	//接口
	
	public User findUserById(@Param("id") Integer id);
	
	public List<User> selectAllUser();
	
////	public int insertUser(User user);
	public void insertUser(User user);
	
//	public int delete(Integer id);
	public void deleteUser(@Param("id") Integer id);
	
//	public int updateUser(User user);
//  public void updateUser(@Param("userName")String userName);
	public void updateUser(@Param("userName")String userName,@Param("id") int id);
	
}
