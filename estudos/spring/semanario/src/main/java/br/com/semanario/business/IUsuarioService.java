package br.com.semanario.business;

import java.util.List;

import br.com.semanario.model.Usuario;


public interface IUsuarioService {

    void save(Usuario usuario);

    void delete(Integer idUsuario);

    List<Usuario> find(String nome);

    Usuario getById(Integer id);
}
