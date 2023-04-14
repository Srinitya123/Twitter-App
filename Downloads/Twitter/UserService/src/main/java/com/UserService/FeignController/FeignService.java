package com.UserService.FeignController;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.UserService.Model.Reply;
import com.UserService.Model.Tweet;


@FeignClient(value="client",url="http://localhost:8125/api/v1.0/tweets") //annotation
public interface FeignService {

//create FeignService interface and copy past all the rest end points from the twitter service but without the body
	
	
	@GetMapping("/test")
	public String test();
	
	@GetMapping("/all")
	public List<Tweet> getAllTweetsOfUsers();
	
	@PostMapping("/{userName}/add")
	public String registerTweet(@PathVariable String userName, @RequestBody Tweet tweet);

	@DeleteMapping("/{userName}/delete/{tweetId}")
	public String deleteTweetOfUser(@PathVariable String userName, @PathVariable int tweetId);
	
	@PutMapping("/{userName}/update/{tweetId}")
	public String UpdateTweet(@PathVariable String userName, @PathVariable int tweetId, @RequestBody Tweet tweet);

	@GetMapping("/{userName}")
	public List<Tweet> tweetsByUser(@PathVariable String userName);

	@GetMapping("/{userName}/like/{tweetId}")
	public String likeTweetOfUser(@PathVariable String userName, @PathVariable int tweetId);

	@PostMapping("/{userName}/reply/{tweetId}")
	public String replyUserTweet(@PathVariable("tweetId") int tweetId,@PathVariable("userName") String userName,@RequestBody Reply reply);
	
	@GetMapping("/replies/{tweetId}")
	public List<String> repliesOfUserTweet(@PathVariable int tweetId);
}
