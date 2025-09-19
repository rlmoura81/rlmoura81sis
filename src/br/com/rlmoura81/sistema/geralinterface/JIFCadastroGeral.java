package br.com.rlmoura81.sistema.geralinterface;

import br.com.rlmoura81.sistema.geral.CadastroGeral;
import br.com.rlmoura81.sistema.geral.CursoRepository;
import br.com.rlmoura81.sistema.geral.CursoUtil;
import br.com.rlmoura81.sistema.geral.DespesaRepository;
import br.com.rlmoura81.sistema.geral.DespesaUtil;
import br.com.rlmoura81.sistema.geral.Grupo;
import br.com.rlmoura81.sistema.geral.GrupoUtil;
import br.com.rlmoura81.sistema.geral.PatrimonioRepository;
import br.com.rlmoura81.sistema.geral.PatrimonioUtil;
import br.com.rlmoura81.sistema.geral.SalarioRepository;
import br.com.rlmoura81.sistema.geral.SalarioUtil;
import br.com.rlmoura81.sistema.geral.TrabalhoRepository;
import br.com.rlmoura81.sistema.geral.TrabalhoUtil;
import br.com.rlmoura81.sistema.principalinterface.JPLogin;
import br.com.rlmoura81.sistema.utilidade.Utilidade;
import javax.swing.JOptionPane;

public class JIFCadastroGeral extends javax.swing.JInternalFrame {
    
    private static JIFCadastroGeral jifcadgeral;
    public int modulo;
        
    public static JIFCadastroGeral getInstancia(int modulo){
        if(modulo == 1){
            if(jifcadgeral == null){
                jifcadgeral = new JIFCadastroGeral(1);
                jifcadgeral.setTitle("Cadastro Curso");
            }               
        }
        if(modulo == 2){
            if(jifcadgeral == null){
                jifcadgeral = new JIFCadastroGeral(2);
                jifcadgeral.setTitle("Cadastro Despesa");
            }              
        }
        if(modulo == 3){
            if(jifcadgeral == null){
                jifcadgeral = new JIFCadastroGeral(3);
                jifcadgeral.setTitle("Cadastro Patrimônio");
            }             
        }
        if(modulo == 4){
            if(jifcadgeral == null){
                jifcadgeral = new JIFCadastroGeral(4);
                jifcadgeral.setTitle("Cadastro Trabalho");
            }             
        }
        if(modulo == 5){
            if(jifcadgeral == null){
                jifcadgeral = new JIFCadastroGeral(5);
                jifcadgeral.setTitle("Cadastro Salário");
            }             
        }        
        return jifcadgeral;
    }
    
    CadastroGeral cadgeral = null;
    
    Grupo grupo = new Grupo();
    GrupoUtil grupou = new GrupoUtil();
        
    CursoRepository cursor = new CursoRepository();
    CursoUtil cursou = new CursoUtil();
    
    DespesaRepository despesar = new DespesaRepository();
    DespesaUtil despesau = new DespesaUtil();
    
    PatrimonioRepository patrimonior = new PatrimonioRepository();
    PatrimonioUtil patrimoniou = new PatrimonioUtil();
    
    TrabalhoRepository trabalhor = new TrabalhoRepository();
    TrabalhoUtil trabalhou = new TrabalhoUtil();
    
    SalarioRepository salarior = new SalarioRepository();
    SalarioUtil salariou = new SalarioUtil();
    
    Utilidade util = new Utilidade();

    public JIFCadastroGeral(int modulo) {
        this.modulo = modulo;
        initComponents();
        
        mascaraCampos();
        formataValor();
        campoModulo();
        tabelaCadGeral();
        jcGrupo();
    }

    private void campoModulo(){
        if(modulo == 1 | modulo == 2 | modulo == 4){
            jLQtde.setVisible(false);
            jTFQtde.setVisible(false);
        }
        if(modulo == 3){
            jLQtde.setVisible(true);
            jTFQtde.setVisible(true);
        }
        if(modulo == 5){
            jLDescricao.setVisible(false);
            jTFDescricao.setVisible(false);
            jLQtde.setVisible(false);
            jTFQtde.setVisible(false);
        }
        if(modulo == 2 | modulo == 3 | modulo == 5){
            jLHoras.setVisible(false);
            jTFHora.setVisible(false);
        }
    }
    
    private void jcGrupo(){
        if(modulo == 1){
            grupou.jcGrupo(jCBGrupo);
        }else{
            jCBGrupo.setVisible(false);
        }
    }
    private void mascaraCampos(){
        util.formataDataCampo(jFTFData);
    }
    
    private void formataValor(){
        jFTFValor.setFormatterFactory(Utilidade.formataValorCampo(jFTFValor));
    }
    
