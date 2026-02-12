package br.com.lucalves.acervo_biblioteca.application.ports.input;

import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.Livro;
import org.jspecify.annotations.Nullable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ILivrosInputPort {
    Long create(Livro request);
    @Nullable Livro get(Long id);
    List<Livro> getAll();
    void delete(Long id);
    void edite(Long id, Livro request);
}
