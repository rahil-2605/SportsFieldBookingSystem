package com.te.sbs.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetUserDto {
	private Long id;
	private String name;
	private String email;
	private LocalDateTime registerDate;
	
}
