package com.travelExpress.covoiturage.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.travelExpress.covoiturage.models.User;
import com.travelExpress.covoiturage.models.UserPrincipal;
import com.travelExpress.covoiturage.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		if (user==null) {
			throw new UsernameNotFoundException("User not found");
		}
	     	return new UserPrincipal(user);
	}

}
