//As entidades JPA são classes Java que representam tabelas no banco de dados relacional.
//Mapeiam objeto-relacional em aplicações Java

//@Entity: Indica que a classe é uma entidade JPA.
//@Table(name = "livros"): Especifica a tabela no banco de dados à qual a entidade está mapeada.
//@Id: Denota o campo que é a chave primária da tabela.
//@GeneratedValue(strategy = GenerationType.IDENTITY): Indica que o valor da chave primária é gerado automaticamente pelo banco de dados.
//@Column(nullable = false): Especifica que a coluna não pode ter valores nulos.
//@ManyToOne: Define um relacionamento muitos-para-um com outra entidade.
//@JoinColumn(name = "autor_id"): Especifica a coluna de junção para o relacionamento muitos-para-um.

package com.brandao.sgb2.model;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String isbn;

    //RELACIONAMENTOS
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    //getters e setters
    //Os getters e setters são métodos especiais que permitem acessar e modificar os campos privados das classes de entidade.
    // Eles são colocados dentro das próprias classes de entidade, que estão localizadas no pacote model do projeto.

    public Long getId(){
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
