/**Importation du pakage */
package iut.reignrise.projet.Vues;

/**Autres importations*/
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import iut.reignrise.projet.Controleurs.ClickController;
import iut.reignrise.projet.DataManagers.CarteManager;
import iut.reignrise.projet.Managers.ClicManager;
import iut.reignrise.projet.Modeles.ChargeurCartes;
import iut.reignrise.projet.Metiers.ListeCarte;
import iut.reignrise.projet.Modeles.NetoyeurID;
import iut.reignrise.projet.Modeles.GPS;
import iut.reignrise.projet.R;


/**
 * Activité sur la quelle on est au démarrage de l'application
 */
public class MainActivity extends AppCompatActivity{
    /**Variable permettant le passage de donnée entre les activité */
    public static final String  SURNAME_JOUEUR="surnameJoueur";
    public static final String  PAGE = "MainActivity";

    /**Variable qui correspond a des élément présent dans le code xml*/

    /**Variable permettant de charger les données de la BDD*/

    private ListeCarte listeCarte;

    private static final int REQUEST_CODE_LOCATION_PERMISSION = 1;
    private TextView textAdresse;
    private ResultReceiver resultReceiver;
    private static final String SAVED_NAME="savedName";
    private EditText editText;
    private ClickController clickController;
    private ClicManager clicManager;
    private GPS gps;
    private String namer;

    /*-------------------------------------------------------------------------------------------------------------------------------------------*/

    /**
     * Fonction qui crée l'activité
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        clicManager = new ClicManager();
        clickController = new ClickController(clicManager);
        if (savedInstanceState != null){
            namer = savedInstanceState.getString(SAVED_NAME);
        }
        resultReceiver = new AdressResultReceiver(new Handler());
        gps = new GPS(this,resultReceiver,this);
        listeCarte = new ListeCarte();
        ChargeurCartes chargeurCartes = new ChargeurCartes(new CarteManager(this));
        chargeurCartes.chargerCartes(listeCarte.getListeCarte());
        setContentView(R.layout.activity_main);
        textAdresse = findViewById(R.id.textAdresse);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        editText =(EditText) findViewById(R.id.editTextSurname);
        namer = savedInstanceState.getString(SAVED_NAME);
        editText.setText(namer);
    }


    // invoked when the activity may be temporarily destroyed, save the instance state here
    @Override
    public void onSaveInstanceState(Bundle outState) {
        editText =(EditText) findViewById(R.id.editTextSurname);
        String namer = editText.getText().toString();
        outState.putString(SAVED_NAME, namer);
        super.onSaveInstanceState(outState);
    }
    /*-------------------------------------------------------------------------------------------------------------------------------------------*/
    /**Méthodes qui permettent de géger le cycle de vie d'une application **/

    /**
     * Méthode appeller à la création de l'activité, elle permet de créer les instances nécessaire au chargement
     * des données de la base de donnée
     */
    @Override
    protected void onStart(){
        super.onStart();
        if(ContextCompat.checkSelfPermission(
                getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION
        )!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_CODE_LOCATION_PERMISSION
            );
        }else{
            gps.getCurrentLocation(this);
        }
    }

    /*-------------------------------------------------------------------------------------------------------------------------------------------*/


    /**
     * Cette fonction détecte si l'utilisateur appuit sur la flèche retour du téléphone
     */
    @Override
    public void onBackPressed() {
        clicManager.clicQuitter(this);
    }
    /*-------------------------------------------------------------------------------------------------------------------------------------------*/


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_CODE_LOCATION_PERMISSION && grantResults.length > 0){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                gps.getCurrentLocation(this);
            }else{
                Toast.makeText(this, "Permission refusée", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void clic(View view){
        editText = (EditText) findViewById(R.id.editTextSurname);
        NetoyeurID netoyeurID = new NetoyeurID();
        String pseudo = editText.getText().toString();
        TextView textErreur = (TextView) findViewById(R.id.textErreur);
        clickController.gererAction( textErreur, pseudo,netoyeurID.getID(view),this,view,this);
    }

    private class AdressResultReceiver extends ResultReceiver{
        public AdressResultReceiver(Handler handler) {
            super(handler);
        }
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData){
            super.onReceiveResult(resultCode,resultData);
            if(resultCode == Constantes.SUCCESS_RESULT){
                textAdresse.setText(resultData.getString(Constantes.RESULT_DATA_KEY));
            }else{
                Toast.makeText(MainActivity.this,resultData.getString(Constantes.RESULT_DATA_KEY),Toast.LENGTH_SHORT).show();
            }
        }
    }
}

