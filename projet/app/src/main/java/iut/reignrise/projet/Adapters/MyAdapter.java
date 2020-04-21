/**Importation du pakage */
package iut.reignrise.projet.Adapters;

/**Autres importations*/
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import iut.reignrise.projet.Metiers.Score;
import iut.reignrise.projet.R;
import java.util.ArrayList;

/**
 * Classe qui permet de construire les lignes du tableau de score
 */
public class MyAdapter extends ArrayAdapter<Score> {

    /**
     * Nos variables
     * @param dataSet : score present en base de donnee
     * @param mContext : represente le contexte
     */
    private ArrayList<Score> dataSet;
    private Context mContext;

    /**
     * Constructeur de la classe
     * @param listeDeScore : corresponds a la liste de score
     * @param context : correspond au context
     */
    public MyAdapter(ArrayList<Score> listeDeScore, Context context) {
        super(context, R.layout.row_items, listeDeScore);
        this.dataSet = listeDeScore;
        this.mContext=context;
    }

    /**
     * Class ViewHolder
     * Permet de recuperer les elements de la ligne d'un tableaua remplir (colone du surname et du score )
     */
    private static class ViewHolder {
        private TextView surnameJoueurTab;
        private TextView scoresTab;
    }

    /**
     * Permet de mettre les elements d'une ligne dans cette meme ligne
     * @param position : de quelle ligne il s'agit
     * @param convertView : la view
     * @param parent : le parent
     * @return la view
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        viewHolder = new ViewHolder();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.row_items, parent, false);
        viewHolder.surnameJoueurTab = (TextView) convertView.findViewById(R.id.surnameJoueurTab);
        viewHolder.scoresTab = (TextView) convertView.findViewById(R.id.scoresTab);
        convertView.setTag(viewHolder);
        viewHolder.surnameJoueurTab.setText(getItem(position).getPseudo());
        viewHolder.scoresTab.setText(String.valueOf(getItem(position).getScore()));
        return convertView;
    }
}
