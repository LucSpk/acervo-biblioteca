package br.com.lucalves.acervo_biblioteca.application.core.domain.livros;

import java.util.List;

public record CreateNewLivroRequest(
        String titulo,
        String suubtitulo,
        String autor,
        int volume,
        String editora,
        String idioma,
        List<String> tags
) {
}
