package com.TweetService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TweetService.Model.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Integer> {
                                                     //<object, dataType>
	Tweet findBytweetId(int tweetId);
	List<Tweet> findByUserName(String userName);
}
