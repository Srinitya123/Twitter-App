package com.UserService.Service;

import java.util.List;



import com.UserService.Model.User;


public interface ServiceInterface {
	
	boolean addUser(User user);
	public List<User> getAllUser();
	User findUserByUsername(String firstName);
	boolean forgetPassword(String userName,String password);
}
