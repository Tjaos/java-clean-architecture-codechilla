package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioEmArquivos implements RepositorioDeUsuario {
    List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarios;
    }

    @Override
    public Usuario editarUsuario(String cpf, Usuario usuario) {
        return null;
    }

    @Override
    public void excluirUsuario(String cpf) {
        usuarios.stream()
                .map(u -> {
                    if (u.getCpf() == cpf) {
                        usuarios.remove(u);
                    }
                    return null;
                });
    }

    public void gravaEmArquivo(String nomeArquivo) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(nomeArquivo);
            fileWriter.write(this.usuarios.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
