package br.com.ForumHub_ONE.topicos;

import br.com.ForumHub_ONE.curso.CursoTipo;

import java.time.LocalDateTime;

public record DadosListagemTopicos(String titulo, String mensagem, CursoTipo curso, Long autor, LocalDateTime dataCriacao) {

    public DadosListagemTopicos(Topico topico){
        this(topico.getTitulo(), topico.getMensagem(),topico.getCurso(), topico.getAutor(), topico.getDataCriacao());
    }
}
