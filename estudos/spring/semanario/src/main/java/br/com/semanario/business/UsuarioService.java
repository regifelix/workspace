package br.com.semanario.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import br.com.semanario.model.Usuario;

public class UsuarioService implements IUsuarioService {
    // simulacao do banco de dados
    private static Map<Integer, Usuario> database = new HashMap<Integer, Usuario>();
    private static Integer currentId = 0;

    public UsuarioService() {
        Usuario usuario = new Usuario();
        usuario.setNome("Maria das Neves");
        save(usuario);
        Usuario u = new Usuario();
        u.setNome("Jose da Silva");
        save(u);        
        Usuario u_ = new Usuario();
        u_.setNome("Joao Teodoro");
        save(u_);
    }


    @Override
    public synchronized void delete(Integer idUsuario) {
        database.remove(idUsuario);
    }

    @Override
    public synchronized void save(Usuario usuario) {
        if (usuario != null) {
            if (usuario.getId() == null) {
                currentId++;
                usuario.setId(currentId);
                database.put(usuario.getId(), usuario);
            } else {
                database.put(usuario.getId(), usuario);
            }
        }
    }

    @Override
    public List<Usuario> find(String nome) {
        if (StringUtils.hasText(nome)) {
            List<Usuario> usuarioList = new ArrayList<Usuario>();
            for (Integer id : database.keySet()) {
                if (database.get(id).getNome().toLowerCase().contains(nome.toLowerCase())) {
                    usuarioList.add(database.get(id));
                }
            }
            return usuarioList;
        }
        return new ArrayList<Usuario>(database.values());
    }

    @Override
    public Usuario getById(Integer id) {
        return database.get(id);
    }
}
