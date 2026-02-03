package br.com.lucalves.acervo_biblioteca.adapters.input.controllers;

import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.CreateNewLivroRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface LivrosSwagger {

    @PostMapping("adicionar")
    public ResponseEntity<?> create(@RequestBody CreateNewLivroRequest request);
}
