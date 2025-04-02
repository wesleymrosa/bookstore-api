package br.wesley.bookstore.dtos;

import br.wesley.bookstore.domain.Livro;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

public class LivroDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    @NotEmpty(message = "Campo título é obrigatório !")
    @Length(min = 3, max = 50, message = "O campo título deve ter entre 3 e 50 caracteres.")
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
