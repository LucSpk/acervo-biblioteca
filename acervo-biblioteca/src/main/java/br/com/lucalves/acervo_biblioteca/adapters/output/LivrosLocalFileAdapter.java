package br.com.lucalves.acervo_biblioteca.adapters.output;

import br.com.lucalves.acervo_biblioteca.adapters.output.domain.inmemoria.LivrosInMemoria;
import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.Livro;
import br.com.lucalves.acervo_biblioteca.application.ports.output.ILivrosOutputPort;
import org.springframework.stereotype.Repository;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LivrosLocalFileAdapter implements ILivrosOutputPort {

    private static final String FILE_PATH = "./livros.json";
    private final ObjectMapper mapper = new ObjectMapper();

    private Map<Long, LivrosInMemoria> livros = new HashMap<>();

    public LivrosLocalFileAdapter() {
        carregaArquivo();
    }

    @Override
    public Long create(Livro request) {
        LivrosInMemoria novoLivro = new LivrosInMemoria(
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

        if(!livros.containsValue(novoLivro)) {
            Long id = livros.keySet()
                    .stream()
                    .max(Long::compareTo)
                    .orElse(0L) + 1;

            livros.put(id, novoLivro);
            salvarArquivo();
            return id;
        }

        return 0L;
    }

    @Override
    public Livro get(Long id) {
        if (!livros.containsKey(id))
            return null;

        LivrosInMemoria livro = livros.get(id);

        return new Livro(
                livro.titulo(),
                livro.subtitulo(),
                livro.autor(),
                livro.volume(),
                livro.edicao(),
                livro.editora(),
                livro.idioma(),
                livro.generos(),
                livro.tags(),
                id
        );
    }

    @Override
    public List<Livro> getAll() {
        return livros.entrySet()
            .stream()
            .map(entry -> new Livro(
                    entry.getValue().titulo(),
                    entry.getValue().subtitulo(),
                    entry.getValue().autor(),
                    entry.getValue().volume(),
                    entry.getValue().edicao(),
                    entry.getValue().editora(),
                    entry.getValue().idioma(),
                    entry.getValue().generos(),
                    entry.getValue().tags(),
                    entry.getKey()
            ))
            .toList();
    }

    @Override
    public void delete(Long id) {
        livros.remove(id);
        salvarArquivo();
    }

    @Override
    public void edite(Long id, Livro request) {

    }

    private void carregaArquivo() {
        File file = new File(FILE_PATH);

        if(!file.exists())
            criarArquivoVazio(file);

        try {
            livros = mapper.readValue(
                    file,
                    new TypeReference<Map<Long, LivrosInMemoria>>() {}
            );
        } catch (JacksonException e) {
            throw new RuntimeException("Erro ao carregar arquivo", e);
        }
    }

    private void criarArquivoVazio(File file) {
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }

        mapper.writerWithDefaultPrettyPrinter()
                .writeValue(file, new HashMap<Long, LivrosInMemoria>());
    }

    private void salvarArquivo() {
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(FILE_PATH), livros);
        } catch (JacksonException e) {
            throw new RuntimeException("Erro ao salvar arquivo", e);
        }
    }
}
