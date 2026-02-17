package br.com.lucalves.acervo_biblioteca.communs.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String mensagem) {
        super(mensagem);
    }
}
