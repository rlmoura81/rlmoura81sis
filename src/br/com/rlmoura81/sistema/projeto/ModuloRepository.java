package br.com.rlmoura81.sistema.projeto;

import br.com.rlmoura81.sistema.principal.IPadraoRepository;
import br.com.rlmoura81.sistema.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModuloRepository implements IPadraoRepository{

    String sql = "";
    
    ProjetoRepository projetor = new ProjetoRepository();
        
    @Override
    public void inserir(Object o) {
        Modulo m = (Modulo) o;
        try{                       
            sql = "INSERT INTO modulo (cd_modulo, ds_modulo, ds_descricao, nm_hora, nm_complexidade, nm_horacomplexidade, cd_projeto, cd_usuario)" +
                  "     VALUES (sq_modulo.nextval, ?, ?, ?, ?, ?, ?, ?)";
                  PreparedStatement ps = JPLogin.con.prepareStatement(sql);
                  ps.setString(1, m.getDs_modulo());
                  ps.setString(2, m.getDs_descricao());
                  ps.setBigDecimal(3, m.getNm_hora()); 
                  ps.setInt(4, m.getNm_complexidade());
                  ps.setBigDecimal(5, m.getNm_horacomplexidade());
                  ps.setInt(6, m.getProjeto().getCd_projeto());
                  ps.setInt(7, m.getCd_usuario());
                  ps.execute();
                  ps.close();
                  JOptionPane.showMessageDialog(null, "Salvo.", "Módulo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Módulo", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        Modulo m = (Modulo) o;
        try{
            sql = "UPDATE modulo" +
                  "   SET ds_modulo = ?," +
                  "       ds_descricao = ?," +
                  "       nm_hora = ?," +
                  "       nm_complexidade = ?," +  
                  "       nm_horacomplexidade = ?" +  
                  " WHERE cd_modulo = ?" +
                  "   AND cd_projeto = ?"+
                  "   AND cd_usuario = ?";
                  PreparedStatement ps = JPLogin.con.prepareStatement(sql);
                  ps.setString(1, m.getDs_modulo());
                  ps.setString(2, m.getDs_descricao());
                  ps.setBigDecimal(3, m.getNm_hora());
                  ps.setInt(4, m.getNm_complexidade());
                  ps.setBigDecimal(5, m.getNm_horacomplexidade());
                  ps.setInt(6, m.getCd_modulo());
                  ps.setInt(7, m.getProjeto().getCd_projeto());
                  ps.setInt(8, m.getCd_usuario());
                  ps.execute();
                  ps.close();
                  JOptionPane.showMessageDialog(null, "Salvo.", "Módulo", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" + 
                    ex.getMessage(), "Módulo", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        Modulo m = (Modulo) o;
        try{
            sql = "DELETE FROM modulo" +
                  " WHERE cd_modulo = ?" +
                  "   AND cd_projeto = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, m.getCd_modulo());
            ps.setInt(2, m.getProjeto().getCd_projeto());
            ps.setInt(3, m.getCd_usuario());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Módulo", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList getLista(int cd_projeto) {
        ArrayList modulo = new ArrayList();
        try{
            sql = "SELECT cd_modulo, ds_modulo, ds_descricao, nm_hora, nm_complexidade, nm_horacomplexidade, cd_projeto, cd_usuario" +
                  "  FROM modulo" +
                  " WHERE cd_projeto = ?" +
                  "   AND cd_usuario = ?" + 
                  " ORDER BY ds_modulo";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, cd_projeto);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Modulo m = new Modulo(
                    rs.getInt("cd_modulo"),
                    rs.getString("ds_modulo"),
                    rs.getString("ds_descricao"),
                    rs.getBigDecimal("nm_hora"),
                    rs.getInt("nm_complexidade"),
                    rs.getBigDecimal("nm_horacomplexidade"),
                    (Projeto)projetor.getById(rs.getInt("cd_projeto")),
                    rs.getInt("cd_usuario"));
                    modulo.add(m);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de modulos:\n" +
                    ex.getMessage(), "Módulo", JOptionPane.ERROR_MESSAGE);
        }
        return modulo;
    }
    
    public ArrayList getListaProjetoModulo() {
        ArrayList modulo = new ArrayList();
        try{
            sql = "SELECT COUNT(m.cd_modulo) AS qtdemodulo, SUM(m.nm_hora) AS totalhora, SUM(m.nm_horacomplexidade) AS totalhoracomplexidade, m.cd_projeto AS cdprojeto, m.cd_usuario AS cdusuario" +
                  "  FROM modulo m, projeto p" + 
                  " WHERE m.cd_projeto = p.cd_projeto" +
                  "   AND m.cd_usuario = p.cd_usuario" +
                  "   AND m.cd_usuario = ?" +  
                  " GROUP BY m.cd_projeto, m.cd_usuario, p.ds_projeto" +
                  " ORDER BY p.ds_projeto";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                Modulo m = new Modulo(
                    rs.getInt("qtdemodulo"),
                    rs.getBigDecimal("totalhora"),
                    rs.getBigDecimal("totalhoracomplexidade"),
                    (Projeto)projetor.getById(rs.getInt("cdprojeto")),
                    rs.getInt("cdusuario"));
                    modulo.add(m);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de projetos e modulos:\n" +
                    ex.getMessage(), "Valores Projetos", JOptionPane.ERROR_MESSAGE);
        }
        return modulo;
    }

    @Override
    public Object getById(int id) {
        Modulo m = null;
        try{
            sql = "SELECT cd_modulo, ds_modulo, ds_descricao, nm_hora, nm_complexidade, nm_horacomplexidade, cd_projeto, cd_usuario" +
                  "  FROM modulo" +
                  " WHERE cd_projeto = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                m = new Modulo(
                    rs.getInt("cd_modulo"),
                    rs.getString("ds_modulo"),
                    rs.getString("ds_descricao"),
                    rs.getBigDecimal("nm_hora"),
                    rs.getInt("nm_complexidade"),
                    rs.getBigDecimal("nm_horacomplexidade"),
                    (Projeto)projetor.getById(rs.getInt("cd_projeto")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em modulos:\n" +
                    ex.getMessage(), "Módulo", JOptionPane.ERROR_MESSAGE);
        }
        return m;
    }    
}
