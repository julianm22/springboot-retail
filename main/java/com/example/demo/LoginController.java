package com.example.demo;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService ls;
	
	@RequestMapping(value="/validateLogin", method= RequestMethod.POST)
	public void validateLogin(@RequestParam("uname") String username,
            				@RequestParam("pwd") String password,
            				HttpServletResponse response) throws IOException  {
		List<Login> logins = ls.getLogins();
		for(Login l : logins) {
			if(l.getUsername().equalsIgnoreCase(username)
					&& l.getPassword().equals(password)) {
				if(l.getType().equalsIgnoreCase("admin")) {
					response.sendRedirect("adminHome");
					return;
				} else {
					response.sendRedirect("userHome");
					return;
				}
			}
		}
		response.sendRedirect("invalidLogin");
	}

}
