package com.everis.sumativa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.sumativa.models.Carrito;
import com.everis.sumativa.models.Usuario;
import com.everis.sumativa.services.CarritoService;
import com.everis.sumativa.services.UsuarioService;
import com.everis.sumativa.util.Validaciones;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	@Autowired
	CarritoService carritoService;
	
	@RequestMapping("")
	public String inicioUsuario(Model model) {
		List<Usuario> usuarios  = usuarioService.findAll();
		model.addAttribute("usuarios", usuarios);
		return "usuario.jsp";
	}
	@RequestMapping("/login")
	public String loginUsuario(Model model,
			@RequestParam("nombre") String nombre,
			@RequestParam("pass") String pass) {
		
		
		List<Usuario> usuarios  = usuarioService.findAll();
		for (Usuario usuario:usuarios) {
			//System.out.println("usuarios : " + usuario.getNombre() + usuario.getPassword() );
			//System.out.println("Ingresado : " + nombre  + pass );
			if (usuario.getNombre().equals(nombre) 
				&& usuario.getPassword().equals(pass)) {
				
				model.addAttribute("mensaje", true);
				model.addAttribute("nombreUsuario", usuario.getNombre());
				return "index.jsp";
			}
		}
		
		
		model.addAttribute("mensaje", false);
		return "login.jsp";
	}
	
	
	

	
	@RequestMapping("/insertar")
	public String insertar(@RequestParam("nombre") String nombre,
			@RequestParam("pass") String pass, 
			@RequestParam("correo") String correo, 
			Model model) {
		
		boolean correoValido = false;
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setPassword(pass);
		if (Validaciones.validarCorreo(correo)) {
			usuario.setCorreo(correo);
			usuario = usuarioService.saveUsuario(usuario);
			correoValido = true;
		}
		
		Carrito carrito = new Carrito();
		carrito.setUsuario(usuario);
		carrito = carritoService.save(carrito);
		
		model.addAttribute("mensaje", correoValido);
		
		return "redirect:/usuario";
	}
	
	

}
