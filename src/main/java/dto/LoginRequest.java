package dto;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class LoginRequest {

	@Autowired
	private String username;
	@Autowired
	private String password;
	
}
