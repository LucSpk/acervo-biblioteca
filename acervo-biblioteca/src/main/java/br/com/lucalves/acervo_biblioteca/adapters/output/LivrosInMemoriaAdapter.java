package br.com.lucalves.acervo_biblioteca.adapters.output;

import br.com.lucalves.acervo_biblioteca.adapters.output.domain.inmemoria.LivrosInMemoria;
import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.CreateNewLivroRequest;
import br.com.lucalves.acervo_biblioteca.application.ports.output.ILivrosOutputPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LivrosInMemoriaAdapter implements ILivrosOutputPort {
    private Map<String, LivrosInMemoria> livros = new HashMap<>();

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
        livros.put(String.valueOf(livrosInMemoria.hashCode()), livrosInMemoria);
        livros.values().forEach(System.out::println);
    }
}
