package br.wesley.bookstore.controller;

import br.wesley.bookstore.domain.Livro;
import br.wesley.bookstore.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Livros", description = "Operações com livros cadastrados")
@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todos os livros de uma categoria")
    @ApiResponse(responseCode = "200", description = "Livros listados com sucesso")
    @GetMapping
    public List<Livro> listarTodos(
            @Parameter(description = "ID da categoria para filtragem", required = true)
            @RequestParam(value = "categoria") Long idCategoria) {
        return service.findAll(idCategoria);
    }

    @Operation(summary = "Criar novo livro em uma categoria")
    @ApiResponse(responseCode = "201", description = "Livro criado com sucesso")
    @PostMapping
    public Livro criar(
            @Parameter(description = "ID da categoria onde o livro será criado", required = true)
            @RequestParam(value = "categoria") Long idCategoria,
            @RequestBody Livro livro) {
        return service.create(idCategoria, livro);
    }

    @Operation(summary = "Buscar livro por ID")
    @ApiResponse(responseCode = "200", description = "Livro localizado")
    @ApiResponse(responseCode = "404", description = "Livro não encontrado")
    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id) {
        return service.findById(id);
    }

    @Operation(summary = "Atualizar livro por ID")
    @ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso")
    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id,
                           @RequestBody Livro livro) {
        return service.update(id, livro);
    }

    @Operation(summary = "Remover livro por ID")
    @ApiResponse(responseCode = "204", description = "Livro removido com sucesso")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.delete(id);
    }
}
