package bw.practise.ang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bw.practise.ang.bean.User;
import bw.practise.ang.mapper.UserMapper;
import bw.practise.ang.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
	
	@Resource
	private UserMapper userMapper;

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User LoginUI(String phone, String password) {
		// TODO Auto-generated method stub
		List<User> userList = userMapper.LoginUI(phone,password);
		if(userList!=null&&userList.size()>0){
			return userList.get(0);
		}
         return null;
		
	}

	@Override
	public List<User> searchTalbe() {
		// TODO Auto-generated method stub
		  List<User> list=userMapper.searchTable();
		return list;
	}

	@Override
	public void insertUser(String user_name, String password) {
		  User user=new User();
		  user.setName(user_name);
		  user.setPassword(password);
		  userMapper.insertUser(user);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getUserByName(String user_name) {
		// TODO Auto-generated method stub
		return userMapper.findUserByName("user_name");
	}


}
