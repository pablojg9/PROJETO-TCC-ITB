package com.itb.tcc.amazbook.amazbook.modules.jwt.filter;

import com.itb.tcc.amazbook.amazbook.modules.user.model.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itb.tcc.amazbook.amazbook.modules.jwt.service.JWTTokenAuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//Estabelece o nosso gerenciador de token
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
    // Obrigamos a autenticar a URL
    public JWTLoginFilter(String url, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(url));

        //Gerenciador de autenticação
        setAuthenticationManager(authenticationManager);
    }

    // Retorna o usuario ao processar a autenticação
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {

        // esta pegando o token para validar;
        Usuario user = new ObjectMapper()
                .readValue(request.getInputStream(), Usuario.class);

        return getAuthenticationManager()
                .authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(), user.getSenha()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        new JWTTokenAuthenticationService().addAuthentication(response, authResult.getName());
    }
}
