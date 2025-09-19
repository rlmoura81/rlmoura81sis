package br.com.rlmoura81.sistema.geral;

import br.com.rlmoura81.sistema.utilidade.Utilidade;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SalarioUtil {
    
    CadastroGeral cadgeral = new CadastroGeral();
    SalarioRepository salarior = new SalarioRepository();
    
    ArrayList lista = new ArrayList();
        
    public void tabelaSalario(JTable o){
        String []nomeColuna = {"Data", "Valor"};
        lista = salarior.getLista();
        Object[][]dadosArray = new Object[lista.size()][nomeColuna.length];
        for(int i=0; i < lista.size(); i++){
            cadgeral = (CadastroGeral)lista.get(i);
            dadosArray[i][0] = Utilidade.formatoData.format(cadgeral.getDt_cadgeral().getTime());
            dadosArray[i][1] = Utilidade.formatoValor.format(cadgeral.getNm_valor());
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
            JOptionPane.showMessageDialog(null, "Selecione um valor de salario da lista.",
                    "Salário", JOptionPane.INFORMATION_MESSAGE);
        }
        return selecionado;
    }    
}
