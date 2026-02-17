package br.com.lucalves.acervo_biblioteca.adapters.output;

import br.com.lucalves.acervo_biblioteca.adapters.output.domain.inmemoria.LivrosInMemoria;
import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.Livro;
import br.com.lucalves.acervo_biblioteca.application.ports.output.ILivrosOutputPort;
import br.com.lucalves.acervo_biblioteca.communs.exceptions.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LivrosInMemoriaAdapter implements ILivrosOutputPort {
    private Map<Long, LivrosInMemoria> livros = new HashMap<>();

    @Override
    public Long create(Livro request) {
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

        if(!livros.containsValue(livrosInMemoria)) {
            Long id = (long)livros.values().size();
            id = id + 1;
            livros.put(id, livrosInMemoria);
            return id;
        }

        return livros.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(livrosInMemoria))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow();
    }

    @Override
    public Livro get(Long id) {
        if(!livros.containsKey(id))
            throw new NotFoundException("Id " + id + " não encontrado");

        LivrosInMemoria livrosInMemoria = livros.get(id);
        return new Livro(
                livrosInMemoria.titulo(),
                livrosInMemoria.subtitulo(),
                livrosInMemoria.autor(),
                livrosInMemoria.volume(),
                livrosInMemoria.edicao(),
                livrosInMemoria.editora(),
                livrosInMemoria.idioma(),
                livrosInMemoria.generos(),
                livrosInMemoria.tags(),
                id
        );
    }

    public List<Livro> getAll() {
        return livros.entrySet().stream().map(arg -> new Livro(
                arg.getValue().titulo(),
                arg.getValue().subtitulo(),
                arg.getValue().autor(),
                arg.getValue().volume(),
                arg.getValue().edicao(),
                arg.getValue().editora(),
                arg.getValue().idioma(),
                arg.getValue().generos(),
                arg.getValue().tags(),
                arg.getKey()
            )).toList();
    }

    @Override
    public void delete(Long id) {
        livros.remove(id);
    }

    @Override
    public void edite(Long id, Livro request) {
        if(!livros.containsKey(id))
            return;

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

        livros.put(id, livrosInMemoria);
    }
}
