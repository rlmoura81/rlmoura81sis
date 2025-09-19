package br.com.rlmoura81.sistema.geral;

import java.math.BigDecimal;
import java.util.Calendar;

public class CadastroGeral {
    
    private int cd_cadgeral;
    private String ds_cadgeral;
    private int nm_qtde;
    private BigDecimal nm_valor;
    private Calendar dt_cadgeral;
    private int nm_hora;
    private Grupo grupo;
    private int cd_usuario;

    public int getCd_cadgeral() {
        return cd_cadgeral;
    }

    public void setCd_cadgeral(int cd_cadgeral) {
        this.cd_cadgeral = cd_cadgeral;
    }

    public String getDs_cadgeral() {
        return ds_cadgeral;
    }

    public void setDs_cadgeral(String ds_cadgeral) {
        this.ds_cadgeral = ds_cadgeral;
    }

    public int getNm_qtde() {
        return nm_qtde;
    }

    public void setNm_qtde(int nm_qtde) {
        this.nm_qtde = nm_qtde;
    }

    public BigDecimal getNm_valor() {
        return nm_valor;
    }

    public void setNm_valor(BigDecimal nm_valor) {
        this.nm_valor = nm_valor;
    }

    public Calendar getDt_cadgeral() {
        return dt_cadgeral;
    }

    public void setDt_cadgeral(Calendar dt_cadgeral) {
        this.dt_cadgeral = dt_cadgeral;
    }

    public int getNm_hora() {
        return nm_hora;
    }

    public void setNm_hora(int nm_hora) {
        this.nm_hora = nm_hora;
    }
    
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    
    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public CadastroGeral(int cd_cadgeral, String ds_cadgeral, BigDecimal nm_valor, Calendar dt_cadgeral, int nm_hora, Grupo grupo, int cd_usuario) {
        this.cd_cadgeral = cd_cadgeral;
        this.ds_cadgeral = ds_cadgeral;
        this.nm_valor = nm_valor;
        this.dt_cadgeral = dt_cadgeral;
        this.nm_hora = nm_hora;
        this.grupo = grupo;
        this.cd_usuario = cd_usuario;
    }

    public CadastroGeral(int cd_cadgeral, String ds_cadgeral, int nm_qtde, BigDecimal nm_valor, Calendar dt_cadgeral, int nm_hora, int cd_usuario) {
        this.cd_cadgeral = cd_cadgeral;
        this.ds_cadgeral = ds_cadgeral;
        this.nm_qtde = nm_qtde;
        this.nm_valor = nm_valor;
        this.dt_cadgeral = dt_cadgeral;
        this.nm_hora = nm_hora;
        this.cd_usuario = cd_usuario;
    }
    
    public CadastroGeral(int cd_cadgeral, String ds_cadgeral, int nm_qtde, BigDecimal nm_valor, Calendar dt_cadgeral, int cd_usuario) {
        this.cd_cadgeral = cd_cadgeral;
        this.ds_cadgeral = ds_cadgeral;
        this.nm_qtde = nm_qtde;
        this.nm_valor = nm_valor;
        this.dt_cadgeral = dt_cadgeral;
        this.cd_usuario = cd_usuario;
    }
    
    public CadastroGeral(int cd_cadgeral, BigDecimal nm_valor, Calendar dt_cadgeral, int cd_usuario) {
        this.cd_cadgeral = cd_cadgeral;
        this.nm_valor = nm_valor;
        this.dt_cadgeral = dt_cadgeral;
        this.cd_usuario = cd_usuario;
    }

    public CadastroGeral() {
    }

    @Override
    public String toString() {
        return "CadGeral{" + "cd_cadgeral=" + cd_cadgeral + ", ds_cadgeral=" + ds_cadgeral + ", nm_qtde=" + nm_qtde + ", nm_valor=" + nm_valor + ", dt_cadgeral=" + dt_cadgeral + ", cd_usuario=" + cd_usuario + '}';
    }
           
}
