/**Importation du package */
package iut.reignrise.projet.DataManagers;

/**Autres importations*/
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Classe qui represente notre base de donnee
 */
public class BDD extends SQLiteOpenHelper {

    /**
     * Nos variables
     * @param DATABASE_VERSION : version de la base de donnee
     * @param DATABASE_NAME : corresponds au nom de la base de donnee
     * @param instance : corresponds a l instance de la base de donnee
     * @param context : coresponds au context de la base de donnee
     */
    public static final int DATABASE_VERSION=15;
    public static final String DATABASE_NAME = "data_reigns";
    public static BDD instance;
    public Context context;

    /**
     * Constructeur de la base de donnee
     * @param context : coresponds au context de la base de donnee
     */
    public BDD(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;
    }

    /**
     * Permet de recuperer l instance de la base de donnee
     * @param context : corresponds a l instance de la base de donnee
     * @return l instance de la base de donnee
     */
    public static synchronized BDD getInstance(Context context){
        if(instance == null){
            instance = new BDD(context);
        }
        return instance;
    }

    /**
     * Genere la base de donnee et permet l'execution des requetes des tables
     * @param bd : represente la base de donnee
     */
    @Override
    public void onCreate(SQLiteDatabase bd){
        bd.execSQL(ScoreManager.CREATE_TABLE_SCORE);
        bd.execSQL(CarteManager.CREATE_TABLE_CARTE);
    }

    /**
     * Permet de mettre a jour la base de donnee
     * @param bd represente la base de donnee
     * @param i1
     * @param i2
     */
    @Override
    public void onUpgrade(SQLiteDatabase bd, int i1, int i2){
        bd.execSQL("DROP TABLE IF EXISTS carte");
        bd.execSQL("DROP TABLE IF EXISTS Score");
        onCreate(bd);
    }
}

