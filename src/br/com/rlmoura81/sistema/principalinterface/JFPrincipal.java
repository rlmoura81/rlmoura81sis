package br.com.rlmoura81.sistema.principalinterface;

import br.com.rlmoura81.sistema.geralinterface.JIFCadastroGeral;
import br.com.rlmoura81.sistema.geralinterface.JIFGrupo;
import br.com.rlmoura81.sistema.projetointerface.JIFProjeto;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class JFPrincipal extends javax.swing.JFrame {
    
    GerenciarInterface gerenciainterface;   
    
    
    public JFPrincipal() {
        initComponents();
        
        this.gerenciainterface = new GerenciarInterface(jDPPrincipal);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle("Sistema rlmoura81" + " - " + "Usuário: ");
        nlsDateFormat();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDPPrincipal = new javax.swing.JDesktopPane();
        jMBPrincipal = new javax.swing.JMenuBar();
        jMPrincipal = new javax.swing.JMenu();
        jMIProjeto = new javax.swing.JMenuItem();
        jMITerminal = new javax.swing.JMenuItem();
        jMISair = new javax.swing.JMenuItem();
        JMGeral = new javax.swing.JMenu();
        jMIGrupo = new javax.swing.JMenuItem();
        jMICursos = new javax.swing.JMenuItem();
        jMIDespesa = new javax.swing.JMenuItem();
        jMIPatrimonio = new javax.swing.JMenuItem();
        JMITrabalho = new javax.swing.JMenuItem();
        jMISalario = new javax.swing.JMenuItem();
        jMSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDPPrincipalLayout = new javax.swing.GroupLayout(jDPPrincipal);
        jDPPrincipal.setLayout(jDPPrincipalLayout);
        jDPPrincipalLayout.setHorizontalGroup(
            jDPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 855, Short.MAX_VALUE)
        );
        jDPPrincipalLayout.setVerticalGroup(
            jDPPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
        );

        jMPrincipal.setText("Principal");

        jMIProjeto.setText("Projetos");
        jMIProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIProjetoActionPerformed(evt);
            }
        });
        jMPrincipal.add(jMIProjeto);

        jMITerminal.setText("Terminal");
        jMITerminal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMITerminalActionPerformed(evt);
            }
        });
        jMPrincipal.add(jMITerminal);

        jMISair.setText("Sair");
        jMISair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISairActionPerformed(evt);
            }
        });
        jMPrincipal.add(jMISair);

        jMBPrincipal.add(jMPrincipal);

        JMGeral.setText("Geral");

        jMIGrupo.setText("Grupo");
        jMIGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIGrupoActionPerformed(evt);
            }
        });
        JMGeral.add(jMIGrupo);

        jMICursos.setText("Curso");
        jMICursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMICursosActionPerformed(evt);
            }
        });
        JMGeral.add(jMICursos);

        jMIDespesa.setText("Despesa");
        jMIDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIDespesaActionPerformed(evt);
            }
        });
        JMGeral.add(jMIDespesa);

        jMIPatrimonio.setText("Patrimonio");
        jMIPatrimonio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIPatrimonioActionPerformed(evt);
            }
        });
        JMGeral.add(jMIPatrimonio);

        JMITrabalho.setText("Trabalho");
        JMITrabalho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMITrabalhoActionPerformed(evt);
            }
        });
        JMGeral.add(JMITrabalho);

        jMISalario.setText("Salario");
        jMISalario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMISalarioActionPerformed(evt);
            }
        });
        JMGeral.add(jMISalario);

        jMBPrincipal.add(JMGeral);

        jMSobre.setText("Sobre");
        jMSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMSobreMouseClicked(evt);
            }
        });
        jMBPrincipal.add(jMSobre);

        setJMenuBar(jMBPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDPPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDPPrincipal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPrincipal().setVisible(true);
            }
        });
    }    
    
        /**
     * <p><strong>EN:</strong> Validates and adjusts the Oracle session’s 
     * NLS_DATE_FORMAT parameter.  
     * If the current format is different from <code>DD/MM/RR</code>, 
     * updates the session to use <code>dd/MM/yyyy</code>.</p>
     *
     * <p><strong>IT:</strong> Verifica e aggiorna il parametro 
     * NLS_DATE_FORMAT della sessione Oracle.  
     * Se il formato attuale è diverso da <code>DD/MM/RR</code>, 
     * imposta la sessione su <code>dd/MM/yyyy</code>.</p>
     *
     * <p><strong>PT-BR:</strong> Valida e ajusta o parâmetro 
     * NLS_DATE_FORMAT da sessão Oracle.  
     * Se o formato atual for diferente de <code>DD/MM/RR</code>, 
     * altera a sessão para <code>dd/MM/yyyy</code>.</p>
     */
    private void nlsDateFormat(){
        String sql;
        String nlsDateFormat = null;
        try{
            sql = "SELECT value" +
                  "  FROM NLS_SESSION_PARAMETERS" +
                  " WHERE PARAMETER = 'NLS_DATE_FORMAT'";
            PreparedStatement ps = JPLogin.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                nlsDateFormat = rs.getString("value");
            }
            if(!nlsDateFormat.equals("DD/MM/RR")){
                try{
                    sql = "ALTER SESSION SET NLS_DATE_FORMAT = 'dd/MM/yyyy'";
                    ps.execute(sql);
                }catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Erro ao alterar a nls_Date_Format:\n" +
                            ex.getMessage());
                }
            }
            ps.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de nls_Date_Format:\n" +
                    ex.getMessage());
        }
    }
    
    private void jMISairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMISairActionPerformed

    private void jMITerminalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMITerminalActionPerformed
        try {
            Runtime.getRuntime().exec("cmd /c start C:\\Users\\rlmou\\OneDrive\\Documents\\rlmoura81sis\\scripts\\scriptRlmoura81.bat");
        } catch (IOException ex) {
            Logger.getLogger(JFPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMITerminalActionPerformed

    private void jMSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMSobreMouseClicked
        JOptionPane.showMessageDialog(null, "Versão - beta\n" + "by rlmoura81"  , "Sistema",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMSobreMouseClicked

    private void jMIProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIProjetoActionPerformed
        gerenciainterface.abrirInterface(JIFProjeto.getInstancia());
    }//GEN-LAST:event_jMIProjetoActionPerformed

    private void jMICursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMICursosActionPerformed
        gerenciainterface.abrirInterface(JIFCadastroGeral.getInstancia(1));
    }//GEN-LAST:event_jMICursosActionPerformed

    private void jMIDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIDespesaActionPerformed
        gerenciainterface.abrirInterface(JIFCadastroGeral.getInstancia(2));
    }//GEN-LAST:event_jMIDespesaActionPerformed

    private void jMIPatrimonioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIPatrimonioActionPerformed
        gerenciainterface.abrirInterface(JIFCadastroGeral.getInstancia(3));
    }//GEN-LAST:event_jMIPatrimonioActionPerformed

    private void JMITrabalhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMITrabalhoActionPerformed
        gerenciainterface.abrirInterface(JIFCadastroGeral.getInstancia(4));
    }//GEN-LAST:event_JMITrabalhoActionPerformed

    private void jMISalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMISalarioActionPerformed
        gerenciainterface.abrirInterface(JIFCadastroGeral.getInstancia(5));
    }//GEN-LAST:event_jMISalarioActionPerformed

    private void jMIGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIGrupoActionPerformed
        gerenciainterface.abrirInterface(JIFGrupo.getInstancia());
    }//GEN-LAST:event_jMIGrupoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JMGeral;
    private javax.swing.JMenuItem JMITrabalho;
    private javax.swing.JDesktopPane jDPPrincipal;
    private javax.swing.JMenuBar jMBPrincipal;
    private javax.swing.JMenuItem jMICursos;
    private javax.swing.JMenuItem jMIDespesa;
    private javax.swing.JMenuItem jMIGrupo;
    private javax.swing.JMenuItem jMIPatrimonio;
    private javax.swing.JMenuItem jMIProjeto;
    private javax.swing.JMenuItem jMISair;
    private javax.swing.JMenuItem jMISalario;
    private javax.swing.JMenuItem jMITerminal;
    private javax.swing.JMenu jMPrincipal;
    private javax.swing.JMenu jMSobre;
    // End of variables declaration//GEN-END:variables
}
