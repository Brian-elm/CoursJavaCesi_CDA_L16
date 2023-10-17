import java.util.ArrayList;
import java.util.HashMap;

public class Principale {

    public static void main(String[] args) throws InterruptedException {

        //Types
        int monNombre = 429999999;
        long monLongNombre = 4299999999999999999L;

        String monTexte = "Hello";
        char noteModuleJava = 'A';

        byte octet = 127;
        short petitNombre = 32767;

        double monGrandDecimal = 3.142345678945678987654345678;
        float monPetitDecimal = 3.19F;

        float resultat = monNombre / monPetitDecimal;
        //System.out.println("Valuer : " + monNombre + 10);

        //Objet
        Personne unePersonne = new Personne();
        unePersonne.setNom("EL MESKIRI");
        unePersonne.setPrenom("Brian");
        unePersonne.setAge(20);


        Personne uneDeuxiemePersonne = new Personne();
        uneDeuxiemePersonne.setNom("HOFFMANN");
        uneDeuxiemePersonne.setPrenom("Théo");
        uneDeuxiemePersonne.setAge(18);

        //System.out.println(unePersonne.isMajeur());

        Personne[] listePersonnes = {unePersonne, uneDeuxiemePersonne};


        //while
        int index = 0;
        while(index < listePersonnes.length){
            //System.out.println(listePersonnes[index].getNom());
            index ++;
        }


        //for
        for (int i = 0; i < listePersonnes.length; i ++){
            //System.out.println(listePersonnes[i].getPrenom());
        }


        //foreach
        for (Personne unePers : listePersonnes) {
            //System.out.println(unePers.getAge());
        }


        ArrayList<Personne> listePersonnes2 = new ArrayList<Personne>();
        listePersonnes2.add(unePersonne);
        listePersonnes2.add(uneDeuxiemePersonne);
        //System.out.println(listePersonnes2.get(0).getNom());


        HashMap<String, Personne> mapPersonne = new HashMap<>();
        mapPersonne.put("brian", unePersonne);
        mapPersonne.put("theo", uneDeuxiemePersonne);
        //System.out.println(mapPersonne.get("brian").getNom());


        Etudiant JeanDupont = new Etudiant();
        JeanDupont.setNoteGlobale(20);


        //Suite
        new CasseBrique();

    }

}