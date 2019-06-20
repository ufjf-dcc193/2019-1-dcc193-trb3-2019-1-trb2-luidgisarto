package br.ufjf.luidgisarto.trb2.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "avaliador")
public class Avaliador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "avaliador_id")
    private Integer id;
    private String nome;

    private String email;

    private String codigo;

    @OneToMany(mappedBy = "avaliador")
    private List<Revisao> revisoes;

    @ManyToMany
    @JoinTable(joinColumns = {
    @JoinColumn(name = "avaliador_id") }, inverseJoinColumns = { @JoinColumn(name = "area_id") })
    @NotEmpty(message = "O campo deve possuir pelo menos um selecionado")
    private List<Area> areas;
    
    public Avaliador() {
        
    }

    public Avaliador(String nome, Area area) {
        this.areas = new ArrayList<>();
        this.nome = nome;
        this.areas.add(area);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
