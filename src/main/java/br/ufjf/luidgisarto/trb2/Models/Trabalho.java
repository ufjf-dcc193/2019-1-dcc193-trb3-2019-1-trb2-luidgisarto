package br.ufjf.luidgisarto.trb2.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Trabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trabalho_id")
    private Long id;

    @NotBlank(message = "O campo é obrigatório")
    private String titulo;

    @NotBlank(message = "O campo é obrigatório")
    private String descricao;

    @NotBlank(message = "O campo é obrigatório")
    private String url;

    @ManyToOne
    @NotNull(message = "O campo é obrigatório")
    private Area area;

    @OneToMany(mappedBy = "trabalho")
    private List<Revisao> revisoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
