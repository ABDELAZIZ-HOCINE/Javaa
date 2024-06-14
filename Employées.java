import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;

public class Employées extends Abeilles {

    public Employées(int x, int y, int speed) {
        super(x, y, Color.black);
    }

    boolean isDifferent = true;
    public void move(int w, int h) {
        
        if (bestSource != null && (bestSource.getX() <= this.x + 60 && bestSource.getX() >= this.x - 60) && (bestSource.getY() <= this.y + 60 && bestSource.getY() >= this.y - 60)) {
            isDifferent = false;
        }

        if (isDifferent) {
            // déplacer simplement vers la droite
            x += random.nextInt(-20,40);
            y += random.nextInt(-20,40);
            // Assurer que le touriste reste dans les limites de l'écran
            if (x < 0) x = w;
            if (y < 0) y = h;
            if (x > w) x = 0;
            if (y > h) y = 0;
        }else{
            x = bestSource.getX()+random.nextInt(0,40);
            y = bestSource.getY()+random.nextInt(0,40);
        }
    }

    Sources bestSource = null;
    public void chooseSource(ArrayList<Sources> sources) {
        int maxNectar = Integer.MIN_VALUE;
        for (Sources source : sources) {
            if (source.getNectar() > maxNectar) {
                maxNectar = source.getNectar();
                bestSource = source;
            }
        }
    }

    public void paint(Graphics g) {


        g.fillOval(this.x - this.radius, this.y - this.radius, 2 * this.radius, 2 * this.radius);
        
        if (! isDifferent) {
            g.drawString("Une employée a choisi la source " +  bestSource.getnumsource(), 100, 100);
        }

        
    }

}