package br.wesley.bookstore.dtos;

import br.wesley.bookstore.domain.Livro;

import java.io.Serializable;

public class LivroDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String titulo;

    public LivroDto() {
    }

    public LivroDto(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
