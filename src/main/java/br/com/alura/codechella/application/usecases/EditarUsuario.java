package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class EditarUsuario {

    private final RepositorioDeUsuario repositorio;


    public EditarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario editarDadosUsuario(String cpf, Usuario usuario){
        return repositorio.editarUsuario(cpf,usuario);
    }
}
