package com.everis.sumativa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.sumativa.models.Usuario;
import com.everis.sumativa.reporsitories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	public Usuario saveUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(usuario);
	}

	public Optional<Usuario> findById(Long usuarioID) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(usuarioID);
	}
}
