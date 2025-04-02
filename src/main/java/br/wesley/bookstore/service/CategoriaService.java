package br.wesley.bookstore.service;

import br.wesley.bookstore.domain.Categoria;
import br.wesley.bookstore.dtos.CategoriaDto;
import br.wesley.bookstore.repositories.CategoriaRepository;
import br.wesley.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria findById(Long id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado " + id + ", tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return categoriaRepository.save(obj);
    }

    public Categoria update(Long id, CategoriaDto objDto) {
        Categoria obj = findById(id);
        obj.getNome(obj.getNome());
        obj.setDescricao(obj.getDescricao());
        return categoriaRepository.save(obj);
    }
}
