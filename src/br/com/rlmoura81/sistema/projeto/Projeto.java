package br.com.rlmoura81.sistema.projeto;

public class Projeto {
    
    private int cd_projeto;
    private String ds_projeto;
    private int cd_usuario;

    public int getCd_projeto() {
        return cd_projeto;
    }

    public void setCd_projeto(int cd_projeto) {
        this.cd_projeto = cd_projeto;
    }

    public String getDs_projeto() {
        return ds_projeto;
    }

    public void setDs_projeto(String ds_projeto) {
        this.ds_projeto = ds_projeto;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Projeto(int cd_projeto, String ds_projeto, int cd_usuario) {
        this.cd_projeto = cd_projeto;
        this.ds_projeto = ds_projeto;
        this.cd_usuario = cd_usuario;
    }

    public Projeto() {
    }

    @Override
    public String toString() {
        return "Projeto{" + "cd_projeto=" + cd_projeto + ", ds_projeto=" + ds_projeto + ", cd_usuario=" + cd_usuario + '}';
    }

            
}
