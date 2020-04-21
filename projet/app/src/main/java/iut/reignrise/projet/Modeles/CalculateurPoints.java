/**Importation du package */
package iut.reignrise.projet.Modeles;

/**Autres importations*/
import iut.reignrise.projet.Adapters.CardStackAdapter;
import iut.reignrise.projet.Managers.PartieManager;
import iut.reignrise.projet.Metiers.Carte;
import iut.reignrise.projet.Vues.FragmentJauge;

/**
 * Classe permetant de calculer les points d'une partie
 */
public class CalculateurPoints {
    /**
     * @param barres: permets de stocker le remplissage des barres richesse, pouvoir et revolte
     * @param tabFragmentsJauge : permet de stocker les fragments des jauges et de les manipuler
     * @param compteurDeCarte : permet de compter le nombre de cartes passées
     * @param verificateurPartie : permet de vérifier si la partie doit se terminée ou non
     * @param pm : permet de gérer la partie
     */
    private Integer barres[];
    private FragmentJauge tabFragmentJauge[];
    private int compteurDeCarte =0;
    private VerificateurPartie verificateurPartie;
    private PartieManager pm;

    public CalculateurPoints(Integer barres[], FragmentJauge tabFragmentJauge[],PartieManager pm){
        this.barres = barres;
        this.tabFragmentJauge = tabFragmentJauge;
        this.verificateurPartie = new VerificateurPartie(barres);
        this.pm = pm;
    }

    /**
     * Methode permettant de calculer les points en fin de partie
     * @param choix contient le choix du joueur (swipe droit ou gauche)
     * @param adapter
     */
    public void calculsDesPoints(Boolean choix, CardStackAdapter adapter) {
        int influence = 1;
        Carte carte = adapter.getCarteCourante().get(compteurDeCarte);
        int tab[];
        tab = carte.getInfluences();
        compteurDeCarte = compteurDeCarte + 1;
        if (!choix) {
            influence = -1;
        }
        for (int i = 0; i < 3; i++) {
            barres[i] = tabFragmentJauge[i].updateJauge(barres[i], tab[i] * influence);
        }
    }

    public int getCompteurDeCarte() {
        return compteurDeCarte;
    }
}


