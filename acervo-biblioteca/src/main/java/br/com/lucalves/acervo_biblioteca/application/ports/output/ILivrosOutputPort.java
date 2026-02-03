package br.com.lucalves.acervo_biblioteca.application.ports.output;

import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.CreateNewLivroRequest;

public interface ILivrosOutputPort {
    public void create(CreateNewLivroRequest request);
}
