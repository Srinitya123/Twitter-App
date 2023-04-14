package com.TweetService.Model;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Tweet")
public class Tweet {
 
	// All entities in this class are always private
	@Id
	@GeneratedValue
	private int tweetId;
	
	private String userName;
	
	@Column(length = 50)
	private String tag;
	
	@Column(length = 144)
	private String message;
	
	@CreationTimestamp
	@Column(nullable = false ,updatable = false)
	private Date postTimeStamp;
	
	@UpdateTimestamp
	private Date updateTimeStamp;
	
	private int likes=0;
	
	
	
	
}
