package br.wesley.bookstore.dtos;

import br.wesley.bookstore.domain.Categoria;
import br.wesley.bookstore.domain.Livro;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    @NotEmpty(message = "Campo nome é obrigatório !")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres.")
    private String nome;
    @NotEmpty(message = "Campo descrição é obrigatório !")
    @Length(min = 3, max = 300, message = "O campo descrição deve ter entre 3 e 300 caracteres.")
    private String descricao;

    public CategoriaDto() {
    }

    public CategoriaDto(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
