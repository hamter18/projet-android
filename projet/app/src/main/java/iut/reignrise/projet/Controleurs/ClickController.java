/**Importation du package */
package iut.reignrise.projet.Controleurs;

/**Autres importations*/
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import iut.reignrise.projet.Managers.ClicManager;

/**
 * Classe qui sert de controler, elle permet de gérer les different click de l'application
 */
public class ClickController {

    /**
     * Nos variables
     * @param cm : permet d appeller les fonctions click
     */
    private ClicManager cm;

    /**
     * Constructeur de la classe
     * @param clicManager : permet d appeller les fonctions click
     */
    public ClickController(ClicManager clicManager){
        cm=clicManager;
    }

    /**
     * Permet d'appeller la fonction clic associer a l action de l utilisateur
     * @param textErreur : utiliser dans la main activity, permet de recuperer la textView erreur si besoin
     * @param pseudo : permet de recuper le pseudo du joueur
     * @param bouton : pemret de savoir quel bouton a ete cliquer
     * @param context : permet de savoir le context du click
     * @param view : permet de savoir sur quel view a ete realiser l action
     * @param activity : pemret de connaitre l activite ou l'action a ete realise
     */
    public void gererAction(TextView textErreur, String pseudo, String bouton, Context context, View view, Activity activity){
        switch (bouton){
            case "buttonJouer":
                if (textErreur!=null){
                    cm.clicJouer(textErreur,pseudo,context,activity);
                }
                else{
                    cm.clicJouer(pseudo,context,activity);
                }
                break;
            case "buttonQuitter":
                cm.clicQuitter(context);
                break;
            case "btnParametre":
                cm.clicParametre(context);
                break;
            case "btnScores":
                cm.clicTableauDesScore(context,activity);
                break;
            case "btnNouvellePartie":
                cm.clicNouvellePartie(pseudo,context,activity);
                break;
            default:
                break;
        }
    }
}
