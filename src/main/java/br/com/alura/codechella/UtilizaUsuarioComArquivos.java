package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivos;

import java.time.LocalDate;

public class UtilizaUsuarioComArquivos {
    public static void main(String[] args) {
        RepositorioDeUsuarioEmArquivos repositorioDeUsuarioEmArquivos = new RepositorioDeUsuarioEmArquivos();

        repositorioDeUsuarioEmArquivos.cadastrarUsuario(
                new Usuario(
                        "123.123.123-12",
                        "Joab",
                        LocalDate.parse("2000-12-12"),

                        "joab@email.com"));
        repositorioDeUsuarioEmArquivos.cadastrarUsuario(
                new Usuario(
                        "123.123.123-12",
                        "Marialina",
                        LocalDate.parse("2000-12-12"),

                        "marialina@email.com"));
        repositorioDeUsuarioEmArquivos.cadastrarUsuario(
                new Usuario(
                        "123.123.123-12",
                        "Cristóvão",
                        LocalDate.parse("2000-12-12"),

                        "cristovao@email.com"));
        repositorioDeUsuarioEmArquivos.cadastrarUsuario(
                new Usuario(
                        "123.123.123-12",
                        "Péricles",
                        LocalDate.parse("2000-12-12"),

                        "pericles@email.com"));
        //System.out.println(repositorioDeUsuarioEmArquivos.listarTodos());
        repositorioDeUsuarioEmArquivos.gravaEmArquivo("usuarios.txt");
    }

}
