package com.fasttrack.security.mapper;

import com.fasttrack.model.User;
import com.fasttrack.security.dto.AuthenticatedUserDto;
import com.fasttrack.security.dto.RegistrationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  User convertToUser(RegistrationRequest registrationRequest);

  AuthenticatedUserDto convertToAuthenticatedUserDto(User user);

  User convertToUser(AuthenticatedUserDto authenticatedUserDto);

}
