/**Importation du package */
package iut.reignrise.projet.Vues;

/**Autres importations*/
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import iut.reignrise.projet.Adapters.MyAdapter;
import iut.reignrise.projet.Controleurs.ClickController;
import iut.reignrise.projet.DataManagers.ScoreManager;
import iut.reignrise.projet.Managers.ClicManager;
import iut.reignrise.projet.Modeles.ChargeurScores;
import iut.reignrise.projet.Metiers.ListeScore;
import iut.reignrise.projet.Modeles.NetoyeurID;
import iut.reignrise.projet.R;

/**
 * Classe de l'activité de tableau des scores
 */
public class ActivityTableauDesScores extends AppCompatActivity {
    private String message;
    private String nomJoueur;
    private ListeScore listeScore= new ListeScore();
    private ChargeurScores chargeurScores;
    private ClickController clickController;
    private ListView listView;
    private static MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        clickController = new ClickController(new ClicManager());
        setContentView(R.layout.activity_tableau_des_scores);
        chargeurScores = new ChargeurScores(new ScoreManager(this));
        chargeurScores.chargerScores(listeScore.getListeScore());
        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.PAGE);
        Intent intent2 = getIntent();
        nomJoueur = intent2.getStringExtra(GameActivity.SURNAME_JOUEUR);
        adapter= new MyAdapter(listeScore.getListeScore(), this);
        listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();

    }
    public void clic(View view){
        NetoyeurID netoyeurID = new NetoyeurID();
        clickController.gererAction( null,nomJoueur,netoyeurID.getID(view),this,view,this);
    }
}