    private void tabelaCadGeral(){
        if(modulo == 1){
            cursou.tabelaCurso(jTCadGeral);            
        }
        if(modulo == 2){
            despesau.tabelaDespesa(jTCadGeral);
        }
        if(modulo == 3){
            patrimoniou.tabelaPatrimonio(jTCadGeral);
        }
        if(modulo == 4){
            trabalhou.tabelaTrabalho(jTCadGeral);
        } 
        if(modulo == 5){
            salariou.tabelaSalario(jTCadGeral);
        }
    }
    
    private void limpaCampos(){
        jTFDescricao.setText(null);
        jTFHora.setText(null);
        jFTFValor.setValue(null);
        jFTFData.setText(null);
        jCBGrupo.setSelectedIndex(0);
    }
    
    private boolean validaCampos(){
        if(modulo != 5){
            if(jTFDescricao.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Campo em branco.");
                jTFDescricao.requestFocus();
                return false;
            }
            if(jFTFValor.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Campo em branco.");
                jFTFValor.requestFocus();
                return false;
            }        
            if(!util.validaDataCampo(jFTFData.getText())){
                jFTFData.requestFocus();
                return false;
            }
                    
            if(jTFHora.getText().isEmpty()){
                jTFHora.requestFocus();
                return false;
            }            
        }else{
            if(jFTFValor.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Campo em branco.");
                jFTFValor.requestFocus();
                return false;
            }        
            if(!util.validaDataCampo(jFTFData.getText())){
                jFTFData.requestFocus();
                return false;
            }            
        }
        return true;
    }
    
    private void salvar(){
        if(cadgeral == null){
            cadgeral = new CadastroGeral();
            cadgeral.setDs_cadgeral(jTFDescricao.getText());
            cadgeral.setGrupo(grupo);
            cadgeral.setDt_cadgeral(util.recebeData(jFTFData.getText()));
            cadgeral.setNm_valor(Utilidade.converter(jFTFValor.getText()));
            cadgeral.setCd_usuario(JPLogin.codloginuser);
            if(modulo == 1){
                cadgeral.setNm_hora(Integer.parseInt(jTFHora.getText()));
                cursor.inserir(cadgeral);
            }
            if(modulo == 2){
                despesar.inserir(cadgeral);
            }
            if(modulo == 3){
                cadgeral.setNm_qtde(Integer.parseInt(jTFQtde.getText()));
                patrimonior.inserir(cadgeral);
            }
            if(modulo == 4){
                trabalhor.inserir(cadgeral);
            }   
            if(modulo == 5){
                salarior.inserir(cadgeral);
            }
            cadgeral = null;
        }else{
            cadgeral.setDs_cadgeral(jTFDescricao.getText());
            cadgeral.setGrupo(grupo);
            cadgeral.setDt_cadgeral(util.recebeData(jFTFData.getText()));
            cadgeral.setNm_valor(Utilidade.converter(jFTFValor.getText()));
            cadgeral.setCd_usuario(JPLogin.codloginuser); 
            if(modulo == 1){
                cadgeral.setNm_hora(Integer.parseInt(jTFHora.getText()));
                cursor.alterar(cadgeral);                
            }
            if(modulo == 2){               
                despesar.alterar(cadgeral);
            }
            if(modulo == 3){
                cadgeral.setNm_qtde(Integer.parseInt(jTFQtde.getText()));
                patrimonior.alterar(cadgeral);
            }
            if(modulo == 4){
                trabalhor.alterar(cadgeral);
            }  
            if(modulo == 5){
                salarior.alterar(cadgeral);
            }
            cadgeral = null;
        }
    }
    
    private void excluir(){
        if(modulo == 1){
            if((CadastroGeral)cursou.getSelectObject(jTCadGeral) != null){
                cursor.excluir(cadgeral);              
            }            
        }
        if(modulo == 2){
            if((CadastroGeral)despesau.getSelectObject(jTCadGeral) != null){
                despesar.excluir(cadgeral);                   
            }
        }
        if(modulo == 3){
            if((CadastroGeral)patrimoniou.getSelectObject(jTCadGeral) != null){
                patrimonior.excluir(cadgeral);   
            }
        }    
        if(modulo == 4){
            if((CadastroGeral)trabalhou.getSelectObject(jTCadGeral) != null){
                trabalhor.excluir(cadgeral);    
            }
        }
        if(modulo == 5){
            if((CadastroGeral)salariou.getSelectObject(jTCadGeral) != null){
                salarior.excluir(cadgeral);     
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jLDescricao = new javax.swing.JLabel();
        jTFDescricao = new javax.swing.JTextField();
        jLData = new javax.swing.JLabel();
        jFTFData = new javax.swing.JFormattedTextField();
        jLValor = new javax.swing.JLabel();
        jFTFValor = new javax.swing.JFormattedTextField();
        jLHoras = new javax.swing.JLabel();
        jLQtde = new javax.swing.JLabel();
        jTFQtde = new javax.swing.JTextField();
        jCBGrupo = new javax.swing.JComboBox<>();
        jTFHora = new javax.swing.JTextField();
        jPBotao = new javax.swing.JPanel();
        jBSalvar = new javax.swing.JButton();
        jBExcluir = new javax.swing.JButton();
        jPTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCadGeral = new javax.swing.JTable();

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

        jLDescricao.setText("Descrição:");

        jLData.setText("Data:");

        jLValor.setText("Valor:");

        jLHoras.setText("Horas:");

        jLQtde.setText("Qtde:");

        jTFQtde.setText("1");

        jCBGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBGrupoActionPerformed(evt);
            }
        });

