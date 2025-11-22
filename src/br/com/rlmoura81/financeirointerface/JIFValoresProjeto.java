package br.com.rlmoura81.financeirointerface;

import br.com.rlmoura81.sistema.geral.DespesaRepository;
import br.com.rlmoura81.sistema.projeto.Modulo;
import br.com.rlmoura81.sistema.projeto.ModuloUtil;
import br.com.rlmoura81.sistema.utilidade.Utilidade;

public class JIFValoresProjeto extends javax.swing.JInternalFrame {
    
    private static JIFValoresProjeto jifvaloresprojeto;
    
    public static JIFValoresProjeto getInstancia(){
        if (jifvaloresprojeto == null){
            jifvaloresprojeto = new JIFValoresProjeto();
            jifvaloresprojeto.setTitle("Valores Projetos");
        } return jifvaloresprojeto;
    }
    
    Modulo modulo = new Modulo();
    ModuloUtil modelou = new ModuloUtil();
    
    DespesaRepository despesar = new DespesaRepository();
    
    Utilidade util = new Utilidade();

    public JIFValoresProjeto() {
        initComponents();
        
        formataValorCampo();
        tabelaProjetosValores();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPProjeto = new javax.swing.JPanel();
        jLProjeto = new javax.swing.JLabel();
        jTFProjeto = new javax.swing.JTextField();
        jLModulos = new javax.swing.JLabel();
        jTFModulos = new javax.swing.JTextField();
        jLHora = new javax.swing.JLabel();
        jTFHora = new javax.swing.JTextField();
        jPValores = new javax.swing.JPanel();
        jLCustoMensal = new javax.swing.JLabel();
        jFTFCustoMensal = new javax.swing.JFormattedTextField();
        jLCustoHora = new javax.swing.JLabel();
        jFTFCustoHora = new javax.swing.JFormattedTextField();
        jLTotalValores = new javax.swing.JLabel();
        jLValorHora = new javax.swing.JLabel();
        jFTFValorHora = new javax.swing.JFormattedTextField();
        jPValoresProjetos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProjeto = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
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

        jPProjeto.setBorder(javax.swing.BorderFactory.createTitledBorder("Projeto"));

        jLProjeto.setText("Projeto:");

        jTFProjeto.setEditable(false);

        jLModulos.setText("Modulos:");

        jTFModulos.setEditable(false);

        jLHora.setText("Hora:");

        jTFHora.setEditable(false);

        javax.swing.GroupLayout jPProjetoLayout = new javax.swing.GroupLayout(jPProjeto);
        jPProjeto.setLayout(jPProjetoLayout);
        jPProjetoLayout.setHorizontalGroup(
            jPProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPProjetoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLProjeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLModulos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFModulos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(395, Short.MAX_VALUE))
        );
        jPProjetoLayout.setVerticalGroup(
            jPProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPProjetoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLProjeto)
                    .addComponent(jTFProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLHora)
                    .addComponent(jTFHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLModulos)
                    .addComponent(jTFModulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPValores.setBorder(javax.swing.BorderFactory.createTitledBorder("Valores"));

        jLCustoMensal.setText("Custo Mensal:");

        jFTFCustoMensal.setEditable(false);

        jLCustoHora.setText("Custo Hora:");

        jFTFCustoHora.setEditable(false);

        jLTotalValores.setText("Total: 0,00");

        jLValorHora.setText("Valor Hora:");

        jFTFValorHora.setEditable(false);

        javax.swing.GroupLayout jPValoresLayout = new javax.swing.GroupLayout(jPValores);
        jPValores.setLayout(jPValoresLayout);
        jPValoresLayout.setHorizontalGroup(
            jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLCustoMensal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFCustoMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPValoresLayout.createSequentialGroup()
                        .addComponent(jLValorHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFValorHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPValoresLayout.createSequentialGroup()
                        .addComponent(jLCustoHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFCustoHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLTotalValores)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPValoresLayout.setVerticalGroup(
            jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCustoMensal)
                    .addComponent(jFTFCustoMensal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCustoHora)
                    .addComponent(jFTFCustoHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTotalValores))
                .addGap(18, 18, 18)
                .addGroup(jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLValorHora)
                    .addComponent(jFTFValorHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        jPValoresProjetos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPValoresProjetosLayout = new javax.swing.GroupLayout(jPValoresProjetos);
        jPValoresProjetos.setLayout(jPValoresProjetosLayout);
        jPValoresProjetosLayout.setHorizontalGroup(
            jPValoresProjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPValoresProjetosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPValoresProjetosLayout.setVerticalGroup(
            jPValoresProjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPValoresProjetosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPProjeto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPValoresProjetos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPValores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jPValoresProjetos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifvaloresprojeto = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jTProjetoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProjetoMouseClicked
        modulo = (Modulo)modelou.getSelectObject(jTProjeto);
        jTFProjeto.setText(modulo.getProjeto().getDs_projeto());
        jTFModulos.setText(Integer.toString(modulo.getCd_modulo()));
        jTFHora.setText(Utilidade.formatoValor.format(modulo.getNm_hora()));
        
        valorTotalDespesa();
    }//GEN-LAST:event_jTProjetoMouseClicked

    private void formataValorCampo(){
        jFTFCustoMensal.setFormatterFactory(Utilidade.formataValorCampo(jFTFCustoMensal));
        jFTFCustoHora.setFormatterFactory(Utilidade.formataValorCampo(jFTFCustoHora));
    }
    
    private void tabelaProjetosValores(){
        modelou.tabelaModulo(jTProjeto);
    }
    
    private void valorTotalDespesa(){
        jFTFCustoMensal.setText(Utilidade.formatoValor.format(despesar.valorTotalDespesa()));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField jFTFCustoHora;
    private javax.swing.JFormattedTextField jFTFCustoMensal;
    private javax.swing.JFormattedTextField jFTFValorHora;
    private javax.swing.JLabel jLCustoHora;
    private javax.swing.JLabel jLCustoMensal;
    private javax.swing.JLabel jLHora;
    private javax.swing.JLabel jLModulos;
    private javax.swing.JLabel jLProjeto;
    private javax.swing.JLabel jLTotalValores;
    private javax.swing.JLabel jLValorHora;
    private javax.swing.JPanel jPProjeto;
    private javax.swing.JPanel jPValores;
    private javax.swing.JPanel jPValoresProjetos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFHora;
    private javax.swing.JTextField jTFModulos;
    private javax.swing.JTextField jTFProjeto;
    private javax.swing.JTable jTProjeto;
    // End of variables declaration//GEN-END:variables
}
