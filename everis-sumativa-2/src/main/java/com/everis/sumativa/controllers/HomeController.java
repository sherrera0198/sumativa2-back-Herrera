package com.everis.sumativa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.sumativa.services.UsuarioService;

@Controller
public class HomeController {

	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("")
	public String Inicio(Model model) {
		model.addAttribute("mensaje", false);
		return"index.jsp";
	}
	
	@RequestMapping("/login")
	public String login() {
		return"login.jsp";
	}
	
	@RequestMapping("/cerrarSesion")
	public String logOutUsuario(Model model) {

		model.addAttribute("mensaje", false);
		return "index.jsp";
	}
	
	
}
