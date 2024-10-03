package felicidade;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import controller.controlador;

import java.util.Date;
import java.util.function.Function;
@Component
public class JwTutil {
	



	    private final String SECRET_KEY = "secret";

	    public String extractUsername(String token) {
	        return extractClaim(token, claims::getSubject);
	    }

	    public Date extractExpiration(String token) {
	        return extractClaim(token, claims::getExpiration);
	    }

	    public <T> T extractClaim(String token, Function<claims, T> claimsResolver) {
	        final claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	    }

	    @SuppressWarnings("deprecation")
		private Claims extractAllClaims(String token) {
	        return JwTutil.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	    }

	    private Boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }

	    public String generateToken(String username) {
	        return JwTutil.builder()
	                .setSubject(username)
	                .setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas

	                .compact();
	    }


		public Boolean validateToken(String token, String username) {
	        final String extractedUsername = extractUsername(token);
	        return (extractedUsername.equals(username) && !isTokenExpired(token));
	    }

		public static Object getContext() {
			// TODO Auto-generated method stub
			return null;
		}
	}
