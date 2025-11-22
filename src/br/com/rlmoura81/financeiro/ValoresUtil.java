package br.com.rlmoura81.financeiro;

import br.com.rlmoura81.sistema.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ValoresUtil {
    
    Valores valores = new Valores();
    ValoresRepository valoresr = new ValoresRepository();
    ArrayList lista = new ArrayList();
        
    public void tabelaCurso(JTable o){
        String []nomeColuna = {"Qtde Salario", "Salario Meta", "Valor Hora"};
        lista = valoresr.getLista();
        Object[][]dadosArray = new Object[lista.size()][nomeColuna.length];
        for(int i=0; i < lista.size(); i++){
            valores = (Valores)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoValor.format(valores.getNm_salario());
            dadosArray[i][1] = Utilidade.formatoValor.format(valores.getVl_salario());
            dadosArray[i][2] = Utilidade.formatoValor.format(valores.getVl_hora());
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
            JOptionPane.showMessageDialog(null, "Selecione um item da lista.",
                "Curso", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    }      
}
