package br.com.rlmoura81.sistema.projeto;

import br.com.rlmoura81.sistema.principal.IPadraoRepository;
import br.com.rlmoura81.sistema.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProjetoRepository implements IPadraoRepository{

    String sql = "";
        
    @Override
    public void inserir(Object o) {
        Projeto p = (Projeto) o;
        try{
            sql = "INSERT INTO projeto(cd_projeto, ds_projeto, cd_usuario)" +
                  "     VALUES (sq_projeto.nextval, ?, ?)";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setString(1, p.getDs_projeto());
            ps.setInt(2, JPLogin.codloginuser);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Projeto", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" + 
                    ex.getMessage(), "Projeto", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        Projeto p = (Projeto) o;
        try{
            sql = "UPDATE projeto" +
                  "   SET ds_projeto = ?" +
                  " WHERE cd_projeto = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setString(1, p.getDs_projeto());
            ps.setInt(2, p.getCd_projeto());
            ps.setInt(3, JPLogin.codloginuser);            
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Projeto", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Projeto", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        Projeto p = (Projeto) o;
        try{
            sql = "DELETE FROM projeto" +
                  " WHERE cd_projeto = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, p.getCd_projeto());
            ps.setInt(2, JPLogin.codloginuser);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Projeto", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Projeto", JOptionPane.ERROR_MESSAGE);
        }
    }
    
        public void excluirProjetoModulos(Object o) {
        Projeto p = (Projeto) o;
        try{
            sql = "DELETE FROM modulo" +
                  " WHERE cd_projeto = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, p.getCd_projeto());
            ps.setInt(2, JPLogin.codloginuser);
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido modulos do projeto.", "Projeto", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir os modulos do projeto:\n" +
                    ex.getMessage(), "Projeto", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList projeto = new ArrayList();
        try{
            sql = "SELECT cd_projeto, ds_projeto, cd_usuario" +
                  "  FROM projeto" +
                  " WHERE cd_usuario = ?" +  
                  " ORDER BY ds_projeto";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Projeto p = new Projeto(
                    rs.getInt("cd_projeto"),
                    rs.getString("ds_projeto"),
                    rs.getInt("cd_usuario"));
                projeto.add(p);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de projetos:\n" + 
                    ex.getMessage(), "Projeto", JOptionPane.ERROR_MESSAGE);
        }
        return projeto;
    }

    @Override
    public Object getById(int id) {
        Projeto p = null;
        try{
            sql = "SELECT cd_projeto, ds_projeto, cd_usuario" +
                  "  FROM projeto" +
                  " WHERE cd_projeto = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p = new Projeto(
                    rs.getInt("cd_projeto"),
                    rs.getString("ds_projeto"),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de GetById em projetos:\n" +
                    ex.getMessage(), "Projeto", JOptionPane.ERROR_MESSAGE);
        }
        return p;
    }
    
}
