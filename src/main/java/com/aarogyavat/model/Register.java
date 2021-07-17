package com.aarogyavat.model;

import lombok.Data;

@Data
public class Register {

	private String username;
	private String email;
	private String password;
	private String confirmPass;
	private String firstName;
	private String lastName;
	private String registerAs;
}
