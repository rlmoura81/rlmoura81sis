package br.com.rlmoura81.sistema.principal;

import br.com.rlmoura81.sistema.principalinterface.JFPrincipal;
import br.com.rlmoura81.sistema.principalinterface.JPLogin;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Principal {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws ClassNotFoundException {
       
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run () {
                new JPLogin();
            }
        });   
    }     
}
