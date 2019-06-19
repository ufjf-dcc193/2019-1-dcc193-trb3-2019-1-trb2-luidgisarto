package br.ufjf.luidgisarto.trb2.enums;

public enum SituacaoRevisao {
    Pendente(0, "À Fazer"),
    Avaliado(1, "Avaliado"),
    Impedido(2, "Impedido"),
    Valido(3, "Validado"),
    Invalido(4, "Invalidado");

    private Integer id;
    private String descricao;

    SituacaoRevisao(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
