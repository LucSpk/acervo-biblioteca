package br.com.lucalves.acervo_biblioteca.adapters.input.controllers;

import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ILivrosSwagger {

    @PostMapping("adicionar")
    ResponseEntity<Long> create(@RequestBody Livro request);

    @GetMapping("retorna/{id}")
    ResponseEntity<Livro> get(@PathVariable("id") Long id);

    @GetMapping("listar-todos")
    ResponseEntity<List<Livro>> getAll();

    @DeleteMapping("apagar-livro")
    ResponseEntity<?> delete(@PathVariable("id") Long id);
}
