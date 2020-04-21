/**Importation du package */
package iut.reignrise.projet.Vues;

/**Autres importations*/
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import iut.reignrise.projet.Controleurs.ClickController;
import iut.reignrise.projet.Managers.ActionManager;
import iut.reignrise.projet.Managers.CardManager;
import iut.reignrise.projet.Managers.ClicManager;
import iut.reignrise.projet.Managers.DialogueManager;
import iut.reignrise.projet.Managers.PartieManager;
import iut.reignrise.projet.Modeles.CalculateurPoints;
import iut.reignrise.projet.Adapters.CardStackAdapter;
import iut.reignrise.projet.DataManagers.ScoreManager;
import iut.reignrise.projet.Metiers.ListeCarte;
import iut.reignrise.projet.Metiers.ListeScore;
import iut.reignrise.projet.Modeles.NetoyeurID;
import iut.reignrise.projet.Metiers.Score;
import iut.reignrise.projet.R;

import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;

/**
 * Activité de la partie
 */
public class GameActivity extends AppCompatActivity {

    private ScoreManager sm = new ScoreManager(this);
    private ListeScore listeScore = new ListeScore();
    public static final String  SURNAME_JOUEUR="surnameJoueur";
    private Integer barres[] = {0,0,0};
    private String pseudo;
    private ListeCarte listeCarte = new ListeCarte();
    private CardStackLayoutManager manager;
    private CardStackAdapter adapter;
    private ClickController clickController;
    private DialogueManager dialogueManager;
    private ActionManager actionManager;
    private CalculateurPoints calculateurPoints;
    private PartieManager pm;
    private CardManager cardManager;
    private FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    private FragmentJauge fragment1 = FragmentJauge.newInstance("Pouvoir");
    private FragmentJauge fragment2 = FragmentJauge.newInstance("Richesse");
    private FragmentJauge fragment3 = FragmentJauge.newInstance("Révolte");
    private FragmentJauge fragments[] = {fragment1,fragment2,fragment3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pm = new PartieManager(barres);
        calculateurPoints = new CalculateurPoints(barres,fragments,pm);
        actionManager = new ActionManager(calculateurPoints);
        clickController = new ClickController(new ClicManager());
        dialogueManager = new DialogueManager();
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        cardManager = new CardManager();
        pseudo = intent.getStringExtra(MainActivity.SURNAME_JOUEUR);
        ft.replace(R.id.fragment1, fragments[0]);
        ft.replace(R.id.fragment2, fragments[1]);
        ft.replace(R.id.fragment3, fragments[2]);
        ft.commit();
        CardStackView cardStackView = findViewById(R.id.carte_view);
        manager = new CardStackLayoutManager(this, new CardStackListener() {
            @Override
            public void onCardDragging(Direction direction, float ratio) {
            }
            @Override
            public void onCardSwiped(Direction direction) {
                if (direction == Direction.Right){
                    Toast.makeText(GameActivity.this, "Oui", Toast.LENGTH_SHORT).show();
                    actionManager.action(true,adapter);
                }
                if (direction == Direction.Left){
                    Toast.makeText(GameActivity.this, "Non", Toast.LENGTH_SHORT).show();
                    actionManager.action(false,adapter);
                }
                if(pm.getVerificateurPartie().partiefinie()) {
                    terminerPartie();
                }
            }
            @Override
            public void onCardRewound() {}
            @Override
            public void onCardCanceled() {}
            @Override
            public void onCardAppeared(View view, int position) {}
            @Override
            public void onCardDisappeared(View view, int position) {}
        });
        cardManager.initialiserSwipeCartes(manager);
        adapter = new CardStackAdapter(listeCarte.getListeCarte());
        cardManager.parametrerSwipe(cardStackView,adapter,manager);
    }

    @Override
    protected  void onStart(){
        super.onStart();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    public void clic(View view){
        NetoyeurID netoyeurID = new NetoyeurID();
        clickController.gererAction(null, pseudo,netoyeurID.getID(view),this,view,this);
    }

    public void terminerPartie(){
        int score = pm.calculeDuScore(calculateurPoints.getCompteurDeCarte());
        sm.sauvegardeScore(new Score(1, pseudo, score));
        Intent intent = new Intent(this, ActivityTableauDesScores.class);
        listeScore.ajouterScore(new Score(20, pseudo, score));
        intent.putExtra(SURNAME_JOUEUR, pseudo);
        this.finish();
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}
