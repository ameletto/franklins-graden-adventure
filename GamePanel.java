//GamePanel class that creates instances of all the classes, draws them to the screen
//logic behind the game

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// public class GamePanel extends JPanel implements Runnable, KeyListener{

public class GamePanel extends JPanel implements Runnable, KeyListener {

  Image twerk;

  int appleCounter;

  Image background;
  // boolean yeet = false;

  public int yVelocity = 5;
  public int xVelocity = 5;

  public int numHearts = 5;

  public Franklin tortle;
  public Thread gameThread;
  public Bee bee1;
  public Bee bee2;
  public Bee bee3;
  public Bee bee4;
  public Bee bee5;
  public Bird bird6;
  public Bird bird7;
  public Bird bird8;
  public Bird bird9;
  public Bird bird10;

  public Apple pingguo1;
  public Apple pingguo2;
  public Apple pingguo3;
  public Apple pingguo4;
  public Apple pingguo5;
  public Apple pingguo6;
  public Apple pingguo7;
  public Apple pingguo8;
  public Apple pingguo9;
  public Apple pingguo10;

  public Butterfly butter1;
  public Butterfly butter2;
  public Butterfly butter3;
  public Butterfly butter4;

  public Heart heart1;
  public Heart heart2;
  public Heart heart3;
  public Heart heart4;
  public Heart heart5;

  public Score score;

  GamePanel() {
    score = new Score(810, 440);

    tortle = new Franklin(810 / 2, 440 / 2);
    bee1 = new Bee(100, 0);
    bee2 = new Bee(300, 395);
    bee3 = new Bee(500, 300);
    bee4 = new Bee(700, 180);
    bee5 = new Bee(15, 90);

    bird6 = new Bird(65, 395);
    bird7 = new Bird(220, 300);
    bird8 = new Bird(435, 20);
    bird9 = new Bird(620, 185);
    bird10 = new Bird(750, 10);

    pingguo1 = new Apple(100, 120);
    pingguo2 = new Apple(200, 250);
    pingguo3 = new Apple(300, 380);
    pingguo4 = new Apple(500, 230);
    pingguo5 = new Apple(220, 30);
    pingguo6 = new Apple(600, 80);
    pingguo7 = new Apple(700, 300);
    pingguo8 = new Apple(425, 90);
    pingguo9 = new Apple(95, 350);
    pingguo10 = new Apple(750, 120);

    butter1 = new Butterfly(10, 10);
    butter2 = new Butterfly(770, 400);
    butter3 = new Butterfly(770, 10);
    butter4 = new Butterfly(10, 400);

    heart1 = new Heart(775, 10);
    heart2 = new Heart(740, 10);
    heart3 = new Heart(705, 10);
    heart4 = new Heart(670, 10);
    heart5 = new Heart(635, 10);

    background = new ImageIcon("bg.gif").getImage();
    twerk = new ImageIcon("twerk.gif").getImage();


    this.setPreferredSize(new Dimension(810, 440));
    this.setFocusable(true); 
    this.addKeyListener(this); 
    gameThread = new Thread(this);
    gameThread.start();

  }

