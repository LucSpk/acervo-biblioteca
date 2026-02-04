package br.com.lucalves.acervo_biblioteca.adapters.output;

import br.com.lucalves.acervo_biblioteca.adapters.output.domain.inmemoria.LivrosInMemoria;
import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.Livro;
import br.com.lucalves.acervo_biblioteca.application.ports.output.ILivrosOutputPort;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LivrosInMemoriaAdapter implements ILivrosOutputPort {
    private Map<String, LivrosInMemoria> livros = new HashMap<>();

    @Override
    public void create(Livro request) {
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

    public List<Livro> getAll() {
        return livros.values().stream().map(arg -> {
            return new Livro(
                arg.titulo(),
                arg.subtitulo(),
                arg.autor(),
                arg.volume(),
                arg.edicao(),
                arg.editora(),
                arg.idioma(),
                arg.generos(),
                arg.tags()
            );
        }).toList();
    }
}
