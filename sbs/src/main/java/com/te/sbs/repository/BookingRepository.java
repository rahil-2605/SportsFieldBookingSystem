package com.te.sbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.sbs.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
