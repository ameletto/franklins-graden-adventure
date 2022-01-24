//Score class handles the game score

import java.awt.*;

public class Score extends Rectangle{

  public static int GAME_WIDTH;
  public static int GAME_HEIGHT;
  public static int score;

  public Score(int w, int h){
    score = 0;
    Score.GAME_WIDTH = w;
    Score.GAME_HEIGHT = h;
  }

  public void draw(Graphics g){
    g.setColor(Color.black);
    g.setFont(new Font("Consolas", Font.PLAIN, 60));
    g.drawString(String.valueOf(score), (int)(GAME_WIDTH*0.5), (int)(GAME_HEIGHT*0.2)); 
  }
}