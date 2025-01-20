package Projeto.lucas.todoSpring.domain.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.util.Collections;
import java.util.Date;

@Service
public class AuthenticationService {

    static final long EXPIRATIONTIME = 1000 * 60 * 20;
    static final String SIGNINGKEY = "qwertyuioppLKJHGFDSAZAQplmvgtVGFREWQ";
    static final String PREFIX = "bearer";
    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SIGNINGKEY.getBytes());

    static public void addToken(HttpServletResponse res, String email) {

        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + EXPIRATIONTIME);
        String JtwToken = Jwts.builder()
                .claim("sub", email)
                .claim("iat", now.getTime())//QUDO foi crisdo
                .claim("exp", expirationDate.getTime())
                .signWith(SECRET_KEY)
                .compact();

        res.addHeader("Authorization", PREFIX + " " + JtwToken);
        res.addHeader("Accss - Control- Expose- Headers", "Authorization");
    }

    static public Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token != null) {
            if (token.startsWith(PREFIX)) token = token.substring(PREFIX.length()).trim();
            else throw new MalformedJwtException(("Invalid Authorization header format"));
            Claims claims = Jwts.parser()
                    .verifyWith(SECRET_KEY)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            String email = claims.get("sub", String.class);
            if (email != null)
                return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        }
        return null;
    }
}
