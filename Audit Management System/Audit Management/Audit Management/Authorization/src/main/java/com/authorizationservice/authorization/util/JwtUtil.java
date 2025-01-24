package com.authorizationservice.authorization.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@Slf4j
public class JwtUtil {

    private String SECRET_KEY = "secret";
    /**
     * This method takes the generated token and returns the user name. 
     * @param token
     * @return extract claim method
     */
    public String extractUsername(String token) {
        log.info("BEGIN - [extractUsername(token)]");
		log.info("END - [extractUsername(token)]");
        return extractClaim(token, Claims::getSubject);
    }
    /**
     * This method return expiration details.
     * @param token
     * @return extract claim method
     */
    public Date extractExpiration(String token) {
        log.info("BEGIN - [extractExpiration(token)]");
        log.info("END - [extractUsername(token)]");
        return extractClaim(token, Claims::getExpiration);
    }
    /**
     * This method is used to get the user access details
     * @param <T>
     * @param token
     * @param claimsResolver
     * @return claims
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        log.info("BEGIN - [extractClaims()]");
        final Claims claims = extractAllClaims(token);
        log.info("END - [extractClaims()]");
        return claimsResolver.apply(claims);
    }
    /**
     * This method is used to parse the token based on secret key.
     * @param token
     * @return parsed token
     */
    private Claims extractAllClaims(String token) {
        log.info("BEGIN - [extractAllClaims(token)]");
        log.info("END - [extractAllClaims()]");
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();   // to parse the secret key we provided
    }
    /**
     * This method checks whether the token expired or not.
     * @param token
     * @return
     */
    private Boolean isTokenExpired(String token) {
        log.info("BEGIN - [isTokenExpired(token)]");
        log.info("END - [isTokenExpired(token)]");
        return extractExpiration(token).before(new Date());
    }
    /**
     * This method is used to generate token using user details
     * @param userDetails
     * @return create token
     */
    public String generateToken(UserDetails userDetails) {    // method is to generate token
        log.info("BEGIN - [generateToken(userDetails)]");
        Map<String, Object> claims = new HashMap<>();
        log.debug("CLaims" + claims);
        log.info("END - [generateToken(userDetails)]");
        return createToken(claims, userDetails.getUsername()); 
    }
    /**
     * This method gets the user details from generate token method and creates token. 
     * @param claims
     * @param subject
     * @return token
     */
    private String createToken(Map<String, Object> claims, String subject) {  // to create token
        log.info("BEGIN - [createToken()]");
        log.info("END - [createToken()]");
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))        //To set duration for access token
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }
    /**
     * This method is used to validate token and whether the token is expired.
     * @param token
     * @param userDetails
     * @return
     */
    public Boolean validateToken(String token,UserDetails userDetails) {      // to validate token
        log.info("BEGIN - [validateToken(token,userDetails)]");
        final String username = extractUsername(token);
        log.debug("Username " + username);
        log.info("END - [validateToken(token,userDetails)]");
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
