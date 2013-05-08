package com.transbank.online.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * 
 * @author jeevan
 * @since May 6, 2013
 * @purpose authentication success handler
 *
 */

public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
	    HttpServletResponse response, Authentication authentication)
	    throws ServletException, IOException {
	System.out.println("in auth success handler redirecting to dashboard");
	response.sendRedirect(request.getContextPath() + "/dashboard");
    }

}
