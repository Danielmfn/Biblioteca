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
    private String nome;

    @OneToMany(mappedBy = "localizacao")
    private List<Livro> livros;

    @Column(name = "id_localizacao_pai")
    private Integer idPai;

    @ManyToOne
    @JoinColumn(name = "id_localizacao_pai")
    private Localizacao localizacao;

    @OneToMany(mappedBy = "localizacao")
    private List<Localizacao> localizacoes;

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

    public List<Localizacao> getLocalizacoes() {
        return localizacoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPai() {
        return idPai;
    }

    public void setIdPai(Integer idPai) {
        this.idPai = idPai;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String localizacao) {
        this.nome = localizacao;
    }
}
