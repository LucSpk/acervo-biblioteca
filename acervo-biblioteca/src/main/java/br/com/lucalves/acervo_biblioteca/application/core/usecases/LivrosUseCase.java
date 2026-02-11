package br.com.lucalves.acervo_biblioteca.application.core.usecases;

import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.Livro;
import br.com.lucalves.acervo_biblioteca.application.ports.input.ILivrosInputPort;
import br.com.lucalves.acervo_biblioteca.application.ports.output.ILivrosOutputPort;
import org.jspecify.annotations.Nullable;

import java.util.List;

public class LivrosUseCase implements ILivrosInputPort {

    private final ILivrosOutputPort livrosOutputPort;

    public LivrosUseCase(ILivrosOutputPort livrosOutputPort) {
        this.livrosOutputPort = livrosOutputPort;
    }

    @Override
    public Long create(Livro request) {
        return livrosOutputPort.create(request);
    }

    @Override
    public @Nullable Livro get(Long id) {
        return livrosOutputPort.get(id);
    }

    @Override
    public List<Livro> getAll() {
        return livrosOutputPort.getAll();
    }
}
