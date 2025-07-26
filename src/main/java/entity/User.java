package entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "t_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String password;
	private String role;
	
}

