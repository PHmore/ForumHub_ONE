package br.com.ForumHub_ONE.autor;

public record DadosListagemUsuario(Long id, String nome, String email) {

    public DadosListagemUsuario(Usuario user){
        this(user.getId(), user.getNome(), user.getEmail());
    }
}
