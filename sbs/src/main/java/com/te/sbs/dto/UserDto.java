package com.te.sbs.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDto {
	@NotNull(message = "name should not be null")
	private String name;
	@Email(message = "invalid email Adress")
	private String email;
	@NotNull(message = "password should not be null")
	private String password;

}
