/*
 * @ (#) RouteValidatorFilter.java   1.0     29/03/2024
 *
 * Copyright (c) 2024 IUH All rights reserved
 */
package com.example.apigateway.filter;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

/*
 *@description:
 *@author: Nguyen Tien Dat 19473791
 *@date:   29/03/2024
 *version: 1.0
 */
@Component
public class RouteValidatorFilter {

    public static final List<String> openAPIEndpoints = List.of(
            "/auth/login", "/auth/register",
            "/eureka"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openAPIEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}
