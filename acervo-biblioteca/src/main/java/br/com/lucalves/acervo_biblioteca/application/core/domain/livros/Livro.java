package br.com.lucalves.acervo_biblioteca.application.core.domain.livros;

import java.util.List;
import java.util.Objects;

public record Livro(
        String titulo,
        String subtitulo,
        String autor,
        int volume,
        String edicao,
        String editora,
        String idioma,
        List<String> generos,
        List<String> tags,
        Long id
) {
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro that = (Livro) o;
        return volume == that.volume && Objects.equals(autor, that.autor) && Objects.equals(titulo, that.titulo) && Objects.equals(edicao, that.edicao) && Objects.equals(idioma, that.idioma) && Objects.equals(editora, that.editora) && Objects.equals(subtitulo, that.subtitulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, subtitulo, autor, volume, edicao, editora, idioma);
    }
}
