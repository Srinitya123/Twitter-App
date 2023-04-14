package com.TweetService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TweetService.Model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
	
	List<Reply> findByTweetId(int tweetId);
	void deleteByTweetId(int tweetId);
	
}
