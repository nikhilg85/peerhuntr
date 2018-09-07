package com.infodart.peerhuntr.jpa.service.Impl;

import com.infodart.peerhuntr.dto.response.ResponseDTO;
import com.infodart.peerhuntr.dto.user.UserDTO;

public interface PersonalityTestService {

	public ResponseDTO getTest();
	public ResponseDTO submitTest(UserDTO userDTO);
	public ResponseDTO updateUserPersonality(UserDTO userDTO);
}
