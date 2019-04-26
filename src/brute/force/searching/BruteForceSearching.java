/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brute.force.searching;

import javax.swing.WindowConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
/**
 *
 * @author WKMachine2
 */
public class BruteForceSearching implements ActionListener{

    /**
     * @param args the command line arguments
     */
    NewJFrame view;
    
    public BruteForceSearching(){
        view = new NewJFrame();
        view.getOutput().setContentType("text/html");
        view.getCariBtn().addActionListener(this);
        view.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
        view.setLocationRelativeTo(null);
        view.setVisible(true);  
    }
    
    public static int stringMatching(String text, String pattern){
        int lengthOfPattern = pattern.length();
        int lengthOfText = text.length();
        
        for (int i = 0; i <= lengthOfText - lengthOfPattern; i++){
            int j;
            for (j = 0; j < lengthOfPattern; j++){
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;
            }
            if (j == lengthOfPattern)
                return i;
        }
        return lengthOfText;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        BruteForceSearching brute = new BruteForceSearching();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(view.getCariBtn())){
           int hasil = stringMatching(view.getText().getText(), view.getPattern().getText());
           if (hasil == view.getText().getText().length())
                view.getOutput().setText("<html><body><font color='red'>Error</font><br>"
                        + "<p>Pattern not found</p></body></html>");
           else
               try {
                   view.getOutput().setText("<html><body><font color='green'>Success</font><br>"
                           + "<p>"+view.getText().getText(0,(hasil))+"<font color='blue'>" +view.getText().getText(hasil,view.getPattern().getText().length())
                           + "</font>"+ view.getText().getText(hasil+view.getPattern().getText().length(),view.getText().getText().length()-(hasil+view.getPattern().getText().length()))
                           + "</p></body></html>");
           } catch (BadLocationException ex) {
               Logger.getLogger(BruteForceSearching.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }
    
    
}
