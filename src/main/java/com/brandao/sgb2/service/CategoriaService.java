package com.brandao.sgb2.service;

import com.brandao.sgb2.dto.CategoriaDTO;
import com.brandao.sgb2.model.Categoria;
import com.brandao.sgb2.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaDTO> getAllCategorias() {
        return categoriaRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }
    public CategoriaDTO saveCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = convertToEntity(categoriaDTO);
        Categoria savedCategoria = categoriaRepository.save(categoria);
        return convertToDto(savedCategoria);
    }

    public CategoriaDTO updateCategoria(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada")); categoria.setNome(categoriaDTO.nome());
        Categoria updatedCategoria = categoriaRepository.save(categoria);
        return convertToDto(updatedCategoria);
    }

    public void deleteCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    private CategoriaDTO convertToDto(Categoria categoria) {
        return new CategoriaDTO(
                categoria.getId(),
                categoria.getNome());
    }

    private Categoria convertToEntity(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setId(categoriaDTO.id());
        categoria.setNome(categoriaDTO.nome());
        return categoria;
    }
}
