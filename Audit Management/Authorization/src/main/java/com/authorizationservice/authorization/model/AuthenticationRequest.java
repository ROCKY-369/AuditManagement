package com.authorizationservice.authorization.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Getter
@Setter                 //@getter and @setter are used to generate getters and setters
@NoArgsConstructor      //need default constructor for JSON Parsing
@AllArgsConstructor
@ToString
@Entity
@ApiModel(description = "Creating model class for user logging in")

public class AuthenticationRequest {
	/**
	 * Gets the user name and password.
	 *
	 * @param userName,password username and password of the user .
	 * @return userName,password returns the username and password.
	 */
    @Id
    @ApiModelProperty(value = "Username of the Customer doing login")
    private String userName;

    @ApiModelProperty(value = "Password of the Customer doing login")
    private String password;

}
