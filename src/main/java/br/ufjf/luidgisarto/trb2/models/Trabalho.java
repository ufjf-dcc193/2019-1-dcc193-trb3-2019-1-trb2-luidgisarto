package br.ufjf.luidgisarto.trb2.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trabalho")
public class Trabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trabalho_id")
    private Integer id;

    private String titulo;

    private String descricao;

    private String url;

    @ManyToOne
    private Area area;

    @OneToMany(mappedBy = "trabalho")
    private List<Revisao> revisoes;

    public Trabalho() {
        revisoes = new ArrayList<>();
    }

    public Trabalho(String titulo, String descricao, Area a) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.area = a;
    }

    public Integer getTotalRevisoes() {
        return revisoes.size();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Revisao> getRevisoes() {
        return revisoes;
    }

    public void setRevisoes(List<Revisao> revisoes) {
        this.revisoes = revisoes;
    }

    @Override
    public String toString() {
        return this.titulo;
    }
}
