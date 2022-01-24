//  GameFrame establishes the frame  for the game 
// Runs the constructor in GamePanel class


import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class GameFrame extends JFrame {

  GamePanel panel;
  JLabel label;

  GameFrame(){
    panel = new GamePanel(); 
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(panel);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    this.setLayout(null);
    this.setBackground(Color.black);
 } 
}



 

