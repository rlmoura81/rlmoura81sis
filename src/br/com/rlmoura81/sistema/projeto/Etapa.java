package br.com.rlmoura81.sistema.projeto;

public class Etapa {

    private int cd_etapa;
    private String ds_etapa;
    private String ds_descricao;
    private TipoEtapa tipoetapa;
    private StatusEtapa statusetapa;
    private Modulo modulo;
    private int cd_usuario;

    public int getCd_etapa() {
        return cd_etapa;
    }

    public void setCd_etapa(int cd_etapa) {
        this.cd_etapa = cd_etapa;
    }

    public String getDs_etapa() {
        return ds_etapa;
    }

    public void setDs_etapa(String ds_etapa) {
        this.ds_etapa = ds_etapa;
    }

    public String getDs_descricao() {
        return ds_descricao;
    }

    public void setDs_descricao(String ds_descricao) {
        this.ds_descricao = ds_descricao;
    }

    public TipoEtapa getTipoetapa() {
        return tipoetapa;
    }

    public void setTipoetapa(TipoEtapa tipoetapa) {
        this.tipoetapa = tipoetapa;
    }

    public StatusEtapa getStatusetapa() {
        return statusetapa;
    }

    public void setStatusetapa(StatusEtapa statusetapa) {
        this.statusetapa = statusetapa;
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

    public Etapa(int cd_etapa, String ds_etapa, String ds_descricao, TipoEtapa tipoetapa, StatusEtapa statusetapa, Modulo modulo, int cd_usuario) {
        this.cd_etapa = cd_etapa;
        this.ds_etapa = ds_etapa;
        this.ds_descricao = ds_descricao;
        this.tipoetapa = tipoetapa;
        this.statusetapa = statusetapa;
        this.modulo = modulo;
        this.cd_usuario = cd_usuario;
    }

    public Etapa() {
    }

    @Override
    public String toString() {
        return "Etapa{" + "cd_etapa=" + cd_etapa + ", ds_etapa=" + ds_etapa + ", ds_descricao=" + ds_descricao + ", tipoetapa=" + tipoetapa + ", statusetapa=" + statusetapa + ", modulo=" + modulo + ", cd_usuario=" + cd_usuario + '}';
    }
    
}
