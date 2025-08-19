package br.com.ForumHub_ONE.curso;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Embeddable
@Getter
public class Curso {

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CursoTipo getCategoria() {
        return categoria;
    }

    public void setCategoria(CursoTipo categoria) {
        this.categoria = categoria;
    }

    private String nome;
    @Enumerated(EnumType.STRING)
    private CursoTipo categoria;

    public Curso(){

    }
}
