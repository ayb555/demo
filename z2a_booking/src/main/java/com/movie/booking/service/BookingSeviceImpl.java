package com.movie.booking.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.booking.dto.BookingDTO;
import com.movie.booking.entity.Booking;
import com.movie.booking.entity.Shows;
import com.movie.booking.entity.Theatre;
import com.movie.booking.repository.BookingRepository;
import com.movie.booking.repository.ShowsRepository;

@Service
public class BookingSeviceImpl implements BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private ShowsRepository showsRepository;
	
	@Override
	public void deleteBooking(Integer Id) {
		bookingRepository.deleteById(Id);
	}
	@Override
	public List<Booking> bookingReport(Date start, Date end) {
		System.out.println("b2####");
		return bookingRepository.bookingReport(start, end);
	}
	@Override
	public String addBooking(Booking booking) {
		//booking.setDate(java.time.LocalDateTime.now());
		
		Integer n=booking.getSeatsBooked();
		Integer showId=booking.getShow().getShowId();
		Optional<Shows> s1=showsRepository.findById(showId);
		Shows s=s1.orElse(null);
		
		Integer availSeats=s.getSeats();
		//int availSeats=availSeats1.intValue();
		 /* 
		 * 
		 * Shows show=booking.getShow(); Integer availSeats=show.getSeats();
		 * System.out.println("2#######");
		 */
		if(booking.getSeatsBooked()>availSeats) 
			return "Only "+availSeats+" remaining";
		
		else {
		bookingRepository.save(booking);
		Integer remSeats=availSeats-n;
		s.setSeats(remSeats);
		s.setMovieId(s.getMovieId());
		showsRepository.saveAndFlush(s);
		
		return "Booking success";
		}
		
		
		/*
		 * Optional<Shows> s1=showsRepository.findById(showId); Shows s=s1.orElse(null);
		 * s.getSeats();
		 */
		
		
		/*
		 * Shows s=new Shows(); s.setShowId(showId);
		 * s.setSeats(s.getSeats()-booking.getSeatsBooked());
		 */
	}
	@Override
	public Optional<Booking> findById(Integer Id) {
		System.out.println("3#######");
		return bookingRepository.findById(Id);
		
		
	}
	
	
	
	@Override
	public BookingDTO valueOf(Booking booking) {
		
		BookingDTO bookingDTO = new BookingDTO();
		bookingDTO.setBookingId(booking.getBookingId());
		bookingDTO.setUserId(booking.getUserId());
		//bookingDTO.setShowId(booking.getShowId());
		//bookingDTO.setDate(booking.getDate());
		bookingDTO.setSeatsBooked(booking.getSeatsBooked());
		bookingDTO.setTotalAmount(booking.getTotalAmount());
		//bookingDTOs.add(customerDTO);
		return bookingDTO;
	
	}
	
	

}
