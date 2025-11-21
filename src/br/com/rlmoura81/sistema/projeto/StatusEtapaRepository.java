package br.com.rlmoura81.sistema.projeto;

import br.com.rlmoura81.sistema.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class StatusEtapaRepository {
    
    String sql = "";
    
    public ArrayList<StatusEtapa> getLista() {
        ArrayList<StatusEtapa> stetapa = new ArrayList();
        try{
            sql = "SELECT cd_stetapa, ds_stetapa " +
                  "  FROM stetapa ";            
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                StatusEtapa ste = new StatusEtapa(
                    rs.getInt("cd_stetapa"),
                    rs.getString("ds_stetapa"));
                stetapa.add(ste);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de status de etapa:\n" + 
                    ex.getMessage());
        }
        return stetapa;
    }
        
    public Object getById(int id) {
        StatusEtapa stetapa = null;
        try{
            sql = "SELECT cd_stetapa, ds_stetapa " +
                  "  FROM stetapa " +
                  " WHERE cd_stetapa = ?";            
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                stetapa = new StatusEtapa(
                    rs.getInt("cd_stetapa"),
                    rs.getString("ds_stetapa"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em status de etapa:\n" + 
                    ex.getMessage());
        }
        return stetapa;
    }
    
}
