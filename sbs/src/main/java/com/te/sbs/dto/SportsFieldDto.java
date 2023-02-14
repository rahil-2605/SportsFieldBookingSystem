package com.te.sbs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SportsFieldDto {
	private Long id;
	private String name;
	private int pricePerHour;

}
