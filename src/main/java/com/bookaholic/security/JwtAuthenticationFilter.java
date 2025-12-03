package com.bookaholic.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {


        String path = request.getRequestURI();
        if (path.startsWith("/api/auth/") ||
                path.equals("/api/register") ||
                path.equals("/api/login") ||
                path.contains("/swagger") ||
                path.contains("/api-docs") ||
                path.contains("/v3/api-docs") ||
                path.contains("/webjars") ||
                path.contains("/swagger-resources") ||
                path.contains("/configuration") ||
                path.equals("/v3/api-docs") ||
                path.equals("/api-docs") ||
                path.equals("/swagger-ui") ||
                path.startsWith("/swagger-ui/") ||
                path.endsWith("/swagger-config") ||
                path.contains("/favicon") ||
                path.equals("/")) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        if (jwtUtil.validateToken(token)) {
            String username = jwtUtil.extractUsername(token);

            UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(username, null, null);
            SecurityContextHolder.getContext().setAuthentication(authToken);
        }

        filterChain.doFilter(request, response);
    }
}