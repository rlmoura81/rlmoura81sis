package br.com.rlmoura81.sistema.projeto;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EtapaUtil {
    
    Etapa etapa = new Etapa();
    EtapaRepository etapar = new EtapaRepository();
    ArrayList lista = new ArrayList();
    
    public void tabelaEtapa(JTable o, int cd_modulo){
        String[]nomeColuna = {"Titulo", "Tipo", "Status"};
        lista = etapar.getLista(cd_modulo);
        Object[][]dadosArray = new Object[lista.size()][nomeColuna.length];
        for(int i=0; i < lista.size(); i++){
            etapa = (Etapa)lista.get(i);
            dadosArray[i][0] = etapa.getDs_etapa();
            dadosArray[i][1] = etapa.getTipoetapa().getDs_tpetapa();
            dadosArray[i][2] = etapa.getStatusetapa().getDs_stetapa();
        }
        DefaultTableModel tEtapa = new DefaultTableModel(dadosArray, nomeColuna);
        o.setModel(tEtapa);
    }
    
    public Object getSelectObject(JTable o){
        Object selecionado = null;
        int linhaselecianda = o.getSelectedRow();
        if(linhaselecianda >= 0) {
            selecionado = lista.get(linhaselecianda);
        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma etapa");
        }
        return selecionado;
    }    
}
