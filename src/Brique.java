import java.awt.*;
import java.util.ArrayList;

public class Brique extends Rectangle {

    protected boolean briqueCasse = false;

    public Brique(int posX, int posY, Color couleur, int largeur, int hauteur) {
        super(posX, posY, couleur, largeur, hauteur);
    }

    public boolean isBriqueCasse() {
        return briqueCasse;
    }

    public void setBriqueCasse(boolean briqueCasse) {
        this.briqueCasse = briqueCasse;
    }

    @Override
    public void Dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillRect(posX, posY, width, height);
    }

}
