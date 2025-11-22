package br.com.rlmoura81.financeiro;

import java.math.BigDecimal;

public class Valores {
    
    private int cd_valor;
    private BigDecimal nm_salario;
    private BigDecimal vl_salario;
    private BigDecimal vl_hora;
    private int cd_usuario;

    public int getCd_valor() {
        return cd_valor;
    }

    public void setCd_valor(int cd_valor) {
        this.cd_valor = cd_valor;
    }

    public BigDecimal getNm_salario() {
        return nm_salario;
    }

    public void setNm_salario(BigDecimal nm_salario) {
        this.nm_salario = nm_salario;
    }

    public BigDecimal getVl_salario() {
        return vl_salario;
    }

    public void setVl_salario(BigDecimal vl_salario) {
        this.vl_salario = vl_salario;
    }

    public BigDecimal getVl_hora() {
        return vl_hora;
    }

    public void setVl_hora(BigDecimal vl_hora) {
        this.vl_hora = vl_hora;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Valores(int cd_valor, BigDecimal nm_salario, BigDecimal vl_salario, BigDecimal vl_hora, int cd_usuario) {
        this.cd_valor = cd_valor;
        this.nm_salario = nm_salario;
        this.vl_salario = vl_salario;
        this.vl_hora = vl_hora;
        this.cd_usuario = cd_usuario;
    }

    public Valores() {
    }

    @Override
    public String toString() {
        return "Valores{" + "cd_valor=" + cd_valor + ", nm_salario=" + nm_salario + ", vl_salario=" + vl_salario + ", vl_hora=" + vl_hora + ", cd_usuario=" + cd_usuario + '}';
    }

   
            
}
