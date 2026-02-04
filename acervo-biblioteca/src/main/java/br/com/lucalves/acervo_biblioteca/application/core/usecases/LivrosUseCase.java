package br.com.lucalves.acervo_biblioteca.application.core.usecases;

import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.Livro;
import br.com.lucalves.acervo_biblioteca.application.ports.input.ILivrosInputPort;
import br.com.lucalves.acervo_biblioteca.application.ports.output.ILivrosOutputPort;

public class LivrosUseCase implements ILivrosInputPort {

    private final ILivrosOutputPort livrosOutputPort;

    public LivrosUseCase(ILivrosOutputPort livrosOutputPort) {
        this.livrosOutputPort = livrosOutputPort;
    }

    @Override
    public void create(Livro request) {
        livrosOutputPort.create(request);
    }
}
