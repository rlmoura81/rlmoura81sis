package br.com.rlmoura81.financeirointerface;

import br.com.rlmoura81.financeiro.FinanceiroCalculo;
import br.com.rlmoura81.financeiro.ValoresRepository;
import br.com.rlmoura81.sistema.geral.DespesaRepository;
import br.com.rlmoura81.sistema.geral.SalarioRepository;
import br.com.rlmoura81.sistema.projeto.Modulo;
import br.com.rlmoura81.sistema.projeto.ModuloUtil;
import br.com.rlmoura81.sistema.utilidade.Utilidade;
import java.beans.PropertyVetoException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JOptionPane;

public class JIFValoresProjeto extends javax.swing.JInternalFrame {
    
    private static JIFValoresProjeto jifvaloresprojeto;
    
    public static JIFValoresProjeto getInstancia() throws PropertyVetoException{
        if (jifvaloresprojeto == null){
            jifvaloresprojeto = new JIFValoresProjeto();
            jifvaloresprojeto.setTitle("Valores Projetos");
            jifvaloresprojeto.setMaximum(true);
        } return jifvaloresprojeto;
    }
    
    private BigDecimal valorhora;
    private BigDecimal custodespesa;
    private BigDecimal custohora;
    private BigDecimal custohoracomplexidade;
    private BigDecimal custototal;
    private BigDecimal salariomin;
    private BigDecimal salariometa;
    private BigDecimal valormensalidade;
    private BigDecimal valormensalidadeporcent;
    private BigDecimal custohoramensalidade;
    private BigDecimal custototalmensalidade;
    private BigDecimal qtdesalariominmo;
    private BigDecimal qtdesalariometa;
    
    ValoresRepository valoresr = new ValoresRepository();
    
    Modulo modulo = null;
    ModuloUtil modelou = new ModuloUtil();
    
    DespesaRepository despesar = new DespesaRepository();
    SalarioRepository salarior = new SalarioRepository();
    
    FinanceiroCalculo fc = new FinanceiroCalculo();
    Utilidade util = new Utilidade();

