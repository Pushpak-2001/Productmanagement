package com.product.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.product.model.Manufacturer;
import com.product.model.Dealer;

public class Authinterceptor implements HandlerInterceptor
{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getSession().getAttribute("loginuser").getClass().getSimpleName().equalsIgnoreCase("Manufacturer"))
		{
			return true;
		}
		else
		{
			response.getWriter().print("Please login with your own credentials");
			return false;
		}
	
		//return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
