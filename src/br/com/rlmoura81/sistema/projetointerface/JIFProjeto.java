package br.com.rlmoura81.sistema.projetointerface;

import br.com.rlmoura81.sistema.principalinterface.JPLogin;
import br.com.rlmoura81.sistema.projeto.Modulo;
import br.com.rlmoura81.sistema.projeto.ModuloRepository;
import br.com.rlmoura81.sistema.projeto.ModuloUtil;
import br.com.rlmoura81.sistema.projeto.Projeto;
import br.com.rlmoura81.sistema.projeto.ProjetoRepository;
import br.com.rlmoura81.sistema.projeto.ProjetoUtil;
import javax.swing.JOptionPane;

public class JIFProjeto extends javax.swing.JInternalFrame {
    
    private static JIFProjeto jifprojeto;
    
    public static JIFProjeto getInstancia(){
        if(jifprojeto == null){
            jifprojeto = new JIFProjeto();
            jifprojeto.setTitle("Projeto");
        }
        return jifprojeto;
    }
        
    Projeto projeto = null;
    ProjetoRepository projetor = new ProjetoRepository();
    ProjetoUtil projetou = new ProjetoUtil();
    
    Modulo modulo = null;
    ModuloRepository modulor = new ModuloRepository();
    ModuloUtil modulou = new ModuloUtil();
            
