package br.com.rlmoura81.sistema.projeto;

import java.awt.Component;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;

public class TipoEtapaUtil {
    
    TipoEtapaRepository tpetapar = new TipoEtapaRepository();
    
    /*
    * EM TESTE - COLOCAR COMENTARIO
    * DEFAULTCOMBOBOXMODEL - TIPO ETAPA
    */
    private void jcModelTipoEtapa(JComboBox<TipoEtapa> o){
        o.setRenderer(new DefaultListCellRenderer(){
                @Override
                public Component getListCellRendererComponent(
                    JList<?> list, 
                    Object value,
                    int index,
                    boolean isSelected,
                    boolean cellHasFocus){
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    if(value instanceof TipoEtapa){
                        TipoEtapa tpe = (TipoEtapa) value;
                        if(tpe.getCd_tpetapa()== 0){
                            setText("<Selecione>");
                        }else if(tpe.getDs_tpetapa()!= null){
                            setText(tpe.getDs_tpetapa());
                        }else{
                            setText("Sem Tipo Etapa");
                        }
                    }else{
                        setText("");
                    }
                return this;
            }
        });
    }
    
    public void jcTipoEtapa(JComboBox<TipoEtapa> o){
        List<TipoEtapa> lista = tpetapar.getLista();
        DefaultComboBoxModel<TipoEtapa> model = new DefaultComboBoxModel<>();
        model.addElement(new TipoEtapa(0, null));
        if(lista != null && !lista.isEmpty()){
            for(TipoEtapa tpetapa : lista){
                model.addElement(tpetapa);
            }    
        }
        o.setModel(model);
        jcModelTipoEtapa(o);
    }
}
