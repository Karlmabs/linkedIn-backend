package com.ams.userservice.services;

import com.ams.userservice.dto.UserDto;
import com.ams.userservice.entities.User;
import com.ams.userservice.exceptions.ResourceNotFoundException;
import com.ams.userservice.mapper.UserMapper;
import com.ams.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  private final PasswordEncoder encoder;

  public UserService(UserRepository userRepository, UserMapper userMapper, PasswordEncoder encoder) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
    this.encoder = encoder;
  }

  public List<UserDto> findAll(){
    return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
  }

  public UserDto findById(Long id) {
    return userMapper.toDto(userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id)));
  }

  public UserDto save(UserDto userDto) {
    User user = userMapper.toEntity(userDto);
    return userMapper.toDto(userRepository.save(user));
  }

  public UserDto update(long id, UserDto userDto) {
    User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    user = userMapper.partialUpdate(userDto, user);
    if(userDto.getPassword() != null)
      user.setPassword(encoder.encode(userDto.getPassword()));
    return userMapper.toDto(userRepository.save(user));
  }

  public void delete(Long id) {
    userRepository.deleteById(id);
  }
}
