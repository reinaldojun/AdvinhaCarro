
package advinhacarro;

import advinhacarro.service.CarroService;
import advinhacarro.view.AdvinhaCarroInit;

/**
 *
 * @author Reinaldo
 */
public class AdvinhaCarro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdvinhaCarroInit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new AdvinhaCarroInit(new CarroService()).setVisible(true);
        });
    }
    
}
