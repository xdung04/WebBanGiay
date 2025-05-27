package com.example.bangiay.conf;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RedirectToHttpsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {}

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        // Nếu đang dùng HTTP, redirect sang HTTPS
        if (request.getScheme().equals("http")) {
            String serverName = request.getServerName();
            String requestURI = request.getRequestURI();
            String queryString = request.getQueryString();

            String redirectUrl = "https://" + serverName + ":8443" + requestURI;
            if (queryString != null) {
                redirectUrl += "?" + queryString;
            }

            response.sendRedirect(redirectUrl);
        } else {
            // Nếu đã là HTTPS, cho qua bình thường
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {}
}