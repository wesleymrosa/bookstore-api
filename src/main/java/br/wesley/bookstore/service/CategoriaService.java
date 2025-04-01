package br.wesley.bookstore.service;

import br.wesley.bookstore.domain.Categoria;
import br.wesley.bookstore.service.exceptions.ObjectNotFoundException;
import br.wesley.bookstore.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria findById (Long id){
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException(
                "Objeto não encontrado " + id + ", tipo: " + Categoria.class.getName()));
    }
}
