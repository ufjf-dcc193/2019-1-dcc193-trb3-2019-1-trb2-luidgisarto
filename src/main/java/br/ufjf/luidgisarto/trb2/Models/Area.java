package br.ufjf.luidgisarto.trb2.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "area_id")
    private Long id;
    private String descricao;

    @ManyToMany(mappedBy = "areas")
    private List<Avaliador> avaliadores;

    @OneToMany(mappedBy = "area")
    private List<Trabalho> trabalhos;

    public Area() {

    }

    public Area(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Trabalho> getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(List<Trabalho> trabalhos) {
        this.trabalhos = trabalhos;
    }

    public List<Avaliador> getAvaliadores() {
        return avaliadores;
    }

    public void setAvaliadores(List<Avaliador> avaliadores) {
        this.avaliadores = avaliadores;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
