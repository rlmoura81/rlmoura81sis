package br.com.rlmoura81.sistema.principal;

import br.com.rlmoura81.sistema.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioRepository implements IPadraoRepository{
    
    String sql = "";

    @Override
    public void inserir(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void alterar(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList getLista() {
        ArrayList usuario = new ArrayList();
        try{
            sql = "SELECT usuario cd_usuario, ds_login, ds_senha" +
                  "  FROM usuario";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Usuario u = new Usuario(
                    rs.getInt("cd_usuario"),
                    rs.getString("ds_login"),
                    rs.getString("ds_senha"));
                    usuario.add(u);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de usuarios:\n" +
                    ex.getMessage(), "Usuário", JOptionPane.ERROR_MESSAGE);
        }
        return usuario;
    }

    @Override
    public Object getById(int id) {
        Usuario usuario = null;
        try{
            sql = "SELECT cd_usuario, ds_login, ds_senha" + 
                  "  FROM usuario WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                usuario = new Usuario(
                    rs.getInt("cd_usuario"),
                    rs.getString("ds_login"),
                    rs.getString("ds_senha"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Erro de GetById em usuario:\n" +
                    ex.getMessage(), "Usuário", JOptionPane.ERROR_MESSAGE);
        }
        return usuario;
    }        
}