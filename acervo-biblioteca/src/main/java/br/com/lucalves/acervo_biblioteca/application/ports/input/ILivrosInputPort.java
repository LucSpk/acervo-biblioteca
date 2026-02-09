package br.com.lucalves.acervo_biblioteca.application.ports.input;

import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.Livro;

import java.util.List;

public interface ILivrosInputPort {
    int create(Livro request);
    List<Livro> getAll();
}
