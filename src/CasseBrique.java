import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CasseBrique extends Canvas implements KeyListener {

    public static final int largeur = 500;
    public static final int hauteur = 700;

    public CasseBrique() throws InterruptedException {

        setSize(largeur, hauteur);
        setBounds(0, 0, largeur, hauteur);

        JFrame fenetre = new JFrame();
        JPanel panneau = (JPanel) fenetre.getContentPane();

        panneau.setSize(largeur, hauteur);
        panneau.add(this);
        panneau.setVisible(true);

        fenetre.setSize(largeur, hauteur);
        fenetre.setVisible(true);
        fenetre.setResizable(false);
        fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fenetre.requestFocus();
        fenetre.addKeyListener(this);


        fenetre.pack();

        createBufferStrategy(2);
        setIgnoreRepaint(true);
        setFocusable(false);

        Demarrer();
    }

    Barre barre = new Barre();

    public void Demarrer() throws InterruptedException {

        Balle balle = new Balle();



        while(true){

            Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();

            //----------------------- PROGRAM

            dessin.setColor(Color.WHITE);
            dessin.fillRect(0, 0, largeur, hauteur);

            barre.dessinerBarre(dessin);
            barre.testCollisionBarre();

            balle.dessiner(dessin);
            balle.deplacement();
            balle.testColision();

            if ((balle.getPosY() + balle.getDiametre() >= barre.getPosYBarre()) && (balle.getPosX() >= barre.getPosXBarre()) && (balle.getPosX() <= barre.getPosXBarre() + barre.getWidth())) {
                balle.setPosY(balle.getPosY() - balle.getSpeedY());
                System.out.println("touché !");
            }

            //-----------------------

            dessin.dispose();
            getBufferStrategy().show();
            Thread.sleep(1000 / 60);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 39){
            barre.deplacementDroite();
        } else if (e.getKeyCode() == 37) {
            barre.deplacementGauche();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}