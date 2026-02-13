package br.com.lucalves.acervo_biblioteca.adapters.output;

import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.Livro;
import br.com.lucalves.acervo_biblioteca.application.ports.output.ILivrosOutputPort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LivrosLocalFileAdapter implements ILivrosOutputPort {
    @Override
    public Long create(Livro request) {
        return 0L;
    }

    @Override
    public Livro get(Long id) {
        return null;
    }

    @Override
    public List<Livro> getAll() {
        return List.of();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void edite(Long id, Livro request) {

    }
}
