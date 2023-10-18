import java.awt.*;

public class Vie extends Rond {
    protected int vie;

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public Vie(int posX, int posY, Color couleur, int diametre, int vie) {
        super(posX, posY, couleur, diametre);
        this.vie = vie;
    }

    @Override
    public void Dessiner(Graphics2D dessin) {
        int positoinX = 15;
        for (int i = 0; i < vie; i++) {
            dessin.setColor(couleur);
            dessin.fillOval(positoinX, posY, diametre, diametre);

            positoinX += 25;
        }

    }
}
