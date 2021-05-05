package com.everis.sumativa.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.everis.sumativa.models.Carrito;
import com.everis.sumativa.models.Producto;
import com.everis.sumativa.models.Usuario;
import com.everis.sumativa.services.CarritoService;
import com.everis.sumativa.services.ProductoService;
import com.everis.sumativa.services.UsuarioService;

@Controller
@RequestMapping("/carrito")
public class CarritoController {

	@Autowired
	CarritoService carritoService;
	@Autowired
	ProductoService productoService;
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping("")
	public String inicioCarrito(Model model) {
		List<Carrito> carritos = carritoService.findAll();
		List<Usuario> usuarios = usuarioService.findAll();
		List<Producto> productos = productoService.findAll();
		
		model.addAttribute("productos",productos);
		model.addAttribute("usuarios",usuarios);
		model.addAttribute("carritos",carritos);
	
		
		return "carrito.jsp";
	
	}
	
	
	/*
	@RequestMapping("/insert")
	public String insertarCarrito(@RequestParam("usuarioID") Long id,
			@RequestParam("productos") List<Long> productoId) {
		
		Optional<Usuario> usuario = usuarioService.findById(id); 
		List<Producto> productos = new ArrayList<Producto>() ;
		
		for(Long ID: productoId) {
			
			productos.add(productoService.finByID(ID).get());
		}
		
		Carrito carrito = new Carrito();
		carrito.setUsuario(usuario.get());
		carrito.setProductos(productos);
		
		carrito = carritoService.save(carrito);
		
		
		return"redirect:/carrito";
	}
	
	*/
	
	@RequestMapping("/editar/{id}")
	public String editarCarrito(@PathVariable("id") Long id, Model model) {
		Optional<Carrito> carrito= carritoService.findById(id);
		
		List<Producto> listaProductos =  productoService.findAll();
		
		model.addAttribute("carrito", carrito);
		model.addAttribute("listaProductos", listaProductos);
		return "carroEdit.jsp";
	}
	
	@RequestMapping("/update")
	public String updateCarrito(@ModelAttribute("carrito") Carrito carrito ) {
		carritoService.save(carrito);
		return "redirect:/carrito";
	}

	
	
}
