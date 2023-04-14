package com.TweetService.Controller;

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

import com.TweetService.Model.Reply;
import com.TweetService.Model.Tweet;
import com.TweetService.Service.TweetService;

@RestController
@RequestMapping("/api/v1.0/tweets")
public class Controller {

	@Autowired
	private TweetService tweetService; // object creation

	@GetMapping("/test")
	public String test() {
		return "Application Running";
	}

	@GetMapping("/all")
	public List<Tweet> getAllTweetsOfUsers() {
		return tweetService.getAllTweets();
	}

	@PostMapping("/{userName}/add")
	public String registerTweet(@PathVariable String userName, @RequestBody Tweet tweet) {
		return tweetService.addTweet(userName, tweet);
	}

	@DeleteMapping("/{userName}/delete/{tweetId}")
	public String deleteTweetOfUser(@PathVariable String userName, @PathVariable int tweetId) {
		return tweetService.deleteTweet(userName, tweetId);
	}

	@PutMapping("/{userName}/update/{tweetId}")
	public String UpdateTweet(@PathVariable String userName, @PathVariable int tweetId, @RequestBody Tweet tweet) {
		if (tweetService.UpdateTweet(userName, tweetId, tweet) == false)
			return "Tweet updation failed";
		return "Tweet updated successfully";

	}

	@GetMapping("/{userName}")
	public List<Tweet> tweetsByUser(@PathVariable String userName) {
		return tweetService.getAllTweetsOfUser(userName);

	}

	@GetMapping("/{userName}/like/{tweetId}")
	public String likeTweetOfUser(@PathVariable String userName, @PathVariable int tweetId) {
		return tweetService.likeTweet(userName, tweetId);
	}

	@PostMapping("/{username}/reply/{tweetId}")
	public String replyUserTweet(@PathVariable int tweetId, @PathVariable("username") String userName,
			@RequestBody Reply reply) {
		if (tweetService.replyTweet(tweetId, userName, reply) == false) {
			return "Tweet Not Found";
		}
		return "Reply added";

	}

	@GetMapping("/replies/{tweetId}")
	public List<String> repliesOfUserTweet(@PathVariable int tweetId){
	List<String> replies=tweetService.seeRepliesOfTweet(tweetId);
	if(replies.isEmpty())
	{
		replies.add("Wrong Tweet Id or no replies available for the Tweet");
	}
	return replies;
}
}
