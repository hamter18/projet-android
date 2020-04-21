/**Importation du package */
package iut.reignrise.projet.Modeles;

/**
 * Classe permettant de vérifier si la partie est terminée ou non
 */
public class VerificateurPartie {
    private Integer barres[];

    public VerificateurPartie(Integer barres[]){
        this.barres = barres;
    }

    /**
     * Méthode qui indique si la partie doit se finir ou non
     * @return
     */
    public boolean partiefinie(){
        for(Integer barre : barres ){
            if (barre >= 100)
                return true;
        }
        return false;
    }
}
