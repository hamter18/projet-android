/**Importation du pakage */
package iut.reignrise.projet.Adapters;

/**Autres importations*/
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import iut.reignrise.projet.Metiers.Carte;
import iut.reignrise.projet.Metiers.ListeCarte;
import iut.reignrise.projet.R;

import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Cette classe permet de créer nos cartes
 */
public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder> {

    /**
     * Nos variables
     * @param cartes : notre liste de carte pour notre objets "CardStackView"
     * @param listecarteCourante : représente les cartes "passées"
     * @param listeCarte : représente la liste des cartes disponible
     */
    private List<Carte> cartes;
    private List<Carte> listecarteCourante = new ArrayList<Carte>();
    private ListeCarte listeCarte = new ListeCarte();

    /**
     * Constructeur de la classe
     * @param cartes : notre liste de carte pour notre objets "CardStackView"
     */
    public CardStackAdapter(List<Carte> cartes) {
        this.cartes = cartes;
    }

    /**
     * Permet de créer le ViewHolder nécessaire à la création de l'objet "CardStackView"
     * @param parent : objet parent
     * @param viewType : le type
     * @return le ViewHolder
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.carte_view, parent, false);
        return new ViewHolder(view);
    }

    /**
     * Permet de lier les éléments de la carte au ViewHolder
     * @param holder : le ViewHolder
     * @param position : la position de la carte dans la liste de carte
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(position==cartes.size()-4){
            for(int j = 0; j<listeCarte.getListeCarte().size(); j++){
                cartes.add(listeCarte.getListeCarte().get(j));
            }
        }
        listecarteCourante.add(cartes.get(position));
        holder.setData(cartes.get(position));
    }

    /**
     * Permet de connaitre le notre de carte dans la liste de carte
     * @return la taille de la liste
     */
    @Override
    public int getItemCount() {
        return cartes.size();
    }

    /**
     * Permet de recuperer les elements nessessaire a la construction de la carte
     */
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView nom, dilemme;
        ViewHolder(@NonNull View carteView) {
            super(carteView);
            image = itemView.findViewById(R.id.carte_image);
            nom = itemView.findViewById(R.id.carte_name);
            dilemme = itemView.findViewById(R.id.carte_dilemme);
        }
        void setData(Carte maCarte) {
            Picasso.get()
                    .load(maCarte.getImg())
                    .fit()
                    .centerCrop()
                    .into(image);

            nom.setText(maCarte.getName());
            dilemme.setText(maCarte.getDilemme());
        }
    }

    /**
     * Permet de récupérer les carte qui sont deja passer
     * @return la liste des cartes deja passees
     */
    public List<Carte> getCarteCourante(){
        return listecarteCourante;
    }
}
