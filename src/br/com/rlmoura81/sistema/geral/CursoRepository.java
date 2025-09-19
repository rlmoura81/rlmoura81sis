package br.com.rlmoura81.sistema.geral;

import br.com.rlmoura81.sistema.principal.IPadraoRepository;
import br.com.rlmoura81.sistema.principalinterface.JPLogin;
import br.com.rlmoura81.sistema.utilidade.Utilidade;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CursoRepository implements IPadraoRepository{
    
    GrupoRepository grupor = new GrupoRepository();
    
    String sql = "";
    
    Utilidade util = new Utilidade();

    @Override
    public void inserir(Object o) {
        CadastroGeral c = (CadastroGeral) o;
        try{
            sql = "INSERT INTO curso(cd_curso, ds_curso, cd_grupo, nm_valor, dt_curso, nm_hora, cd_usuario)" +
                  "     VALUES (sq_curso.nextval, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setString(1, c.getDs_cadgeral());
            ps.setInt(2, c.getGrupo().getCd_grupo());
            ps.setBigDecimal(3, c.getNm_valor());
            ps.setString(4, Utilidade.formatoData.format(c.getDt_cadgeral().getTime()));
            ps.setInt(5, c.getNm_hora());
            ps.setInt(6, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Salvo.", "Curso", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao salvar:\n" +
                    ex.getMessage(), "Curso", JOptionPane.ERROR_MESSAGE);            
        }
    }

    @Override
    public void alterar(Object o) {
        CadastroGeral c = (CadastroGeral) o;
        try{
            sql = "UPDATE curso" +
                  "   SET ds_curso = ?, " +
                  "       cd_grupo = ?, " +
                  "       nm_valor = ?, " + 
                  "       dt_curso = ?, " +
                  "       nm_hora = ?" +
                  " WHERE cd_curso = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setString(1, c.getDs_cadgeral());
            ps.setInt(2, c.getGrupo().getCd_grupo());
            ps.setBigDecimal(3, c.getNm_valor());
            ps.setString(4, Utilidade.formatoData.format(c.getDt_cadgeral().getTime()));
            ps.setInt(5, c.getNm_hora());
            ps.setInt(6, c.getCd_cadgeral());
            ps.setInt(7, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Alterado.", "Curso", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao alterar:\n" +
                    ex.getMessage(), "Curso", JOptionPane.ERROR_MESSAGE);            
        }
    }

    @Override
    public void excluir(Object o) {
        CadastroGeral c = (CadastroGeral) o;
        try{
            sql = "DELETE FROM curso" +
                  " WHERE cd_curso = ?" +
                  "   AND cd_usuario = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, c.getCd_cadgeral());
            ps.setInt(2, c.getCd_usuario());
            ps.execute();
            ps.close();
            JOptionPane.showMessageDialog(null, "Excluido.", "Curso", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao excluir:\n" +
                    ex.getMessage(), "Curso", JOptionPane.ERROR_MESSAGE);            
        }
    }

    @Override   
    public ArrayList getLista() {
        ArrayList curso = new ArrayList();
        try{
            sql = "SELECT cd_curso, ds_curso, nm_valor, to_char(dt_curso,'dd/MM/yyyy'), nm_hora, cd_grupo, cd_usuario" +
                  "  FROM curso" +
                  " WHERE cd_usuario = ?" +
                  " ORDER BY dt_curso, ds_curso";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            while(rs.next()){
                CadastroGeral c = new CadastroGeral(
                    rs.getInt("cd_curso"),
                    rs.getString("ds_curso"),
                    rs.getBigDecimal("nm_valor"),
                    util.recebeData(rs.getString("to_char(dt_curso,'dd/MM/yyyy')")),
                    rs.getInt("nm_hora"),
                    (Grupo)grupor.getById(rs.getInt("cd_grupo")),
                    rs.getInt("cd_usuario"));
                curso.add(c);
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a lista de cursos:\n" +
                    ex.getMessage(), "Curso", JOptionPane.ERROR_MESSAGE);
        }
        return curso;
    }

    @Override
    public Object getById(int id) {
        CadastroGeral c = null;
        try{
            sql = "SELECT cd_curso, ds_curso, nm_valor, to_char(dt_curso,'dd/MM/yyyy'), nm_hora, cd_grupo, cd_usuario" +
                  "  FROM curso" +
                  " WHERE cd_curso = ?";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ps.setInt(1, JPLogin.codloginuser);
            ResultSet rs = ps.executeQuery();            
            if(rs.next()){
                c = new CadastroGeral(
                    rs.getInt("cd_curso"),
                    rs.getString("ds_curso"),
                    rs.getBigDecimal("nm_valor"),
                    util.recebeData(rs.getString("to_char(dt_curso,'dd/MM/yyyy')")),
                    rs.getInt("nm_hora"),
                    (Grupo)grupor.getById(rs.getInt("cd_grupo")),
                    rs.getInt("cd_usuario"));
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de getById em curso:\n" +
                    ex.getMessage(), "Curso", JOptionPane.ERROR_MESSAGE);
        }
        return c;
    }    
}
