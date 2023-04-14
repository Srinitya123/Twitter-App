package com.TweetService.Service;

import java.util.List;

import com.TweetService.Model.Reply;
import com.TweetService.Model.Tweet;

public interface TweetService {
	
	String addTweet(String userName,Tweet tweet);
	
	List<Tweet> getAllTweets();
	String deleteTweet(String userName,int tweetId);
    boolean UpdateTweet(String userName, int tweetId,Tweet tweet);
    List<Tweet> getAllTweetsOfUser(String userName);
    String likeTweet(String userName,int tweetId);

	boolean replyTweet(int tweetId, String userName, Reply reply);
	List<String> seeRepliesOfTweet(int tweetId);
    
}
