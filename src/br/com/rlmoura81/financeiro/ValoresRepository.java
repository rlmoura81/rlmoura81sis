package br.com.rlmoura81.financeiro;

import br.com.rlmoura81.sistema.principal.IPadraoRepository;
import br.com.rlmoura81.sistema.principalinterface.JPLogin;
import br.com.rlmoura81.sistema.utilidade.Utilidade;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ValoresRepository implements IPadraoRepository{

    String sql = "";
    
    Utilidade util = new Utilidade();
    
    @Override
    public void inserir(Object o) {
        Valores v = (Valores) o;
        try{
            sql = "INSERT INTO valores (cd_valor, nm_salario, vl_salario, vl_hora, cd_usuario)" +
                  "     VALUES (sq_valores.nextval, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setBigDecimal(1, v.getNm_salario());
            ps.setBigDecimal(2, v.getVl_salario());
            ps.setBigDecimal(3, v.getVl_hora());
            ps.setInt(4, v.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Valores", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Valores", JOptionPane.ERROR_MESSAGE); 
        }    
    }

    @Override
    public void alterar(Object o) {        
        Valores v = (Valores) o;
        try{
            sql = "UPDATE valores" +
                  "   SET nm_salario = ?," +
                  "       vl_salario = ?," +
                  "       vl_hora = ?" +
                  " WHERE cd_valor = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setBigDecimal(1, v.getNm_salario());
            ps.setBigDecimal(2, v.getVl_salario());
            ps.setBigDecimal(3, v.getVl_hora());
            ps.setInt(4, v.getCd_valor());
            ps.setInt(5, v.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Valores", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Valores", JOptionPane.ERROR_MESSAGE); 
        } 
    }

    @Override
    public void excluir(Object o) {
        Valores v = (Valores) o;
        try{
            sql = "DELETE FROM valores" +
                  " WHERE cd_valor = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, v.getCd_valor());
            ps.setInt(2, v.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Valores", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Excluido", JOptionPane.ERROR_MESSAGE); 
        } 
    }

    @Override
    public ArrayList<Valores> getLista() {
        ArrayList<Valores> valores = new ArrayList<>();
        try{
            sql = "SELECT cd_valor, nm_salario, vl_salario, vl_hora, cd_usuario" +
                  "  FROM valores" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Valores v = new Valores(
                        rs.getInt("cd_valor"),
                        rs.getBigDecimal("nm_salario"),
                        rs.getBigDecimal("vl_salario"),
                        rs.getBigDecimal("vl_hora"),
                        rs.getInt("cd_usuario"));
                valores.add(v);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de valores:\n" +
                    ex.getMessage(), "Valores", JOptionPane.ERROR_MESSAGE);
        }
        return valores;
    }

    @Override
    public Object getById(int id) {
        Valores v = null;
        try{
            sql = "SELECT cd_valor, nm_salario, vl_salario, vl_hora, cd_usuario" +
                  "  FROM valores" +
                  " WHERE cd_valor = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                v = new Valores(
                        rs.getInt("cd_valor"),
                        rs.getBigDecimal("nm_salario"),
                        rs.getBigDecimal("vl_salario"),
                        rs.getBigDecimal("vl_hora"),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em valores:\n" +
                    ex.getMessage(), "Valores", JOptionPane.ERROR_MESSAGE);
        }
        return v;
    }  

    public BigDecimal valorHoraMeta() {
        BigDecimal vlhorameta = Utilidade.converter("0,00");
        try{
            sql = "SELECT MAX(vl_hora)" +
                  "  FROM valores" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                vlhorameta = rs.getBigDecimal("MAX(vl_hora)");
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de valorHoraMeta em valores:\n" +
                    ex.getMessage(), "Valores", JOptionPane.ERROR_MESSAGE);
        }
        return vlhorameta;
    }    
    
        public BigDecimal valorSalarioMeta() {
        BigDecimal vlhorameta = Utilidade.converter("0,00");
        try{
            sql = "SELECT MAX(vl_salario)" +
                  "  FROM valores" +
                  " WHERE cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                vlhorameta = rs.getBigDecimal("MAX(vl_salario)");
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de valorSalarioMeta em valores:\n" +
                    ex.getMessage(), "Valores", JOptionPane.ERROR_MESSAGE);
        }
        return vlhorameta;
    } 
    
}
