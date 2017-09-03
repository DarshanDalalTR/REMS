package com.tcs.rems.controllers;

import com.tcs.rems.models.UserCredentials;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        HttpSession session = httpServletRequest.getSession(false);
        String path = httpServletRequest.getServletPath();

        if (path.equals("/error") || path.equals("/testError")) {
            return true;
        }

        if (path.equals("/login") && session != null && session.getAttribute("userDetails") != null) {
            httpServletResponse.sendRedirect("/map/");
        }

        if (path.equals("/login") || path.startsWith("/resources/"))
            return true;

        if (session == null || session.getAttribute("userDetails") == null) {
            httpServletResponse.sendRedirect("/login");
            return false;
        }

        if (path.startsWith("/admin/") && ((UserCredentials) session.getAttribute("userDetails")).getRole() == 1) {
            httpServletResponse.sendRedirect("/error/");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
