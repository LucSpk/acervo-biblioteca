package br.com.lucalves.acervo_biblioteca.adapters.input.controllers;

import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.CreateNewLivroRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("livros/v1")
@Controller
public class LivrosV1Controller implements ILivrosSwagger {

    @Override
    public ResponseEntity<?> create(CreateNewLivroRequest request) {
        return ResponseEntity.ok(request);
    }
}
