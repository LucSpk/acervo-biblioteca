package br.com.lucalves.acervo_biblioteca.adapters.output;

import br.com.lucalves.acervo_biblioteca.adapters.output.domain.inmemoria.LivrosInMemoria;
import br.com.lucalves.acervo_biblioteca.application.core.domain.livros.CreateNewLivroRequest;
import br.com.lucalves.acervo_biblioteca.application.ports.output.ILivrosOutputPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LivrosInMemoriaAdapter implements ILivrosOutputPort {
    private List<LivrosInMemoria> livros = new ArrayList<>();
    private ModelMapper modelMapper;

    @Override
    public void create(CreateNewLivroRequest request) {
        LivrosInMemoria livrosInMemoria = modelMapper.map(request, LivrosInMemoria.class);
        livros.add(livrosInMemoria);
        livros.forEach(System.out::println);
    }
}
