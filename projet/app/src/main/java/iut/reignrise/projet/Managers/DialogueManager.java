/**Importation du package */
package iut.reignrise.projet.Managers;

/**Autres importations*/
import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;

public class DialogueManager {


    public DialogueManager(){}

    /**
     * Méthode qui permet de créer une boite de dialogue de confimation, afin de déterminer si l'utilisateur désire réaliement quitter l'application.
     * Si l'utilisateur clique sur annuler, il retourne sur le jeu, dans le cas contraire, l'utilisateur quitte le jeu et ce dernier ce ferme.
     */
    public void boiteDialogueConfirme(Context contexte){
        new AlertDialog.Builder(contexte)
                .setTitle("Quitter")
                .setMessage("Voulez vous vraiment quitter ?")
                .setPositiveButton(android.R.string.yes,
                        new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int which)
                            {
                                System.exit(0);
                            }
                        })
                .setNegativeButton(android.R.string.cancel,
                        new DialogInterface.OnClickListener()
                        {
                            public void onClick(DialogInterface dialog, int which)
                            {
                            }
                        })
                .create()
                .show();
    }

    /**
     * Permet de créer une boite de dialogue pour les paramètres
     * @param context
     */
    public void onCreateDialog (Context context) {
        new AlertDialog.Builder(context)
                .setTitle("Reigns like")
                .setMessage("Le but de ce jeu est d'avoir le plus richesse et de pouvoir possible tout en évitant une révolte de la population." +
                        "Pour cela vous devez choisir entre deux choix possible une action. A vous de vous pour devenir le dieu de votre " +
                        "ville sans mécontenter vos concitoyens ! ")
                .setNeutralButton(android.R.string.ok, null)
                .show();
    }
}
