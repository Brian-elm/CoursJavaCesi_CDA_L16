import java.awt.*;

public abstract class Sprite {

    protected int posX;
    protected int posY;
    protected Color couleur;

    public Sprite(int posX, int posY, Color couleur) {
        this.posX = posX;
        this.posY = posY;
        this.couleur = couleur;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public abstract void Dessiner(Graphics2D dessin);
}
