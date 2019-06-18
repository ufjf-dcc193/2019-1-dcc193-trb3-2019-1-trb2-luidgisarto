package br.ufjf.luidgisarto.trb2.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String descricao;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Trabalho> trabalhos;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Avaliador> avaliadores;

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
}
