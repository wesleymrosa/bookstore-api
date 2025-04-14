package br.wesley.bookstore.domain;

import br.wesley.bookstore.dtos.CategoriaDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Campo nome é obrigatório !")
    @Length(min = 3, max = 100, message = "O campo nome deve ter entre 3 e 100 caracteres.")
    private String nome;
    @NotEmpty(message = "Campo descrição é obrigatório !")
    @Length(min = 3, max = 300, message = "O campo descrição deve ter entre 3 e 300 caracteres.")
    private String descricao;
    @JsonIgnore
    private List<Livro> livros = new ArrayList<>();

    public Categoria() {
    }

//    public Categoria(String nome, String descricao, List<Livro> livros) {
//        this.nome = nome;
//        this.descricao = descricao;
//        this.livros = livros;
//    }
//
//    public Categoria(Long id, String nome, String descricao, List<Livro> livros) {
//        this.id = id;
//        this.nome = nome;
//        this.descricao = descricao;
//        this.livros = livros;
//    }
//
//    public Categoria(CategoriaDto dto) {
//        this.id = dto.getId();
//        this.nome = dto.getNome();
//        this.descricao = dto.getDescricao();
//        this.livros = new ArrayList<>();
//    }

    public Categoria(CategoriaDto dto) {
        this.id = null; // ← Isso impede o erro de duplicidade
        this.nome = dto.getNome();
        this.descricao = dto.getDescricao();
        this.livros = new ArrayList<>();
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

    @JsonIgnore
    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id.equals(categoria.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", livros=" + livros +
                '}';
    }
}



