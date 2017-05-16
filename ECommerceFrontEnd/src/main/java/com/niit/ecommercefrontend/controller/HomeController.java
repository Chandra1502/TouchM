package com.niit.ecommercefrontend.controller;


import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommercebackend.dao.UserDAO;
import com.niit.ecommercebackend.model.User;



@Controller
public class HomeController {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	User user;
	
	@Autowired
	SessionFactory sessionFactory;
	
	@RequestMapping("/")
	public String showHome()
	{
		return "Home";
	}
	
	@RequestMapping("/Home")
	public String showHomeOnImage()
	{
		return "Home";
	}
	
	@RequestMapping("/Login")
	public String showLogin()
	{
		return "Login";
	}
	
	@RequestMapping("/Signup")
	public ModelAndView showsignup()
	{
		ModelAndView mv= new ModelAndView("Signup");
		return mv;
	}
	
	@RequestMapping("/Validate")
	public ModelAndView showMessage(@RequestParam("username") String uname,@RequestParam("password")String pass)
	{
		ModelAndView mv;
		if(uname.equals("NIIT")&&pass.equals("NIIT"))
		{
			mv=new ModelAndView("Home");
			mv.addObject("LoggedInUser", "User");
			return mv;
		}
		else if(pass.equals("admin")) {
			mv = new ModelAndView("AdminHome");
			mv.addObject("LoggedInUser", "Admin");
			return mv;
		}
		else
		{
			mv=new ModelAndView("Login");
			return mv;
		}
	}	
	
	@RequestMapping(value = "/login_session_attributes")
	public String login_session_attributes(HttpSession session, Model model, @RequestParam(value="username") String id){
		
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		
		System.out.println("inside security check");
		
		session.setAttribute("name", name);
		
		user = userDAO.get(id);
		int x = user.getUserid();
		session.setAttribute("email", user.getEmailid());
		session.setAttribute("LoggedInUser", user.getUsername());
		session.setAttribute("LoggedInUserID", x);
		session.setAttribute("LoggedIn", "true");
		
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		
		String role = "ROLE_USER";
		for(GrantedAuthority authority : authorities){
			if(authority.getAuthority().equals(role)){
				return "Product"; //It has to be View Products page. Since the page is not created we are redirecting to it home.
			}
			else{
				session.setAttribute("isAdmin", "true");
			}
		}
		return "AdminHome";
	}
	
	@RequestMapping("/perform_logout")
	public ModelAndView showLogout(HttpServletRequest request, HttpSession session){
		System.out.println("logout");
		ModelAndView mv = new ModelAndView("Home");
		session.setAttribute("LogOutMessage","You have Successfully Logged Out.");
		session.invalidate();
		session = request.getSession(true);
		mv.addObject("LogOutMessage","You have Successfully Logged Out.");
		mv.addObject("loggedOut","true");
		return mv;
	}
	
	@ModelAttribute
	public User returnObject()
	{
		return new User(); 
	}
	 //After clicking submit this page with data is opened and is sent to addus page
	@RequestMapping(value = "/addus", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request)

	{

		System.out.print(user.getConfirmpassword());
		System.out.println(user.getPassword());

		user.setEnabled("true");
		user.setRole("ROLE_USER");

		if (user.getConfirmpassword().equals(user.getPassword()));

		{

			userDAO.saveOrUpdate(user);

		}

		return "Login";

	}
}


 

