package com.everis.sumativa.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.sumativa.models.Carrito;
import com.everis.sumativa.models.Categoria;
import com.everis.sumativa.models.Producto;
import com.everis.sumativa.services.CategoriaService;
import com.everis.sumativa.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	@Autowired
	CategoriaService categoriaService;
	
	
	@RequestMapping("")
	public String inicioProducto(Model model) {
		List<Producto> productos  = productoService.findAll();
		List<Categoria> categorias  = categoriaService.findAll();
		model.addAttribute("productos", productos);
		model.addAttribute("categorias", categorias);
		return "producto.jsp";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion, 
			@RequestParam("precio") float precio, 
			@RequestParam("categoria") List<Categoria> categoria,
			Model model) {
		
		

		Producto producto = new Producto();
		producto.setNombre(nombre);
		producto.setDescripcion(descripcion);
		producto.setPrecio(precio);
		producto.setCategorias(categoria);
		
		producto= productoService.saveProducto(producto);
		
		
		return "redirect:/producto";
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id") Long id) {
		
		productoService.deleteByID(id);
		return"redirect:/producto";
	}
	
	@RequestMapping("/editar/{id}")
	public String editarProducto(@PathVariable("id") Long id, Model model) {
		Optional<Producto> producto= productoService.finByID(id);
		
		List<Categoria> listaCategorias =  categoriaService.findAll();
		
		model.addAttribute("producto", producto);
		model.addAttribute("listaCategorias", listaCategorias);
		return "productoEdit.jsp";
	}
	
	@RequestMapping("/update")
	public String updateCarrito(@ModelAttribute("producto") Producto producto ) {
		productoService.saveProducto(producto);
		return "redirect:/producto";
	}

	
	@RequestMapping("/buscar")
	public String buscarProducto(@RequestParam("palabra") String palabra,
			Model model) {
		List<Producto> listaProducto =  productoService.findAll();
		List<Producto> listaSalida = new ArrayList<Producto>() ;
		for(Producto producto : listaProducto){
			if(producto.getDescripcion().contains(palabra)) {
				listaSalida.add(producto);
			}
		}
		System.out.println(palabra);
		model.addAttribute("productos",listaSalida);
		
		return"buscar.jsp";
	}
	
	
	
	
}
