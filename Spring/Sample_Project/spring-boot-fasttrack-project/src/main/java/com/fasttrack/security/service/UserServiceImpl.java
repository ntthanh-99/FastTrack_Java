package com.fasttrack.security.service;

import com.fasttrack.model.User;
import com.fasttrack.model.UserRole;
import com.fasttrack.repository.UserRepository;
import com.fasttrack.security.dto.AuthenticatedUserDto;
import com.fasttrack.security.dto.RegistrationRequest;
import com.fasttrack.security.dto.RegistrationResponse;
import com.fasttrack.security.mapper.UserMapper;
import com.fasttrack.service.UserValidationService;
import com.fasttrack.utils.GeneralMessageAccessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private static final String REGISTRATION_SUCCESSFUL = "registration_successful";

  private final UserRepository userRepository;

  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  private final UserValidationService userValidationService;

  private final GeneralMessageAccessor generalMessageAccessor;

  @Override
  public User findByUsername(String username) {

    return userRepository.findByUsername(username);
  }

  @Override
  public RegistrationResponse registration(RegistrationRequest registrationRequest) {

    userValidationService.validateUser(registrationRequest);

    final User user = UserMapper.INSTANCE.convertToUser(registrationRequest);
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setUserRole(UserRole.USER);

    userRepository.save(user);

    final String username = registrationRequest.getUsername();
    final String registrationSuccessMessage = generalMessageAccessor.getMessage(null,
        REGISTRATION_SUCCESSFUL, username);

    log.info("{} registered successfully!", username);

    return new RegistrationResponse(registrationSuccessMessage);
  }

  @Override
  public AuthenticatedUserDto findAuthenticatedUserByUsername(String username) {

    final User user = findByUsername(username);

    return UserMapper.INSTANCE.convertToAuthenticatedUserDto(user);
  }
}
