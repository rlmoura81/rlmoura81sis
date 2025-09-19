package br.com.rlmoura81.sistema.geral;

import br.com.rlmoura81.sistema.principal.IPadraoRepository;
import br.com.rlmoura81.sistema.principalinterface.JPLogin;
import br.com.rlmoura81.sistema.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TrabalhoRepository implements IPadraoRepository{
    
    String sql = "";
    
    Utilidade util = new Utilidade();

    @Override
    public void inserir(Object o) {
        CadastroGeral c = (CadastroGeral) o;
        try{
            sql = "INSERT INTO trabalho(cd_trabalho, ds_trabalho, nm_valor, dt_trabalho, nm_hora, cd_usuario)" +
                  "     VALUES (sq_trabalho.nextval, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setString(1, c.getDs_cadgeral());
            ps.setBigDecimal(2, c.getNm_valor());
            ps.setString(3, Utilidade.formatoData.format(c.getDt_cadgeral().getTime()));
            ps.setInt(4, c.getNm_hora());
            ps.setInt(5, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Trabalho", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Trabalho", JOptionPane.ERROR_MESSAGE);            
        }
    }

    @Override
    public void alterar(Object o) {
        CadastroGeral c = (CadastroGeral) o;
        try{
            sql = "UPDATE trabalho" +
                  "   SET ds_trabalho = ?," +
                  "       nm_valor = ?," +
                  "       dt_trabalho = ?," +
                  "       nm_hora = ?" +
                  " WHERE cd_trabalho = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setString(1, c.getDs_cadgeral());
            ps.setBigDecimal(2, c.getNm_valor());
            ps.setString(3, Utilidade.formatoData.format(c.getDt_cadgeral().getTime()));
            ps.setInt(4, c.getNm_hora());
            ps.setInt(5, c.getCd_cadgeral());
            ps.setInt(6, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Trabalho", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Trabalho", JOptionPane.INFORMATION_MESSAGE);     
        }
    }

    @Override
    public void excluir(Object o) {
        CadastroGeral c = (CadastroGeral) o;
        try{
            sql = "DELETE FROM trabalho" +
                  " WHERE cd_trabalho = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, c.getCd_cadgeral());
            ps.setInt(2, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Trabalho", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Trabalho", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        ArrayList trabalho = new ArrayList();
        try{
            sql = "SELECT cd_trabalho, ds_trabalho, nm_valor, to_char(dt_trabalho,'dd/MM/yyyy'), nm_hora, cd_usuario" +
                  "  FROM trabalho" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY dt_trabalho, ds_trabalho";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CadastroGeral c = new CadastroGeral(
                    rs.getInt("cd_trabalho"),
                    rs.getString("ds_trabalho"),
                    rs.getInt(1),    
                    rs.getBigDecimal("nm_valor"),
                    util.recebeData(rs.getString("to_char(dt_trabalho,'dd/MM/yyyy')")),
                    rs.getInt("nm_hora"),
                    rs.getInt("cd_usuario"));
                trabalho.add(c);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de trabalhos:\n" +
                    ex.getMessage(), "Trabalho", JOptionPane.INFORMATION_MESSAGE);
        }
        return trabalho;
    }

    @Override
    public Object getById(int id) {
        CadastroGeral c = null;
        try{
            sql = "SELECT cd_trabalho, ds_trabalho, nm_valor, to_char(dt_trabalho,'dd/MM/yyyy'), nm_hora, cd_usuario" +
                  "  FROM trabalho" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                c = new CadastroGeral(
                    rs.getInt("cd_trabalho"),
                    rs.getString("ds_trabalho"),
                    rs.getInt("nm_qtde"),
                    rs.getBigDecimal("nm_valor"),
                    util.recebeData(rs.getString("to_char(dt_trabalho,'dd/MM/yyyy')")),
                    rs.getInt("nm_hora"),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em trabalhos:\n" +
                    ex.getMessage(), "Trabalho", JOptionPane.INFORMATION_MESSAGE);
        }
        return c;
    }        
}
