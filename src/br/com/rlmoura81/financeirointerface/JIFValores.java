package br.com.rlmoura81.financeirointerface;

import br.com.rlmoura81.financeiro.FinanceiroCalculo;
import br.com.rlmoura81.financeiro.Valores;
import br.com.rlmoura81.financeiro.ValoresRepository;
import br.com.rlmoura81.financeiro.ValoresUtil;
import br.com.rlmoura81.sistema.geral.DespesaRepository;
import br.com.rlmoura81.sistema.geral.SalarioRepository;
import br.com.rlmoura81.sistema.geral.TrabalhoRepository;
import br.com.rlmoura81.sistema.principalinterface.JPLogin;
import br.com.rlmoura81.sistema.utilidade.Utilidade;
import java.beans.PropertyVetoException;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

public class JIFValores extends javax.swing.JInternalFrame {
    
    private static JIFValores jifvalores;
    
    public static JIFValores getInstancia() throws PropertyVetoException{
        if (jifvalores == null){
            jifvalores = new JIFValores();
            jifvalores.setTitle("Valores");
            jifvalores.setMaximum(true);
        } return jifvalores;
    }
    
    private BigDecimal vltotaldespesa;
    private BigDecimal salariomin;
    private BigDecimal salarioatual;
    private BigDecimal salariomaior;  
    private BigDecimal hora;

    Valores valores = null;
    ValoresRepository valoresr = new ValoresRepository();
    ValoresUtil valoresu = new ValoresUtil();
    
    FinanceiroCalculo fc = new FinanceiroCalculo();
    DespesaRepository depesar = new DespesaRepository();
    SalarioRepository salarior = new SalarioRepository();
    TrabalhoRepository trabalhor = new TrabalhoRepository();
    

    
    Utilidade util = new Utilidade();

    public JIFValores() {
        initComponents();
        
        
        formataValorCampo();
        
        valorTotalDespesa();
        valoresSalarios();
        tabelaValores();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCustos = new javax.swing.JPanel();
        jLCustosMensais = new javax.swing.JLabel();
        jFTFCustosMensais = new javax.swing.JFormattedTextField();
        jLCustosOperacionais = new javax.swing.JLabel();
        jFTFCustosOperacionais = new javax.swing.JFormattedTextField();
        jPSalario = new javax.swing.JPanel();
        jLMinimoAtual = new javax.swing.JLabel();
        jFTFMinimoAtual = new javax.swing.JFormattedTextField();
        jLMaiorRecebido = new javax.swing.JLabel();
        jFTFRecebidoAtual = new javax.swing.JFormattedTextField();
        jLRecebidoAtual = new javax.swing.JLabel();
        jFTFMaiorRecebido = new javax.swing.JFormattedTextField();
        jLQtdeSalMin = new javax.swing.JLabel();
        jTFQtdeSalMinAtual = new javax.swing.JTextField();
        jLQtdeSalMinMaiorRec = new javax.swing.JLabel();
        jTFQtdeSalMinMaiorRec = new javax.swing.JTextField();
        jPHora = new javax.swing.JPanel();
        jLCustoMensalHora = new javax.swing.JLabel();
        jFTFCustoMensalHora = new javax.swing.JFormattedTextField();
        jLCustoOperacionalHora = new javax.swing.JLabel();
        jFTFCustoOpercionalHora = new javax.swing.JFormattedTextField();
        jLSalarioMinHora = new javax.swing.JLabel();
        jFTFSalarioMinHora = new javax.swing.JFormattedTextField();
        jLRecebidoAtualHora = new javax.swing.JLabel();
        jFTFRecebidoAtualHora = new javax.swing.JFormattedTextField();
        jLMairoRecebidoHora = new javax.swing.JLabel();
        jFTFMaiorRecebidoHora = new javax.swing.JFormattedTextField();
        jLTrabalhoMesHora = new javax.swing.JLabel();
        jFTFTrabalhoMesHora = new javax.swing.JFormattedTextField();
        jPValores = new javax.swing.JPanel();
        jLHoraTrabalhoMes = new javax.swing.JLabel();
        jTFHoraTrabalhoMes = new javax.swing.JTextField();
        jLQtdeSalarioMin = new javax.swing.JLabel();
        jFTFQtdeSalarioMin = new javax.swing.JFormattedTextField();
        jLSalarioMeta = new javax.swing.JLabel();
        jFTFSalarioMeta = new javax.swing.JFormattedTextField();
        jLValorHora = new javax.swing.JLabel();
        jFTFValorHora = new javax.swing.JFormattedTextField();
        jPCampos = new javax.swing.JPanel();
        jBCalcular = new javax.swing.JButton();
        jBSalvar = new javax.swing.JButton();
        jPGrid = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTValores = new javax.swing.JTable();

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

        jPCustos.setBorder(javax.swing.BorderFactory.createTitledBorder("Custos"));

        jLCustosMensais.setText("Mensais:");

        jFTFCustosMensais.setEditable(false);

        jLCustosOperacionais.setText("Operacionais:");

        jFTFCustosOperacionais.setEditable(false);

        javax.swing.GroupLayout jPCustosLayout = new javax.swing.GroupLayout(jPCustos);
        jPCustos.setLayout(jPCustosLayout);
        jPCustosLayout.setHorizontalGroup(
            jPCustosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCustosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLCustosMensais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFCustosMensais, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLCustosOperacionais)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFCustosOperacionais, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCustosLayout.setVerticalGroup(
            jPCustosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCustosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCustosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCustosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLCustosOperacionais)
                        .addComponent(jFTFCustosMensais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFTFCustosOperacionais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLCustosMensais))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPSalario.setBorder(javax.swing.BorderFactory.createTitledBorder("Salario"));

