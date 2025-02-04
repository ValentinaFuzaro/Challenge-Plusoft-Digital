package br.com.fiap.challenge.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.fiap.challenge.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthorizationFilter extends OncePerRequestFilter{
    @Autowired 
    TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        // pegar o token no header
        var token = getToken(request);

        // se for valido, autenticar
        if (token != null){
            var usuario = tokenService.valideAndGetUserBy(token);
            Authentication auth = new UsernamePasswordAuthenticationToken(usuario.getEmail(), null, usuario.getAuthorities() );
            SecurityContextHolder.getContext().setAuthentication(auth);
        }

        //chama o próximo
        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        String prefix = "Bearer ";
        var header = request.getHeader("Authorization"); 

        if (header == null || header.isEmpty() || !header.startsWith(prefix)){
            return null;
        }

        return header.replace(prefix, "");

    }
}