package com.brandao.sgb2.dto;

public record LivroDTO(
        Long id,
        String titulo,
        String isbn,
        Long autorId,
        Long categoriaId
) {}
