package br.com.lucalves.acervo_biblioteca.adapters.output.domain.inmemoria;

import java.util.List;

public record LivrosInMemoria(
        String titulo,
        String suubtitulo,
        String autor,
        int volume,
        String editora,
        String idioma,
        List<String> tags
) {
}
