package br.com.rlmoura81.financeiro;

import br.com.rlmoura81.sistema.projeto.Projeto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ValoresProjetosUtil {
    
    ValoresProjetos valorprojeto = new ValoresProjetos();
    ValoresProjetosRepository valorprojetor = new ValoresProjetosRepository();
    
    ArrayList lista = new ArrayList();
    
    public void tabelaValorProjeto(JTable o){
        String[]nomeColuna = {"Projeto"};
        lista = valorprojetor.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i = 0; i < lista.size(); i++){
            valorprojeto = (ValoresProjetos)lista.get(i);
            dadosArray[i][0] = valorprojeto.getVl_mensalidade();
            dadosArray[i][0] = valorprojeto.getVl_mensalidadeporcent();
        }
        DefaultTableModel tProjeto = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tProjeto);
    }
    
    public void tabelaValorProjetoTotal(JTable o, int projeto){
        String[]nomeColuna = {"Projeto", "Modulos", "Mensalidade", " % ", "Total Hora"};
        lista = valorprojetor.getLista(projeto);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];        
        for(int i = 0; i < lista.size(); i++){
            valorprojeto = (ValoresProjetos)lista.get(i);
            dadosArray[i][0] = valorprojeto.getProjeto().getDs_projeto();
            dadosArray[i][1] = valorprojeto.getModulo().getCd_modulo();
            dadosArray[i][2] = valorprojeto.getVl_mensalidade();
            dadosArray[i][3] = valorprojeto.getVl_mensalidadeporcent();
            dadosArray[i][4] = valorprojeto.getModulo().getNm_horacomplexidade();
        }
        DefaultTableModel tProjeto = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tProjeto);
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaSelecionada = o.getSelectedRow();
        if(linhaSelecionada >= 0){
            selecionado = lista.get(linhaSelecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um projeto.", "Valores Projetos", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    }    
    
}
