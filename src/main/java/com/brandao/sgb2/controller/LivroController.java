//é responsável por gerenciar a comunicação entre a interface do usuário (View) e a lógica de negócios (Model)

package com.brandao.sgb2.controller;

import com.brandao.sgb2.dto.LivroDTO;
import com.brandao.sgb2.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

   @Autowired
   private LivroService livroService;

   //Mapeamento de Endpoints

   @GetMapping
   public List<LivroDTO>getAllLivros(){
       return livroService.getAllLivros();
   }

   @PostMapping
   public LivroDTO createLivro(@RequestBody LivroDTO livroDTO){
       return livroService.saveLivro(livroDTO);
   }

   @PutMapping("/{id}")
   public LivroDTO updateLivro(@PathVariable Long id, @RequestBody LivroDTO livroDTO) {
       return livroService.updateLivro(id, livroDTO);
   }

   @DeleteMapping("/{id}")
   public void deleteLivro(@PathVariable Long id) {
       livroService.deleteLivro(id);
   }
}
