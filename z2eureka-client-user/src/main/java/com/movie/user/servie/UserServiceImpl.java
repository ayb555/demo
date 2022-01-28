package com.movie.user.servie;

import java.util.ArrayList;
import java.util.List;

//import org.apache.http.auth.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.user.entity.User;
import com.movie.user.repository.UserRepository;



@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {
	

	@Autowired
	private UserRepository userRepository;
	

	/*
	 * @Override public List<UserDTO> getAllUserDetails(){
	 * Iterable<UserDTO>users=userRepository.findAll(); List<UserDTO> users2=new
	 * ArrayList<>(); users.forEach(user -> { UserDTO u = new UserDTO(null, null,
	 * null, null, null, null); u.setUserId(user.getUserId());
	 * u.setUserName(user.getUserName()); u.setPassword(user.getPassword());
	 * u.setPhoneNo(user.getPhoneNo()); u.setEmailId(user.getEmailId());
	 * u.setRole(user.getRole()); users2.add(u); }); return users2;
	 * }
	 */

	
	@Override
	public void addUser(User user) {
		System.out.println("service");
		userRepository.save(user);
		System.out.println("servi2");
	}
	
	public User login(String userName, String password) {
		User user= userRepository.findByUserNameAndPassword(userName, password);
		return user;
		
	}
	
	/*
	 * public void login(String username, String password) {
	 * 
	 * }
	 */
	
	
	
	/*
	 * @Override public void Register(UserDTO user) throws Exception { if
	 * (userRepository.findById(user.getUserId()) != null) {
	 * 
	 * throw new InvalidCredentialsException ("Registered_User_Error"); } else
	 * userRepository.save(user); }
	 */
	/*
	 * public void Login() {
	 * 
	 * }
	 * 
	 * 
	 * 
	 */
}
	
	