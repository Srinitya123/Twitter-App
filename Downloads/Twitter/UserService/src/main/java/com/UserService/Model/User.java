package com.UserService.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "UserInfo")
public class User {
	
	@Id
	private String userName;
	
	@NotBlank(message="This field is Mandatory")
	private String firstName;
	
	@NotBlank(message="This field is Mandatory")
	private String lastName;
	
	@NotBlank(message="This field is Mandatory")
	private String email;
	
	@NotBlank(message="This field is Mandatory")
	private String contactNumber;
	
	@NotBlank(message="This field is Mandatory")
	private String password;
	
	@NotBlank(message="This field is Mandatory")
	private String confirmPassword;
	
	

}
