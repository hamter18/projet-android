/**Importation du package */
package iut.reignrise.projet.Metiers;

/**Autres importations*/
import java.util.ArrayList;

/**
 * Classe permettant de contenir une liste de cartes
 */
public class ListeCarte {
    private ArrayList<Carte> listeCarte;

    /**
     * Constructeur de ListeDeCarte
     */
    public ListeCarte() {
        CreateurCartes createur = new CreateurCartes();
        listeCarte = createur.creerCartes();
    }
    public ArrayList<Carte> getListeCarte() {
        return listeCarte;
    }
}