        jTFHora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFHoraFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLDescricao)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLQtde)
                            .addComponent(jTFQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLValor)
                            .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLData)
                            .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLHoras)
                            .addComponent(jTFHora, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTFQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCamposLayout.createSequentialGroup()
                                .addComponent(jLHoras)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPCamposLayout.createSequentialGroup()
                                .addComponent(jLData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jFTFData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLQtde)))
                    .addGroup(jPCamposLayout.createSequentialGroup()
                        .addComponent(jLValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPBotao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPBotaoLayout = new javax.swing.GroupLayout(jPBotao);
        jPBotao.setLayout(jPBotaoLayout);
        jPBotaoLayout.setHorizontalGroup(
            jPBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBExcluir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPBotaoLayout.setVerticalGroup(
            jPBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBSalvar)
                    .addComponent(jBExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPTabela.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTCadGeral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTCadGeral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTCadGeralMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTCadGeral);

        javax.swing.GroupLayout jPTabelaLayout = new javax.swing.GroupLayout(jPTabela);
        jPTabela.setLayout(jPTabelaLayout);
        jPTabelaLayout.setHorizontalGroup(
            jPTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPTabelaLayout.setVerticalGroup(
            jPTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){
                salvar();
                tabelaCadGeral();
                limpaCampos();
            }        
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        excluir();
        tabelaCadGeral();
        limpaCampos();
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jTCadGeralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTCadGeralMouseClicked
        if(modulo == 1){
            cadgeral = (CadastroGeral)cursou.getSelectObject(jTCadGeral);
            if(cadgeral.getGrupo() == null){
                jCBGrupo.setSelectedIndex(0);
            }else{
                jCBGrupo.getModel().setSelectedItem(cadgeral.getGrupo());                
            }
            jTFHora.setText(Integer.toString(cadgeral.getNm_hora()));
        }
        if(modulo == 2){
            cadgeral = (CadastroGeral)despesau.getSelectObject(jTCadGeral);
        }
        if(modulo == 3){
            cadgeral = (CadastroGeral)patrimoniou.getSelectObject(jTCadGeral);
            jTFQtde.setText(Integer.toString(cadgeral.getNm_qtde()));
        }
        if(modulo == 4){
            cadgeral = (CadastroGeral)trabalhou.getSelectObject(jTCadGeral);
            jTFHora.setText(Integer.toString(cadgeral.getNm_hora()));
        }    
        if(modulo == 5){
            cadgeral = (CadastroGeral)salariou.getSelectObject(jTCadGeral);
        }
        if(modulo != 5){
            jTFDescricao.setText(cadgeral.getDs_cadgeral());
        }
        jFTFData.setText(Utilidade.formatoData.format(cadgeral.getDt_cadgeral().getTime()));
        jFTFValor.setText(Utilidade.formatoValor.format(cadgeral.getNm_valor()));
    }//GEN-LAST:event_jTCadGeralMouseClicked

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifcadgeral = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jCBGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBGrupoActionPerformed
        if(jCBGrupo.getSelectedIndex() != 0){
            grupo = (Grupo)jCBGrupo.getSelectedItem();
        }else{
            grupo = null;
        }
    }//GEN-LAST:event_jCBGrupoActionPerformed

    private void jTFHoraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFHoraFocusLost
        cadgeral.setNm_hora(Integer.valueOf(jTFHora.getText()));
        if(!(cadgeral.getNm_hora() / cadgeral.getNm_hora() == 1)){
            JOptionPane.showMessageDialog(null, "Somente numeros.");
            jTFHora.requestFocus();
        }
    }//GEN-LAST:event_jTFHoraFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<String> jCBGrupo;
    private javax.swing.JFormattedTextField jFTFData;
    private javax.swing.JFormattedTextField jFTFValor;
    private javax.swing.JLabel jLData;
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLHoras;
    private javax.swing.JLabel jLQtde;
    private javax.swing.JLabel jLValor;
    private javax.swing.JPanel jPBotao;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPTabela;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTCadGeral;
    private javax.swing.JTextField jTFDescricao;
    private javax.swing.JTextField jTFHora;
    private javax.swing.JTextField jTFQtde;
    // End of variables declaration//GEN-END:variables
}