        jLMinimoAtual.setText("Minimo Atual:");

        jFTFMinimoAtual.setEditable(false);

        jLMaiorRecebido.setText("Maior Recebido:");

        jFTFRecebidoAtual.setEditable(false);

        jLRecebidoAtual.setText("Recebido Atual:");

        jFTFMaiorRecebido.setEditable(false);

        jLQtdeSalMin.setText("Qtde Sal. Min.:");

        jTFQtdeSalMinAtual.setEditable(false);

        jLQtdeSalMinMaiorRec.setText("Qtde Sal. Min.:");

        jTFQtdeSalMinMaiorRec.setEditable(false);

        javax.swing.GroupLayout jPSalarioLayout = new javax.swing.GroupLayout(jPSalario);
        jPSalario.setLayout(jPSalarioLayout);
        jPSalarioLayout.setHorizontalGroup(
            jPSalarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSalarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLMinimoAtual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFMinimoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPSalarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPSalarioLayout.createSequentialGroup()
                        .addComponent(jLQtdeSalMin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFQtdeSalMinAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPSalarioLayout.createSequentialGroup()
                        .addComponent(jLRecebidoAtual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFRecebidoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPSalarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPSalarioLayout.createSequentialGroup()
                        .addComponent(jLMaiorRecebido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFMaiorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPSalarioLayout.createSequentialGroup()
                        .addComponent(jLQtdeSalMinMaiorRec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFQtdeSalMinMaiorRec, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPSalarioLayout.setVerticalGroup(
            jPSalarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSalarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPSalarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLMinimoAtual)
                    .addComponent(jLRecebidoAtual)
                    .addComponent(jLMaiorRecebido)
                    .addComponent(jFTFMinimoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFRecebidoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFMaiorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPSalarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLQtdeSalMin)
                    .addComponent(jTFQtdeSalMinAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLQtdeSalMinMaiorRec)
                    .addComponent(jTFQtdeSalMinMaiorRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPHora.setBorder(javax.swing.BorderFactory.createTitledBorder("Hora"));

        jLCustoMensalHora.setText("Custo Mensal:");

        jFTFCustoMensalHora.setEditable(false);

        jLCustoOperacionalHora.setText("Custo Operacional:");

        jFTFCustoOpercionalHora.setEditable(false);

        jLSalarioMinHora.setText("Salario Min.:");

        jFTFSalarioMinHora.setEditable(false);

        jLRecebidoAtualHora.setText("Recebido Atual:");

        jFTFRecebidoAtualHora.setEditable(false);

        jLMairoRecebidoHora.setText("Maior Recebido:");

        jFTFMaiorRecebidoHora.setEditable(false);

        jLTrabalhoMesHora.setText("Trabalho/Mes:");

        jFTFTrabalhoMesHora.setEditable(false);

        javax.swing.GroupLayout jPHoraLayout = new javax.swing.GroupLayout(jPHora);
        jPHora.setLayout(jPHoraLayout);
        jPHoraLayout.setHorizontalGroup(
            jPHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPHoraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPHoraLayout.createSequentialGroup()
                        .addComponent(jLCustoMensalHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFCustoMensalHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLCustoOperacionalHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFCustoOpercionalHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLTrabalhoMesHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFTrabalhoMesHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPHoraLayout.createSequentialGroup()
                        .addComponent(jLSalarioMinHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFSalarioMinHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLRecebidoAtualHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFRecebidoAtualHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLMairoRecebidoHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFMaiorRecebidoHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPHoraLayout.setVerticalGroup(
            jPHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPHoraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCustoMensalHora)
                    .addComponent(jLCustoOperacionalHora)
                    .addComponent(jLTrabalhoMesHora)
                    .addComponent(jFTFCustoMensalHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFCustoOpercionalHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFTrabalhoMesHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSalarioMinHora)
                    .addComponent(jLRecebidoAtualHora)
                    .addComponent(jLMairoRecebidoHora)
                    .addComponent(jFTFSalarioMinHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFRecebidoAtualHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFMaiorRecebidoHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPValores.setBorder(javax.swing.BorderFactory.createTitledBorder("Valores"));

        jLHoraTrabalhoMes.setText("Horas Trabalho Mes:");

        jTFHoraTrabalhoMes.setText("220");

        jLQtdeSalarioMin.setText("Qtde Salario Min.:");

        jFTFQtdeSalarioMin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFQtdeSalarioMinFocusGained(evt);
            }
        });

        jLSalarioMeta.setText("Salario Meta:");

        jFTFSalarioMeta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFSalarioMetaFocusGained(evt);
            }
        });

        jLValorHora.setText("Valor Hora:");

        jFTFValorHora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFValorHoraFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPValoresLayout = new javax.swing.GroupLayout(jPValores);
        jPValores.setLayout(jPValoresLayout);
        jPValoresLayout.setHorizontalGroup(
            jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPValoresLayout.createSequentialGroup()
                        .addComponent(jLHoraTrabalhoMes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFHoraTrabalhoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPValoresLayout.createSequentialGroup()
                        .addComponent(jLQtdeSalarioMin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFQtdeSalarioMin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLSalarioMeta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFSalarioMeta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLValorHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFValorHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPValoresLayout.setVerticalGroup(
            jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLHoraTrabalhoMes)
                    .addComponent(jTFHoraTrabalhoMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLQtdeSalarioMin)
                    .addComponent(jLSalarioMeta)
                    .addComponent(jFTFSalarioMeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLValorHora)
                    .addComponent(jFTFValorHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFQtdeSalarioMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBCalcular.setText("Calcular");
        jBCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCalcularActionPerformed(evt);
            }
        });

        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBCalcular)
                .addGap(18, 18, 18)
                .addComponent(jBSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCalcular)
                    .addComponent(jBSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTValores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTValores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTValoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTValores);

        javax.swing.GroupLayout jPGridLayout = new javax.swing.GroupLayout(jPGrid);
        jPGrid.setLayout(jPGridLayout);
        jPGridLayout.setHorizontalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPGridLayout.setVerticalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPSalario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCustos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPHora, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPValores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCampos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPCustos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formataValorCampo(){
        jFTFCustosMensais.setFormatterFactory(Utilidade.formataValorCampo(jFTFCustosMensais));
        jFTFCustosOperacionais.setFormatterFactory(Utilidade.formataValorCampo(jFTFCustosOperacionais));
        
        jFTFMinimoAtual.setFormatterFactory(Utilidade.formataValorCampo(jFTFMinimoAtual));
        jFTFRecebidoAtual.setFormatterFactory(Utilidade.formataValorCampo(jFTFRecebidoAtual));
        jFTFMaiorRecebido.setFormatterFactory(Utilidade.formataValorCampo(jFTFMaiorRecebido));
        
        jFTFCustoMensalHora.setFormatterFactory(Utilidade.formataValorCampo(jFTFCustoMensalHora));
        jFTFCustoOpercionalHora.setFormatterFactory(Utilidade.formataValorCampo(jFTFCustoOpercionalHora));
        jFTFTrabalhoMesHora.setFormatterFactory(Utilidade.formataValorCampo(jFTFTrabalhoMesHora));
        jFTFSalarioMinHora.setFormatterFactory(Utilidade.formataValorCampo(jFTFSalarioMinHora));
        jFTFRecebidoAtualHora.setFormatterFactory(Utilidade.formataValorCampo(jFTFRecebidoAtualHora));
        jFTFMaiorRecebidoHora.setFormatterFactory(Utilidade.formataValorCampo(jFTFMaiorRecebidoHora));
        
        jFTFQtdeSalarioMin.setFormatterFactory(Utilidade.formataValorCampo(jFTFQtdeSalarioMin));
        jFTFSalarioMeta.setFormatterFactory(Utilidade.formataValorCampo(jFTFSalarioMeta));
        jFTFValorHora.setFormatterFactory(Utilidade.formataValorCampo(jFTFValorHora));
        
    }
    
    private void valorTotalDespesa(){
        vltotaldespesa = depesar.valorTotalDespesa();
        jFTFCustosMensais.setText(Utilidade.formatoValor.format(vltotaldespesa));
    }
    
    private void valoresSalarios(){
        salariomin = salarior.valorSalarioMinimoAtual();
        salarioatual = trabalhor.valorSalarioAtual();
        salariomaior = trabalhor.valorSalarioMaior();
        
        jFTFMinimoAtual.setText(Utilidade.formatoValor.format(salariomin));
        jFTFRecebidoAtual.setText(Utilidade.formatoValor.format(salarioatual));
        jFTFMaiorRecebido.setText(Utilidade.formatoValor.format(salariomaior));
        jTFQtdeSalMinAtual.setText(Utilidade.formatoValor.format(fc.qtdeSalAtual(salarioatual,salariomin)));
        jTFQtdeSalMinMaiorRec.setText(Utilidade.formatoValor.format(fc.qtdeSalMaior(salariomaior, salariomin)));
    }
    
    private void valorHoraDespesa(){        
        jFTFCustoMensalHora.setText(Utilidade.formatoValor.format(fc.custoMensalHora(vltotaldespesa)));
    }
    
    private void calculoValores(){
        jFTFSalarioMinHora.setText(Utilidade.formatoValor.format(fc.salarioHora(salariomin, hora)));
        jFTFRecebidoAtualHora.setText(Utilidade.formatoValor.format(fc.salarioHora(salarioatual, hora)));
        jFTFMaiorRecebidoHora.setText(Utilidade.formatoValor.format(fc.salarioHora(salariomaior, hora)));
    }
    
    private void salarioMeta(){
        BigDecimal qtdesalariometa = null;
        BigDecimal salariometa = null;
        BigDecimal valorhora = null;
        if(!jFTFQtdeSalarioMin.getText().isEmpty()){
            qtdesalariometa = Utilidade.converter(jFTFQtdeSalarioMin.getText());   
        }
        if(!jFTFSalarioMeta.getText().isEmpty()){
            salariometa = Utilidade.converter(jFTFSalarioMeta.getText());   
        }  
        if(!jFTFValorHora.getText().isEmpty()){
            valorhora = Utilidade.converter(jFTFValorHora.getText());
        }
        if(jFTFQtdeSalarioMin.getText().isEmpty() && !jFTFSalarioMeta.getText().isEmpty() && jFTFValorHora.getText().isEmpty()){
            jFTFQtdeSalarioMin.setText(Utilidade.formatoValor.format(fc.salarioMeta(salariometa, qtdesalariometa, salariomin)));
            jFTFValorHora.setText(Utilidade.formatoValor.format(fc.valorHoraMeta(salariometa, hora, valorhora)));
        }
        if(!jFTFQtdeSalarioMin.getText().isEmpty() && jFTFSalarioMeta.getText().isEmpty() && jFTFValorHora.getText().isEmpty()){
            jFTFSalarioMeta.setText(Utilidade.formatoValor.format(fc.salarioMeta(salariometa, qtdesalariometa, salariomin)));
            salariometa = Utilidade.converter(jFTFSalarioMeta.getText());
            jFTFValorHora.setText(Utilidade.formatoValor.format(fc.valorHoraMeta(salariometa, hora, valorhora)));
        }
        if(jFTFQtdeSalarioMin.getText().isEmpty() && jFTFSalarioMeta.getText().isEmpty() && !jFTFValorHora.getText().isEmpty()){ 
            salariometa = fc.valorHoraMeta(salariometa, hora, valorhora);
            jFTFSalarioMeta.setText(Utilidade.formatoValor.format(salariometa));
            jFTFQtdeSalarioMin.setText(Utilidade.formatoValor.format(fc.salarioMeta(salariometa, qtdesalariometa, salariomin)));            
        }
    }
    
    private void tabelaValores(){
        valoresu.tabelaCurso(jTValores);
    }
    
    private boolean validaCampos(){
        if(jTFHoraTrabalhoMes.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.");
            jTFHoraTrabalhoMes.requestFocus();
            return false;
        }
        return true;
    }
    
    private void salvar(){
        if(valores == null){
            valores = new Valores();
            valores.setNm_salario(Utilidade.converter(jFTFQtdeSalarioMin.getText()));
            valores.setVl_salario(Utilidade.converter(jFTFSalarioMeta.getText()));
            valores.setVl_hora(Utilidade.converter(jFTFValorHora.getText()));
            valores.setCd_usuario(JPLogin.codloginuser);
            valoresr.inserir(valores);
            valores = null;
        }else{
            valores.setNm_salario(Utilidade.converter(jFTFQtdeSalarioMin.getText()));
            valores.setVl_salario(Utilidade.converter(jFTFSalarioMeta.getText()));
            valores.setVl_hora(Utilidade.converter(jFTFValorHora.getText()));
            valoresr.alterar(valores);
            valores = null;
        }
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifvalores = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jBCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCalcularActionPerformed
        hora = Utilidade.converter(jTFHoraTrabalhoMes.getText());
        valorHoraDespesa();
        calculoValores();
        salarioMeta();
    }//GEN-LAST:event_jBCalcularActionPerformed

    private void jFTFSalarioMetaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFSalarioMetaFocusGained
        jFTFSalarioMeta.setValue(null);
        jFTFQtdeSalarioMin.setValue(null);
        jFTFValorHora.setValue(null);
        util.posicionaCursojFTFValor(jFTFSalarioMeta);
    }//GEN-LAST:event_jFTFSalarioMetaFocusGained

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(validaCampos()){            
            salvar();
            tabelaValores();
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jFTFQtdeSalarioMinFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFQtdeSalarioMinFocusGained
        jFTFQtdeSalarioMin.setValue(null);
        jFTFSalarioMeta.setValue(null);
        jFTFValorHora.setValue(null);
        util.posicionaCursojFTFValor(jFTFQtdeSalarioMin);
    }//GEN-LAST:event_jFTFQtdeSalarioMinFocusGained

    private void jFTFValorHoraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFValorHoraFocusGained
        jFTFValorHora.setValue(null);
        jFTFSalarioMeta.setValue(null);
        jFTFQtdeSalarioMin.setValue(null);
        util.posicionaCursojFTFValor(jFTFValorHora);
    }//GEN-LAST:event_jFTFValorHoraFocusGained

    private void jTValoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTValoresMouseClicked
        valores = (Valores)valoresu.getSelectObject(jTValores);
        jFTFQtdeSalarioMin.setText(Utilidade.formatoValor.format(valores.getNm_salario()));
        jFTFSalarioMeta.setText(Utilidade.formatoValor.format(valores.getVl_salario()));
        jFTFValorHora.setText(Utilidade.formatoValor.format(valores.getVl_hora()));
    }//GEN-LAST:event_jTValoresMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCalcular;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JFormattedTextField jFTFCustoMensalHora;
    private javax.swing.JFormattedTextField jFTFCustoOpercionalHora;
    private javax.swing.JFormattedTextField jFTFCustosMensais;
    private javax.swing.JFormattedTextField jFTFCustosOperacionais;
    private javax.swing.JFormattedTextField jFTFMaiorRecebido;
    private javax.swing.JFormattedTextField jFTFMaiorRecebidoHora;
    private javax.swing.JFormattedTextField jFTFMinimoAtual;
    private javax.swing.JFormattedTextField jFTFQtdeSalarioMin;
    private javax.swing.JFormattedTextField jFTFRecebidoAtual;
    private javax.swing.JFormattedTextField jFTFRecebidoAtualHora;
    private javax.swing.JFormattedTextField jFTFSalarioMeta;
    private javax.swing.JFormattedTextField jFTFSalarioMinHora;
    private javax.swing.JFormattedTextField jFTFTrabalhoMesHora;
    private javax.swing.JFormattedTextField jFTFValorHora;
    private javax.swing.JLabel jLCustoMensalHora;
    private javax.swing.JLabel jLCustoOperacionalHora;
    private javax.swing.JLabel jLCustosMensais;
    private javax.swing.JLabel jLCustosOperacionais;
    private javax.swing.JLabel jLHoraTrabalhoMes;
    private javax.swing.JLabel jLMaiorRecebido;
    private javax.swing.JLabel jLMairoRecebidoHora;
    private javax.swing.JLabel jLMinimoAtual;
    private javax.swing.JLabel jLQtdeSalMin;
    private javax.swing.JLabel jLQtdeSalMinMaiorRec;
    private javax.swing.JLabel jLQtdeSalarioMin;
    private javax.swing.JLabel jLRecebidoAtual;
    private javax.swing.JLabel jLRecebidoAtualHora;
    private javax.swing.JLabel jLSalarioMeta;
    private javax.swing.JLabel jLSalarioMinHora;
    private javax.swing.JLabel jLTrabalhoMesHora;
    private javax.swing.JLabel jLValorHora;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPCustos;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JPanel jPHora;
    private javax.swing.JPanel jPSalario;
    private javax.swing.JPanel jPValores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFHoraTrabalhoMes;
    private javax.swing.JTextField jTFQtdeSalMinAtual;
    private javax.swing.JTextField jTFQtdeSalMinMaiorRec;
    private javax.swing.JTable jTValores;
    // End of variables declaration//GEN-END:variables
}
