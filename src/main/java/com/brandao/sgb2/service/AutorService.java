package com.brandao.sgb2.service;

import com.brandao.sgb2.dto.AutorDTO;
import com.brandao.sgb2.model.Autor;
import com.brandao.sgb2.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<AutorDTO> getAllAutores() {
        return autorRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public AutorDTO saveAutor(AutorDTO autorDTO) {
        Autor autor = convertToEntity(autorDTO);
        Autor savedAutor = autorRepository.save(autor);
        return convertToDto(savedAutor);
    }

    public AutorDTO updateAutor(Long id, AutorDTO autorDTO) {
        Autor autor = autorRepository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado"));
        autor.setNome(autorDTO.nome());
        autor.setNacionalidade(autorDTO.nacionalidade());
        Autor updatedAutor = autorRepository.save(autor); return convertToDto(updatedAutor);
    }

    public void deleteAutor(Long id) {
        autorRepository.deleteById(id);
    }

    private AutorDTO convertToDto(Autor autor) {
        return new AutorDTO(
                autor.getId(),
                autor.getNome(),
                autor.getNacionalidade()
        );
    }

    private Autor convertToEntity(AutorDTO autorDTO) {
        Autor autor = new Autor();
        autor.setId(autorDTO.id());
        autor.setNome(autorDTO.nome());
        autor.setNacionalidade(autorDTO.nacionalidade());
        return autor;
    }
}
