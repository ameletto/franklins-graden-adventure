//Heart class defines behaviours for the heart image that shows player how many lives they have left

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Heart extends Rectangle{

  
  public static final int BALL_DIAMETER = 20;
  Image heart;

  public Heart(int x, int y){
    super(x, y, BALL_DIAMETER, BALL_DIAMETER);
    heart = new ImageIcon("heart.png").getImage();
  }

  public void yeet(){
    x=696969;
    y=420420;
  }

  public void draw(Graphics g){
    Graphics2D g2D = (Graphics2D) g;
    g2D.drawImage(heart, x, y, null);
  }
}