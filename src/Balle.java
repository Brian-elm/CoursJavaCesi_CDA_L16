import java.awt.*;

public class Balle extends Rond implements Deplacable {

    protected int speedX;
    protected int speedY;

    public Balle(int posX, int posY, Color couleur, int diametre, int speedX, int speedY) {
        super(posX, posY, couleur, diametre);
        this.speedX = speedX;
        this.speedY = speedY;
    }

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
}
