import java.awt.Color;
import java.util.ArrayList;

public class Eclaireuses extends Abeilles {

    public Eclaireuses(int x, int y, int speed) {
        super(x, y, Color.red);
    }

    public void move(int w,int h) {
        // se déplacer aléatoirement/*
        // x = random.nextInt(-10,10); // Déplacement aléatoire horizontalement
        // y = random.nextInt(-10,10); // Déplacement aléatoire verticalement
        // Assurer que le Abeillese reste dans les limites de l'écran
        if (x < 0) x = w;
        if (y < 0) y = h;
        if (x > w) x = 0;
        if (y > h) y = 0;
    }

    @Override
    void chooseSource(ArrayList<Sources> sources) {}
}