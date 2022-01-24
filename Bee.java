//Bee class defines behaviours for the Bee obstacle   

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bee extends Rectangle{

  public int yVelocity = 1 ;
  public int xVelocity = 1;
  public static final int BALL_DIAMETER = 20;
  Image bee;

  public Bee(int x, int y){
    super(x, y, BALL_DIAMETER, BALL_DIAMETER);
    bee = new ImageIcon("bee.gif").getImage();
  }

  public void setYDirection(int yDirection){
    yVelocity = yDirection;
  }

  public void setXDirection(int xDirection){
    xVelocity = xDirection;
  }

  public void move(){

    
    if(x>=810-40 || x<0) {
		xVelocity = xVelocity * -1;
		}
		x = x + xVelocity;
		
  }
  
  public void yeet(){
    x=696969;
    y=420420;
  }


  public void draw(Graphics g){
    Graphics2D g2D = (Graphics2D) g;
    g2D.drawImage(bee, x, y, null);
  }
  
}