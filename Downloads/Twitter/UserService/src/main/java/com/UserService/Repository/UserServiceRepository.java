package com.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UserService.Model.User;

@Repository
public interface UserServiceRepository extends JpaRepository<User, String>{
	// press Ctrl and hover over the keyword you want to understand more
	//you can read the Declaration/ Implementation of those methods

	User findByUserName(String userName);

}
