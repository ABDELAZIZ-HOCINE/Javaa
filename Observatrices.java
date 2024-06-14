import java.awt.Color;
import java.util.ArrayList;

public class Observatrices extends Abeilles {

    public Observatrices(int x, int y, int speed) {
        super(x, y, Color.yellow);
    }

    boolean isDifferent = true;
    public void move(int w, int h) {
        
        if (bestSource != null && (bestSource.getX() <= this.x + 60 && bestSource.getX() >= this.x - 60) && (bestSource.getY() <= this.y + 60 && bestSource.getY() >= this.y - 60)) {
            isDifferent = false;
        }

        if (isDifferent) {
            // déplacer simplement vers la droite
            x += random.nextInt(-10,20);
            y += random.nextInt(-10,20);
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
}