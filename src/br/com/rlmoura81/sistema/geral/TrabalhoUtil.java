package br.com.rlmoura81.sistema.geral;

import br.com.rlmoura81.sistema.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TrabalhoUtil {
    
    CadastroGeral cadgeral = new CadastroGeral();
    TrabalhoRepository trabalhor = new TrabalhoRepository();
    
    ArrayList lista = new ArrayList();
        
    public void tabelaTrabalho(JTable o){
        String []nomeColuna = {"Trabalho", "Data", "Hora", "Valor"};
        lista = trabalhor.getLista();
        Object[][]dadosArray = new Object[lista.size()][nomeColuna.length];
        for(int i=0; i < lista.size(); i++){
            cadgeral = (CadastroGeral)lista.get(i);
            dadosArray[i][0] = cadgeral.getDs_cadgeral();
            dadosArray[i][1] = Utilidade.formatoData.format(cadgeral.getDt_cadgeral().getTime());
            dadosArray[i][2] = cadgeral.getNm_hora();
            dadosArray[i][3] = Utilidade.formatoValor.format(cadgeral.getNm_valor());
        }
        DefaultTableModel tCurso = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tCurso);
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaSelecionada = o.getSelectedRow();
        if(linhaSelecionada >= 0){
            selecionado = lista.get(linhaSelecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um trabalho da lista.", 
                    "Trabalho", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    }       
}
