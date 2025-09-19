package br.com.rlmoura81.sistema.geral;

import br.com.rlmoura81.sistema.principal.IPadraoRepository;
import br.com.rlmoura81.sistema.principalinterface.JPLogin;
import br.com.rlmoura81.sistema.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PatrimonioRepository implements IPadraoRepository{
    
    String sql = "";
    
    Utilidade util = new Utilidade();

    @Override
    public void inserir(Object o) {
        CadastroGeral c = (CadastroGeral) o;
        try{
            sql = "INSERT INTO patrimonio(cd_patrimonio, ds_patrimonio, nm_qtde, nm_valor, dt_patrimonio, cd_usuario)" +
                  "     VALUES (sq_patrimonio.nextval, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setString(1, c.getDs_cadgeral());
            ps.setInt(2, c.getNm_qtde());
            ps.setBigDecimal(3, c.getNm_valor());
            ps.setString(4, Utilidade.formatoData.format(c.getDt_cadgeral().getTime()));
            ps.setInt(5, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Patrimonio", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Patrimonio", JOptionPane.ERROR_MESSAGE);            
        }
    }

    @Override
    public void alterar(Object o) {
        CadastroGeral c = (CadastroGeral) o;
        try{
            sql = "UPDATE patrimonio" +
                  "   SET ds_patrimonio = ?," +
                  "       nm_qtde = ?," +
                  "       nm_valor = ?," +
                  "       dt_patrimonio = ?" +
                  " WHERE cd_patrimonio = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setString(1, c.getDs_cadgeral());
            ps.setInt(2, c.getNm_qtde());
            ps.setBigDecimal(3, c.getNm_valor());
            ps.setString(4, Utilidade.formatoData.format(c.getDt_cadgeral().getTime()));
            ps.setInt(5, c.getCd_cadgeral());
            ps.setInt(6, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showConfirmDialog(null, "Alterado.", "Patrimonio", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Patrimonio", JOptionPane.ERROR_MESSAGE);            
        }
    }

    @Override
    public void excluir(Object o) {
        CadastroGeral c = (CadastroGeral) o;
        try{
            sql = "DELETE FROM patrimonio" +
                  " WHERE cd_patrimonio = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, c.getCd_cadgeral());
            ps.setInt(2, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Patrimonio", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Patrimonio", JOptionPane.ERROR_MESSAGE);            
        }
    }

    @Override    
    public ArrayList getLista() {
        ArrayList patrimonio = new ArrayList();
        try{
            sql = "SELECT cd_patrimonio, ds_patrimonio, nm_qtde, nm_valor, to_char(dt_patrimonio,'dd/MM/yyyy'), cd_usuario" +
                  "  FROM patrimonio" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY ds_patrimonio";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CadastroGeral c = new CadastroGeral(
                    rs.getInt("cd_patrimonio"),
                    rs.getString("ds_patrimonio"),
                    rs.getInt("nm_qtde"),    
                    rs.getBigDecimal("nm_valor"),
                    util.recebeData(rs.getString("to_char(dt_patrimonio,'dd/MM/yyyy')")),
                    rs.getInt("cd_usuario"));
                patrimonio.add(c);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de patrimonios:\n" +
                    ex.getMessage(), "Patrimonio", JOptionPane.ERROR_MESSAGE);
        }
        return patrimonio;
    }

    @Override
    public Object getById(int id) {
        CadastroGeral c = null;
        try{
            sql = "SELECT cd_patrimonio, ds_patrimonio, nm_qtde, nm_valor, to_char(dt_patrimonio,'dd/MM/yyyy'), cd_usuario" +
                  "  FROM patrimonio" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                c = new CadastroGeral(
                    rs.getInt("cd_patrimonio"),
                    rs.getString("ds_patrimonio"),
                    rs.getInt("nm_qtde"),
                    rs.getBigDecimal("nm_valor"),
                    util.recebeData(rs.getString("to_char(dt_patrimonio,'dd/MM/yyyy')")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em patrimonios:\n" +
                    ex.getMessage(), "Patrimonio", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }    
}
