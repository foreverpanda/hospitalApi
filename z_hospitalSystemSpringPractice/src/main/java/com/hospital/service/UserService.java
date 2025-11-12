package com.hospital.service;

import com.hospital.dto.AuthRequest;
import com.hospital.dto.AuthResponse;

public interface UserService {
	

	AuthResponse signIn(AuthRequest reqDTO);
	
}
