package com.te.sbs.dto;

import com.te.sbs.entity.BookingStatus;
import com.te.sbs.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetBookingByIdDto {
	private Long id;
	private String bookingDate;
	private UserDto userDto;
	private SportsFieldDto sportsFieldDto;
	private TimeSlotDto timeSlotDto;
	private BookingStatus bookingStatus;
	private Payment payment;

}
