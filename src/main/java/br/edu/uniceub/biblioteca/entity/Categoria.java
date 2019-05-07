package br.edu.uniceub.biblioteca.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_categoria_livro")
public class Categoria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria_livro")
    private Integer id;

    @Column(name = "ds_nome")
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Livro> livros;

    public Categoria() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Categoria categoria = (Categoria) o;

        return id.equals(categoria.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
