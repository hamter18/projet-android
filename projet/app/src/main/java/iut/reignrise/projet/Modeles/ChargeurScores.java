/**Importation du package */
package iut.reignrise.projet.Modeles;

/**Autres importations*/
import android.database.Cursor;
import iut.reignrise.projet.DataManagers.ScoreManager;
import iut.reignrise.projet.Metiers.Score;
import java.util.ArrayList;

/**
 * Classe permettant de charger les scores depuis la base de données
 */
public class ChargeurScores {
    /**
     * @param sm: manager permettant la liaison avec la base de données
     */
    private ScoreManager sm;

    public ChargeurScores(ScoreManager scoreManager){
        sm=scoreManager;
    }

    /**
     * méthode permettant de charger les scores depuis la base de données
     * @param scores liste des scores à remplir
     */
    public void chargerScores(ArrayList<Score> scores){
        sm.open();
        Cursor c = sm.getScores();
        if(c.moveToFirst()){
            do {
                Score score = new Score();
                score.setIdScore(c.getInt(c.getColumnIndex(ScoreManager.CLE_ID_SCORE)));
                score.setScore(c.getInt(c.getColumnIndex(ScoreManager.CLE_SCORE)));
                score.setPseudo(c.getString(c.getColumnIndex(ScoreManager.CLE_PSEUDO)));
                scores.add(score);
            }while(c.moveToNext());
        }
        c.close();
        sm.close();
    }
}
