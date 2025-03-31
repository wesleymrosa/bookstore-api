package br.wesley.bookstore.repositories;

import br.wesley.bookstore.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Long, Livro> {
}