    public JIFProjeto() {
        initComponents();
        
        jBNovo.setEnabled(false);
        jTPProjeto.setEnabledAt(1, false);
        tabelaProjeto();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jLProjeto = new javax.swing.JLabel();
        jTFProjeto = new javax.swing.JTextField();
        jBNovo = new javax.swing.JButton();
        jPBotoes = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jTPProjeto = new javax.swing.JTabbedPane();
        jPProjeto = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProjeto = new javax.swing.JTable();
        jPModulo = new javax.swing.JPanel();
        jPModuloCampos = new javax.swing.JPanel();
        jLModulo = new javax.swing.JLabel();
        jTFModulo = new javax.swing.JTextField();
        jLDescricaoModulo = new javax.swing.JLabel();
        jTFDescricaoModulo = new javax.swing.JTextField();
        jLHorasModulo = new javax.swing.JLabel();
        jTFHora = new javax.swing.JTextField();
        jPModuloGrid = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTModulo = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLProjeto.setText("Projeto:");

        jBNovo.setText("Novo");
        jBNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLProjeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBNovo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLProjeto)
                    .addComponent(jTFProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBNovo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBotoesLayout = new javax.swing.GroupLayout(jPBotoes);
        jPBotoes.setLayout(jPBotoesLayout);
        jPBotoesLayout.setHorizontalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBSalvar)
                    .addComponent(jBExcluir))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPBotoesLayout.setVerticalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTPProjeto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTProjeto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTProjeto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProjetoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTProjeto);

        javax.swing.GroupLayout jPProjetoLayout = new javax.swing.GroupLayout(jPProjeto);
        jPProjeto.setLayout(jPProjetoLayout);
        jPProjetoLayout.setHorizontalGroup(
            jPProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPProjetoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPProjetoLayout.setVerticalGroup(
            jPProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPProjetoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPProjeto.addTab("Projetos", jPProjeto);

        jLModulo.setText("Módulo:");

        jLDescricaoModulo.setText("Descrição:");

        jLHorasModulo.setText("Horas:");

        javax.swing.GroupLayout jPModuloCamposLayout = new javax.swing.GroupLayout(jPModuloCampos);
        jPModuloCampos.setLayout(jPModuloCamposLayout);
        jPModuloCamposLayout.setHorizontalGroup(
            jPModuloCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPModuloCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPModuloCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLDescricaoModulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLModulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPModuloCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPModuloCamposLayout.createSequentialGroup()
                        .addComponent(jTFDescricaoModulo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLHorasModulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFHora, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        jPModuloCamposLayout.setVerticalGroup(
            jPModuloCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPModuloCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPModuloCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLModulo)
                    .addComponent(jTFModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPModuloCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDescricaoModulo)
                    .addComponent(jTFDescricaoModulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLHorasModulo)
                    .addComponent(jTFHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTModulo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTModulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTModuloMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTModulo);

        javax.swing.GroupLayout jPModuloGridLayout = new javax.swing.GroupLayout(jPModuloGrid);
        jPModuloGrid.setLayout(jPModuloGridLayout);
        jPModuloGridLayout.setHorizontalGroup(
            jPModuloGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPModuloGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPModuloGridLayout.setVerticalGroup(
            jPModuloGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPModuloGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPModuloLayout = new javax.swing.GroupLayout(jPModulo);
        jPModulo.setLayout(jPModuloLayout);
        jPModuloLayout.setHorizontalGroup(
            jPModuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPModuloLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPModuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPModuloCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPModuloGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPModuloLayout.setVerticalGroup(
            jPModuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPModuloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPModuloCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPModuloGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPProjeto.addTab("Modulos", jPModulo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTPProjeto))
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTPProjeto)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpaCampo(){
        jTFProjeto.setText(null);
        projeto.setCd_projeto(0);
        jTPProjeto.setEnabledAt(1, false);
    }
    
    private void limpaCampoModulo(){
        jTFModulo.setText(null);
        jTFDescricaoModulo.setText(null);
        jTFHora.setText(null);
    }
    
    private void tabelaProjeto(){
        projetou.tabelaProjeto(jTProjeto);
    }
    
    private boolean validaCampoProjeto(){
        if(jTFProjeto.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.");
            jTFProjeto.requestFocus();
            return false;
        }
        return true;
    }
    
    private boolean validaCampoModulo(){
        if(jTFModulo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.");
            jTFModulo.requestFocus();
            return false;
        }
        if(jTFDescricaoModulo.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.");
            jTFDescricaoModulo.requestFocus();
            return false;
        }
        if(jTFHora.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.");
            jTFHora.requestFocus();
            return false;
        }
        return true;
    }
    
    private void projetoSalvar(){        
        if(projeto == null){
            projeto = new Projeto();
            projeto.setDs_projeto(jTFProjeto.getText());
            projeto.setCd_usuario(JPLogin.codloginuser);
            projetor.inserir(projeto);
            projeto = null;
        }else{
            projeto.setDs_projeto(jTFProjeto.getText());
            projeto.setCd_usuario(JPLogin.codloginuser);
            projetor.alterar(projeto);
            projeto = null;
        }       
    }
    
    private void moduloSalvar(){
        if(modulo == null){
            modulo = new Modulo();
            modulo.setDs_modulo(jTFModulo.getText());
            modulo.setDs_descricao(jTFDescricaoModulo.getText());   
            modulo.setNm_hora(Integer.parseInt(jTFHora.getText()));
            modulo.setProjeto(projeto);
            modulo.setCd_usuario(JPLogin.codloginuser);
            modulor.inserir(modulo);
            modulo = null;
        }else{
            modulo.setDs_modulo(jTFModulo.getText());
            modulo.setDs_descricao(jTFDescricaoModulo.getText());   
            modulo.setNm_hora(Integer.parseInt(jTFHora.getText()));
            modulo.setProjeto(projeto);
            modulo.setCd_usuario(JPLogin.codloginuser);
            modulor.alterar(modulo);
            modulo = null;
        }    
    }
        
    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(jTPProjeto.getSelectedIndex() == 0){
            if(validaCampoProjeto()){
                projetoSalvar();
                limpaCampo();
                tabelaProjeto();               
            }        
        }
        if(jTPProjeto.getSelectedIndex() == 1){
            if(validaCampoModulo()){
                moduloSalvar(); 
                limpaCampoModulo();
                modulou.tabelaModulo(jTModulo, projeto.getCd_projeto());
            }
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifprojeto = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jTProjetoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProjetoMouseClicked
        projeto = (Projeto)projetou.getSelectObject(jTProjeto);
        jTFProjeto.setText(projeto.getDs_projeto());
        jTPProjeto.setEnabledAt(1, true);
        modulou.tabelaModulo(jTModulo, projeto.getCd_projeto());
        jBNovo.setEnabled(true);
    }//GEN-LAST:event_jTProjetoMouseClicked

    private void jTModuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTModuloMouseClicked
        modulo = (Modulo)modulou.getSelectObject(jTModulo);
        jTFModulo.setText(modulo.getDs_modulo());
        jTFDescricaoModulo.setText(modulo.getDs_descricao());
        jTFHora.setText(Integer.toString(modulo.getNm_hora()));
    }//GEN-LAST:event_jTModuloMouseClicked

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        if(jTPProjeto.getSelectedIndex() == 0){
            if((Projeto)projetou.getSelectObject(jTProjeto) != null){
                projetor.excluir(projeto);
                limpaCampo();
                tabelaProjeto();
            }
        }
        if(jTPProjeto.getSelectedIndex() == 1){
            if((Modulo)modulou.getSelectObject(jTModulo) != null){
                modulor.excluir(modulo);
                limpaCampoModulo();
                modulou.tabelaModulo(jTModulo, projeto.getCd_projeto());
            }
        }
        jBNovo.setEnabled(false);
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        limpaCampo();
        limpaCampoModulo();
        jBNovo.setEnabled(false);
    }//GEN-LAST:event_jBNovoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JLabel jLDescricaoModulo;
    private javax.swing.JLabel jLHorasModulo;
    private javax.swing.JLabel jLModulo;
    private javax.swing.JLabel jLProjeto;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPModulo;
    private javax.swing.JPanel jPModuloCampos;
    private javax.swing.JPanel jPModuloGrid;
    private javax.swing.JPanel jPProjeto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFDescricaoModulo;
    private javax.swing.JTextField jTFHora;
    private javax.swing.JTextField jTFModulo;
    private javax.swing.JTextField jTFProjeto;
    private javax.swing.JTable jTModulo;
    private javax.swing.JTabbedPane jTPProjeto;
    private javax.swing.JTable jTProjeto;
    // End of variables declaration//GEN-END:variables
}
