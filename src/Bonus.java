import java.awt.*;

public class Bonus extends Rectangle implements Deplacable {

    protected boolean bonusCasse = false;

    public boolean isBonusCasse() {
        return bonusCasse;
    }

    public void setBonusCasse(boolean bonusCasse) {
        this.bonusCasse = bonusCasse;
    }

    public Bonus(int posX, int posY, Color couleur, int largeur, int hauteur) {
        super(posX, posY, couleur, largeur, hauteur);
    }

    @Override
    public void Dessiner(Graphics2D dessin) {
        dessin.setColor(couleur);
        dessin.fillRect(posX, posY, width, height);
    }
}
