package br.com.ForumHub_ONE.topicos;

import br.com.ForumHub_ONE.curso.CursoTipo;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
public class Topico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dataCriacao;
    private Boolean estado;
    private Long autor;
    @Enumerated(EnumType.STRING)
    private CursoTipo curso;
    public Topico(){

    }
    public Topico(PostarTopicoDados topic){
        this.estado = true;
        this.titulo = topic.titulo();
        this.mensagem = topic.mensagem();
        this.autor = topic.autor();
        this.curso = topic.curso();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getAutor() {
        return autor;
    }

    public void setAutor(Long autor) {
        this.autor = autor;
    }

    public CursoTipo getCurso() {
        return curso;
    }

    public void setCurso(CursoTipo curso) {
        this.curso = curso;
    }

    public void atualizarDados( DadosAlteracaoTopico topico) {
        if (topico.titulo() != null) {
            this.titulo = topico.titulo();
        }
        if (topico.mensagem() != null) {
            this.mensagem = topico.mensagem();
        }
    }

    public void excluir() {
        this.estado = false;
    }
}
