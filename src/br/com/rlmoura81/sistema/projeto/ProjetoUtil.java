package br.com.rlmoura81.sistema.projeto;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProjetoUtil {
    
    Projeto projeto = new Projeto();
    ProjetoRepository projetor = new ProjetoRepository();
    
    ArrayList lista = new ArrayList();
    
    public void tabelaProjeto(JTable o){
        String[]nomeColuna = {"Projeto"};
        lista = projetor.getLista();
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i = 0; i < lista.size(); i++){
            projeto = (Projeto)lista.get(i);
            dadosArray[i][0] = projeto.getDs_projeto();
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
            JOptionPane.showMessageDialog(null, "Selecione um projeto.", "Projeto", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    }
}
