package br.com.rlmoura81.sistema.projeto;

import br.com.rlmoura81.sistema.principal.IPadraoRepository;
import br.com.rlmoura81.sistema.principalinterface.JPLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EtapaRepository implements IPadraoRepository{
    
    String sql = "";
    
    TipoEtapaRepository tpetapar = new TipoEtapaRepository();
    StatusEtapaRepository stetapar = new StatusEtapaRepository();
    ModuloRepository modulor = new ModuloRepository();

    @Override
    public void inserir(Object o) {
        Etapa e = (Etapa) o;
        try{
            sql = "INSERT INTO etapa (cd_etapa, ds_etapa, ds_descricao, cd_tpetapa, cd_stetapa, cd_modulo, cd_usuario)" +
                  "     VALUES (sq_etapa.nextval, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setString(1, e.getDs_etapa());
            ps.setString(2, e.getDs_descricao());
            ps.setInt(3, e.getTipoetapa().getCd_tpetapa());
            ps.setInt(4, e.getStatusetapa().getCd_stetapa());
            ps.setInt(5, e.getModulo().getCd_modulo());
            ps.setInt(6, e.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Etapa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Etapa", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void alterar(Object o) {
        Etapa e = (Etapa) o;
        try{
            sql = "UPDATE etapa " +
                  "   SET ds_etapa = ?, " +
                  "       ds_descricao = ?, " +
                  "       cd_tpetapa = ?, " +
                  "       cd_stetapa = ? " +
                  " WHERE cd_etapa = ?" + 
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setString(1, e.getDs_etapa());
            ps.setString(2, e.getDs_descricao());
            ps.setInt(3, e.getTipoetapa().getCd_tpetapa());
            ps.setInt(4, e.getStatusetapa().getCd_stetapa());
            ps.setInt(5, e.getCd_etapa());
            ps.setInt(6, e.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Etapa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Etapa", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void excluir(Object o) {
        Etapa e = (Etapa) o;
        try{
            sql = "DELETE FROM etapa " +
                  " WHERE cd_etapa = ?, " +
                  "   AND cd_modulo = ?, " +
                  "   AND cd_usuario = ?)";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, e.getCd_etapa());
            ps.setInt(2, e.getModulo().getCd_modulo());
            ps.setInt(3, e.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Etapa", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Etapa", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ArrayList getLista() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ArrayList<Etapa> getLista(int cd_modulo) {
        ArrayList<Etapa> etapa = new ArrayList<>();
        try{
            sql = "SELECT cd_etapa, ds_etapa, ds_descricao, cd_tpetapa, cd_stetapa, cd_modulo, cd_usuario" +
                  "  FROM etapa" + 
                  " WHERE cd_modulo = ?" + 
                  "   AND cd_usuario = ?" +
                  " ORDER BY ds_etapa";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, cd_modulo);
            ps.setInt(2, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery(); 
            while(rs.next()){
                Etapa e = new Etapa(
                        rs.getInt("cd_etapa"),
                        rs.getString("ds_etapa"),
                        rs.getString("ds_descricao"),
                        (TipoEtapa)tpetapar.getById(rs.getInt("cd_tpetapa")),
                        (StatusEtapa)stetapar.getById(rs.getInt("cd_stetapa")),
                        (Modulo)modulor.getById(rs.getInt("cd_modulo")),
                        rs.getInt("cd_usuario"));
                        etapa.add(e);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de etapas:\n" +
                    ex.getMessage());
        }
        return etapa;
    }

    @Override
    public Object getById(int id) {        
        Etapa etapa = new Etapa();
        try{
            sql = "SELECT cd_etapa, ds_etapa, ds_descricao, cd_tpetapa, cd_stetapa, cd_modulo, cd_usuario" +
                  "  FROM etapa" +
                  " WHERE cd_etapa = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(); 
            if(rs.next()){
                etapa = new Etapa(
                        rs.getInt("cd_etapa"),
                        rs.getString("ds_etapa"),
                        rs.getString("ds_descricao"),
                        (TipoEtapa)tpetapar.getById(rs.getInt("cd_tpetapa")),
                        (StatusEtapa)stetapar.getById(rs.getInt("cd_stetapa")),
                        (Modulo)modulor.getById(rs.getInt("cd_modulo")),
                        rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em etapas:\n" +
                    ex.getMessage());
        }
        return etapa;
    }    


}
