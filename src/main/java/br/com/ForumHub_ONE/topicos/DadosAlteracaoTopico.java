package br.com.ForumHub_ONE.topicos;

import jakarta.validation.constraints.NotNull;

public record DadosAlteracaoTopico(
        @NotNull
        Long id,
        String titulo,
        String mensagem) {
        public DadosAlteracaoTopico(Topico topico) {
                this(topico.getId(), topico.getTitulo(), topico.getMensagem());
        }
}
