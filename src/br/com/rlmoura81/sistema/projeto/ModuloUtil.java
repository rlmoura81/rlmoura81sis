package br.com.rlmoura81.sistema.projeto;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModuloUtil {
    
    Modulo modulo = new Modulo();
    ModuloRepository modulor = new ModuloRepository();
    
    ArrayList lista = new ArrayList();
    
    public void tabelaModulo(JTable o, int projeto){
        String[]nomeColuna = {"Modulo", "Descrição", "Hora"};
        lista = modulor.getLista(projeto);
        Object[][] dadosArray = new Object[lista.size()][nomeColuna.length];
        
        for(int i = 0; i < lista.size(); i++){
            modulo = (Modulo)lista.get(i);
            dadosArray[i][0] = modulo.getDs_modulo();
            dadosArray[i][1] = modulo.getDs_descricao();
            dadosArray[i][2] = modulo.getNm_hora();
        }
        DefaultTableModel tModulo = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tModulo);
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaSelecionada = o.getSelectedRow();
        if(linhaSelecionada >= 0){
            selecionado = lista.get(linhaSelecionada);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um modulo.");
        }
        return selecionado;
    }
}
