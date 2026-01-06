package br.com.alura.codechella.domain;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class UsuarioTest {
    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123.456789-99", "Thiago", LocalDate.parse("2000-11-11"), "email@example.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("12345678999", "Thiago", LocalDate.parse("2000-11-11"), "email@example.com"));


        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("", "Thiago", LocalDate.parse("2000-11-11"), "email@example.com"));

    }

    @Test
    public void naoDeveCadastrarUsuarioComIdadeMenorDe18() {

        LocalDate dataNascimento = LocalDate.now().minusYears(17);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> {
                    new Usuario("123.456.789-99", "Jon", dataNascimento, "email@example.com");
                });

        Assertions.assertEquals("Usuário deve ter pelo menos 18 anos de idade!", exception.getMessage());

    }


    @Test
    public void deveCriarUsuarioUsandoFabricaUsuario() {
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento("João",
                "321.123.345-00", LocalDate.parse("1999-12-12"));

        Assertions.assertEquals("João", usuario.getNome());

        usuario = fabrica.incluiEndereco("12312-123", 10, "Apto 10");

        Assertions.assertEquals("Apto 10", usuario.getEndereco().getComplemento());
    }

}