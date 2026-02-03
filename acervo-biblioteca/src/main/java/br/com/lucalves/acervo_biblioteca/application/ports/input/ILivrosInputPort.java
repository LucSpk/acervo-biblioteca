package br.com.lucalves.acervo_biblioteca.application.ports.input;

import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.CreateNewLivroRequest;

public interface ILivrosInputPort {
    public void create(CreateNewLivroRequest request);
}
