package br.com.rlmoura81.sistema.projetointerface;

import br.com.rlmoura81.sistema.principalinterface.JPLogin;
import br.com.rlmoura81.sistema.projeto.Etapa;
import br.com.rlmoura81.sistema.projeto.EtapaRepository;
import br.com.rlmoura81.sistema.projeto.EtapaUtil;
import br.com.rlmoura81.sistema.projeto.Modulo;
import br.com.rlmoura81.sistema.projeto.ModuloRepository;
import br.com.rlmoura81.sistema.projeto.ModuloUtil;
import br.com.rlmoura81.sistema.projeto.Projeto;
import br.com.rlmoura81.sistema.projeto.ProjetoRepository;
import br.com.rlmoura81.sistema.projeto.ProjetoUtil;
import br.com.rlmoura81.sistema.projeto.StatusEtapa;
import br.com.rlmoura81.sistema.projeto.StatusEtapaUtil;
import br.com.rlmoura81.sistema.projeto.TipoEtapa;
import br.com.rlmoura81.sistema.projeto.TipoEtapaUtil;
import br.com.rlmoura81.sistema.utilidade.Utilidade;
import java.beans.PropertyVetoException;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

public class JIFProjeto extends javax.swing.JInternalFrame {
    
    private static JIFProjeto jifprojeto;
    
    public static JIFProjeto getInstancia() throws PropertyVetoException{
        if(jifprojeto == null){
            jifprojeto = new JIFProjeto();
            jifprojeto.setTitle("Projeto");
            jifprojeto.setMaximum(true);
        }
        return jifprojeto;
    }
    
    private int jcbcomplexidade;
        
    Projeto projeto = null;
    ProjetoRepository projetor = new ProjetoRepository();
    ProjetoUtil projetou = new ProjetoUtil();
    
    Modulo modulo = null;
    ModuloRepository modulor = new ModuloRepository();
    ModuloUtil modulou = new ModuloUtil();
    
    Etapa etapa = null;
    EtapaRepository etapar = new EtapaRepository();
    EtapaUtil etapau = new EtapaUtil();
    
    TipoEtapa tpetapa = null;
    TipoEtapaUtil tpetapau = new TipoEtapaUtil();
    
    StatusEtapa stetapa = null;
    StatusEtapaUtil stetapau = new StatusEtapaUtil();
            
    public JIFProjeto() {
        initComponents();
        
        jBNovo.setEnabled(false);
        tabelaProjeto();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCampos = new javax.swing.JPanel();
        jLProjeto = new javax.swing.JLabel();
        jTFProjeto = new javax.swing.JTextField();
        jBNovo = new javax.swing.JButton();
        jLProjetoSelecionado = new javax.swing.JLabel();
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
        jCBComplexidade = new javax.swing.JComboBox<>();
        jLHorasComplexidade = new javax.swing.JLabel();
        jTFHorasComplexidade = new javax.swing.JTextField();
        jPModuloGrid = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTModulo = new javax.swing.JTable();
        jPEtapa = new javax.swing.JPanel();
        jPEstapaCampos = new javax.swing.JPanel();
        jLTipoEtapa = new javax.swing.JLabel();
        jCBTipoEtapa = new javax.swing.JComboBox<>();
        jLStatusEtapa = new javax.swing.JLabel();
        jCBStatusEtapa = new javax.swing.JComboBox<>();
        jLTituloEtapa = new javax.swing.JLabel();
        jTFTituloEtapa = new javax.swing.JTextField();
        jDescricaoEtapa = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTADescricaoEtapa = new javax.swing.JTextArea();
        jPGrid = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTEtapa = new javax.swing.JTable();

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

        jLProjetoSelecionado.setText("Projeto:");

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
                .addGap(18, 18, 18)
                .addComponent(jLProjetoSelecionado)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPCamposLayout.setVerticalGroup(
            jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLProjeto)
                    .addComponent(jTFProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBNovo)
                    .addComponent(jLProjetoSelecionado))
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

