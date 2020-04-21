/**Importation du package */
package iut.reignrise.projet.Managers;

/**
 * Classe permettant de gérer la partie
 */
import iut.reignrise.projet.Modeles.VerificateurPartie;

public class PartieManager {

    /**
     * @param verificateurPartie : Permet de vérifier si la partie est finie
     */

    private VerificateurPartie verificateurPartie;

    /**
     * Constructeur du PartieManager
     * @param barres
     */
    public PartieManager(Integer barres[]){
        verificateurPartie = new VerificateurPartie(barres);
    }

    /**
     * méthode qui permet de calculer le score à la fin de la partie
     * @param compteurDeCarte
     * @return
     */
    public int calculeDuScore(int compteurDeCarte){
        int score;
        score = compteurDeCarte /2;
        return score;
    }

    /**
     * Permet de récupérer le vérificateur de partie
     */
    public VerificateurPartie getVerificateurPartie() {
        return verificateurPartie;
    }
}
