package com.joelson.swarm.filter;


import com.joelson.swarm.model.enterprise.UserHolder;

import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@WebFilter(urlPatterns = "/*")
public class Filter implements javax.servlet.Filter {

    @Inject
    private UserHolder userHolder;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String user = request.getHeader("user");
        userHolder.setUser(user);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        CDI.current().destroy(userHolder);
    }
}