        jPProjeto.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPProjetoComponentShown(evt);
            }
        });

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPProjetoLayout.setVerticalGroup(
            jPProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPProjetoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPProjeto.addTab("Projetos", jPProjeto);

        jPModulo.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPModuloComponentShown(evt);
            }
        });

        jLModulo.setText("Módulo:");

        jLDescricaoModulo.setText("Descrição:");

        jLHorasModulo.setText("Horas:");

        jTFHora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTFHoraFocusLost(evt);
            }
        });

        jCBComplexidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baixa", "Media", "Alta" }));
        jCBComplexidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBComplexidadeActionPerformed(evt);
            }
        });

        jLHorasComplexidade.setText("Horas Complexidade:");

        jTFHorasComplexidade.setEditable(false);

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
                        .addComponent(jTFHora, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBComplexidade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLHorasComplexidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFHorasComplexidade, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
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
                    .addComponent(jTFHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBComplexidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLHorasComplexidade)
                    .addComponent(jTFHorasComplexidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
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

        jPEtapa.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPEtapaComponentShown(evt);
            }
        });

        jPEstapaCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLTipoEtapa.setText("Tipo:");

        jCBTipoEtapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTipoEtapaActionPerformed(evt);
            }
        });

        jLStatusEtapa.setText("Status:");

        jCBStatusEtapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBStatusEtapaActionPerformed(evt);
            }
        });

        jLTituloEtapa.setText("Titulo:");

        jDescricaoEtapa.setText("Descricao:");

        jTADescricaoEtapa.setColumns(20);
        jTADescricaoEtapa.setRows(5);
        jScrollPane3.setViewportView(jTADescricaoEtapa);

        javax.swing.GroupLayout jPEstapaCamposLayout = new javax.swing.GroupLayout(jPEstapaCampos);
        jPEstapaCampos.setLayout(jPEstapaCamposLayout);
        jPEstapaCamposLayout.setHorizontalGroup(
            jPEstapaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEstapaCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPEstapaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPEstapaCamposLayout.createSequentialGroup()
                        .addGroup(jPEstapaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPEstapaCamposLayout.createSequentialGroup()
                                .addComponent(jLTipoEtapa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCBTipoEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLStatusEtapa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCBStatusEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPEstapaCamposLayout.createSequentialGroup()
                                .addComponent(jLTituloEtapa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFTituloEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jDescricaoEtapa))
                        .addGap(0, 439, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPEstapaCamposLayout.setVerticalGroup(
            jPEstapaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEstapaCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPEstapaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPEstapaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCBTipoEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLStatusEtapa)
                        .addComponent(jCBStatusEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLTipoEtapa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPEstapaCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTituloEtapa)
                    .addComponent(jTFTituloEtapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDescricaoEtapa)
                .addGap(8, 8, 8)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPGrid.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTEtapa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTEtapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTEtapaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTEtapa);

        javax.swing.GroupLayout jPGridLayout = new javax.swing.GroupLayout(jPGrid);
        jPGrid.setLayout(jPGridLayout);
        jPGridLayout.setHorizontalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPGridLayout.setVerticalGroup(
            jPGridLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPGridLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPEtapaLayout = new javax.swing.GroupLayout(jPEtapa);
        jPEtapa.setLayout(jPEtapaLayout);
        jPEtapaLayout.setHorizontalGroup(
            jPEtapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEtapaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPEtapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPEstapaCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPEtapaLayout.setVerticalGroup(
            jPEtapaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPEtapaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPEstapaCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPGrid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPProjeto.addTab("Etapas", jPEtapa);

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
    
    private void limpaCampoProjeto(){
        jLProjetoSelecionado.setText("Projeto:");
        jTFProjeto.setText(null);
        jTPProjeto.setEnabledAt(1, false);
    }
    
    private void limpaCampoModulo(){
        jTFModulo.setText(null);
        jTFDescricaoModulo.setText(null);
        jTFHora.setText(null);
        jCBComplexidade.setSelectedIndex(0);
        jTFHorasComplexidade.setText(null);
    }
    
    private void limpaCampoEtapa(){
        tpetapau.jcTipoEtapa(jCBTipoEtapa);
        stetapau.jcStatusEtapa(jCBStatusEtapa);
        jTFTituloEtapa.setText(null);
        jTADescricaoEtapa.setText(null);
    }
    
    private void tabelaProjeto(){
        projetou.tabelaProjeto(jTProjeto);
    }
    
    private void tabelaModulo(){
        modulou.tabelaModulo(jTModulo, projeto.getCd_projeto());
    }
    
    private void tabelaEtapa(){
        etapau.tabelaEtapa(jTEtapa, modulo.getCd_modulo());
    }
    
    private void jcTipoEtapa(){
        tpetapau.jcTipoEtapa(jCBTipoEtapa);
    }
    
    private void jcStatusEtapa(){
        stetapau.jcStatusEtapa(jCBStatusEtapa);
    }
    
    private BigDecimal horaComplexidade(BigDecimal hora){
        BigDecimal porcentagem;
        BigDecimal resultado = null;
        if(jcbcomplexidade == 0){
            resultado = hora;
        }
        if(jcbcomplexidade == 1){
            porcentagem = Utilidade.converter("0,25");
            resultado = (hora.multiply(porcentagem)).add(hora);
        }
        if(jcbcomplexidade == 2){
            porcentagem = Utilidade.converter("0,50");
            resultado = (hora.multiply(porcentagem)).add(hora);
        }
        return resultado;
    } 
    
    private void executaHoraComplexidade(){
        jTFHorasComplexidade.setText(Utilidade.formatoValor.format(horaComplexidade(Utilidade.converter(jTFHora.getText()))));
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
    
    private boolean validaCampoEtapa(){
        if(tpetapa == null){
            JOptionPane.showMessageDialog(null, "Selecione o Tipo.");
            jCBTipoEtapa.requestFocus();
            return false;
        }
        if(stetapa == null){
            JOptionPane.showMessageDialog(null, "Selecione o Status.");
            jCBStatusEtapa.requestFocus();
            return false;
        }
        if(jTFTituloEtapa.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.");
            jTFTituloEtapa.requestFocus();
            return false;
        }
        if(jTADescricaoEtapa.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campo em branco.");
            jTADescricaoEtapa.requestFocus();
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
            modulo.setNm_hora(Utilidade.converter(jTFHora.getText()));
            modulo.setNm_complexidade(jCBComplexidade.getSelectedIndex());
            modulo.setNm_horacomplexidade(Utilidade.converter(jTFHorasComplexidade.getText()));
            modulo.setProjeto(projeto);
            modulo.setCd_usuario(JPLogin.codloginuser);
            modulor.inserir(modulo);
            modulo = null;
        }else{
            modulo.setDs_modulo(jTFModulo.getText());
            modulo.setDs_descricao(jTFDescricaoModulo.getText());   
            modulo.setNm_hora(Utilidade.converter(jTFHora.getText()));
            modulo.setNm_complexidade(jCBComplexidade.getSelectedIndex());
            modulo.setNm_horacomplexidade(Utilidade.converter(jTFHorasComplexidade.getText()));
            modulo.setCd_usuario(JPLogin.codloginuser);
            modulor.alterar(modulo);
            modulo = null;
        }    
    }
    
    private void etapaSalvar(){
        if(etapa == null){
            etapa = new Etapa();
            etapa.setTipoetapa(tpetapa);
            etapa.setStatusetapa(stetapa);
            etapa.setDs_etapa(jTFTituloEtapa.getText());
            etapa.setDs_descricao(jTADescricaoEtapa.getText());
            etapa.setModulo(modulo);
            etapa.setCd_usuario(JPLogin.codloginuser);
            etapar.inserir(etapa);
            etapa = null;
        }else{
            etapa.setTipoetapa(tpetapa);
            etapa.setStatusetapa(stetapa);
            etapa.setDs_etapa(jTFTituloEtapa.getText());
            etapa.setDs_descricao(jTADescricaoEtapa.getText());
            etapa.setCd_usuario(JPLogin.codloginuser);
            etapar.alterar(etapa);
            etapa = null;
        }
    }
        
    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        if(jTPProjeto.getSelectedIndex() == 0){
            if(validaCampoProjeto()){
                projetoSalvar();
                limpaCampoProjeto();
                tabelaProjeto();               
            }        
        }
        if(jTPProjeto.getSelectedIndex() == 1){
            if(validaCampoModulo()){
                moduloSalvar(); 
                limpaCampoModulo();
                tabelaModulo();
            }
        }
        if(jTPProjeto.getSelectedIndex() == 2){
            if(validaCampoEtapa()){
                etapaSalvar();
                limpaCampoEtapa();
                tabelaEtapa();
            }
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed
        jifprojeto = null;
    }//GEN-LAST:event_formInternalFrameClosed

    private void jTProjetoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProjetoMouseClicked
        projeto = (Projeto)projetou.getSelectObject(jTProjeto);
        jTFProjeto.setText(projeto.getDs_projeto());
        jLProjetoSelecionado.setText("Projeto: " + projeto.getDs_projeto());
        tabelaModulo();
        jTPProjeto.setEnabledAt(1, true);
        jBNovo.setEnabled(true);
    }//GEN-LAST:event_jTProjetoMouseClicked

    private void jTModuloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTModuloMouseClicked
        modulo = (Modulo)modulou.getSelectObject(jTModulo);
        jTFModulo.setText(modulo.getDs_modulo());
        jTFDescricaoModulo.setText(modulo.getDs_descricao());
        jTFHora.setText(Utilidade.formatoValor.format(modulo.getNm_hora()));
        jCBComplexidade.setSelectedIndex(modulo.getNm_complexidade());
        jTFHorasComplexidade.setText(Utilidade.formatoValor.format(modulo.getNm_horacomplexidade()));
        jLProjetoSelecionado.setText("Projeto: " + projeto.getDs_projeto() + " Modulo: " + modulo.getDs_descricao());
        tabelaEtapa();
        jTPProjeto.setEnabledAt(2, true);
        jcTipoEtapa();
        jcStatusEtapa();
    }//GEN-LAST:event_jTModuloMouseClicked

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        if(jTPProjeto.getSelectedIndex() == 0){
            if((Projeto)projetou.getSelectObject(jTProjeto) != null){
                projetor.excluirProjetoModulos(projeto);
                projetor.excluir(projeto);
                limpaCampoProjeto();
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
        
        if(jTPProjeto.getSelectedIndex() == 2){
            if((Etapa)etapau.getSelectObject(jTEtapa) != null){
                etapar.excluir(etapa);
                limpaCampoEtapa();
                etapau.tabelaEtapa(jTEtapa, etapa.getModulo().getCd_modulo());
            }
        }
        jBNovo.setEnabled(false);
    }//GEN-LAST:event_jBExcluirActionPerformed

    private void jBNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoActionPerformed
        limpaCampoProjeto();
        limpaCampoModulo();
        jBNovo.setEnabled(false);
    }//GEN-LAST:event_jBNovoActionPerformed

    private void jCBTipoEtapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipoEtapaActionPerformed
        if(jCBTipoEtapa.getSelectedIndex() != 0){
            tpetapa = new TipoEtapa();
            tpetapa = (TipoEtapa)jCBTipoEtapa.getSelectedItem();    
        }else{
            tpetapa = null;
        }
        
    }//GEN-LAST:event_jCBTipoEtapaActionPerformed

    private void jCBStatusEtapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBStatusEtapaActionPerformed
        if(jCBStatusEtapa.getSelectedIndex() != 0){
            stetapa = new StatusEtapa();
            stetapa = (StatusEtapa)jCBStatusEtapa.getSelectedItem();    
        }else{
            stetapa = null;
        }
    }//GEN-LAST:event_jCBStatusEtapaActionPerformed

    private void jTEtapaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTEtapaMouseClicked
        etapa = (Etapa)etapau.getSelectObject(jTEtapa);
        etapa.setModulo(modulo);
        jCBTipoEtapa.getModel().setSelectedItem(etapa.getTipoetapa());
        jCBStatusEtapa.getModel().setSelectedItem(etapa.getStatusetapa());
        jTFTituloEtapa.setText(etapa.getDs_etapa());
        jTADescricaoEtapa.setText(etapa.getDs_descricao());
        jLProjetoSelecionado.setText("Projeto: " + projeto.getDs_projeto() + " Modulo: " + modulo.getDs_descricao() + " Etapa: " + etapa.getDs_etapa());
    }//GEN-LAST:event_jTEtapaMouseClicked

    private void jCBComplexidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBComplexidadeActionPerformed
        jcbcomplexidade = jCBComplexidade.getSelectedIndex();
        if(!jTFHora.getText().isEmpty()){            
            executaHoraComplexidade();   
        }
    }//GEN-LAST:event_jCBComplexidadeActionPerformed

    private void jTFHoraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTFHoraFocusLost
        if(!jTFHora.getText().isEmpty()){
            executaHoraComplexidade();   
        }
    }//GEN-LAST:event_jTFHoraFocusLost

    private void jPProjetoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPProjetoComponentShown
        System.out.println("--Projeto");
        jTPProjeto.setEnabledAt(1, false);
        jTPProjeto.setEnabledAt(2, false);
        if(jTPProjeto.isEnabledAt(1)== false && jTPProjeto.isEnabledAt(2) == false){
            limpaCampoModulo();
            System.out.println("Modulo e etapa false");
        }
    }//GEN-LAST:event_jPProjetoComponentShown

    private void jPModuloComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPModuloComponentShown
        System.out.println("--Modulo");
        jTPProjeto.setEnabledAt(2, false);
        if(jTPProjeto.isEnabledAt(0)== true && jTPProjeto.isEnabledAt(2) == false){
            limpaCampoEtapa();
            System.out.println("Projeto true e etapa false");
        }
    }//GEN-LAST:event_jPModuloComponentShown

    private void jPEtapaComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPEtapaComponentShown
        System.out.println("--Etapa");
        if(jTPProjeto.isEnabledAt(0)== true && jTPProjeto.isEnabledAt(1) == true){
            System.out.println("Projeto true, modulo true e etapa true");
        }        
    }//GEN-LAST:event_jPEtapaComponentShown

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExcluir;
    private javax.swing.JButton jBNovo;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<String> jCBComplexidade;
    private javax.swing.JComboBox<StatusEtapa> jCBStatusEtapa;
    private javax.swing.JComboBox<TipoEtapa> jCBTipoEtapa;
    private javax.swing.JLabel jDescricaoEtapa;
    private javax.swing.JLabel jLDescricaoModulo;
    private javax.swing.JLabel jLHorasComplexidade;
    private javax.swing.JLabel jLHorasModulo;
    private javax.swing.JLabel jLModulo;
    private javax.swing.JLabel jLProjeto;
    private javax.swing.JLabel jLProjetoSelecionado;
    private javax.swing.JLabel jLStatusEtapa;
    private javax.swing.JLabel jLTipoEtapa;
    private javax.swing.JLabel jLTituloEtapa;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPCampos;
    private javax.swing.JPanel jPEstapaCampos;
    private javax.swing.JPanel jPEtapa;
    private javax.swing.JPanel jPGrid;
    private javax.swing.JPanel jPModulo;
    private javax.swing.JPanel jPModuloCampos;
    private javax.swing.JPanel jPModuloGrid;
    private javax.swing.JPanel jPProjeto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTADescricaoEtapa;
    private javax.swing.JTable jTEtapa;
    private javax.swing.JTextField jTFDescricaoModulo;
    private javax.swing.JTextField jTFHora;
    private javax.swing.JTextField jTFHorasComplexidade;
    private javax.swing.JTextField jTFModulo;
    private javax.swing.JTextField jTFProjeto;
    private javax.swing.JTextField jTFTituloEtapa;
    private javax.swing.JTable jTModulo;
    private javax.swing.JTabbedPane jTPProjeto;
    private javax.swing.JTable jTProjeto;
    // End of variables declaration//GEN-END:variables
}
