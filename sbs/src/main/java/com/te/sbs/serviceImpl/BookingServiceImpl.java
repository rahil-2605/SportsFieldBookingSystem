package com.te.sbs.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.sbs.dto.BookingDto;
import com.te.sbs.dto.BookingStatusDto;
import com.te.sbs.dto.PaymentDto;
import com.te.sbs.entity.Booking;
import com.te.sbs.entity.BookingStatus;
import com.te.sbs.entity.Payment;
import com.te.sbs.entity.SportsField;
import com.te.sbs.entity.TimeSlot;
import com.te.sbs.entity.User;
import com.te.sbs.repository.BookingRepository;
import com.te.sbs.repository.BookingStatusRepository;
import com.te.sbs.repository.PaymentRepository;
import com.te.sbs.repository.SportsFieldRepository;
import com.te.sbs.repository.TimeSlotRepository;
import com.te.sbs.repository.UserRepository;
import com.te.sbs.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SportsFieldRepository sportsFieldRepository;
	
	@Autowired
	private TimeSlotRepository timeSlotRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private BookingStatusRepository bookingStatusRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private EmailService emailService;

	@Override
	public Object booking(BookingDto bookingDto) {
		Object object = new Object();
		Booking booking = new Booking();
		List<TimeSlot> timeSlotList = timeSlotRepository.findAll();
		boolean flag = false;
		if (timeSlotList.isEmpty()) {
			booking.setBookingDate(bookingDto.getBookingDate());
			User user = userRepository.findById(bookingDto.getUserId()).get();
			booking.setUser(user);
			SportsField sportsField = sportsFieldRepository.findById(bookingDto.getSportsFieldId()).get();
			booking.setSportsField(sportsField);

			TimeSlot timeSlot = new TimeSlot();
			timeSlot.setBookingDate(bookingDto.getBookingDate());
			timeSlot.setStartTime(bookingDto.getTimeSlotDto().getStartTime());
			timeSlot.setEndTime(bookingDto.getTimeSlotDto().getEndTime());
			timeSlotRepository.save(timeSlot);
			booking.setTimeSlot(timeSlot);

			BookingStatus bookingStatus = new BookingStatus();
			bookingStatus.setStatus(bookingDto.getBookingStatusDto().getStatus());

			booking.setBookingStatus(bookingStatus);
			bookingStatusRepository.save(bookingStatus);

			bookingRepository.save(booking);
			object = "Booking Successfull complete the payment";
			return object;

		} else {
			for (int i = 0; i < timeSlotList.size(); i++) {
				if (bookingDto.getBookingDate().equals(timeSlotList.get(i).getBookingDate())) {
					if (bookingDto.getTimeSlotDto().getStartTime().equals(timeSlotList.get(i).getStartTime())
							&& bookingDto.getTimeSlotDto().getStartTime().equals(timeSlotList.get(i).getStartTime())) {

						flag = true;
					}
				}
			}
			if (flag) {
				object = "Slot is not available";
				return object;
			}
		}

		if (!flag) {
			booking.setBookingDate(bookingDto.getBookingDate());
			User user = userRepository.findById(bookingDto.getUserId()).get();
			booking.setUser(user);
			SportsField sportsField = sportsFieldRepository.findById(bookingDto.getSportsFieldId()).get();
			booking.setSportsField(sportsField);

			TimeSlot timeSlot = new TimeSlot();
			timeSlot.setBookingDate(bookingDto.getBookingDate());
			timeSlot.setStartTime(bookingDto.getTimeSlotDto().getStartTime());
			timeSlot.setEndTime(bookingDto.getTimeSlotDto().getEndTime());
			timeSlotRepository.save(timeSlot);
			booking.setTimeSlot(timeSlot);

			BookingStatus bookingStatus = new BookingStatus();
			bookingStatus.setStatus(bookingDto.getBookingStatusDto().getStatus());

			booking.setBookingStatus(bookingStatus);
			bookingStatusRepository.save(bookingStatus);

			bookingRepository.save(booking);
			object = "slot booked Successful complete the payment";
		}
		return object;

	}

	@Override
	public Object payment(PaymentDto paymentDto, Long bookingId) {
		Payment payment = new Payment();
		BeanUtils.copyProperties(paymentDto, payment);
		payment.setPaymentDate(LocalDateTime.now());
		Booking booking = bookingRepository.findById(bookingId).get();
		booking.setPayment(payment);
		BookingStatus bookingStatus = bookingStatusRepository.findById(bookingId).get();
		bookingStatus.setStatus("Confirmed");

		paymentRepository.save(payment);
		bookingRepository.save(booking);

		return bookingStatus.getStatus();
	}

	@Override
	public BookingStatusDto getStatusById(Long bookingId) {
		BookingStatus currentBookingStatus=bookingStatusRepository.findById(bookingId).get();
		BookingStatusDto bookingStatusDto=new BookingStatusDto();
		BeanUtils.copyProperties(currentBookingStatus,bookingStatusDto );
		Booking booking=bookingRepository.findById(bookingId).get();
		
		emailService.sendEmail(booking.getUser().getEmail(),"Booking Status",bookingStatusDto.getStatus());
		
		return bookingStatusDto;
	}
	
	
}
