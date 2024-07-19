package com.vanlang.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Accounts")
public class Account implements Serializable {

	@Id
	@NotBlank(message = "User name empty")
	String username;
	@NotBlank(message = "Password empty")
	@Size(min = 3, max = 12, message = "Password must be between 3 and 12 characters")
	String password;
	@NotBlank(message = "Name not empty")
	String fullname;
	@NotBlank(message = "Email not empty")
	@Email(message = "Email malformed")
	String email;
	String photo;
	String token;
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;

	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<Authority> authorities;
	@Override
	public String toString() {
		return "{username=" + username + ", password=" + password + "}";
	}
	
}