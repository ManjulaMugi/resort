package com.lara.resort.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lara.resort.Exceptions.ResourceNotFoundException;
import com.lara.resort.models.User;
import com.lara.resort.repositories.UserRepository;

@CrossOrigin(origins = "http://localhost:9092")
@RestController
@RequestMapping("/resort")
public class UserDataController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDataController.class);

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Get all users
	 * @return
	 */
	
	@GetMapping("/readUsers")
	public Iterable<User> getALLUser()
	{
		return userRepository.findAll();
	}
	
	/**
	 * Saving data in the database
	 * @param user to user data in JSON formate
	 * @return
	 */
	@PostMapping("/saveUsers")
	public User saveUsers(@RequestBody User user)
	{
		userRepository.save(user);
		logger.info("save user informatio :" + user);
		return userRepository.save(user);
	}
	
	/**
	 * finding a user by Id
	 * @param userID topass a specific user ID in the path variable
	 * @return
	 */
	
	@GetMapping("/getUsers/{id}")
	public User getUserById(@PathVariable(value = "id") Long userID)
	{
//		logger.info("user id give as a parameter: " + userID);
		logger.debug("user id give as a parameter: " + userID);
		return userRepository.findById(userID).orElseThrow(() -> new ResourceNotFoundException("user", "id", userID));
	}
	
	@PutMapping("/updateUsers/{id}")
	
	public User updateUser(@PathVariable(value = "id") Long userID,@RequestBody User userDetails)
	{
		User user = userRepository.findById(userID)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userID));
		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setSex(userDetails.getSex());
		user.setAge(userDetails.getAge());
		user.setUserName(userDetails.getUserName());
		user.setCity(userDetails.getCity());
		User updateUser = userRepository.save(user);
		return updateUser;
	}
	
//	@DeleteMapping("/deleteUsers/{id}")
//	public ResponeEntity<User> deleteUser(@PathVariable(value ="id")Long userId){
//		User user = userRepository.findById(userId)
//				.orElseThrow() -> new ResourceNotFoundException("User","id",userId));
//			userRepository.delete(user);
//			return ResponseEntity.ok().build();
//	}
	
	@DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
	
}
