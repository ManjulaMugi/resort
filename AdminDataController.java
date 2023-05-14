package com.lara.resort.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lara.resort.Exceptions.ResourceNotFoundException;
import com.lara.resort.models.Admin;
import com.lara.resort.models.User;
import com.lara.resort.repositories.AdminRepository;


@CrossOrigin(origins = "http://localhost:9092")
@RestController
@RequestMapping("/resort")
public class AdminDataController {
	

	private static final Logger logger = LoggerFactory.getLogger(AdminDataController.class);

	@Autowired
	private AdminRepository adminRepository;
	
	
	/**
	 * Get admin details
	 * @return
	 */
	
	@GetMapping("/readAdmin")
	public Iterable<Admin> getAdmin()
	{
		return adminRepository.findAll();
	}
	
	/**
	 * Saving data in the database
	 * @param user to user data in JSON formate
	 * @return
	 */
	@PostMapping("/saveAdmin")
	public Admin saveAdmin(@RequestBody Admin admin)
	{
		adminRepository.save(admin);
		logger.info("save user informatio :" + admin);
		return adminRepository.save(admin);
	}
	
	/**
	 * finding a admin by Id
	 * @param adminID topass a specific admin ID in the path variable
	 * @return
	 */
	
	@GetMapping("/getAdmin/{id}")
	public Admin getAdminById(@PathVariable(value = "id") Long adminID)
	{
//		logger.info("admin id give as a parameter: " + adminID);
		logger.debug("admin id give as a parameter: " + adminID);
		return adminRepository.findById(adminID).orElseThrow(() -> new ResourceNotFoundException("admin", "id", adminID));
	}
	
	@PutMapping("/updateAdmin/{id}")
	public Admin updateAdmin(@PathVariable(value = "id") Long adminID,@RequestBody Admin adminDetails)
	{
		Admin admin = adminRepository.findById(adminID)
				.orElseThrow(() -> new ResourceNotFoundException("admin", "id", adminID));
		admin.setFirstName(adminDetails.getFirstName());
		admin.setLastName(adminDetails.getLastName());
		admin.setSex(adminDetails.getSex());
		admin.setAge(adminDetails.getAge());
		admin.setAdminName(adminDetails.getAdminName());
		admin.setCity(adminDetails.getCity());
		Admin updateAdmin = adminRepository.save(admin);
		return updateAdmin;
	}
	
}
