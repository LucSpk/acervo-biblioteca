package br.com.lucalves.acervo_biblioteca.application.core.domain.livros;

import java.util.List;

public record CreateNewLivroRequest(
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
