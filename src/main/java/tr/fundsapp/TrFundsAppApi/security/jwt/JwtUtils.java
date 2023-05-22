package tr.fundsapp.TrFundsAppApi.security.jwt;

import io.jsonwebtoken.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;
import tr.fundsapp.TrFundsAppApi.security.services.UserDetailsImpl;

import java.util.Date;

@Component
@Log4j2
public class JwtUtils {

    @Value("${fundsApp.TrFundsAppApi.jwtCookieName}")
    private String jwtCookie;

    @Value("${fundsApp.TrFundsAppApi.jwtSecret}")
    private String jwtSecret;

    @Value("${fundsApp.TrFundsAppApi.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String getJwtFromCookies(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, jwtCookie);
        if (cookie != null) {
            return cookie.getValue();
        } else {
            return null;
        }
    }

    public ResponseCookie generateJwtCookie(UserDetailsImpl userPrincipal) {
        String jwt = generateTokenFromUserName(userPrincipal.getUsername());
        return ResponseCookie.from(jwtCookie, jwt).path("/abc").build();
    }

    public ResponseCookie getCleanJwtCookie() {
        return ResponseCookie.from(jwtCookie, null).path("/abc").maxAge(24 * 60 * 60).httpOnly(true).build();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: " + e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: " + e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("Invalid JWT unsupported: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: " + e.getMessage());
        }
        return false;
    }

    public String generateTokenFromUserName(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date().getTime() + jwtExpirationMs)))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

}