  public void paint(Graphics g) {
    super.paint(g);
    Graphics2D g2D = (Graphics2D) g;

    g2D.drawImage(background, 0, 0, null);

    bee1.draw(g);
    bee2.draw(g);
    bee3.draw(g);
    bee4.draw(g);
    bee5.draw(g);
    bird6.draw(g);
    bird7.draw(g);
    bird8.draw(g);
    bird9.draw(g);
    bird10.draw(g);
    score.draw(g);

    tortle.draw(g);

    pingguo1.draw(g);
    pingguo2.draw(g);
    pingguo3.draw(g);
    pingguo4.draw(g);
    pingguo5.draw(g);
    pingguo6.draw(g);
    pingguo7.draw(g);
    pingguo8.draw(g);
    pingguo9.draw(g);
    pingguo10.draw(g);

    butter1.draw(g);
    butter2.draw(g);
    butter3.draw(g);
    butter4.draw(g);

    heart1.draw(g);
    heart2.draw(g);
    heart3.draw(g);
    heart4.draw(g);
    heart5.draw(g);

    if (appleCounter == 10) {
      bee1.yeet();
      bee2.yeet();
      bee3.yeet();
      bee4.yeet();
      bee5.yeet();
      bird6.yeet();
      bird7.yeet();
      bird8.yeet();
      bird9.yeet();
      bird10.yeet();
      butter1.yeet();
      butter2.yeet();
      butter3.yeet();
      butter4.yeet();
  
      g2D.drawImage(twerk, 0, 0, null);
      g2D.setColor(Color.white);
      g2D.setFont(new Font("Consolas", Font.PLAIN, 40));
      g2D.drawString("Wahoo! You got all the apples :)", 100, 250);
    }

    if(numHearts == 0){
    g2D.drawImage(twerk, 0, 0, null);
    g2D.setColor(Color.white);
    g2D.setFont(new Font("Consolas", Font.PLAIN, 40));
    g2D.drawString("You failed to get all of the apples :(", 100, 250);
    }
  }

  public void run() {
    long lastTime = System.nanoTime();
    double amountOfTicks = 60;
    double ns = 1000000000 / amountOfTicks;
    double delta = 0;
    long now;

    while (true) { 
      now = System.nanoTime();
      delta = delta + (now - lastTime) / ns;
      lastTime = now;

      if (delta >= 1) {
        move();
        checkCollision();
        repaint();
        delta--;
      }
    }
  }

	public static boolean collide1 = false;
	public static boolean collide2 = false;
	public static boolean collide3 = false;
	public static boolean collide4 = false;
	public static boolean collide5 = false;
	public static boolean collide6 = false;
	public static boolean collide7 = false;
	public static boolean collide8 = false;
	public static boolean collide9 = false;
	public static boolean collide10 = false;
	public static boolean collide11 = false;
	public static boolean collide12 = false;
	public static boolean collide13 = false;
	public static boolean collide14 = false;

