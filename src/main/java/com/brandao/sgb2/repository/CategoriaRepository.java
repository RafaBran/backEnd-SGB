package com.brandao.sgb2.repository;

import com.brandao.sgb2.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
