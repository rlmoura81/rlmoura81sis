package br.com.rlmoura81.sistema.projeto;

import java.math.BigDecimal;

public class Modulo {
    
    private int cd_modulo;
    private String ds_modulo;
    private String ds_descricao;
    private BigDecimal nm_hora;
    private int nm_complexidade;
    private BigDecimal nm_horacomplexidade;
    private Projeto projeto;
    private int cd_usuario;

    public int getCd_modulo() {
        return cd_modulo;
    }

    public void setCd_modulo(int cd_modulo) {
        this.cd_modulo = cd_modulo;
    }

    public String getDs_modulo() {
        return ds_modulo;
    }

    public void setDs_modulo(String ds_modulo) {
        this.ds_modulo = ds_modulo;
    }

    public String getDs_descricao() {
        return ds_descricao;
    }

    public void setDs_descricao(String ds_descricao) {
        this.ds_descricao = ds_descricao;
    }

    public BigDecimal getNm_hora() {
        return nm_hora;
    }

    public void setNm_hora(BigDecimal nm_hora) {
        this.nm_hora = nm_hora;
    }

    public int getNm_complexidade() {
        return nm_complexidade;
    }

    public void setNm_complexidade(int nm_complexidade) {
        this.nm_complexidade = nm_complexidade;
    }

    public BigDecimal getNm_horacomplexidade() {
        return nm_horacomplexidade;
    }

    public void setNm_horacomplexidade(BigDecimal nm_horacomplexidade) {
        this.nm_horacomplexidade = nm_horacomplexidade;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Modulo(int cd_modulo, String ds_modulo, String ds_descricao, BigDecimal nm_hora, int nm_complexidade, BigDecimal nm_horacomplexidade, Projeto projeto, int cd_usuario) {
        this.cd_modulo = cd_modulo;
        this.ds_modulo = ds_modulo;
        this.ds_descricao = ds_descricao;
        this.nm_hora = nm_hora;
        this.nm_complexidade = nm_complexidade;
        this.nm_horacomplexidade = nm_horacomplexidade;
        this.projeto = projeto;
        this.cd_usuario = cd_usuario;
    }    

    public Modulo(int cd_modulo, BigDecimal nm_hora, BigDecimal nm_horacomplexidade, Projeto projeto, int cd_usuario) {
        this.cd_modulo = cd_modulo;
        this.nm_hora = nm_hora;
        this.nm_horacomplexidade = nm_horacomplexidade;
        this.projeto = projeto;
        this.cd_usuario = cd_usuario;
    }
        
    public Modulo() {
    }

    @Override
    public String toString() {
        return "Modulo{" + "cd_modulo=" + cd_modulo + ", ds_modulo=" + ds_modulo + ", ds_descricao=" + ds_descricao + ", nm_hora=" + nm_hora + ", nm_complexidade=" + nm_complexidade + ", nm_horacomplexidade=" + nm_horacomplexidade + ", projeto=" + projeto + ", cd_usuario=" + cd_usuario + '}';
    }

       
}
