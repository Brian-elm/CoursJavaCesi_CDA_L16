import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class CasseBrique extends Canvas implements KeyListener {

    public static final int largeur = 500;
    public static final int hauteur = 700;
    Barre barre = new Barre(250, 630, Color.RED, 120, 10);
    Balle balle = new Balle(50, 200, Color.BLUE, 30, 5, 7);
    Vie vie = new Vie(0, 10, Color.GREEN, 20, 3);


    // Bonus random
    Random random = new Random();
    int x = random.nextInt(largeur - 100 + 1) + 100;
    int y = random.nextInt(hauteur - 100 + 1) + 100;
    Bonus bonus = new Bonus(x, y, Color.cyan, 10, 10);

    public CasseBrique() throws InterruptedException {

        setSize(largeur, hauteur);
        setBounds(0, 0, largeur, hauteur);

        JFrame fenetre = new JFrame();
        JPanel panneau = (JPanel) fenetre.getContentPane();

        panneau.setSize(largeur, hauteur);
        panneau.add(this);
        panneau.setVisible(true);

        fenetre.setSize(largeur, hauteur);
        fenetre.setTitle("Casse Brique");
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

    public void Demarrer() throws InterruptedException {

        boolean vivant = true;

        // Mur de brique

        ArrayList<Brique> TabBrique = new ArrayList<Brique>();

        for (int i = 0; i < 3; i++) {
            int positionX = 20;
            int positionY = 50 + i * 35;

            for (int ind = 0; positionX + 25 <= this.largeur; ind++) {
                TabBrique.add(new Brique(positionX, positionY, Color.gray, 25, 25));
                positionX += 25 + 15;
            }
        }

        while(vivant){

            Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();

            //----------------------- PROGRAM

            dessin.setColor(Color.WHITE);
            dessin.fillRect(0, 0, largeur, hauteur);

            barre.Dessiner(dessin);
            balle.Dessiner(dessin);
            vie.Dessiner(dessin);
            if(!bonus.isBonusCasse()) {
                bonus.Dessiner(dessin);
            }

            // Dessin brique
            for (Brique brique : TabBrique) {
                brique.Dessiner(dessin);
                // Collision avec les briques
                if (balle.posX + balle.diametre >= brique.posX && balle.posX <= brique.posX + brique.width
                        && balle.posY + balle.diametre >= brique.posY && balle.posY <= brique.posY + brique.height && !brique.isBriqueCasse()) {
                    balle.setSpeedY(-balle.getSpeedY());
                    brique.setBriqueCasse(true);
                }
            }

            balle.deplacement();
            balle.testColision();

            // Collision avec la barre
            if ((balle.getPosY() + balle.getDiametre() >= barre.getPosY()) && (balle.getPosX() >= barre.getPosX()) && (balle.getPosX() <= barre.getPosX() + barre.getWidth())) {
                balle.setSpeedY(-balle.getSpeedY());
            }

            // Collision avec le bas de la fênetre
            if (balle.getPosY() >= hauteur - balle.getDiametre()){
                vie.setVie(vie.getVie() - 1);
                balle.setPosX(50);
                balle.setPosY(200);
            }

            // Collision avec le bonus
            if (balle.posX + balle.diametre >= bonus.posX && balle.posX <= bonus.posX + bonus.width && balle.posY + balle.diametre >= bonus.posY && balle.posY <= bonus.posY + bonus.height && !bonus.isBonusCasse()) {
                balle.setSpeedY(-balle.getSpeedY());
                bonus.setBonusCasse(true);
                vie.setVie(vie.getVie() + 1);
            }


                //-----------------------

            dessin.dispose();
            getBufferStrategy().show();
            Thread.sleep(1000 / 30);

            if(vie.getVie() == 0){
                vivant = false;
                JOptionPane.showMessageDialog(null, "Perdu !", "Info", JOptionPane.INFORMATION_MESSAGE);
            }

            TabBrique.removeIf(Brique::isBriqueCasse);
            if(TabBrique.isEmpty()){
                vivant = false;
                JOptionPane.showMessageDialog(null, "Bien joué tu as gagné !", "Victoire", JOptionPane.INFORMATION_MESSAGE);

            }
        }

    }

    public void recommencer(){

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