package com.UserService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.UserService.FeignController.FeignService;
import com.UserService.Model.Reply;
import com.UserService.Model.Tweet;
import com.UserService.Model.User;
import com.UserService.Service.ServiceInterface;

@RestController
@RequestMapping("/api/v1.0/tweets")
public class UserController {
	
	@Autowired
	private ServiceInterface serviceInterface;
	
	@Autowired
	private FeignService feignService;
	
	@GetMapping("/test")
	public String test()
	{
		return "Application running";
	}
	
	@PostMapping("/register")
	public String registerUser(@RequestBody User user)
	{
		
		if(serviceInterface.addUser(user)==false)
		{
			return "User Not registered";
		}
		else
		{
			return "User registered successfully";
		}
	}
	
	@GetMapping("/users/all")
	public List<User> getAllUser(){
		
		return serviceInterface.getAllUser();
	}
	
	
	@GetMapping("/byName/{userName}")
    public User findByUsername(@PathVariable("userName") String userName){
		
	
       return serviceInterface.findUserByUsername(userName);
	}
	
	@PutMapping("/{userName}/forgot")
	public String changeUserPassword(@PathVariable String userName,@RequestBody String password)
	{
		if(serviceInterface.forgetPassword(userName, password))
			{
			return "Password Changed";
			}
		return "User Not Found";
	}
	
	
	@GetMapping("/all")
	public List<Tweet> getAllTweets()
	{
		return feignService.getAllTweetsOfUsers();
	}
	
	@PostMapping("/{userName}/add")
	public String registerTheTweet(@PathVariable String userName,@RequestBody Tweet tweet)
	{
		return feignService.registerTweet(userName,tweet);
	}
	
	@DeleteMapping("/{userName}/delete/{tweetId}")
	public String deleteTweet(@PathVariable String userName, @PathVariable int tweetId)
	{
		return feignService.deleteTweetOfUser(userName, tweetId);
	}
	
	@PutMapping("/{userName}/update/{tweetId}")
	public String UpdateTweetsOfUser(@PathVariable String userName, @PathVariable int tweetId, @RequestBody Tweet tweet)
	{
		return feignService.UpdateTweet(userName, tweetId, tweet);
	}
	
	@GetMapping("/{userName}")
	public List<Tweet> tweetsOfUser(@PathVariable String userName)
	{
		return feignService.tweetsByUser(userName);
	}
	
	@GetMapping("/{userName}/like/{tweetId}")
	public String likeTweet(@PathVariable String userName, @PathVariable int tweetId)
	{
		return feignService.likeTweetOfUser(userName, tweetId);
	}
	
	@PostMapping("/{userName}/reply/{tweetId}")
	public String replyToTweet(@PathVariable("tweetId") int tweetId,@PathVariable("userName") String userName,@RequestBody Reply reply)
	{
		return feignService.replyUserTweet(tweetId, userName, reply);
	}
	
	@GetMapping("/replies/{tweetId}")
	public List<String> repliesUserTweet(@PathVariable int tweetId)
	{
		return feignService.repliesOfUserTweet(tweetId);
	}
}
