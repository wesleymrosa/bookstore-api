package br.wesley.bookstore.controller;

import br.wesley.bookstore.domain.Categoria;
import br.wesley.bookstore.dtos.CategoriaDto;
import br.wesley.bookstore.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "v1/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> findAll() {
        List<Categoria> list = categoriaService.findAll();
        List<CategoriaDto> listDTO = list.stream()
                .map(obj -> new CategoriaDto(obj))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> create(@Valid @RequestBody CategoriaDto dto) {

        Categoria obj = new Categoria();
        obj.setId(null); // Isso é crucial!
        obj.setNome(dto.getNome());
        obj.setDescricao(dto.getDescricao());

        Categoria saved = categoriaService.create(obj);
        return ResponseEntity.ok().body(new CategoriaDto(saved));
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDto> update(@PathVariable Long id, @Valid @RequestBody CategoriaDto objDto) {
        Categoria newObj = categoriaService.update(id, objDto);
        return ResponseEntity.ok().body(new CategoriaDto(newObj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


//    @PostMapping
//    public ResponseEntity<CategoriaDto> create(@Valid @RequestBody CategoriaDto dto) {
//        Categoria obj = new Categoria(null, dto.getNome(), dto.getDescricao(), new ArrayList<>());
//        Categoria saved = categoriaService.create(obj);
//        return ResponseEntity.ok().body(new CategoriaDto(saved));
//    }


//    @PostMapping
//    public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria obj) {
//        obj = categoriaService.create(obj);
//        return ResponseEntity.ok().body(obj);
//    }