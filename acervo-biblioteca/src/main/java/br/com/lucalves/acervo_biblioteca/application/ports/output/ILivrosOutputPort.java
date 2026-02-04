package br.com.lucalves.acervo_biblioteca.application.ports.output;

import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.Livro;

public interface ILivrosOutputPort {
    public void create(Livro request);
}
