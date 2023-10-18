import java.awt.*;

public class Rond extends Sprite {
    protected int diametre;

    public Rond(int posX, int posY, Color couleur, int diametre) {
        super(posX, posY, couleur);
        this.diametre = diametre;
    }

    @Override
    public void Dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillOval(posX, posY, diametre, diametre);
    }
}
