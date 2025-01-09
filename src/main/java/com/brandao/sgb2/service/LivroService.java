//são responsáveis por encapsular a lógica de negócios
//atuam como intermediários entre os Controladores (Controllers) e os Repositórios (Repositories).

package com.brandao.sgb2.service;

import com.brandao.sgb2.dto.LivroDTO;
import com.brandao.sgb2.model.Autor;
import com.brandao.sgb2.model.Categoria;
import com.brandao.sgb2.model.Livro;
import com.brandao.sgb2.repository.AutorRepository;
import com.brandao.sgb2.repository.CategoriaRepository;
import com.brandao.sgb2.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<LivroDTO> getAllLivros(){
        return livroRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public LivroDTO saveLivro(LivroDTO livroDTO) {
        Livro livro = convertToEntity(livroDTO);
        Livro savedLivro = livroRepository.save(livro);
        return convertToDto(savedLivro);
    }

    public LivroDTO updateLivro(Long id, LivroDTO livroDTO) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        livro.setTitulo(livroDTO.titulo());
        livro.setIsbn(livroDTO.isbn());

        Autor autor = autorRepository.findById(livroDTO.autorId())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
        Categoria categoria = categoriaRepository.findById(livroDTO.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        livro.setAutor(autor);
        livro.setCategoria(categoria);

        Livro updatedLivro = livroRepository.save(livro);
        return convertToDto(updatedLivro);
    }

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }

    private LivroDTO convertToDto(Livro livro) {
        Long autorId = livro.getAutor() != null ? livro.getAutor().getId() : null;
        String autorNome = livro.getAutor() != null ? livro.getAutor().getNome() : "Autor não definido";
        Long categoriaId = livro.getCategoria() != null ? livro.getCategoria().getId() : null;
        String categoriaNome = livro.getCategoria() != null ? livro.getCategoria().getNome() : "Categoria não definida";

        return new LivroDTO(
                livro.getId(),
                livro.getTitulo(),
                livro.getIsbn(),
                autorId,
                autorNome,
                categoriaId,
                categoriaNome
        );
    }

    private Livro convertToEntity(LivroDTO livroDTO) {
        Livro livro = new Livro();
        livro.setId(livroDTO.id());
        livro.setTitulo(livroDTO.titulo());
        livro.setIsbn(livroDTO.isbn());

        Autor autor = autorRepository.findById(livroDTO.autorId())
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
        Categoria categoria = categoriaRepository.findById(livroDTO.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        livro.setAutor(autor);
        livro.setCategoria(categoria);
        return livro;
    }
}
