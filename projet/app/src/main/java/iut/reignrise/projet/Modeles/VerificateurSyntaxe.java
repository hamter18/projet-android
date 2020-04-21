/**Importation du package */
package iut.reignrise.projet.Modeles;

/**
 * Classe permettant de vérifier le pseudo du joueur
 */
public class VerificateurSyntaxe {

    public VerificateurSyntaxe(){}

    /**
     * Méthode vérifiant si le pseudo est correct ou non
     * @param pseudo
     * @return
     */
    public boolean verifierPseudo(String pseudo){
        if(pseudo.length()==0 || pseudo.trim().length()==0){
            return true;
        }
        return false;
    }
}
