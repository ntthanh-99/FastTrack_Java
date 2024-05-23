package com.fasttrack.controller;

import com.fasttrack.security.dto.RegistrationRequest;
import com.fasttrack.security.dto.RegistrationResponse;
import com.fasttrack.security.service.UserService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

  private final UserService userService;

  @PostMapping
  public ResponseEntity<RegistrationResponse> registrationRequest(
      @Valid @RequestBody RegistrationRequest registrationRequest) {

    final RegistrationResponse registrationResponse = userService.registration(registrationRequest);

    return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
  }

}
