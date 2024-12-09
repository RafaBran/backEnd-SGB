package com.brandao.sgb2.controller;

import com.brandao.sgb2.dto.AutorDTO;
import com.brandao.sgb2.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<AutorDTO> getAllAutores(){
        return autorService.getAllAutores();
    }

    @PostMapping
    public AutorDTO createAutor(@RequestBody AutorDTO autorDTO) {
        return autorService.saveAutor(autorDTO);
    }

    @PutMapping("/{id}")
    public AutorDTO updateAutor(@PathVariable Long id, @RequestBody AutorDTO autorDTO) {
        return autorService.updateAutor(id, autorDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAutor(@PathVariable Long id) {
        autorService.deleteAutor(id);
    }
}
