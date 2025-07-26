package dto;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class LoginResponse {
	
	@Autowired
	private String token;
	
	public LoginResponse(String token) {
		this.token = token;
	}
	
}
