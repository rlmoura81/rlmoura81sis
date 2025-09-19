package br.com.rlmoura81.sistema.principal;

public class Usuario {
    private int cd_usuario;
    private String ds_login;
    private String ds_senha;

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public String getDs_login() {
        return ds_login;
    }

    public void setDs_login(String ds_login) {
        this.ds_login = ds_login;
    }

    public String getDs_senha() {
        return ds_senha;
    }

    public void setDs_senha(String ds_senha) {
        this.ds_senha = ds_senha;
    }

    public Usuario(int cd_usuario, String ds_login, String ds_senha) {
        this.cd_usuario = cd_usuario;
        this.ds_login = ds_login;
        this.ds_senha = ds_senha;
    }

    public Usuario() {
    }

    @Override
    public String toString() {
        return ds_login;
    }
   
}
