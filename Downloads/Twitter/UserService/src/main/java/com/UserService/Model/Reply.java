package com.UserService.Model;

import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



public class Reply {
	
	@Id
	@GeneratedValue
	private int replyId;
	
	private int tweetId;
	private String userNameOfTweet;
	private String userNameOfReplyTweet;
	
	@Column(length = 144)
	private String replyMessage;
	
	@Column(length = 50)
	private String replyTag;
	
	@CreationTimestamp
	@Column(nullable = false,updatable = false)
	private Date replyTime;

	public int getTweetId() {
		return tweetId;
	}

	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}

	public String getUserNameOfTweet() {
		return userNameOfTweet;
	}

	public void setUserNameOfTweet(String userNameOfTweet) {
		this.userNameOfTweet = userNameOfTweet;
	}

	public String getUserNameOfReplyTweet() {
		return userNameOfReplyTweet;
	}

	public void setUserNameOfReplyTweet(String userNameOfReplyTweet) {
		this.userNameOfReplyTweet = userNameOfReplyTweet;
	}

	public String getReplyMessage() {
		return replyMessage;
	}

	public void setReplyMessage(String replyMessage) {
		this.replyMessage = replyMessage;
	}

	public String getReplyTag() {
		return replyTag;
	}

	public void setReplyTag(String replyTag) {
		this.replyTag = replyTag;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public Reply(int tweetId, String userNameOfTweet, String userNameOfReplyTweet, String replyMessage,
			String replyTag, Date replyTime) {
		super();
		this.tweetId = tweetId;
		this.userNameOfTweet = userNameOfTweet;
		this.userNameOfReplyTweet = userNameOfReplyTweet;
		this.replyMessage = replyMessage;
		this.replyTag = replyTag;
		this.replyTime = replyTime;
	}

	public Reply() {
		
	}
	

}
