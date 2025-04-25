package br.wesley.bookstore.controller;

import br.wesley.bookstore.domain.Livro;
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

    @Operation(summary = "Listar todos os livros")
    @ApiResponse(responseCode = "200", description = "Livros listados com sucesso")
    @GetMapping
    public List<Livro> listarTodos() {
        return List.of();
    }

    @Operation(summary = "Criar novo livro")
    @ApiResponse(responseCode = "201", description = "Livro criado com sucesso")
    @PostMapping
    public Livro criar(@RequestBody Livro livro) {
        return livro;
    }

    @Operation(summary = "Buscar livro por ID")
    @ApiResponse(responseCode = "200", description = "Livro localizado")
    @ApiResponse(responseCode = "404", description = "Livro não encontrado")
    @GetMapping("/{id}")
    public Livro buscarPorId(
            @Parameter(description = "ID do livro") @PathVariable Long id) {
        return new Livro();
    }

    @Operation(summary = "Atualizar livro por ID")
    @ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso")
    @PutMapping("/{id}")
    public Livro atualizar(
            @Parameter(description = "ID do livro") @PathVariable Long id,
            @RequestBody Livro livro) {
        return livro;
    }

    @Operation(summary = "Remover livro por ID")
    @ApiResponse(responseCode = "204", description = "Livro removido com sucesso")
    @DeleteMapping("/{id}")
    public void deletar(
            @Parameter(description = "ID do livro") @PathVariable Long id) {
    }
}
