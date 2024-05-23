package com.fasttrack.security.service;

import com.fasttrack.model.User;
import com.fasttrack.security.dto.AuthenticatedUserDto;
import com.fasttrack.security.dto.RegistrationRequest;
import com.fasttrack.security.dto.RegistrationResponse;


public interface UserService {

  User findByUsername(String username);

  RegistrationResponse registration(RegistrationRequest registrationRequest);

  AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
