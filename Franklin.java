//Franklin class defines behaviours for the player-controlled object   

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Franklin extends Rectangle{

  public int yVelocity;
  public int xVelocity;
  public final int SPEED = 2; 
  public static final int FRANKLIN_WIDTH = 30;
  public static final int FRANKLIN_LENGTH = 60;
  Image franklin;

  public Franklin(int x, int y){
    super(x, y, FRANKLIN_WIDTH, FRANKLIN_LENGTH);
    franklin = new ImageIcon("franklin.png").getImage();
  }

  public void keyPressed(KeyEvent e){
    if(e.getKeyChar() == 'd'){
      setXDirection(SPEED);
      move();
    }

    if(e.getKeyChar() == 'a'){
      setXDirection(SPEED*-1);
      move();
    }

    if(e.getKeyChar() == 'w'){
      setYDirection(SPEED*-1);
      move();
    }

    if(e.getKeyChar() == 's'){
      setYDirection(SPEED);
      move();
    }
  }

  public void keyReleased(KeyEvent e){
    if(e.getKeyChar() == 'd'){
      setXDirection(0);
      move();
    }

    if(e.getKeyChar() == 'a'){
      setXDirection(0);
      move();
    }

    if(e.getKeyChar() == 'w'){
      setYDirection(0);
      move();
    }

    if(e.getKeyChar() == 's'){
      setYDirection(0);
      move();
    }
  }

  public void setYDirection(int yDirection){
    yVelocity = yDirection;
  }

  public void setXDirection(int xDirection){
    xVelocity = xDirection;
  }


  public void move(){
    y = y + yVelocity;
    x = x + xVelocity; 
  }

  public void draw(Graphics g){
    Graphics2D g2D = (Graphics2D) g;
    g2D.drawImage(franklin, x, y, null);
  }
}