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

    @Column(name = "id_categoria_pai")
    private Integer idPai;

    @ManyToOne
    @JoinColumn(name = "id_categoria_pai")
    private Categoria categoria;

    @OneToMany(mappedBy = "categoria")
    private List<Categoria> categorias;

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

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public Integer getIdPai() {
        return idPai;
    }

    public void setIdPai(Integer idPai) {
        this.idPai = idPai;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
