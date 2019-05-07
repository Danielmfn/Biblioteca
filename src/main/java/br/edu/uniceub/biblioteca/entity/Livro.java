package br.edu.uniceub.biblioteca.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_livro")
public class Livro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livro")
    private Integer id;

    @Column(name = "ds_titulo")
    private String titulo;

    @Column(name = "ds_isbn")
    private String isbn;

    @Column(name = "ds_autor")
    private String autor;

    @Column(name = "dt_aquisicao")
    private LocalDate aquisicao;

    @OneToMany(mappedBy = "livro")
    private List<Emprestimo> emprestimos;

    @ManyToOne
    @JoinColumn(name = "id_localizacao")
    private Localizacao localizacao;

    @ManyToOne
    @JoinColumn(name = "id_categoria_livro")
    private Categoria categoria;

    public Livro() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Livro livro = (Livro) o;

        return id.equals(livro.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getAquisicao() {
        return aquisicao;
    }

    public void setAquisicao(LocalDate aquisicao) {
        this.aquisicao = aquisicao;
    }
}
