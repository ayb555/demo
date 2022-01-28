package com.movie.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.movie.user.dto.UserDTO;
import com.movie.user.entity.User;


public interface UserRepository extends CrudRepository<User, Integer> {
	public User findByUserNameAndPassword(String userName, String password);

	
}
