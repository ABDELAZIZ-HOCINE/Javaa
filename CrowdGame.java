import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class CrowdGame extends JFrame {

    private ArrayList<Abeilles> abeille = new ArrayList<>();
    private ArrayList<Sources> source = new ArrayList<>();
    private ArrayList<Ruches> ruche = new ArrayList<>();
    private int w, h;

    class Environnement extends JPanel {

        public Environnement(CrowdGame cg) {
            super();
            this.setBackground(Color.WHITE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawHive(g);
            drawSources(g);
            drawAbeilles(g);
        }

        private void drawHive(Graphics g) {
            // Dessiner la ruche (matrice)
            for (Ruches r : getruche()){
                r.paint(g);
            }
        }

        private void drawSources(Graphics g) {
            for (Sources s : getsource()) {
                s.paint(g);
            }
        }

        private void drawAbeilles(Graphics g) {
            for (Abeilles abeille : getabeille()) {
                abeille.paint(g);
            }
        }
    }

    private Environnement environnement;

    public CrowdGame() {
        Random random = new Random();
        this.h = 800;
        this.w = 1000;

        int nbEmployées = 30;
        int nbObservatrices = 30;
        int nbEclaireuses = 15;

        for (int i = 0; i < nbEmployées; i++) {
            int startX = random.nextInt(w);
            int startY = random.nextInt(h);
            abeille.add(new Employées(startX, startY, 1));
        }

        for (int i = 0; i < nbObservatrices; i++) {
            int startX = random.nextInt(w);
            int startY = random.nextInt(h);
            abeille.add(new Observatrices(startX, startY, 1));
        }

        for (int i = 0; i < 1; i++) {
            int startX = 200;
            int startY = 200;
            ruche.add(new Ruches(startX, startY, new Color(255, 165, 0)));
        }

        // Place les abeilles éclaireuses dans les ruches
        for (Ruches ruche : getruche()) {
            ruche.placeEclaireuses(abeille, nbEclaireuses);
        }

        // Crée et ajoute trois sources à la simulation
        for (int i = 1; i <= 3; i++) {
            int startX = random.nextInt(w)+i*5;
            if (startX <= 400) {
                startX = startX + 400;
            }
            int startY = random.nextInt(h)+i*5;
            if (startY <= 400) {
                startY = startY + 400;
            }
            source.add(new Sources(startX, startY,10, Sources.generateRandomColor(), i));
        }

        for (Abeilles abeille : abeille) {
                abeille.chooseSource(source);
        }
        
        environnement = new Environnement(this);
        add(environnement);
        setTitle("Simulation d'une ruche");
        setSize(w, h);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    Abeilles[] getabeille() {
        return abeille.toArray(new Abeilles[0]);
    }

    Sources[] getsource() {
        return source.toArray(new Sources[0]);
    }

    Ruches[] getruche() {
        return ruche.toArray(new Ruches[0]);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((200));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (Abeilles abeille : abeille) {
                abeille.move(environnement.getWidth(), environnement.getHeight());
            }
            environnement.repaint();
        }
    }

    public static void main(String[] args) {
        CrowdGame cg = new CrowdGame();
        cg.run();
    }
}
