package br.edu.uniceub.biblioteca.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_localizacao")
public class Localizacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localizacao")
    private Integer id;

    @Column(name = "ds_localizacao")
    private String localizacao;

    @OneToMany(mappedBy = "localizacao")
    private List<Livro> livros;

    public Localizacao() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Localizacao that = (Localizacao) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
