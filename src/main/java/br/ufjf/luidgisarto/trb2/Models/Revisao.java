package br.ufjf.luidgisarto.trb2.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import br.ufjf.luidgisarto.trb2.enums.SituacaoRevisao;

@Entity
public class Revisao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "revisao_id")
    private Long id;

    @Min(value = 0, message = "o valor mínimo permitido é 0")
    @Max(value = 100, message = "o valor máximo permitido é de 100")
    private Integer nota;
    private String descricao;

    @ManyToOne
    private Avaliador avaliador;
    @ManyToOne
    private Trabalho trabalho;

    @Enumerated
    private SituacaoRevisao situacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Avaliador getAvaliador() {
        return avaliador;
    }

    public void setAvaliador(Avaliador avaliador) {
        this.avaliador = avaliador;
    }

    public Trabalho getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(Trabalho trabalho) {
        this.trabalho = trabalho;
    }

    public SituacaoRevisao getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoRevisao situacao) {
        this.situacao = situacao;
    }
}
