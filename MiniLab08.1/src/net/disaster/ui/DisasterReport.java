/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package net.disaster.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DisasterReport {
  
  private JFrame frame;
  private String message = "Earthquake!";  // dialog message
  
  public void layout() {
    frame = new JFrame("Disaster Report");
    
    // QUIZ: why can't a lambda be used here, as in button.addActionListener?
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    
    JButton button = new JButton("Do NOT Press Me");
    /*
     * Instance variables and methods, static variables and methods fully available to lambda.
     * Local variables also available to lambda, but must be final or "effectively final."
     */
    button.addActionListener((e) -> {
      warning(message);                       // lambda calls instance method, passing instance variable
      message = "No disasters at this time";  // reassign instance variable OK
      button.setText("OK To Press Me Now");   // does not break rules of a final variable
      // TODO: reassign button to reference a *new* JButton object
    });
    
    // finish UI setup
    frame.add(button);
    frame.setSize(400, 250);
    frame.setLocationByPlatform(true);
    frame.setVisible(true);
  }
  
  private void warning(String msg) {
    JOptionPane.showMessageDialog(frame, msg, "Disaster Status", JOptionPane.WARNING_MESSAGE);
  }
  
  public static void main(String[] args) {
    new DisasterReport().layout();
  }
}