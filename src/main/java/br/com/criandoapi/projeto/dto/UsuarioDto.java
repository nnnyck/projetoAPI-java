package br.com.criandoapi.projeto.service;

import br.com.criandoapi.projeto.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void sincronizarComBancoDeDados(List<Usuario> usuariosJava) {
        List<Usuario> usuariosBancoDeDados = entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class)
                .getResultList();

        // Identificar usuários para remover
        List<Usuario> usuariosParaRemover = usuariosBancoDeDados.stream()
                .filter(usuario -> !usuariosJava.contains(usuario))
                .collect(Collectors.toList());

        // Remover usuários inexistentes no Java, mas existentes no banco de dados
        for (Usuario usuario : usuariosParaRemover) {
            entityManager.remove(usuario);
        }
    }
}
