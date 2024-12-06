package com.brandao.sgb2.controller;

import com.brandao.sgb2.dto.CategoriaDTO;
import com.brandao.sgb2.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<CategoriaDTO> getAllCategorias(){
        return categoriaService.getAllCategorias();
    }

    @PostMapping
    public CategoriaDTO createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.saveCategoria(categoriaDTO);
    }

    @PutMapping("/{id}")
    public CategoriaDTO updateCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) { return categoriaService.updateCategoria(id, categoriaDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
    }
}
