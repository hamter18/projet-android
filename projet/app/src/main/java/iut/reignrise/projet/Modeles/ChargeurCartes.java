/**Importation du package */
package iut.reignrise.projet.Modeles;

/**Autres importations*/
import android.database.Cursor;
import iut.reignrise.projet.DataManagers.CarteManager;
import iut.reignrise.projet.Metiers.Carte;
import java.util.*;

/**
 * Classe permettant de charger les cartes depuis la BDD
 */
public class ChargeurCartes {
/**
 * @param cm: Permet de relier à la base de données
 */
    private CarteManager cm;

    public ChargeurCartes(CarteManager carteManager){
        cm=carteManager;
    }

    /**
     * méthode permettant de charger les cartes depuis la base de données
     * @param cartes tableau de cartes dans lequel doivent êtres ajoutées chaques cartes
     */
    public void chargerCartes(ArrayList<Carte> cartes){
        cm.open();
        Cursor c = cm.getCartes();
        if(c.moveToFirst()){
            Carte carte = new Carte();
            int influences[] = new int[3];
            do{
                carte.setId_carte(c.getInt(c.getColumnIndex(CarteManager.CLE_ID_CARTE)));
                carte.setName(c.getString(c.getColumnIndex(CarteManager.CLE_NOM_CARTE)));
                carte.setImg(c.getInt(c.getColumnIndex(CarteManager.CLE_IMG_CARTE)));
                carte.setDilemme(c.getString(c.getColumnIndex(CarteManager.CLE_DILEMME_CARTE)));
                influences[0] = c.getInt(c.getColumnIndex(CarteManager.CLE_INFLUENCE_JAUGE_1));
                influences[1] = c.getInt(c.getColumnIndex(CarteManager.CLE_INFLUENCE_JAUGE_2));
                influences[2] = c.getInt(c.getColumnIndex(CarteManager.CLE_INFLUENCE_JAUGE_3));
                carte.setInfluences(influences);
                cartes.add(carte);
            }while(c.moveToNext());
        }
        c.close();
        cm.close();
    }
}
