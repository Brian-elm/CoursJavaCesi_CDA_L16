import java.awt.*;

public class Rectangle extends Sprite {
    protected int width;
    protected int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle(int posX, int posY, Color couleur, int largeur, int hauteur) {
        super(posX, posY, couleur);
        this.width = largeur;
        this.height = hauteur;
    }

    @Override
    public void Dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillRect(posX, posY, width, height);
    }
}
