import java.awt.*;

public class Balle extends Sprite {

    protected int speedX = 5;
    protected int speedY = 10;
    protected Color couleur = Color.BLUE;
    public int getDiametre() {
        return diametre;
    }
    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
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

    public int getSpeedX() {

        return speedX;
    }

    public void setSpeedX(int speedX) {

        this.speedX = speedX;
    }

    public int getSpeedY() {

        return speedY;
    }

    public void setSpeedY(int speedY) {

        this.speedY = speedY;
    }


    //Méthodes
    public void deplacement(){

        posX += speedX;
        posY += speedY;
    }

    public void testColision(){

        if(posX >= CasseBrique.largeur - diametre || posX <= 0){
            speedX = -speedX;
        }
        if(posY >= CasseBrique.hauteur - diametre || posY <= 0){
            speedY = -speedY;
        }
    }

    public void dessiner(Graphics2D dessin){
        dessin.setColor(couleur);
        dessin.fillOval(posX, posY, diametre, diametre);
    }
}
