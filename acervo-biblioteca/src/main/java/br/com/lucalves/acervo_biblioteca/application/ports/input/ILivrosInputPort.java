package br.com.lucalves.acervo_biblioteca.application.ports.input;

import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.Livro;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ILivrosInputPort {
    int create(Livro request);
    @Nullable Livro get(Integer id);
    List<Livro> getAll();
}
