package br.com.rlmoura81.sistema.geral;

import br.com.rlmoura81.sistema.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DespesaUtil {
    
    CadastroGeral cadgeral = new CadastroGeral();
    DespesaRepository despesar = new DespesaRepository();
    
    ArrayList lista = new ArrayList();
        
    public void tabelaDespesa(JTable o){
        String []nomeColuna = {"Despesa", "Data", "Valor"};
        lista = despesar.getLista();
        Object[][]dadosArray = new Object[lista.size()][nomeColuna.length];
        for(int i=0; i < lista.size(); i++){
            cadgeral = (CadastroGeral)lista.get(i);
            dadosArray[i][0] = cadgeral.getDs_cadgeral();
            dadosArray[i][1] = Utilidade.formatoData.format(cadgeral.getDt_cadgeral().getTime());
            dadosArray[i][2] = Utilidade.formatoValor.format(cadgeral.getNm_valor());
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
            JOptionPane.showMessageDialog(null, "Selecione uma despesa da lista.",
                    "Despesa", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    }    
}
