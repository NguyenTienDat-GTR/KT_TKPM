/*
 * @ (#) JwtUtil.java   1.0     29/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.apigateway.util;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.security.sasl.AuthenticationException;
import java.text.ParseException;
import java.util.Date;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   29/03/2024
 *version: 1.0
 */
@Component
public class JwtUtil {

    private static Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    private static final String SECRET = "nguyen tien dat 10/07/2001 19473791";

    //--------------------getExpirationDateFromToken-------------------------
    private Date getExpirationDateFromToken(JWTClaimsSet claims) {
        return claims != null ? claims.getExpirationTime() : new Date();
    }

    //--------------------isTokenExpired-------------------------
    private boolean isTokenExpired(JWTClaimsSet claims) {
        return getExpirationDateFromToken(claims).after(new Date());
    }

    public void validateToken(String token) throws Exception {
        try {
            // Parse token and get the claims
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWTClaimsSet claims = signedJWT.getJWTClaimsSet();

            // Verify the token signature
            JWSVerifier verifier = new MACVerifier(SECRET.getBytes());
            if (!signedJWT.verify(verifier)) {
                //
                System.out.println("Signature verification failed");
            }
            // Check if token has expired
            if (isTokenExpired(claims)) {

                System.out.println("Token has expired");
            }
            //
            System.out.println("Token is valid");
        } catch (ParseException | JOSEException e) {
            logger.error("Error validating token: {}", e.getMessage());
            throw new AuthenticationException("Error validating token") {};
        }
    }
}
