/**Importation du package */
package iut.reignrise.projet.DataManagers;

/**Autres importations*/
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


/**
 * Classe qui permet de manipuler des objets Carte en base de données
 */
public class CarteManager {

    /**
     * @param TABLE_NAME : Nom de la table en base de données
     * @param CLE_ID_CARTE : ID de la carte au sein de la base de données
     * @param CLE_NOM_CARTE : Nom de la carte en base de données
     * @param CLE_IMG_CARTE : Image de la carte en base de données
     * @param CLE_DILEMME_CARTE : Dilemme de la carte
     * @param CLE_INFLUENCE_JAUGE_1 : Indique la manière dont est influencée la première jauge (richesse)
     * @param CLE_INFLUENCE_JAUGE_2 : Indique la manière dont est influencée la deuxième jauge (pouvoir)
     * @param CLE_INFLUENCE_JAUGE_3 : Indique la manière dont est influencée la troisème jauge (révole)
     * @param CREATE_TABLE_CARTE : permet de créer la table quand la base de donnée est crée ou mise à jour
     * @param data_reings : Objet de type BDD afin de pouvoir entrer en interaction avec la base de données en récupérant une instance de cette dernière
     * @param bd : Objet permettant d'insérer de nouvelles données
     */
    private static final String TABLE_NAME ="carte";
    public static final String CLE_ID_CARTE ="id_carte";
    public static final String CLE_NOM_CARTE ="name";
    public static final String CLE_IMG_CARTE = "img";
    public static final String CLE_DILEMME_CARTE = "dilemme";
    public static final String CLE_INFLUENCE_JAUGE_1 = "influence_jauge_1";
    public static final String CLE_INFLUENCE_JAUGE_2 = "influence_jauge_2";
    public static final String CLE_INFLUENCE_JAUGE_3 = "influence_jauge_3";
    public static final String CREATE_TABLE_CARTE = "CREATE TABLE "+TABLE_NAME+
            " ("+
            " "+CLE_ID_CARTE+" INTEGER primary key,"+
            " "+CLE_NOM_CARTE+" TEXT,"+
            " "+CLE_IMG_CARTE+" INTEGER,"+
            " "+CLE_DILEMME_CARTE+" TEXT,"+
            " "+CLE_INFLUENCE_JAUGE_1+" INTEGER,"+
            " "+CLE_INFLUENCE_JAUGE_2+" INTEGER,"+
            " "+CLE_INFLUENCE_JAUGE_3+" INTEGER"+
            ");";
    private BDD data_reigns;
    private SQLiteDatabase bd;

    /**
     * Constructeur du CarteManager
     * @param context
     */
    public CarteManager(Context context){
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
     * Permet de récupérer un ensemble de cartes en base de données des objets de type carte
     * @return un ensemble de cartes
     */
    public Cursor getCartes(){
        return bd.rawQuery("SELECT * FROM "+TABLE_NAME,null);
    }

}

