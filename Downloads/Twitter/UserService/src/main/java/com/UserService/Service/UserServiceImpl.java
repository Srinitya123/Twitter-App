package com.UserService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserService.Model.User;
import com.UserService.Repository.UserServiceRepository;

@Service
public class UserServiceImpl implements ServiceInterface {

	@Autowired
	private UserServiceRepository userServiceRepository; //object creation
	
	@Override
	public boolean addUser(User user) {
		if(user.getPassword().equalsIgnoreCase(user.getConfirmPassword())!=true)
		{
			return false;
		}
		userServiceRepository.save(user);
		return true;
	}
	

	@Override
	public List<User> getAllUser(){
		List<User> user= userServiceRepository.findAll();
		return user;
			
	}
	
	@Override
	public User findUserByUsername(String userName){
		User user = userServiceRepository.findByUserName(userName);
		if(user == null)
			System.out.println("User Not found");
		return user;
		
	}

	@Override
	public boolean forgetPassword(String userName, String password) {
		User user = userServiceRepository.findByUserName(userName);
		if(user==null)
		{
			return false;
		}
		user.setPassword(password);
		userServiceRepository.save(user);
		return true;
	}
 }