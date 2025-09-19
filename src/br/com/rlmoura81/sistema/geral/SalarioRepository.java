package br.com.rlmoura81.sistema.geral;

import br.com.rlmoura81.sistema.principal.IPadraoRepository;
import br.com.rlmoura81.sistema.principalinterface.JPLogin;
import br.com.rlmoura81.sistema.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SalarioRepository implements IPadraoRepository{
    
    String sql = "";
    
    Utilidade util = new Utilidade();

    @Override
    public void inserir(Object o) {
        CadastroGeral c = (CadastroGeral) o;
        try{
            sql = "INSERT INTO salario(cd_salario, nm_valor, dt_salario, cd_usuario)" +
                  "     VALUES (sq_salario.nextval, ?, ?, ?)";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setBigDecimal(1, c.getNm_valor());
            ps.setString(2, Utilidade.formatoData.format(c.getDt_cadgeral().getTime()));
            ps.setInt(3, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Salário", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Salário", JOptionPane.ERROR_MESSAGE);            
        }
    }

    @Override
    public void alterar(Object o) {
        CadastroGeral c = (CadastroGeral) o;
        try{
            sql = "UPDATE salario" +
                  "   SET nm_valor = ?," +
                  "       dt_salario = ?," +
                  "       cd_usuario = ?" +
                  " WHERE cd_salario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setBigDecimal(1, c.getNm_valor());
            ps.setString(2, Utilidade.formatoData.format(c.getDt_cadgeral().getTime()));
            ps.setInt(3, c.getCd_usuario());
            ps.setInt(4, c.getCd_cadgeral());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Salário", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Salário", JOptionPane.ERROR_MESSAGE);            
        }
    }

    @Override
    public void excluir(Object o) {
        CadastroGeral c = (CadastroGeral) o;
        try{
            sql = "DELETE FROM salario" +
                  " WHERE cd_salario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, c.getCd_cadgeral());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Salário", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Salário", JOptionPane.ERROR_MESSAGE);            
        }
    }

    @Override    
    public ArrayList getLista() {
        ArrayList salario = new ArrayList();
        try{
            sql = "SELECT cd_salario, nm_valor, to_char(dt_salario,'dd/MM/yyyy'), cd_usuario" +
                  "  FROM salario" +
                  " ORDER BY dt_salario";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CadastroGeral c = new CadastroGeral(
                    rs.getInt("cd_salario"),  
                    rs.getBigDecimal("nm_valor"),
                    util.recebeData(rs.getString("to_char(dt_salario,'dd/MM/yyyy')")),
                    rs.getInt("cd_usuario"));
                salario.add(c);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de salarios:\n" +
                    ex.getMessage(), "Salário", JOptionPane.ERROR_MESSAGE);
        }
        return salario;
    }

    @Override
    public Object getById(int id) {
        CadastroGeral c = null;
        try{
            sql = "SELECT cd_salario, nm_valor, to_char(dt_salario,'dd/MM/yyyy'), cd_usuario" +
                  "  FROM salario" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                c = new CadastroGeral(
                    rs.getInt("cd_salario"),
                    rs.getString(null),
                    rs.getInt(null),
                    rs.getBigDecimal("nm_valor"),
                    util.recebeData(rs.getString("to_char(dt_salario,'dd/MM/yyyy')")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em salario:\n" +
                    ex.getMessage(), "Salário", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }        
}
