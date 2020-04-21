/**Importation du package */
package iut.reignrise.projet.Metiers;

/**Autres importations*/
import java.util.ArrayList;

/**
 * Classe permettant de contenir une Liste de scores
 */
public class ListeScore {
    /**
     * @param listeScore : Permet de contneir une liste de scores
     */
    private ArrayList<Score> listeScore = new ArrayList<Score>();

    public ListeScore() {}

    /**
     * Permet de rajouter un nouveau score dans la liste
     * @param newScore
     */
    public void ajouterScore(Score newScore){
        listeScore.add(newScore);
        setListeScore(listeScore);
    }

    public void setListeScore (ArrayList<Score> newListe){
        listeScore =newListe;
    }

    public ArrayList<Score> getListeScore() {
        return listeScore;
    }
}
