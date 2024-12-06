package com.brandao.sgb2.repository;

import com.brandao.sgb2.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
