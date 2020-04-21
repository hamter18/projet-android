/**Importation du package */
package iut.reignrise.projet.Managers;

/**Autres importations*/
import android.util.Log;
import iut.reignrise.projet.Modeles.CalculateurPoints;
import iut.reignrise.projet.Adapters.CardStackAdapter;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Classe permettant de gérer les actions de l'utilisateur quand il fait des swipes
 */
public class ActionManager {

    /**
     * @param cm : Calculateur de points permettant de calculer les points
     */
    private CalculateurPoints cm;

    /**
     * Constructeur de l'ActionManager
     * @param cm
     */
    public ActionManager(CalculateurPoints cm){
        this.cm=cm;
    }

    /**
     * Fonction permettant de gérer l'acion du swipe
     * @param action
     * @param cardStackAdapter
     */
    public void action (Boolean action, CardStackAdapter cardStackAdapter){
        long startTime = System.nanoTime();
        if(cm.getCompteurDeCarte()!=0){
            long difference = System.nanoTime() - startTime;
            if(difference<5000){
          //      dm.onCreateDialogMessageErreur(context);
            }
            Log.d("tag","77 difference de temps: " + difference );
            new Timer().schedule(
                    new TimerTask(){
                        @Override
                        public void run(){
                        }
                    }, 2000);
        }
        cm.calculsDesPoints(action,cardStackAdapter);
    }
}
