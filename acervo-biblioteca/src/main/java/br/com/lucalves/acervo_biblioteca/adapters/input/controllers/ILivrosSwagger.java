package br.com.lucalves.acervo_biblioteca.adapters.input.controllers;

import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ILivrosSwagger {

    @PostMapping("adicionar")
    public ResponseEntity<Integer> create(@RequestBody Livro request);

    @GetMapping("listar-todos")
    public ResponseEntity<List<Livro>> getAll();
}
