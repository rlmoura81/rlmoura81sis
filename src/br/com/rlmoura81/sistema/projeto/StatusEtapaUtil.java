package br.com.rlmoura81.sistema.projeto;

import java.awt.Component;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;

public class StatusEtapaUtil {
    
    StatusEtapaRepository stetapar = new StatusEtapaRepository();
    
    /*
    * EM TESTE - COLOCAR COMENTARIO
    * DEFAULTCOMBOBOXMODEL - STATUS ETAPA
    */
    private void jcModelStatusEtapa(JComboBox<StatusEtapa> o){
        o.setRenderer(new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(
                    JList<?> list, 
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus){
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value instanceof StatusEtapa){
                        StatusEtapa ste = (StatusEtapa) value;
                        if(ste.getCd_stetapa()== 0){
                            setText("<Selecione>");
                        }else if(ste.getDs_stetapa()!= null){
                            setText(ste.getDs_stetapa());
                        }else{
                            setText("Sem Status Etapa");
                        }
                    }else{
                        setText("");
                    }
                return this;
            }
        });
    }
    
    public void jcStatusEtapa(JComboBox<StatusEtapa> o){
        List<StatusEtapa> lista = stetapar.getLista();
        DefaultComboBoxModel<StatusEtapa> model = new DefaultComboBoxModel<>();
        model.addElement(new StatusEtapa(0, null));
        if(lista != null && !lista.isEmpty()){
            for(StatusEtapa stetapa : lista){
                model.addElement(stetapa);
            }    
        }
        o.setModel(model);
        jcModelStatusEtapa(o);
    }
}
