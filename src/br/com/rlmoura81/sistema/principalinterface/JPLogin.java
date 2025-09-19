package br.com.rlmoura81.sistema.principalinterface;

import br.com.rlmoura81.sistema.conexao.ConexaoPersistencia;
import br.com.rlmoura81.sistema.principal.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JPLogin extends javax.swing.JPanel {
    
    public static int codloginuser;
    
    public static Connection con = ConexaoPersistencia.getConnection();
    
    JFrame jfrm = new JFrame();
    Usuario usuario = new Usuario();
    String sql = "";

    public JPLogin() {
        initComponents();
        
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(300, 200);
        jfrm.setLocationRelativeTo(null);
        jfrm.add(this);
        jfrm.setVisible(true);
        jfrm.setTitle("Login - Sistema");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jLLogin = new javax.swing.JLabel();
        jTFLogin = new javax.swing.JTextField();
        jLSenha = new javax.swing.JLabel();
        jFTFSenha = new javax.swing.JFormattedTextField();
        jPBotoes = new javax.swing.JPanel();
        jBAcessar = new javax.swing.JButton();

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLLogin.setText("Login:");

        jLSenha.setText("Senha:");

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jFTFSenha))
                .addContainerGap())
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLLogin))
                .addGap(18, 18, 18)
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSenha)
                    .addComponent(jFTFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBAcessar.setText("Acessar");
        jBAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAcessarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBotoesLayout = new javax.swing.GroupLayout(jPBotoes);
        jPBotoes.setLayout(jPBotoesLayout);
        jPBotoesLayout.setHorizontalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBAcessar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPBotoesLayout.setVerticalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBAcessar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
   
    private boolean validaCampos(){
        if((jTFLogin.getText().isEmpty()) | (jFTFSenha.getText().isEmpty())){
            JOptionPane.showMessageDialog(null, "Campos em branco.", 
                    "Login", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
    
    private Object getUsuario(String login){
        try{
            sql = "SELECT cd_usuario, ds_login, ds_senha" +
                  "  FROM usuario" +
                  " WHERE ds_login = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                usuario = new Usuario(
                    rs.getInt("cd_usuario"),
                    rs.getString("ds_login"),
                    rs.getString("ds_senha"));
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Usuário inválido.",
                "Login", JOptionPane.INFORMATION_MESSAGE);
        }
        return usuario;
    }
    
    private boolean validaUsuario(){
        if(!jTFLogin.getText().equals(usuario.getDs_login())){
            JOptionPane.showMessageDialog(null, "Usuario não existente",
                    "Login", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if(!jFTFSenha.getText().equals(usuario.getDs_senha())){
            JOptionPane.showMessageDialog(null, "Senha inválida.",
                    "Login", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void abreMenuPrincipal(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
                public void run (){
                new JFPrincipal().setVisible(true);}
        });
    }
    
    private void jBAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAcessarActionPerformed
        if(validaCampos()){
            usuario = (Usuario)getUsuario(jTFLogin.getText());
            if(validaUsuario()){
                codloginuser = usuario.getCd_usuario();
                abreMenuPrincipal();
                jfrm.dispose();
            }    
        }
    }//GEN-LAST:event_jBAcessarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAcessar;
    private javax.swing.JFormattedTextField jFTFSenha;
    private javax.swing.JLabel jLLogin;
    private javax.swing.JLabel jLSenha;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JTextField jTFLogin;
    // End of variables declaration//GEN-END:variables
}
