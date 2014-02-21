package br.com.semanario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.webflow.action.MultiAction;

import br.com.semanario.business.IUsuarioService;
import br.com.semanario.model.Usuario;

public class UsuarioController extends MultiAction {
	private IUsuarioService usuarioService;

	@Required
	public void setUsuarioService(IUsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public List<Usuario> find(String nome) {
		return usuarioService.find(nome);
	}

	public void delete(Usuario usuario) {
		usuarioService.delete(usuario.getId());
	}

	public Usuario getById(Integer id) {
		return usuarioService.getById(id);
	}

	public void save(Usuario usuario) {
		usuarioService.save(usuario);
	}

	public Usuario getNewUsuario() {
		return new Usuario();
	}
}
