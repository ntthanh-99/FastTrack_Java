package com.fasttrack.exceptions;

import com.fasttrack.controller.RegistrationController;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice(basePackageClasses = RegistrationController.class)
public class RegistrationControllerAdvice {

  @ExceptionHandler(RegistrationException.class)
  ResponseEntity<ApiExceptionResponse> handleRegistrationException(
      RegistrationException exception) {

    final ApiExceptionResponse response = new ApiExceptionResponse(exception.getErrorMessage(),
        HttpStatus.BAD_REQUEST, LocalDateTime.now());

    return ResponseEntity.status(response.getStatus()).body(response);
  }

}
