package br.com.rlmoura81.financeiro;

import br.com.rlmoura81.sistema.projeto.Modulo;
import br.com.rlmoura81.sistema.projeto.Projeto;
import java.math.BigDecimal;

public class ValoresProjetos {

    private BigDecimal vl_mensalidade;
    private BigDecimal vl_mensalidadeporcent;
    private Projeto projeto;
    private Modulo modulo;
    private int cd_usuario;

    public BigDecimal getVl_mensalidade() {
        return vl_mensalidade;
    }

    public void setVl_mensalidade(BigDecimal vl_mensalidade) {
        this.vl_mensalidade = vl_mensalidade;
    }

    public BigDecimal getVl_mensalidadeporcent() {
        return vl_mensalidadeporcent;
    }

    public void setVl_mensalidadeporcent(BigDecimal vl_mensalidadeporcent) {
        this.vl_mensalidadeporcent = vl_mensalidadeporcent;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public ValoresProjetos(BigDecimal vl_mensalidade, BigDecimal vl_mensalidadeporcent, Projeto projeto, Modulo modulo, int cd_usuario) {
        this.vl_mensalidade = vl_mensalidade;
        this.vl_mensalidadeporcent = vl_mensalidadeporcent;
        this.projeto = projeto;
        this.modulo = modulo;
        this.cd_usuario = cd_usuario;
    }
    
    public ValoresProjetos(BigDecimal vl_mensalidade, BigDecimal vl_mensalidadeporcent, Projeto projeto, int cd_usuario) {
        this.vl_mensalidade = vl_mensalidade;
        this.vl_mensalidadeporcent = vl_mensalidadeporcent;
        this.projeto = projeto;
        this.cd_usuario = cd_usuario;
    }    

    public ValoresProjetos() {
    }

    @Override
    public String toString() {
        return "ValoresProjetos{" + "vl_mensalidade=" + vl_mensalidade + ", vl_mensalidadeporcent=" + vl_mensalidadeporcent + ", projeto=" + projeto + ", cd_usuario=" + cd_usuario + '}';
    }
            
}