  public void checkCollision() {

    if (tortle.y <= 0) {
      tortle.y = 0;
    }
    if (tortle.y >= 440 - 60) {
      tortle.y = 440 - 60;
    }
    if (tortle.x <= 0) {
      tortle.x = 0;
    }
    if (tortle.x + 30 >= 810) {
      tortle.x = 810 - 30;
    }


    if (tortle.intersects(bee1)) {
			if (!collide1){
				collide1 = true;

        if (numHearts == 5) {
					heart5.yeet();
					numHearts--;
				} else if (numHearts == 4) {
					heart4.yeet();
					numHearts--;
				} else if (numHearts == 3) {
					heart3.yeet();
					numHearts--;
				} else if (numHearts == 2) {
					heart2.yeet();
					numHearts--;
				} else if (numHearts == 1) {
					heart1.yeet();
					numHearts--;
				} 
			}
    } else {
			collide1 = false;
		}
		if (tortle.intersects(bee2)) {
			if (!collide2){
				collide2 = true;

        if (numHearts == 5) {
					heart5.yeet();
					numHearts--;
				} else if (numHearts == 4) {
					heart4.yeet();
					numHearts--;
				} else if (numHearts == 3) {
					heart3.yeet();
					numHearts--;
				} else if (numHearts == 2) {
					heart2.yeet();
					numHearts--;
				} else if (numHearts == 1) {
					heart1.yeet();
					numHearts--;
				} 
			}
    } else {
			collide2 = false;
		}
		if (tortle.intersects(bee3)) {
			if (!collide3){
				collide3 = true;

        if (numHearts == 5) {
					heart5.yeet();
					numHearts--;
				} else if (numHearts == 4) {
					heart4.yeet();
					numHearts--;
				} else if (numHearts == 3) {
					heart3.yeet();
					numHearts--;
				} else if (numHearts == 2) {
					heart2.yeet();
					numHearts--;
				} else if (numHearts == 1) {
					heart1.yeet();
					numHearts--;
				} 
			}
    } else {
			collide3 = false;
		}
		if (tortle.intersects(bee4)) {
			if (!collide4){
				collide4 = true;

        if (numHearts == 5) {
					heart5.yeet();
					numHearts--;
				} else if (numHearts == 4) {
					heart4.yeet();
					numHearts--;
				} else if (numHearts == 3) {
					heart3.yeet();
					numHearts--;
				} else if (numHearts == 2) {
					heart2.yeet();
					numHearts--;
				} else if (numHearts == 1) {
					heart1.yeet();
					numHearts--;
				} 
			}
    } else {
			collide4 = false;
		}
		if (tortle.intersects(bee5)) {
			if (!collide5){
				collide5 = true;

        if (numHearts == 5) {
					heart5.yeet();
					numHearts--;
				} else if (numHearts == 4) {
					heart4.yeet();
					numHearts--;
				} else if (numHearts == 3) {
					heart3.yeet();
					numHearts--;
				} else if (numHearts == 2) {
					heart2.yeet();
					numHearts--;
				} else if (numHearts == 1) {
					heart1.yeet();
					numHearts--;
				} 
			}
    } else {
			collide5 = false;
		}
    
    if (tortle.intersects(bird6)) {
			if (!collide6){
				collide6 = true;

        if (numHearts == 5) {
					heart5.yeet();
					numHearts--;
				} else if (numHearts == 4) {
					heart4.yeet();
					numHearts--;
				} else if (numHearts == 3) {
					heart3.yeet();
					numHearts--;
				} else if (numHearts == 2) {
					heart2.yeet();
					numHearts--;
				} else if (numHearts == 1) {
					heart1.yeet();
					numHearts--;
				} 
			}
    } else {
			collide6 = false;
		}

    if (tortle.intersects(bird7)) {
			if (!collide7){
				collide7 = true;

        if (numHearts == 5) {
					heart5.yeet();
					numHearts--;
				} else if (numHearts == 4) {
					heart4.yeet();
					numHearts--;
				} else if (numHearts == 3) {
					heart3.yeet();
					numHearts--;
				} else if (numHearts == 2) {
					heart2.yeet();
					numHearts--;
				} else if (numHearts == 1) {
					heart1.yeet();
					numHearts--;
				} 
			}
    } else {
			collide7 = false;
		}

    if (tortle.intersects(bird8)) {
			if (!collide8){
				collide8 = true;

        if (numHearts == 5) {
					heart5.yeet();
					numHearts--;
				} else if (numHearts == 4) {
					heart4.yeet();
					numHearts--;
				} else if (numHearts == 3) {
					heart3.yeet();
					numHearts--;
				} else if (numHearts == 2) {
					heart2.yeet();
					numHearts--;
				} else if (numHearts == 1) {
					heart1.yeet();
					numHearts--;
				} 
			}
    } else {
			collide8 = false;
		}

    if (tortle.intersects(bird9)) {
			if (!collide9){
				collide9 = true;

        if (numHearts == 5) {
					heart5.yeet();
					numHearts--;
				} else if (numHearts == 4) {
					heart4.yeet();
					numHearts--;
				} else if (numHearts == 3) {
					heart3.yeet();
					numHearts--;
				} else if (numHearts == 2) {
					heart2.yeet();
					numHearts--;
				} else if (numHearts == 1) {
					heart1.yeet();
					numHearts--;
				} 
			}
    } else {
			collide9 = false;
		}

    if (tortle.intersects(bird10)) {
			if (!collide10){
				collide10 = true;

        if (numHearts == 5) {
					heart5.yeet();
					numHearts--;
				} else if (numHearts == 4) {
					heart4.yeet();
					numHearts--;
				} else if (numHearts == 3) {
					heart3.yeet();
					numHearts--;
				} else if (numHearts == 2) {
					heart2.yeet();
					numHearts--;
				} else if (numHearts == 1) {
					heart1.yeet();
					numHearts--;
				} 
			}
    } else {
			collide10 = false;
		}
    


   if (tortle.intersects(butter1)) {
			if (!collide11){
				collide11 = true;

        if (numHearts == 5) {
					heart5.yeet();
					numHearts--;
				} else if (numHearts == 4) {
					heart4.yeet();
					numHearts--;
				} else if (numHearts == 3) {
					heart3.yeet();
					numHearts--;
				} else if (numHearts == 2) {
					heart2.yeet();
					numHearts--;
				} else if (numHearts == 1) {
					heart1.yeet();
					numHearts--;
				} 
			}
    } else {
			collide11 = false;
		}

    if (tortle.intersects(butter2)) {
			if (!collide12){
				collide12 = true;

        if (numHearts == 5) {
					heart5.yeet();
					numHearts--;
				} else if (numHearts == 4) {
					heart4.yeet();
					numHearts--;
				} else if (numHearts == 3) {
					heart3.yeet();
					numHearts--;
				} else if (numHearts == 2) {
					heart2.yeet();
					numHearts--;
				} else if (numHearts == 1) {
					heart1.yeet();
					numHearts--;
				} 
			}
    } else {
			collide12 = false;
		}

    if (tortle.intersects(butter3)) {
			if (!collide13){
				collide13 = true;

        if (numHearts == 5) {
					heart5.yeet();
					numHearts--;
				} else if (numHearts == 4) {
					heart4.yeet();
					numHearts--;
				} else if (numHearts == 3) {
					heart3.yeet();
					numHearts--;
				} else if (numHearts == 2) {
					heart2.yeet();
					numHearts--;
				} else if (numHearts == 1) {
					heart1.yeet();
					numHearts--;
				} 
			}
    } else {
			collide13 = false;
		}

    if (tortle.intersects(butter4)) {
			if (!collide14){
				collide14 = true;

        if (numHearts == 5) {
					heart5.yeet();
					numHearts--;
				} else if (numHearts == 4) {
					heart4.yeet();
					numHearts--;
				} else if (numHearts == 3) {
					heart3.yeet();
					numHearts--;
				} else if (numHearts == 2) {
					heart2.yeet();
					numHearts--;
				} else if (numHearts == 1) {
					heart1.yeet();
					numHearts--;
				} 
			}
    } else {
			collide14 = false;
		}

    if (tortle.intersects(pingguo1)) {
      pingguo1.yeet();
      Score.score++;
      appleCounter++;
    }
    if (tortle.intersects(pingguo2)) {
      pingguo2.yeet();
      Score.score++;
      appleCounter++;
    }
    if (tortle.intersects(pingguo3)) {
      pingguo3.yeet();
      Score.score++;
      appleCounter++;
    }
    if (tortle.intersects(pingguo4)) {
      pingguo4.yeet();
      Score.score++;
      appleCounter++;
    }
    if (tortle.intersects(pingguo5)) {
      pingguo5.yeet();
      Score.score++;
      appleCounter++;
    }
    if (tortle.intersects(pingguo6)) {
      pingguo6.yeet();
      Score.score++;
      appleCounter++;
    }
    if (tortle.intersects(pingguo7)) {
      pingguo7.yeet();
      Score.score++;
      appleCounter++;
    }
    if (tortle.intersects(pingguo8)) {
      pingguo8.yeet();
      Score.score++;
      appleCounter++;
    }
    if (tortle.intersects(pingguo9)) {
      pingguo9.yeet();
      Score.score++;
      appleCounter++;
    }
    if (tortle.intersects(pingguo10)) {
      pingguo10.yeet();
      Score.score++;
      appleCounter++;
    }

  }

  public void move() {
    tortle.move();
    bee1.move();
    bee2.move();
    bee3.move();
    bee4.move();
    bee5.move();
    bird6.move();
    bird7.move();
    bird8.move();
    bird9.move();
    bird10.move();

    butter1.move();
    butter2.move();
    butter3.move();
    butter4.move();
  }

  public void keyPressed(KeyEvent e) {
    tortle.keyPressed(e);
  }

  // if a key is released, we'll send it over to the Playerbee class for
  // processing
  public void keyReleased(KeyEvent e) {
    tortle.keyReleased(e);
  }

  // left empty because we don't need it; must be here because it is required to
  // be overridded by the KeyListener interface
  public void keyTyped(KeyEvent e) {

  }

}