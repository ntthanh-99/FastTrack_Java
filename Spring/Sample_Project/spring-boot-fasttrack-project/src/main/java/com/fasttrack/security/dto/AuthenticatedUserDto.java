package com.fasttrack.security.dto;

import com.fasttrack.model.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class AuthenticatedUserDto {

  private String name;

  private String username;

  private String password;

  private UserRole userRole;

}
