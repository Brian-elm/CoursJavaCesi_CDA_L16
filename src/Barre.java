import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Barre extends Sprite {

    protected Color couleur = Color.RED;

    public int getPosXBarre() {
        return posXBarre;
    }

    public int getWidth(){
        return width;
    }

    public void setPosXBarre(int posXBarre) {
        this.posXBarre = posXBarre;
    }

    public int getPosYBarre() {
        return posYBarre;
    }

    //Méthode
    public void dessinerBarre(Graphics2D dessinBarre){
        dessinBarre.setColor(couleur);
        dessinBarre.fillRect(posXBarre, posYBarre, width, height);
    }

    public void deplacementGauche(){
        posXBarre -= 10;
    }

    public void deplacementDroite(){
        posXBarre += 10;
    }

    public void testCollisionBarre(){
        if(posXBarre >= CasseBrique.largeur - width) {
            posXBarre -= 10;
        }
        if(posXBarre <= 0) {
            posXBarre += 10;
        }
    }
}