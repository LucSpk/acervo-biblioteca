package br.com.lucalves.acervo_biblioteca.application.ports.output;

import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.Livro;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface ILivrosOutputPort {
    Long create(Livro request);
    Livro get(Long id);
    List<Livro> getAll();
    void delete(Long id);
    void edite(Long id, Livro request);
}
