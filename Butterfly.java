//Butterfly class defines behaviours for the Butterfly obstacle   

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Butterfly extends Rectangle{

  public int yVelocity = 1 ;
  public int xVelocity = 1;
  public static final int BALL_DIAMETER = 20;
  Image butterfly;

  public Butterfly(int x, int y){
    super(x, y, BALL_DIAMETER, BALL_DIAMETER);
    butterfly = new ImageIcon("butterfly.gif").getImage();
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
		
		if(y>=440-40 || y<0) {
			yVelocity = yVelocity * -1;
		}
		y = y + yVelocity;
  }
  
  public void yeet(){
    x=696969;
    y=420420;
  }

  public void draw(Graphics g){
    Graphics2D g2D = (Graphics2D) g;
    g2D.drawImage(butterfly, x, y, null);
  }
  
}