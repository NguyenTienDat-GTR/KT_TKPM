/*
 * @ (#) JwtUtil.java   1.0     28/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.authjwt.util;
/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   28/03/2024
 *version: 1.0
 */

import com.example.authjwt.authen.UserPricipal;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jose.shaded.gson.JsonObject;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private static Logger logger = LoggerFactory.getLogger(JwtUtil.class);
    public static final String USER = "tiendat";
    public static final String SECRET = "nguyen tien dat 10/07/2001 19473791";

    public String generateToken(UserPricipal userPricipal) {
        String token = null;
        try {
            JWTClaimsSet.Builder builder = new JWTClaimsSet.Builder();
            builder.claim(USER, userPricipal);
            builder.expirationTime(generateExpirationTime());
            JWTClaimsSet claims = builder.build();

            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claims);
            JWSSigner signer = new MACSigner(SECRET.getBytes());
            signedJWT.sign(signer);

            token = signedJWT.serialize();
        } catch (Exception e) {
            logger.error("Error generate token: ", e);
        }
        return null;

    }

    public Date generateExpirationTime() {
        return new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10);//10h 1000 is 1s 60 is 1m 60 is 1h 10 is 10h
    }

    /**
     * get claims from token
     */
    public JWTClaimsSet getClaimsFromToken(String token) {
        JWTClaimsSet claims = null;
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWSVerifier verifier = new MACVerifier(SECRET.getBytes());
            if (!signedJWT.verify(verifier)) {
                claims = signedJWT.getJWTClaimsSet();
            }
        } catch (Exception e) {
            logger.error("Error get claims from token: ", e);
        }
        return claims;
    }

    /**
     * get user from token
     */
    public UserPricipal getUserFromToken(String token) {
        UserPricipal userPricipal = null;
        try {
            JWTClaimsSet claims = getClaimsFromToken(token);
            if (claims != null && claims.getClaim(USER) != null) {
                JsonObject jsonObject = (JsonObject) claims.getClaim(USER);
                userPricipal = new ObjectMapper().readValue(jsonObject.toString(), UserPricipal.class);

            }
        } catch (Exception e) {
            logger.error("Error get user from token: ", e.getMessage());
        }
        return userPricipal;
    }

    /**
     * get expired date from token
     */
    private Date getExpirationDateFromToken(JWTClaimsSet claims) {
        return claims != null ? claims.getExpirationTime() : new Date();
    }

    /**
     * check is token expired
     */
    private boolean isTokenExpired(JWTClaimsSet claims) {
        return getExpirationDateFromToken(claims).after(new Date());
    }
}
