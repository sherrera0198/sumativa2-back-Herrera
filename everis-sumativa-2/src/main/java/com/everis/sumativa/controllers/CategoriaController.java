package com.everis.sumativa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.sumativa.models.Categoria;
import com.everis.sumativa.services.CategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

	
	@Autowired
	CategoriaService categoriaService;
	
	
	@RequestMapping("")
	public String inicioCategoria(Model model) {
		List<Categoria> categorias  = categoriaService.findAll();
		model.addAttribute("categorias", categorias);
		return "categoria.jsp";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@RequestParam("nombre") String nombre, 
			Model model) {
	

		Categoria categoria = new Categoria();
		categoria.setNombre(nombre);

		
		categoria= categoriaService.saveCategoria(categoria);
		
		
		return "redirect:/categoria";
	}
}
