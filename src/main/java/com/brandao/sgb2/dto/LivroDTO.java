
//DTO, Data Transfer Object (Objeto de Transferência de Dados)
// padrão de design usado para transportar dados entre diferentes camadas de uma aplicação
// DTO é uma simples classe

package com.brandao.sgb2.dto;

public record LivroDTO(
        Long id,
        String titulo,
        String isbn,
        Long autorId,
        Long categoriaId
) {}
