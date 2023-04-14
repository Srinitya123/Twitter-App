package com.TweetService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TweetService.Model.Like;
import com.TweetService.Model.Reply;
import com.TweetService.Model.Tweet;
import com.TweetService.Repository.LikeRepository;
import com.TweetService.Repository.ReplyRepository;
import com.TweetService.Repository.TweetRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TweetServiceImpl implements TweetService {

	// All methods in the Implementation class are always public

	@Autowired
	private TweetRepository tweetRepository; // object creation

	@Autowired
	private LikeRepository likeRepository;

	@Autowired
	private ReplyRepository replyRepository;

	// Overriding all the methods

	@Override
	public String addTweet(String userName, Tweet tweet) {
		System.out.println("username= " + tweet.getUserName());
		tweet.setUserName(userName);
		tweetRepository.save(tweet);
		return "Tweet saved successfully";
	}

	@Override
	public List<Tweet> getAllTweets() {

		return tweetRepository.findAll();
	}

	@Override
	public String deleteTweet(String userName, int tweetId) {

		Tweet tweet = tweetRepository.findBytweetId(tweetId);
		if (tweet == null)
			return "tweet not found ";
		if (tweet.getUserName().equals(userName) != true)
			return "user not found";
		tweetRepository.deleteById(tweetId);
		if(likeRepository.findByTweetId(tweetId)!=null)
		{
			likeRepository.deleteByTweetId(tweetId);
		}
		
		if(replyRepository.findByTweetId(tweetId)!=null)
		{
			replyRepository.deleteByTweetId(tweetId);
		}

		return "Tweet deleted";
	}

	@Override
	public boolean UpdateTweet(String userName, int tweetId, Tweet tweet) {

		if (tweetRepository.findBytweetId(tweetId) == null)
			return false;
		if (tweetRepository.findBytweetId(tweetId).getUserName().equals(userName) != true)
			return false;
		tweet.setTweetId(tweetId);
		tweet.setUserName(userName);
		tweetRepository.save(tweet);

		return true;

	}

	@Override
	public List<Tweet> getAllTweetsOfUser(String userName) {

		return tweetRepository.findByUserName(userName);
	}

	@Override
	public String likeTweet(String userName, int tweetId) {

		Tweet tweet = tweetRepository.findBytweetId(tweetId);
		if (tweet == null)
			return "Tweet Not found";
		List<Like> like = likeRepository.findByTweetId(tweetId);
		for (Like l : like) {
			if (l.getUserNameWhoLiked().equals(userName))
				return "Already Liked the tweet";
		}
		Like likeobj = new Like(tweetId, userName);
		likeRepository.save(likeobj);
		tweet.setLikes(tweet.getLikes() + 1);
		tweetRepository.save(tweet);

		return "Tweet Liked Successfully";
	}

	@Override
	public boolean replyTweet(int tweetId, String userName, Reply reply) {
		Tweet tweet = tweetRepository.findBytweetId(tweetId);
		if (tweet == null)
			return false;

		reply.setUserNameOfTweet(tweet.getUserName());
		reply.setUserNameOfReplyTweet(userName);
		reply.setTweetId(tweetId);
		replyRepository.save(reply);

		return true;

	}

	
	@Override
	public List<String> seeRepliesOfTweet(int tweetId) {
		List<String> replies = new ArrayList<>();
		Tweet tweet = tweetRepository.findBytweetId(tweetId);
		List<Reply> reply = replyRepository.findByTweetId(tweetId);
		if (reply.isEmpty()) {
			return replies;
		}

		replies.add("Tweet ID- " + tweetId);
		replies.add("Username of original tweet- " + tweet.getUserName());
		replies.add("Original Tweet- " + tweet.getMessage());
		if (tweet.getTag() != null)
			replies.add("Original tag- " + tweet.getTag());
		replies.add("Time uploaded- " + tweet.getPostTimeStamp());
		for (Reply t : reply) {
			replies.add("Reply username- " + t.getUserNameOfReplyTweet());
			replies.add("Reply Message- " + t.getReplyMessage());
			if (t.getReplyTag() != null)
				replies.add("Reply Tag- " + t.getReplyTag());
			replies.add("Reply Time- " + t.getReplyTime());
		}
		return replies;
	}

}
