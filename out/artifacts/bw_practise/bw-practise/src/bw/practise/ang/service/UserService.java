package bw.practise.ang.service;

import java.util.List;

import bw.practise.ang.bean.User;

public interface UserService {

	//public List<User> findUserByIdService(int user_id);

	 User LoginUI(String phone, String password);

	 List<User> searchTalbe();

	 void insertUser(String user_name, String password);

	 Integer getUserByName(String user_name);

}
