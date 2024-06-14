import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

abstract class Abeilles {
    int x, y, radius = 4;
    Color c;

    public Abeilles(int x, int y, Color c) {this.x = x;this.y = y;this.c = c;}

    public void paint(Graphics g) {
        g.setColor(this.c);
        g.fillOval(this.x - this.radius, this.y - this.radius, 2 * this.radius, 2 * this.radius);
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
      return y;
    }
  
    abstract void move(int w, int h);

    abstract void chooseSource(ArrayList<Sources> sources);

    public Random random = new Random();
    public static Color generateRandomColor() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}