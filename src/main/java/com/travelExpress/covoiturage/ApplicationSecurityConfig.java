package com.travelExpress.covoiturage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@Configuration

public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	
	@SuppressWarnings("unused")
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers(
				"/login", 
				"/resources/**", 
				"/css/**", 
				"/fonts/**", 
				"/img/**").permitAll()
		.antMatchers(
				"/register", 
				"/resources/**", 
				"/css/**", 
				"/fonts/**", 
				"/img/**", "/js/**").permitAll()
		
		.antMatchers(
				"/users/addNew").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login").permitAll();
	}
	

	@Bean 
	public PasswordEncoder passwordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
	
	
}
