package security;

import java.util.Date;

import entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

		private final String secret = "chave";
		
		public String generateToken(User user) {
			return Jwts.builder()
					.setSubject(user.getUsername())
					.claim("role", user.getRole())
					.setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + 86400000))
					.signWith(SignatureAlgorithm.HS256, secret)
					.compact();
		}
		
		public Claims extractClaims(String token) {
	        return Jwts.parser()
	                .setSigningKey(secret)
	                .parseClaimsJws(token)
	                .getBody();
	    }

	    public boolean isTokenValid(String token) {
	        try {
	            return extractClaims(token).getExpiration().after(new Date());
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public String getUsername(String token) {
	        return extractClaims(token).getSubject();
	    }

//	    public String getRole(String token) {
//	        return extractClaims(token).get("role", String.class);
//	    }

}
