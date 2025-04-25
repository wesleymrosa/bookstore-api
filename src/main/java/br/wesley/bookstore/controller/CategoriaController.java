package br.wesley.bookstore.controller;

import br.wesley.bookstore.domain.Categoria;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Categorias", description = "Operações com categorias de livros")
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Operation(summary = "Listar todas as categorias")
    @ApiResponse(responseCode = "200", description = "Categorias listadas com sucesso")
    @GetMapping
    public List<Categoria> listarTodas() {
        return List.of();
    }

    @Operation(summary = "Criar nova categoria")
    @ApiResponse(responseCode = "201", description = "Categoria criada com sucesso")
    @PostMapping
    public Categoria criar(@RequestBody Categoria categoria) {
        return categoria;
    }

    @Operation(summary = "Buscar categoria por ID")
    @ApiResponse(responseCode = "200", description = "Categoria localizada")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @GetMapping("/{id}")
    public Categoria buscarPorId(
            @Parameter(description = "ID da categoria") @PathVariable Long id) {
        return new Categoria();
    }

    @Operation(summary = "Atualizar categoria por ID")
    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso")
    @PutMapping("/{id}")
    public Categoria atualizar(
            @Parameter(description = "ID da categoria") @PathVariable Long id,
            @RequestBody Categoria categoria) {
        return categoria;
    }

    @Operation(summary = "Deletar categoria por ID")
    @ApiResponse(responseCode = "204", description = "Categoria removida com sucesso")
    @DeleteMapping("/{id}")
    public void deletar(
            @Parameter(description = "ID da categoria") @PathVariable Long id) {
    }
}
