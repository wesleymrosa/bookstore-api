package br.wesley.bookstore.service;

import br.wesley.bookstore.domain.Livro;
import br.wesley.bookstore.repositories.LivroRepository;
import br.wesley.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro findById(Long id) {
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Objeto não encontrado ! id: " + id + " Tipo: " + Livro.class.getName()));
    }
}
