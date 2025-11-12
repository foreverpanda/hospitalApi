package com.hospital.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.Application;
import com.hospital.custom_exceptions.AuthenticationException;
import com.hospital.dto.AuthRequest;
import com.hospital.dto.AuthResponse;
import com.hospital.entities.User;
import com.hospital.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private ModelMapper modelMapper;
	private UserRepository userRepository;

	@Override
	public AuthResponse signIn(AuthRequest reqDTO) {
		System.out.println("Inside userservice");
		System.out.println(reqDTO);
		User entity = userRepository.findByEmailAndPassword(reqDTO.getEmail(), reqDTO.getPassword())
				.orElseThrow(() -> new AuthenticationException("Invalid Email or Password!!"));
System.out.println(entity);
		AuthResponse respDTO = modelMapper.map(entity, AuthResponse.class);
System.out.println(respDTO);
		return respDTO;
	}

}
