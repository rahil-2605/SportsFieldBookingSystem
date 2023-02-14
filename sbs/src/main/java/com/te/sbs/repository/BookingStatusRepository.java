package com.te.sbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.sbs.entity.BookingStatus;

@Repository
public interface BookingStatusRepository extends JpaRepository<BookingStatus, Long> {

}
