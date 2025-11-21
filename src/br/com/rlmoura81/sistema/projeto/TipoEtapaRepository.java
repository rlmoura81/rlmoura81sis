package br.com.rlmoura81.sistema.projeto;

import br.com.rlmoura81.sistema.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TipoEtapaRepository {
    
    String sql = "";
    
    public ArrayList<TipoEtapa> getLista() {
        ArrayList<TipoEtapa> tpetapa = new ArrayList();
        try{
            sql = "SELECT cd_tpetapa, ds_tpetapa " +
                  "  FROM tpetapa ";            
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                TipoEtapa tpe = new TipoEtapa(
                    rs.getInt("cd_tpetapa"),
                    rs.getString("ds_tpetapa"));
                tpetapa.add(tpe);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de tipo de etapa:\n" + 
                    ex.getMessage());
        }
        return tpetapa;
    }
    
    public Object getById(int id) {
        TipoEtapa tpetapa = null;
        try{
            sql = "SELECT cd_tpetapa, ds_tpetapa " +
                  "  FROM tpetapa " +
                  " WHERE cd_tpetapa = ?";            
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                tpetapa = new TipoEtapa(
                    rs.getInt("cd_tpetapa"),
                    rs.getString("ds_tpetapa"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em tipo de etapa:\n" + 
                    ex.getMessage());
        }
        return tpetapa;
    }
    
}