    public JIFValoresProjeto() {
        initComponents();
        
        salario();
        formataValorCampo();
        valorTotalDespesa();
        valorHoraMeta();
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
        jLHoraTotal = new javax.swing.JLabel();
        jTFHoraTotal = new javax.swing.JTextField();
        jPValores = new javax.swing.JPanel();
        jLCustoMensal = new javax.swing.JLabel();
        jFTFCustoMensal = new javax.swing.JFormattedTextField();
        jLCustoHora = new javax.swing.JLabel();
        jFTFCustoHora = new javax.swing.JFormattedTextField();
        jLCustoTotal = new javax.swing.JLabel();
        jFTFTotalValores = new javax.swing.JFormattedTextField();
        jLValorHora = new javax.swing.JLabel();
        jFTFValorHora = new javax.swing.JFormattedTextField();
        jLMensalidade = new javax.swing.JLabel();
        jFTFMensalidadeValor = new javax.swing.JFormattedTextField();
        jFTFMensalidadePorcent = new javax.swing.JFormattedTextField();
        jLCustoHoraMensalidade = new javax.swing.JLabel();
        jFTFCustoHoraMensalidade = new javax.swing.JFormattedTextField();
        jLCustoTotalMensalidade = new javax.swing.JLabel();
        jFTFCustoTotalMensalidade = new javax.swing.JFormattedTextField();
        jLQtdeSalarioMin = new javax.swing.JLabel();
        jFTFQtdeSalarioMin = new javax.swing.JFormattedTextField();
        jLQtdeSalarioMeta = new javax.swing.JLabel();
        jFTFQtdeSalarioMeta = new javax.swing.JFormattedTextField();
        jLQtdeSalarioTotal = new javax.swing.JLabel();
        jFTFQtdeSalarioTotal = new javax.swing.JFormattedTextField();
        jPValoresProjetos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProjeto = new javax.swing.JTable();
        jPCampos = new javax.swing.JPanel();
        jLMensalidadeValorCalc = new javax.swing.JLabel();
        jFTFMensalidadeValorCalc = new javax.swing.JFormattedTextField();
        jFTFMensalidadePorcentCalc = new javax.swing.JFormattedTextField();
        jPBotoes = new javax.swing.JPanel();
        jBCalcular = new javax.swing.JButton();
        jBSalvar = new javax.swing.JButton();

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

        jLHoraTotal.setText("Hora Total:");

        jTFHoraTotal.setEditable(false);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLHoraTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFHoraTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jTFModulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLHoraTotal)
                    .addComponent(jTFHoraTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPValores.setBorder(javax.swing.BorderFactory.createTitledBorder("Valores"));

        jLCustoMensal.setText("Custo Mensal:");

        jFTFCustoMensal.setEditable(false);

        jLCustoHora.setText("Custo Hora:");

        jFTFCustoHora.setEditable(false);

        jLCustoTotal.setText("Custo Total:");

        jFTFTotalValores.setEditable(false);

        jLValorHora.setText("Valor Hora:");

        jFTFValorHora.setEditable(false);

        jLMensalidade.setText("Mensalidade:");

        jFTFMensalidadeValor.setEditable(false);

        jFTFMensalidadePorcent.setEditable(false);

        jLCustoHoraMensalidade.setText("Custo Hora Mensalidade:");

        jFTFCustoHoraMensalidade.setEditable(false);

        jLCustoTotalMensalidade.setText("Custo Total Mensalidade:");

        jFTFCustoTotalMensalidade.setEditable(false);

        jLQtdeSalarioMin.setText("Qtde Salario Min:");

        jFTFQtdeSalarioMin.setEditable(false);
        jFTFQtdeSalarioMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFTFQtdeSalarioMinActionPerformed(evt);
            }
        });

        jLQtdeSalarioMeta.setText("Qtde Salario Meta:");

        jFTFQtdeSalarioMeta.setEditable(false);

        jLQtdeSalarioTotal.setText("Qtde Salario Total:");

        jFTFQtdeSalarioTotal.setEditable(false);

        javax.swing.GroupLayout jPValoresLayout = new javax.swing.GroupLayout(jPValores);
        jPValores.setLayout(jPValoresLayout);
        jPValoresLayout.setHorizontalGroup(
            jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPValoresLayout.createSequentialGroup()
                        .addGroup(jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPValoresLayout.createSequentialGroup()
                                .addComponent(jLCustoMensal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFTFCustoMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLValorHora)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFTFValorHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPValoresLayout.createSequentialGroup()
                                .addComponent(jLCustoTotal)
                                .addGap(51, 51, 51)
                                .addComponent(jFTFTotalValores, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPValoresLayout.createSequentialGroup()
                                .addComponent(jLMensalidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFTFMensalidadeValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFTFMensalidadePorcent, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPValoresLayout.createSequentialGroup()
                                .addComponent(jLCustoTotalMensalidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFTFCustoTotalMensalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPValoresLayout.createSequentialGroup()
                                .addComponent(jLQtdeSalarioTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFTFQtdeSalarioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPValoresLayout.createSequentialGroup()
                                .addComponent(jLQtdeSalarioMeta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFTFQtdeSalarioMeta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPValoresLayout.createSequentialGroup()
                                .addComponent(jLQtdeSalarioMin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFTFQtdeSalarioMin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPValoresLayout.createSequentialGroup()
                        .addComponent(jLCustoHora)
                        .addGap(18, 18, 18)
                        .addComponent(jFTFCustoHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(201, 201, 201)
                        .addComponent(jLCustoHoraMensalidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFTFCustoHoraMensalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPValoresLayout.setVerticalGroup(
            jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCustoMensal)
                    .addComponent(jFTFCustoMensal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLValorHora)
                    .addComponent(jFTFValorHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLMensalidade)
                    .addComponent(jFTFMensalidadeValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFMensalidadePorcent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLQtdeSalarioMin)
                    .addComponent(jFTFQtdeSalarioMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCustoHora)
                    .addComponent(jFTFCustoHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCustoHoraMensalidade)
                    .addComponent(jFTFCustoHoraMensalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLQtdeSalarioMeta)
                    .addComponent(jFTFQtdeSalarioMeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCustoTotal)
                    .addComponent(jFTFTotalValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLCustoTotalMensalidade)
                    .addComponent(jFTFCustoTotalMensalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLQtdeSalarioTotal)
                    .addComponent(jFTFQtdeSalarioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLMensalidadeValorCalc.setText("Mensalidade:");

        jFTFMensalidadeValorCalc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFMensalidadeValorCalcFocusGained(evt);
            }
        });

        jFTFMensalidadePorcentCalc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jFTFMensalidadePorcentCalcFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPCamposLayout = new javax.swing.GroupLayout(jPCampos);
        jPCampos.setLayout(jPCamposLayout);
        jPCamposLayout.setHorizontalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLMensalidadeValorCalc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFMensalidadeValorCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFTFMensalidadePorcentCalc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLMensalidadeValorCalc)
                    .addComponent(jFTFMensalidadeValorCalc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFTFMensalidadePorcentCalc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBCalcular.setText("Calcular");
        jBCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCalcularActionPerformed(evt);
            }
        });

        jBSalvar.setText("Salvar");

        javax.swing.GroupLayout jPBotoesLayout = new javax.swing.GroupLayout(jPBotoes);
        jPBotoes.setLayout(jPBotoesLayout);
        jPBotoesLayout.setHorizontalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBCalcular)
                .addGap(18, 18, 18)
                .addComponent(jBSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPBotoesLayout.setVerticalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBCalcular)
                    .addComponent(jBSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPValoresProjetos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPBotoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPProjeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPValores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPCampos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPValoresProjetos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    private void formataValorCampo(){
        jFTFCustoMensal.setFormatterFactory(Utilidade.formataValorCampo(jFTFCustoMensal));
        jFTFCustoHora.setFormatterFactory(Utilidade.formataValorCampo(jFTFCustoHora));
        jFTFTotalValores.setFormatterFactory(Utilidade.formataValorCampo(jFTFTotalValores));
        jFTFMensalidadeValorCalc.setFormatterFactory(Utilidade.formataValorCampo(jFTFMensalidadeValorCalc));
        jFTFMensalidadePorcentCalc.setFormatterFactory(Utilidade.formataValorCampo(jFTFMensalidadePorcentCalc));
        jFTFQtdeSalarioMin.setFormatterFactory(Utilidade.formataValorCampo(jFTFQtdeSalarioMin));
        jFTFQtdeSalarioMeta.setFormatterFactory(Utilidade.formataValorCampo(jFTFQtdeSalarioMeta));
        jFTFQtdeSalarioTotal.setFormatterFactory(Utilidade.formataValorCampo(jFTFQtdeSalarioTotal));
    }
    
    private void tabelaProjetosValores(){
        modelou.tabelaModulo(jTProjeto);
    }
    
    private void valorTotalDespesa(){
        custodespesa = despesar.valorTotalDespesa();
        jFTFCustoMensal.setText(Utilidade.formatoValor.format(custodespesa));
    }
    
    private void valorHoraMeta(){
        valorhora = valoresr.valorHoraMeta();
        jFTFValorHora.setText(Utilidade.formatoValor.format(valorhora));
    }
    
    private void salario(){
        salariomin = salarior.valorSalarioMinimoAtual();
        salariometa = valoresr.valorSalarioMeta();
    }
    
    private void custoTotal(){
        custototal = fc.custoTotal(custodespesa, custohora);
        jFTFTotalValores.setText(Utilidade.formatoValor.format(custototal));
    }
    
    private boolean validarCampos(){
        if(modulo == null){
            JOptionPane.showMessageDialog(null, "Selecione o projeto.");
            return false;
        }
        return true;
    }
    
    private void calcularMensalidade(){   
        valormensalidade = null;
        valormensalidadeporcent = null;
        if(!jFTFMensalidadeValorCalc.getText().isEmpty()){        
            valormensalidade = Utilidade.converter(jFTFMensalidadeValorCalc.getText());    
        }
        if(!jFTFMensalidadePorcentCalc.getText().isEmpty()){
            valormensalidadeporcent = Utilidade.converter(jFTFMensalidadePorcentCalc.getText());
        }
        if(!jFTFMensalidadeValorCalc.getText().isEmpty() && jFTFMensalidadePorcentCalc.getText().isEmpty()){
            valormensalidadeporcent = fc.calculoMensalidade(salariomin, valormensalidade, valormensalidadeporcent);
            jFTFMensalidadePorcentCalc.setText(Utilidade.formatoValor.format(valormensalidadeporcent));
            jFTFMensalidadePorcent.setText(Utilidade.formatoValor.format(valormensalidadeporcent));
            jFTFMensalidadeValor.setText(Utilidade.formatoValor.format(valormensalidade));
        }
        if(jFTFMensalidadeValorCalc.getText().isEmpty() && !jFTFMensalidadePorcentCalc.getText().isEmpty()){
            valormensalidade = fc.calculoMensalidade(salariomin, valormensalidade, valormensalidadeporcent);
            jFTFMensalidadeValorCalc.setText(Utilidade.formatoValor.format(valormensalidade));
            jFTFMensalidadeValor.setText(Utilidade.formatoValor.format(valormensalidade));
            jFTFMensalidadePorcent.setText(Utilidade.formatoValor.format(valormensalidadeporcent));
        }
    }

    private void calcularCustoHoraMensalidade(){
        valormensalidade = Utilidade.converter(jFTFMensalidadeValor.getText());
        custohoramensalidade = fc.custoTotalMensalidade(custohora, valormensalidade);
        jFTFCustoHoraMensalidade.setText(Utilidade.formatoValor.format(custohoramensalidade));
    }
    
    private void calcularCustoTotalMensalidade(){
        valormensalidade = Utilidade.converter(jFTFMensalidadeValor.getText());
        custototalmensalidade = fc.custoTotalMensalidade(custototal, valormensalidade);
        jFTFCustoTotalMensalidade.setText(Utilidade.formatoValor.format(custototalmensalidade));
    }
    
    private void calcularQtdeSalario(){
        qtdesalariominmo = fc.qtdeSalario(salariomin, valormensalidade);
        jFTFQtdeSalarioMin.setText(Utilidade.formatoValor.format(qtdesalariominmo));
        qtdesalariometa = fc.qtdeSalario(salariometa, valormensalidade);
        jFTFQtdeSalarioMeta.setText(Utilidade.formatoValor.format(qtdesalariometa));
        jFTFQtdeSalarioTotal.setText(Utilidade.formatoValor.format(qtdesalariometa.add(custodespesa.divide(valormensalidade, 2, RoundingMode.HALF_UP))));
    }
    
    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifvaloresprojeto = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jTProjetoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProjetoMouseClicked
        modulo = (Modulo)modelou.getSelectObject(jTProjeto);
        jTFProjeto.setText(modulo.getProjeto().getDs_projeto());
        jTFModulos.setText(Integer.toString(modulo.getCd_modulo()));
        jTFHora.setText(Utilidade.formatoValor.format(modulo.getNm_hora()));
        jTFHoraTotal.setText(Utilidade.formatoValor.format(modulo.getNm_horacomplexidade()));
        custohora = fc.custoHora(modulo.getNm_horacomplexidade(), valorhora);
        jFTFCustoHora.setText(Utilidade.formatoValor.format(custohora));
        custoTotal();
    }//GEN-LAST:event_jTProjetoMouseClicked

    private void jFTFMensalidadeValorCalcFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFMensalidadeValorCalcFocusGained
        jFTFMensalidadeValorCalc.setValue(null);
        jFTFMensalidadePorcentCalc.setValue(null);
        util.posicionaCursojFTFValor(jFTFMensalidadeValorCalc);
    }//GEN-LAST:event_jFTFMensalidadeValorCalcFocusGained

    private void jFTFMensalidadePorcentCalcFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFTFMensalidadePorcentCalcFocusGained
        jFTFMensalidadePorcentCalc.setValue(null);
        jFTFMensalidadeValorCalc.setValue(null);
        util.posicionaCursojFTFValor(jFTFMensalidadePorcentCalc);
    }//GEN-LAST:event_jFTFMensalidadePorcentCalcFocusGained

    private void jBCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCalcularActionPerformed
        if(validarCampos()){
            calcularMensalidade();  
            calcularCustoHoraMensalidade();
            calcularCustoTotalMensalidade(); 
            calcularQtdeSalario();
        }        
    }//GEN-LAST:event_jBCalcularActionPerformed

    private void jFTFQtdeSalarioMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFTFQtdeSalarioMinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTFQtdeSalarioMinActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCalcular;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JFormattedTextField jFTFCustoHora;
    private javax.swing.JFormattedTextField jFTFCustoHoraMensalidade;
    private javax.swing.JFormattedTextField jFTFCustoMensal;
    private javax.swing.JFormattedTextField jFTFCustoTotalMensalidade;
    private javax.swing.JFormattedTextField jFTFMensalidadePorcent;
    private javax.swing.JFormattedTextField jFTFMensalidadePorcentCalc;
    private javax.swing.JFormattedTextField jFTFMensalidadeValor;
    private javax.swing.JFormattedTextField jFTFMensalidadeValorCalc;
    private javax.swing.JFormattedTextField jFTFQtdeSalarioMeta;
    private javax.swing.JFormattedTextField jFTFQtdeSalarioMin;
    private javax.swing.JFormattedTextField jFTFQtdeSalarioTotal;
    private javax.swing.JFormattedTextField jFTFTotalValores;
    private javax.swing.JFormattedTextField jFTFValorHora;
    private javax.swing.JLabel jLCustoHora;
    private javax.swing.JLabel jLCustoHoraMensalidade;
    private javax.swing.JLabel jLCustoMensal;
    private javax.swing.JLabel jLCustoTotal;
    private javax.swing.JLabel jLCustoTotalMensalidade;
    private javax.swing.JLabel jLHora;
    private javax.swing.JLabel jLHoraTotal;
    private javax.swing.JLabel jLMensalidade;
    private javax.swing.JLabel jLMensalidadeValorCalc;
    private javax.swing.JLabel jLModulos;
    private javax.swing.JLabel jLProjeto;
    private javax.swing.JLabel jLQtdeSalarioMeta;
    private javax.swing.JLabel jLQtdeSalarioMin;
    private javax.swing.JLabel jLQtdeSalarioTotal;
    private javax.swing.JLabel jLValorHora;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPProjeto;
    private javax.swing.JPanel jPValores;
    private javax.swing.JPanel jPValoresProjetos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFHora;
    private javax.swing.JTextField jTFHoraTotal;
    private javax.swing.JTextField jTFModulos;
    private javax.swing.JTextField jTFProjeto;
    private javax.swing.JTable jTProjeto;
    // End of variables declaration//GEN-END:variables
}
