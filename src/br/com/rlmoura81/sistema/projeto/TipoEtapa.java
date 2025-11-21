package br.com.rlmoura81.sistema.projeto;

public class TipoEtapa {
    
    private int cd_tpetapa;
    private String ds_tpetapa;

    public int getCd_tpetapa() {
        return cd_tpetapa;
    }

    public void setCd_tpetapa(int cd_tpetapa) {
        this.cd_tpetapa = cd_tpetapa;
    }

    public String getDs_tpetapa() {
        return ds_tpetapa;
    }

    public void setDs_tpetapa(String ds_tpetapa) {
        this.ds_tpetapa = ds_tpetapa;
    }

    public TipoEtapa(int cd_tpetapa, String ds_tpetapa) {
        this.cd_tpetapa = cd_tpetapa;
        this.ds_tpetapa = ds_tpetapa;
    }

    public TipoEtapa() {
    }

    @Override
    public String toString() {
        return "TipoEtapa{" + "cd_tpetapa=" + cd_tpetapa + ", ds_tpetapa=" + ds_tpetapa + '}';
    }
        
}
