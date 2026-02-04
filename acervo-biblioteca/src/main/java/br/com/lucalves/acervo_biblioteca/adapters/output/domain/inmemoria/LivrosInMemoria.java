package br.com.lucalves.acervo_biblioteca.adapters.output.domain.inmemoria;

import java.util.List;

public record LivrosInMemoria(
        String titulo,
        String subtitulo,
        String autor,
        int volume,
        String edicao,
        String editora,
        String idioma,
        List<String> generos,
        List<String> tags
) {
}
