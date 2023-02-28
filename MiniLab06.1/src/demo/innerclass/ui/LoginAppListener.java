/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package demo.innerclass.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginAppListener
implements ActionListener {
  private JTextField nameField;
  private JTextField passwordField;
  private JLabel messageLabel;
  
  public LoginAppListener(JTextField nameField, JTextField passwordField, JLabel messageLabel) {
	  this.nameField = nameField;
	  this.passwordField = passwordField;
	  this.messageLabel = messageLabel;
  }
  
  /**
   * The heart of an ActionListener - this gets called when the event is fired.
   * Need to authenticate the user and display appropriate message on the UI.
   */
  @Override
  public void actionPerformed(ActionEvent evt) {
    if ("derek".equals(nameField.getText()) && "smalls".equals(passwordField.getText())) {
      messageLabel.setText("Login successful!");
    }
    else {
      messageLabel.setText("Sorry, try again");
    }
    nameField.setText("");
    passwordField.setText("");
  }
}