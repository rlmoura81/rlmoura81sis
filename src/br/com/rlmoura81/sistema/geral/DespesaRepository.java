package br.com.rlmoura81.sistema.geral;

import br.com.rlmoura81.sistema.principal.IPadraoRepository;
import br.com.rlmoura81.sistema.principalinterface.JPLogin;
import br.com.rlmoura81.sistema.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DespesaRepository implements IPadraoRepository{
    
    String sql = "";
    
    Utilidade util = new Utilidade();

    @Override
    public void inserir(Object o) {
        CadastroGeral c = (CadastroGeral) o;
        try{
            sql = "INSERT INTO despesa(cd_despesa, ds_despesa, nm_valor, dt_despesa, cd_usuario)" +
                  "     VALUES (sq_despesa.nextval, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setString(1, c.getDs_cadgeral());
            ps.setBigDecimal(2, c.getNm_valor());
            ps.setString(3, Utilidade.formatoData.format(c.getDt_cadgeral().getTime()));
            ps.setInt(4, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Despesa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Despesa", JOptionPane.ERROR_MESSAGE);            
        }
    }

    @Override
    public void alterar(Object o) {
        CadastroGeral c = (CadastroGeral) o;
        try{
            sql = "UPDATE despesa" +
                  "   SET ds_despesa = ?," +
                  "       nm_valor = ?," +
                  "       dt_despesa = ?" +
                  " WHERE cd_despesa = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setString(1, c.getDs_cadgeral());
            ps.setBigDecimal(2, c.getNm_valor());
            ps.setString(3, Utilidade.formatoData.format(c.getDt_cadgeral().getTime()));
            ps.setInt(4, c.getCd_cadgeral());
            ps.setInt(5, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Despesa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Despesa", JOptionPane.ERROR_MESSAGE);            
        }
    }

    @Override
    public void excluir(Object o) {
        CadastroGeral c = (CadastroGeral) o;
        try{
            sql = "DELETE FROM despesa" +
                  " WHERE cd_despesa = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, c.getCd_cadgeral());
            ps.setInt(2, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Despesa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Despesa", JOptionPane.ERROR_MESSAGE);            
        }
    }

    @Override   
    public ArrayList getLista() {
        ArrayList despesa = new ArrayList();
        try{
            sql = "SELECT cd_despesa, ds_despesa, nm_valor, to_char(dt_despesa,'dd/MM/yyyy'), cd_usuario" +
                  "  FROM despesa" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY ds_despesa";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CadastroGeral c = new CadastroGeral(
                    rs.getInt("cd_despesa"),
                    rs.getString("ds_despesa"),
                    rs.getInt(1),    
                    rs.getBigDecimal("nm_valor"),
                    util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                    rs.getInt("cd_usuario"));
                despesa.add(c);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de despesa:\n" +
                    ex.getMessage(), "Despesa", JOptionPane.ERROR_MESSAGE);
        }
        return despesa;
    }

    @Override
    public Object getById(int id) {
        CadastroGeral c = null;
        try{
            sql = "SELECT cd_despesa, ds_despesa, nm_valor, to_char(dt_despesa,'dd/MM/yyyy'), cd_usuario" +
                  "  FROM despesa" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                c = new CadastroGeral(
                    rs.getInt("cd_despesa"),
                    rs.getString("ds_despesa"),
                    rs.getInt(null),
                    rs.getBigDecimal("nm_valor"),
                    util.recebeData(rs.getString("to_char(dt_despesa,'dd/MM/yyyy')")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em despesa:\n" +
                    ex.getMessage(), "Despesa", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }  
    
}
