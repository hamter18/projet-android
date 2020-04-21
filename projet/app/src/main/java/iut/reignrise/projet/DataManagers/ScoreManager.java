/**Importation du package */
package iut.reignrise.projet.DataManagers;

/**Autres importations*/
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import iut.reignrise.projet.Metiers.Score;


/**
 *  Classe qui permet de manipuler des objets Score en base de données
 */
public class ScoreManager {
    /**
     * @param TABLE_NAME : Nom de la table en base de données
     * @param CLE_ID_SCORE : ID du score en base de donnéess
     * @param CLE_PSEUDO : Pseudo stocké en base de données
     * @param CLE_SCORE : Score stocké en base de données
     * @param CREATE_TABLE_SCORE : Permet de créer la table Score à la création ou mise à jour de la base de données
     * @param data_reings : Objet de type BDD afin de pouvoir entrer en interaction avec la base de données en récupérant une instance de cette dernière
     * @param bd : Objet permettant d'insérer de nouvelles données
     */
    private static final String TABLE_NAME = "Score";
    public static final String CLE_ID_SCORE = "id_score";
    public static final String CLE_PSEUDO = "pseudo";
    public static final String CLE_SCORE = "score";
    public static final String CREATE_TABLE_SCORE = "CREATE TABLE "+TABLE_NAME+
            " ("+
            " "+CLE_ID_SCORE+" INTEGER primary key,"+
            " "+CLE_PSEUDO+" TEXT,"+
            " "+CLE_SCORE+" INTEGER"+
            ");";
    private BDD data_reigns;
    private SQLiteDatabase bd;

    /**
     * Constructeur du ScoreManager
     * @param context
     */
    public ScoreManager(Context context){
        data_reigns = BDD.getInstance(context);
    }

    /**
     * Permet l'écrituree en base de données
     */
    public void open(){
        bd = data_reigns.getWritableDatabase();
    }

    /**
     * Permet de refermer l'accès à la base de données
     */
    public void close(){
        bd.close();
    }

    /**
     * Permet d'ajouter un score en base de données
     * @param score
     * @return
     */
    public long addScore(Score score){
        ContentValues data = new ContentValues();
        data.put(CLE_PSEUDO,score.getPseudo());
        data.put(CLE_SCORE,score.getScore());
        return bd.insert(TABLE_NAME,null,data);
    }

    /**
     * Permet d'ajouter un score en base de données en ouvrant fermant l'accès en cette dernière
     * @param score
     */
    public void sauvegardeScore(Score score){
        this.open();
        this.addScore(score);
        this.close();
    }

    /**
     * Permet de récupérer un ensemble de scores en base de données des objets de type score
     * @return un ensemble de scores
     */
    public Cursor getScores() {
        return bd.rawQuery("SELECT * FROM "+TABLE_NAME,null);
    }
}
