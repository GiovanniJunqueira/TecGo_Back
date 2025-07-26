package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dto.LoginRequest;
import dto.LoginResponse;
import entity.User;
import repository.UserRepository;
import security.JwtUtil;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;
		
	@Autowired
	private JwtUtil jwtUtil;
	
	public LoginResponse login(LoginRequest request) {
		User user = userRepository.findByUsername(request.getUsername()).orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado"));
		
		if (!user.getPassword().equals(request.getPassword())) {
			throw new BadCredentialsException("Senha inválida");
		}
		
		String token = jwtUtil.generateToken(user);
		return new LoginResponse(token);
	
	}
}
