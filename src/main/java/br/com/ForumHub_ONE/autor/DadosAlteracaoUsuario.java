package br.com.ForumHub_ONE.autor;

import jakarta.validation.constraints.NotNull;

public record DadosAlteracaoUsuario(
        @NotNull
        Long id,
        String nome,
        String email){
}
