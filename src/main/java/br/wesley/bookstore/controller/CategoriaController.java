package br.wesley.bookstore.controller;

import br.wesley.bookstore.domain.Categoria;
import br.wesley.bookstore.dtos.CategoriaDto;
import br.wesley.bookstore.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Categorias", description = "Operações com categorias de livros")
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todas as categorias")
    @ApiResponse(responseCode = "200", description = "Categorias listadas com sucesso")
    @GetMapping
    public List<Categoria> listarTodas() {
        return service.findAll();
    }

    @Operation(summary = "Criar nova categoria")
    @ApiResponse(responseCode = "201", description = "Categoria criada com sucesso")
    @PostMapping
    public Categoria criar(@RequestBody Categoria categoria) {
        return service.create(categoria);
    }

    @Operation(summary = "Buscar categoria por ID")
    @ApiResponse(responseCode = "200", description = "Categoria localizada")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @GetMapping("/{id}")
    public Categoria buscarPorId(@PathVariable Long id) {
        return service.findById(id);
    }

    @Operation(summary = "Atualizar categoria por ID")
    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso")
    @PutMapping("/{id}")
    public Categoria atualizar(
            @PathVariable Long id,
            @RequestBody CategoriaDto categoriaDto) {
        return service.update(id, categoriaDto);
    }

    @Operation(summary = "Deletar categoria por ID")
    @ApiResponse(responseCode = "204", description = "Categoria removida com sucesso")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.delete(id);
    }
}
