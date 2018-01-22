package bw.practise.ang.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import bw.practise.ang.bean.User;

public interface UserMapper {
	
	public List<User> findUserById(@Param("paramMap") Map<String, Object> paramMap);

	public List<User> searchTable();

	public void insertUser(@Param("paramMap") User user);

	public Integer findUserByName(@Param("user_name") String user_name);

	/*
	 * 
	 * 登录验证
	 * 
	 * */

	public List<User> LoginUI(@Param("phone") String phone, @Param("password")String password);

}
