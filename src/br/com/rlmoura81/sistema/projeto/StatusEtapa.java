package br.com.rlmoura81.sistema.projeto;

public class StatusEtapa {
    
    private int cd_stetapa;
    private String ds_stetapa;

    public int getCd_stetapa() {
        return cd_stetapa;
    }

    public void setCd_stetapa(int cd_stetapa) {
        this.cd_stetapa = cd_stetapa;
    }

    public String getDs_stetapa() {
        return ds_stetapa;
    }

    public void setDs_stetapa(String ds_stetapa) {
        this.ds_stetapa = ds_stetapa;
    }

    public StatusEtapa(int cd_stetapa, String ds_stetapa) {
        this.cd_stetapa = cd_stetapa;
        this.ds_stetapa = ds_stetapa;
    }
    
    public StatusEtapa() {
    }

    @Override
    public String toString() {
        return "StatusEtapa{" + "cd_stetapa=" + cd_stetapa + ", ds_stetapa=" + ds_stetapa + '}';
    }
    
}
