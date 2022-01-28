package com.movie.booking.entity;

import java.sql.Time;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="shows")
public class Shows {
	@Id
	private Integer showId;
	@Column(name="theatre_id")
	private Integer theatreId;
	@Column(name="movie_id")
	private Integer movieId;
	@Column(name="show_time")
	private Time showTime;
	private Integer seats;
	
	

	public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public Integer getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public Time getShowTime() {
		return showTime;
	}

	public void setShowTime(Time showTime) {
		this.showTime = showTime;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	@Override
	public int hashCode() {
		return Objects.hash(movieId, seats, showId, showTime, theatreId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shows other = (Shows) obj;
		return Objects.equals(movieId, other.movieId) && Objects.equals(seats, other.seats)
				&& Objects.equals(showId, other.showId) && Objects.equals(showTime, other.showTime)
				&& Objects.equals(theatreId, other.theatreId);
	}

	@Override
	public String toString() {
		return "Shows [showId=" + showId + ", theatreId=" + theatreId + ", movieId=" + movieId + ", showTime="
				+ showTime + ", seats=" + seats + "]";
	}

	

	

	

	
	
	
	
	

}
