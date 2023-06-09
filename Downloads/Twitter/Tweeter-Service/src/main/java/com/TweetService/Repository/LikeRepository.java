package com.TweetService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TweetService.Model.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Integer>{
	List<Like> findByTweetId(int tweetId);
	void deleteByTweetId(int tweetId);
}
