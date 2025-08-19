package br.com.ForumHub_ONE.controller;

import br.com.ForumHub_ONE.topicos.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController{

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastro(@RequestBody @Valid PostarTopicoDados post, UriComponentsBuilder uriBuilder){
        var topico = new Topico(post);
        repository.save(topico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(topico.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemTopicos>> listar(Pageable pageable){
        var page = repository.findAllByEstadoTrue(pageable).map(DadosListagemTopicos::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity alterarTopico(@RequestBody @Valid DadosAlteracaoTopico post){
        var topico = repository.getReferenceById(post.id());
        topico.atualizarDados(post);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var topico = repository.getReferenceById(id);
        topico.excluir();
        return ResponseEntity.noContent().build();

    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var topico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));

    }
}
