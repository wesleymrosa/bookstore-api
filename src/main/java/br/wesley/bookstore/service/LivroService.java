package br.wesley.bookstore.service;

import br.wesley.bookstore.domain.Livro;
import br.wesley.bookstore.repositories.CategoriaRepository;
import br.wesley.bookstore.repositories.LivroRepository;
import br.wesley.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    private final CategoriaService categoriaService;


    public LivroService(LivroRepository livroRepository, CategoriaRepository categoriaRepository, CategoriaService categoriaService) {
        this.livroRepository = livroRepository;
        this.categoriaService = categoriaService;
    }

    public Livro findById(Long id) {
        Optional<Livro> obj = livroRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Objeto não encontrado ! id: " + id + " Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll(Long id_cat) {
        categoriaService.findById(id_cat);
        return livroRepository.findAllByCategoria(id_cat);
    }
}
