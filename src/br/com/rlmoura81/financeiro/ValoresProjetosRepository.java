package br.com.rlmoura81.financeiro;

import br.com.rlmoura81.sistema.principal.IPadraoRepository;
import br.com.rlmoura81.sistema.principalinterface.JPLogin;
import br.com.rlmoura81.sistema.projeto.ModuloRepository;
import br.com.rlmoura81.sistema.projeto.Projeto;
import br.com.rlmoura81.sistema.projeto.ProjetoRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ValoresProjetosRepository implements IPadraoRepository{
    
    String sql = "";
    
    ProjetoRepository projetor = new ProjetoRepository();
    ModuloRepository modulor = new ModuloRepository();
    
    @Override
    public void inserir(Object o) {
        ValoresProjetos vl = (ValoresProjetos) o;
        try{
            sql = "INSERT INTO valorprojeto(vl_mensalidade, vl_mensalidadeporcent, cd_projeto, cd_usuario)" +
                  "     VALUES (?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setBigDecimal(1, vl.getVl_mensalidade());
            ps.setBigDecimal(2, vl.getVl_mensalidadeporcent());
            ps.setInt(3, vl.getProjeto().getCd_projeto());
            ps.setInt(4, vl.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Valor Projeto", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" + 
                    ex.getMessage(), "Valores Projetos", JOptionPane.ERROR_MESSAGE);
            
        }
    }

    @Override
    public void alterar(Object o) {
        ValoresProjetos vl = (ValoresProjetos) o;
        try{
            sql = "UPDATE valorprojeto" +
                  "   SET vl_mensalidade = ?," +
                  "       vl_mensalidadeporcent = ?" +
                  " WHERE cd_projeto = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setBigDecimal(1, vl.getVl_mensalidade());
            ps.setBigDecimal(2, vl.getVl_mensalidadeporcent());
            ps.setInt(3, vl.getProjeto().getCd_projeto());
            ps.setInt(4, vl.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Valor Projeto", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" + 
                    ex.getMessage(), "Valores Projetos", JOptionPane.ERROR_MESSAGE);
            
        }
    }

    @Override
    public void excluir(Object o) {
        ValoresProjetos vl = (ValoresProjetos) o;
        try{
            sql = "DELETE FROM valorprojeto" +
                  " WHERE cd_projeto = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, vl.getProjeto().getCd_projeto());
            ps.setInt(2, vl.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Valor Projeto", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" + 
                    ex.getMessage(), "Valores Projetos", JOptionPane.ERROR_MESSAGE);
            
        }
    }

    @Override
    public ArrayList<ValoresProjetos> getLista() {
        ArrayList<ValoresProjetos> valorprojeto = new ArrayList<>();
        try{
            sql = "SELECT vl_mensalidade, vl_mensalidadeporcent, cd_projeto, cd_usuario" +
                  "  FROM valorprojeto, projeto" +
                  " WHERE cd_usuario = ?" +
                  "   AND cd_usuario = ?" +
                  " ORDER BY ds_projeto";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ValoresProjetos vl = new ValoresProjetos(
                    rs.getBigDecimal("vl_mensalidade"),
                    rs.getBigDecimal("vl_mensalidadeporcent"),
                    (Projeto)projetor.getById(rs.getInt("cd_projeto")),
                    rs.getInt("cd_usuario"));
                valorprojeto.add(vl);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de valores de projetos:\n" + 
                    ex.getMessage(), "Valores Projetos", JOptionPane.ERROR_MESSAGE);            
        }
        return valorprojeto;
    }
    
    public ArrayList<ValoresProjetos> getLista(int projeto) {
        ArrayList<ValoresProjetos> valorprojeto = new ArrayList<>();
        try{
            sql = "SELECT vl_mensalidade, vl_mensalidadeporcent, cd_projeto, cd_usuario" +
                  "  FROM valorprojeto, projeto"  +
                  " WHERE cd_projeto = ?," +
                  "   AND cd_usuario = ?" +
                  " ORDER BY ds_projeto";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, projeto);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ValoresProjetos vl = new ValoresProjetos(
                    rs.getBigDecimal("vl_mensalidade"),
                    rs.getBigDecimal("vl_mensalidadeporcent"),
                    (Projeto)projetor.getById(rs.getInt("cd_projeto")),
                    rs.getInt("cd_usuario"));
                valorprojeto.add(vl);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de valores de projetos e mensalidades:\n" + 
                    ex.getMessage(), "Valores Projetos", JOptionPane.ERROR_MESSAGE);            
        }
        return valorprojeto;
    }    
    /*
    public ArrayList<ValoresProjetos> getListaValorProjeto() {
        ArrayList<ValoresProjetos> valorprojeto = new ArrayList<>();
        try{
            sql = "SELECT vp.vl_mensalidade AS vlmensalidade, vp.vl_mensalidadeporcent AS vlmensalidadeporcent, vp.cd_projeto AS cdprojeto, vp.cd_usuario AS cdusuario, m.qtdemodulos, m.totalhoras, m.totalhorascomplexidade" +
                  "  FROM valorprojeto vp" +
                  "  LEFT JOIN(SELECT cd_projeto, COUNT(cd_modulo) AS qtdemodulos, SUM(nm_hora) AS totalhoras, SUM(nm_horacomplexidade) AS totalhorascomplexidade, cd_usuario" +
                  "              FROM modulo" +
                  "             GROUP BY cd_projeto, cd_usuario) m" +
                  "    ON vp.cd_projeto = m.cd_projeto" +
                  "   AND vp.cd_usuario = m.cd_usuario" +
                  " WHERE vp.cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ValoresProjetos vl = new ValoresProjetos(
                    rs.getBigDecimal("vlmensalidade"),
                    rs.getBigDecimal("vlmensalidadeporcent"),
                    (Projeto)projetor.getById(rs.getInt("cdprojeto")),
                    rs.getInt("cdusuario"));
                valorprojeto.add(vl);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de valores de projetos e mensalidades:\n" + 
                    ex.getMessage(), "Valores Projetos", JOptionPane.ERROR_MESSAGE);            
        }
        return valorprojeto;
    }    
*/
    @Override
    public Object getById(int id) {
        ValoresProjetos vl  = null;
        try{
            sql = "SELECT vl_mensalidade, vl_mensalidadeporcent, cd_projeto, cd_usuario" +
                  "  FROM valorprojeto" +
                  " WHERE cd_projeto = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                vl = new ValoresProjetos(
                    rs.getBigDecimal("vl_mensalidade"),
                    rs.getBigDecimal("vl_mensalidadeporcent"),
                    (Projeto)projetor.getById(rs.getInt("cd_projeto")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em valores de projetos:\n" + 
                    ex.getMessage(), "Valores Projetos", JOptionPane.ERROR_MESSAGE);            
        }
        return vl;
    }    
}
