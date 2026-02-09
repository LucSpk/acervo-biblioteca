package br.com.lucalves.acervo_biblioteca.application.ports.output;

import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.Livro;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ILivrosOutputPort {
    int create(Livro request);
    Livro get(Integer id);
    List<Livro> getAll();
}
