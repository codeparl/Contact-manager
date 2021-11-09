package contactaddress.gui.messages;

import contactaddress.Application;
import javax.swing.JOptionPane;


public class Message {
    
    
    public static  void showError(String msg, String title){
        JOptionPane
        .showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);

    }

    public static  int confirm(String msg, String title){
      return  JOptionPane
        .showConfirmDialog(null, msg, title, JOptionPane.YES_NO_OPTION);

    }
}
