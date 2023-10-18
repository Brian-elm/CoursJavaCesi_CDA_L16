import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Barre extends Rectangle {

    public Barre(int posX, int posY, Color couleur, int largeur, int hauteur) {
        super(posX, posY, couleur, largeur, hauteur);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getWidth(){
        return width;
    }

    public void setPosX(int posXBarre) {
        this.posX = posXBarre;
    }

    //Méthode

    public void deplacementGauche(){
        testCollisionBarre();
        posX -= 10;
    }

    public void deplacementDroite(){
        testCollisionBarre();
        posX += 10;
    }

    public void testCollisionBarre(){
        if(posX >= CasseBrique.largeur - width) {
            posX -= 10;
        }
        if(posX <= 0) {
            posX += 10;
        }
    }
}