package com.example.demo.Controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller403 {
	@GetMapping(value = "/403")
	public String a403() {
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			return new String("/layouts/admin/fragments/403");
		}
		return new String("/layouts/admin/pages/dasboard");
		
	}
}
