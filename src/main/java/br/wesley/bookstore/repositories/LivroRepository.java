package br.wesley.bookstore.repositories;

import br.wesley.bookstore.domain.Categoria;
import br.wesley.bookstore.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findAllByCategoria(Categoria categoria);
}

