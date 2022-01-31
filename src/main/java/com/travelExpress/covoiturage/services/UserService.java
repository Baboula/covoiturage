package com.travelExpress.covoiturage.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelExpress.covoiturage.models.User;
import com.travelExpress.covoiturage.repositories.UserRepository;


@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//Get All Users
	public List<User> findAll(){
		return userRepository.findAll();
	}	
	
	//Get User By Id
	public Optional<User> findById(int id) {
		return userRepository.findById(id);
	}	
	
	//Delete User
	public void delete(int id) {
		userRepository.deleteById(id);
	}
	
	//Update User
	public void save(User user) {
		userRepository.save(user);
	}
	
	//Get User By username
	public User findByUsername(String un) {
			return userRepository.findByUsername(un);
	}
	

}
