/**Importation du package */
package iut.reignrise.projet.Managers;

/**Autres importations*/
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import iut.reignrise.projet.Modeles.VerificateurSyntaxe;
import iut.reignrise.projet.R;
import iut.reignrise.projet.Vues.ActivityTableauDesScores;
import iut.reignrise.projet.Vues.GameActivity;
import iut.reignrise.projet.Vues.MainActivity;

public class ClicManager {

    private static final String SURNAME_JOUEUR = "surnameJoueur";
    private static final String PAGE = "Page";
    private DialogueManager dm;
    private VerificateurSyntaxe verificateur;

    public ClicManager(){
        dm = new DialogueManager();
        verificateur = new VerificateurSyntaxe();
    }

    /**Fonction clic de l'application */

    /**Fonction appelé lorsque le joueur appuie sur le button "Quitter" de l'activity
     * */

    public void clicQuitter(Context context) {
        dm.boiteDialogueConfirme(context);
    }
    /**
     /**Fonction appelée lorsque le joueur appuie sur le button "Jouer" de l'activity.
     /* Cette fonction vérifie que le joueur est bien entrer un pseudo pour jouer.
     /* Dans le cas contraire, elle affiche un message d'alerte, indiquant à l'itulisateur qu'
     /* doit rentrer un pseudo.
     /* Sinon le joueur est rediriger vers la page de jeu.
     *
     */

    public void clicJouer(TextView textErreur, String pseudo,Context contexte,Activity activity){
        if(verificateur.verifierPseudo(pseudo)){
            textErreur.setText("vous devez renseigner un surname");
            textErreur.setBackgroundResource(R.color.error);
        }
        else{
            Intent intent = new Intent(contexte, GameActivity.class);
            intent.putExtra(SURNAME_JOUEUR, pseudo);
            activity.finish();
            contexte.startActivity(intent);
        }
    }

    /**
     *Fonction appelée lorsque le joueur appuie sur le button "Jouer" de l'activity.
     *Cette fonction vérifie que le joueur est bien entrer un pseudo pour jouer.
     *Dans le cas contraire, elle affiche un message d'alerte, indiquant à l'itulisateur qu'
     *doit rentrer un pseudo.
     *Sinon le joueur est rediriger vers la page de jeu.
     */
    public void clicJouer( String pseudo,Context contexte,Activity activity){
        Intent intent = new Intent(contexte, GameActivity.class);
        intent.putExtra(SURNAME_JOUEUR, pseudo);
        activity.finish();
        contexte.startActivity(intent);
    }

    /**
     * Fonction appelée lorsque le joueur appuie sur le bouton de paramètre de l'activité
     * Cette fonction fait apparaitre un dialogue indiquant le principe du jeu
     * @param context
     */
    public void clicParametre(Context context) {
        dm.onCreateDialog(context);
    }


    /**
     *Fonction appelée lorsque le joueur appuie sur le trophée de tableau des scores dans la MainActivity
     * Cette fonction nous redirige vers l'activité de tableau des scores
     * @param contexte : contexte de l'activité
     * @param activity : activité
     */
    public void clicTableauDesScore(Context contexte,Activity activity){
        String message = "MainActivity";
        Intent intent = new Intent(contexte, ActivityTableauDesScores.class);
        intent.putExtra(PAGE, message);
        activity.finish();
        contexte.startActivity(intent);
    }

    /**
     * Fonction appelée sur l'activité de tableau des scores lorsqu'on clique sur le bouton pour relancer une partie
     * @param pseudo : pseudo du joueur
     * @param context : contexte de l'activité
     * @param activity : activité
     */
    public void clicNouvellePartie(String pseudo,Context context,Activity activity) {
        if(pseudo!=null){
            Intent intent = new Intent(context, GameActivity.class);
            intent.putExtra(SURNAME_JOUEUR, pseudo);
            activity.finish();
            context.startActivity(intent);
        }
        else{
            Intent intent = new Intent(context, MainActivity.class);
            activity.finish();
            context.startActivity(intent);
        }
    }
}
