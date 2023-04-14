package com.UserService.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import org.hibernate.annotations.CreationTimestamp;

//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Like {

	@Id
	@GeneratedValue
	private int likeId;
	
	private Integer tweetId;
	
	private String userNameWhoLiked;
	
	@CreationTimestamp
	@Column(nullable = false, updatable = false)
	private Date timeStamp;
	
	public Like(int tweetId , String userNameWhoLiked) 
	{
		super();
		this.tweetId=tweetId;
		this.userNameWhoLiked=userNameWhoLiked;
	}
	
	
}
