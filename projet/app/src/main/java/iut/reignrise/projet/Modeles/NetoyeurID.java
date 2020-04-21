/**Importation du package */
package iut.reignrise.projet.Modeles;

/**Autres importations*/
import android.view.View;

/**
 * Classe permettant de récupérer les ID depuis les vues
 */
public class NetoyeurID {

    public NetoyeurID(){}

    public String getID(View view){
        return view.getResources().getResourceName(view.getId()).substring(24);
    }
}
