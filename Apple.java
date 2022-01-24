//Apple class defines behaviours for the object meant to be collected by the player through their player-controlled object   

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Apple extends Rectangle{

    Image pingguo;
  public static final int BALL_DIAMETER = 20;
  	

  public Apple (int x, int y){
    super(x, y,BALL_DIAMETER,BALL_DIAMETER);
    pingguo = new ImageIcon("pingguo.png").getImage();
  }

  public void yeet(){
    x=696969;
    y=420420;
  }

  public void draw(Graphics g){
    Graphics2D g2D = (Graphics2D) g;
    g2D.drawImage(pingguo, x, y, null);
  }
  
}