package com.code.codeevents.service;

import com.code.codeevents.models.User;
import com.code.codeevents.models.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
