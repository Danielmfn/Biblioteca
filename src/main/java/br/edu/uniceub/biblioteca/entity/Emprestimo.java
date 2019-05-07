package br.edu.uniceub.biblioteca.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emprestimo")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;

    @Column(name = "dt_emprestimo")
    private LocalDate dtEmprestimo;

    @Column(name = "dt_devolucao")
    private LocalDate dtDevolucao;

    public Emprestimo() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Emprestimo that = (Emprestimo) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDtEmprestimo() {
        return dtEmprestimo;
    }

    public void setDtEmprestimo(LocalDate dtEmprestimo) {
        this.dtEmprestimo = dtEmprestimo;
    }

    public LocalDate getDtDevolucao() {
        return dtDevolucao;
    }

    public void setDtDevolucao(LocalDate dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }
}
