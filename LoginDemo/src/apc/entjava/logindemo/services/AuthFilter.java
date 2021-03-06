package apc.entjava.logindemo.services;

import apc.entjava.logindemo.AuthBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by student on 12/2/2017.
 */
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // Get the session from session attribute
        AuthBean authBean = (AuthBean)((HttpServletRequest)servletRequest)
                                .getSession().getAttribute("authBean");

        // For the first application request there is no session in the session so user needs to log in
        // For other requests session is present but we need to check if user has logged in successfully
        if (authBean == null ||
                authBean.getLoggedUsername() == null ||
                authBean.getLoggedUsername().isEmpty()) {
            String contextPath = ((HttpServletRequest)servletRequest).getContextPath();
            ((HttpServletResponse)servletResponse).sendRedirect(contextPath + "/index.jsf");
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
