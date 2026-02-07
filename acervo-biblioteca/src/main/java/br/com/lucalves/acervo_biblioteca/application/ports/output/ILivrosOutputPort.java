package br.com.lucalves.acervo_biblioteca.application.ports.output;

import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.Livro;

import java.util.List;

public interface ILivrosOutputPort {
    void create(Livro request);
    List<Livro> getAll();
}
