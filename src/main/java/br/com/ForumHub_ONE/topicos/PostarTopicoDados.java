package br.com.ForumHub_ONE.topicos;

import br.com.ForumHub_ONE.curso.CursoTipo;

public record PostarTopicoDados(String titulo, String mensagem, Long autor, CursoTipo curso) {

}
