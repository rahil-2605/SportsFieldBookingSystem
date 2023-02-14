package com.te.sbs.service;

import com.te.sbs.dto.BookingDto;
import com.te.sbs.dto.BookingStatusDto;
import com.te.sbs.dto.PaymentDto;

public interface BookingService {
	public Object booking(BookingDto bookingDto);

	public Object payment(PaymentDto paymentDto, Long bookingId);

	public BookingStatusDto getStatusById(Long bookingId);

}
