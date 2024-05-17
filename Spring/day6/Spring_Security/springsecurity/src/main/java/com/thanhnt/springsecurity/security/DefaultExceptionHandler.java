package com.thanhnt.springsecurity.security;

import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ Exception.class })
    @ResponseBody
    public ResponseEntity<?> handleException(Exception ex) {
        final Map<String, Object> body = new HashMap<>();
        if (ex instanceof AccessDeniedException) {
            body.put("status", HttpServletResponse.SC_FORBIDDEN);
            body.put("error", "Unknown");
            body.put("message", ex.getMessage());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(body);
        } else {
            body.put("status", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            body.put("error", "Unknown");
            body.put("message", ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
        }
    }
}

