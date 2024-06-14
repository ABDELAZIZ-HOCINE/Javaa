import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Ruches {

    private int x, y;
    private Color color;
    private int RectSize = 200;
    private int nbSquares = 10;
    private int squareSize = RectSize / nbSquares;
    private int[][] matrix;

    public Ruches(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;

        // Initialiser la matrice de la ruche
        matrix = new int[nbSquares][nbSquares];
        for (int i = 0; i < nbSquares; i++) {
            for (int j = 0; j < nbSquares; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.orange);
        // Dessiner la ruche (matrice)
        for (int i = 0; i < nbSquares; i=i+1) {
            for (int j = 0; j < nbSquares; j=j+1) {
                if (matrix[i][j] == 0) {
                    g.fillRect(x + j * squareSize, y + i * squareSize, squareSize, squareSize);
                }
                g.setColor(Color.BLACK);
                g.drawRect(x + j * squareSize, y + i * squareSize, squareSize, squareSize);
                g.setColor(Color.orange);
            }
        }
        g.setColor(Color.BLACK);
        g.fillRect((x + RectSize - squareSize / 2), (y + squareSize * (nbSquares / 2)), squareSize / 2, squareSize);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public int getRectSize() {
        return RectSize;
    }

    public int getsquareSize() {
        return squareSize;
    }

    public int getnbSquares() {
        return nbSquares;
    }



    public void placeEclaireuses(ArrayList<Abeilles> abeilles, int nbEclaireuses) {
        int k=0;
        for (int i = 0; k < nbEclaireuses; i++) {
            for (int j=0;j < nbSquares && k< nbEclaireuses;j++ ){      
                int row = j;
                int col = i;
                // Vérification si la position est vide
                if (matrix[row][col] == 0) {
                    matrix[row][col] = 1; // Marquer la position comme occupée par une abeille éclaireuse
                    abeilles.add(new Eclaireuses(x+squareSize/2 + col * squareSize, y+squareSize/2 + row * squareSize, 1)); // Ajout également à la liste générale d'abeilles
                    k++;

                }
            }
        }
    }
    
}