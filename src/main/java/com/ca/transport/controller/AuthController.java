package com.ca.transport.controller;

import com.ca.transport.model.User;
import com.ca.transport.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

	  @Autowired
	    private UserService userService;

	    // Show login page
	    @GetMapping("/login")
	    public String showLoginPage() {
	        return "auth/login";
	    }

	    // Show register page
	    @GetMapping("/register")
	    public String showRegisterPage(Model model) {
	        model.addAttribute("user", new User());
	        return "auth/register";
	    }

	    // Handle registration
	    @PostMapping("/register")
	    public String registerUser(@Valid @ModelAttribute("user") User user,
	                               BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "auth/register";
	        }

	        if (userService.usernameExists(user.getUsername())) {
	            model.addAttribute("error", "Username already exists!");
	            return "auth/register";
	        }

	        userService.registerUser(user);
	        return "redirect:/login?registered";
	    }
}
