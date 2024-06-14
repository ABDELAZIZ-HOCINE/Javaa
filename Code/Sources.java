import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Sources {

    Random random = new Random();
    private int x, y, i;
    private Color color;
    private int nectar;

    public Sources(int x, int y, int nectar, Color color, int i) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.i = i;
        this.nectar = nectar + random.nextInt(-10, 10);

    }

    public static Color generateRandomColor() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }

    public void paint(Graphics g) {
        int diameter = 30;
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
        g.setColor(Color.BLACK);
        g.drawString("Source " + i, x, y);
        g.drawString("➔ Nectar: "+ nectar + "ml", x, y-10);
    }

    public int getNectar() {
      return  nectar;
    }
    public int getnumsource(){
      return i;
    }

    public int getX() {
        return x;
    }

    public int getY() {
      return y;
    }
  
}
