package Projeto.lucas.todoSpring.filters;

import Projeto.lucas.todoSpring.domain.services.AuthenticationService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.io.IOException;

public class AuthorizationFilter  extends GenericFilter {

    @Override
    public  void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterchain)
        throws  IOException, ServletException {
        Authentication authentication = AuthenticationService.getAuthentication((HttpServletRequest) servletRequest);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterchain.doFilter(servletRequest, servletResponse);
    }
}
