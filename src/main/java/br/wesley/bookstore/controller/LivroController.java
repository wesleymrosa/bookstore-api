package br.wesley.bookstore.controller;

import br.wesley.bookstore.domain.Livro;
import br.wesley.bookstore.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "v1/livros")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id) {
        Livro obj = livroService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> findAll(@RequestParam(value = "categoria") Long id_cat) {
        List<Livro> list = livroService.findAll(id_cat);
        return ResponseEntity.ok().body(list);
    }


//    @GetMapping
//    public ResponseEntity<List<LivroDto>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Long id_cat) {
//        List<Livro> list = livroService.findAll(id_cat);
//        List<LivroDto> listDto = list.stream().map(obj -> new LivroDto(obj)).collect(Collectors.toList());
//        return ResponseEntity.ok().body(listDto);
//    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update(@PathVariable Long id, @Valid @RequestBody Livro obj) {
        Livro newObj = livroService.update(id, obj);
        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestParam(value = "categoria", defaultValue = "0")
                                        Long id_cat, @Valid @RequestBody Livro obj) {
        Livro newObj = livroService.create(id_cat, obj);
        return ResponseEntity.status(201).body(newObj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
