package com.te.sbs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookingDto {
	
	private Long id;	
	private String bookingDate;
	private Long userId;
	private Long sportsFieldId;
	private TimeSlotDto timeSlotDto;
	private BookingStatusDto bookingStatusDto;	

}
