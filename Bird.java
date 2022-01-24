//Bird class defines behaviours for the Bird obstacle   

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bird extends Rectangle{

  public int yVelocity = -1 ;
  public int xVelocity = -1;
  public static final int BALL_DIAMETER = 20;
  Image bird;

  public Bird(int x, int y){
    super(x, y, BALL_DIAMETER, BALL_DIAMETER);
    bird = new ImageIcon("flappyberd.gif").getImage();
  }

  public void setYDirection(int yDirection){
    yVelocity = yDirection;
  }

  public void setXDirection(int xDirection){
    xVelocity = xDirection;
  }

  public void move(){
		
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
    g2D.drawImage(bird, x, y, null);
  }
  
}