package br.ufjf.luidgisarto.trb2.dtos;

public class TrabalhoAreaDto {
    private Long totalAvaliados;
    private String titulo;
    private String descricao;
    private String url;

    public TrabalhoAreaDto(String titulo, String descricao, String url) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.url = url;
    }

    public long getTotalAvaliados() {
        return totalAvaliados;
    }

    public void setTotalAvaliados(Long totalAvaliados) {
        this.totalAvaliados = totalAvaliados;
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
}
