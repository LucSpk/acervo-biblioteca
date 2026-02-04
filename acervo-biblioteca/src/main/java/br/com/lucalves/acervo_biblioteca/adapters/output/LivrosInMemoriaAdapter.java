package br.com.lucalves.acervo_biblioteca.adapters.output;

import br.com.lucalves.acervo_biblioteca.adapters.output.domain.inmemoria.LivrosInMemoria;
import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.CreateNewLivroRequest;
import br.com.lucalves.acervo_biblioteca.application.ports.output.ILivrosOutputPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LivrosInMemoriaAdapter implements ILivrosOutputPort {
    private List<LivrosInMemoria> livros = new ArrayList<>();

    @Override
    public void create(CreateNewLivroRequest request) {
        LivrosInMemoria livrosInMemoria = new LivrosInMemoria(
                request.titulo(),
                request.subtitulo(),
                request.autor(),
                request.volume(),
                request.edicao(),
                request.editora(),
                request.idioma(),
                request.generos(),
                request.tags()
        );
        livros.add(livrosInMemoria);
        livros.forEach(System.out::println);
    }
}
