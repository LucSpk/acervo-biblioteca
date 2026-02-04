package br.com.lucalves.acervo_biblioteca.adapters.input.controllers;

import br.com.lucalves.acervo_biblioteca.adapters.output.LivrosInMemoriaAdapter;
import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.CreateNewLivroRequest;
import br.com.lucalves.acervo_biblioteca.application.core.usecases.LivrosUseCase;
import br.com.lucalves.acervo_biblioteca.application.ports.input.ILivrosInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("livros/v1")
@Controller
public class LivrosV1Controller implements ILivrosSwagger {

    private final ILivrosInputPort livrosInputPort;

    @Autowired
    public LivrosV1Controller(LivrosInMemoriaAdapter livrosInMemoriaAdapter) {
        this.livrosInputPort = new LivrosUseCase(livrosInMemoriaAdapter);
    }

    @Override
    public ResponseEntity<?> create(CreateNewLivroRequest request) {
        livrosInputPort.create(request);
        return ResponseEntity.noContent().build();
    }
}
