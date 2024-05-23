package com.fasttrack.controller;

import com.fasttrack.security.dto.LoginRequest;
import com.fasttrack.security.dto.LoginResponse;
import com.fasttrack.security.jwt.JwtTokenService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

  private final JwtTokenService jwtTokenService;

  @PostMapping
  public ResponseEntity<LoginResponse> loginRequest(@Valid @RequestBody LoginRequest loginRequest) {

    final LoginResponse loginResponse = jwtTokenService.getLoginResponse(loginRequest);

    return ResponseEntity.ok(loginResponse);
  }

}
