package com.fasttrack.exceptions;

import com.fasttrack.controller.LoginController;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice(basePackageClasses = LoginController.class)
public class LoginControllerAdvice {

  @ExceptionHandler(BadCredentialsException.class)
  ResponseEntity<ApiExceptionResponse> handleRegistrationException(
      BadCredentialsException exception) {

    final ApiExceptionResponse response = new ApiExceptionResponse(exception.getMessage(),
        HttpStatus.UNAUTHORIZED, LocalDateTime.now());

    return ResponseEntity.status(response.getStatus()).body(response);
  }

}
