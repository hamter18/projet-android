/**Importation du package */
package iut.reignrise.projet.Modeles;

/**Autres importations*/
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Looper;
import android.os.ResultReceiver;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

/**
 * Classe permettant de récupoérer la position GPS
 */
public class GPS {
    /**
     * @param activity: activité
     * @param  resultReceiver : permet de stocker le résultat de la géolocalisation
     * @param context: contexte de l'activité
     */
    private Activity activity;
    private ResultReceiver resultReceiver;
    private Context context;

    public GPS(Activity activity,ResultReceiver resultReceiver,Context context){
        this.activity=activity;
        this.resultReceiver=resultReceiver;
        this.context=context;
    }

    /**
     * Methode récupérant l'adresse actuelle du joueur
     * @param activity
     */
    public void getCurrentLocation(final Activity activity){
        final LocationRequest locationRequest = new LocationRequest();
        locationRequest.setInterval(10000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationServices.getFusedLocationProviderClient(activity)
                .requestLocationUpdates(locationRequest,new LocationCallback(){

                    @Override
                    public void onLocationResult(LocationResult locationResult) {
                        super.onLocationResult(locationResult);
                        LocationServices.getFusedLocationProviderClient(activity)
                                .removeLocationUpdates(this);
                        if(locationResult != null && locationResult.getLocations().size() > 0){
                            int latestLocationIndex = locationResult.getLocations().size() -1;
                            double latitude =
                                    locationResult.getLocations().get(latestLocationIndex).getLatitude();
                            double longitude =
                                    locationResult.getLocations().get(latestLocationIndex).getLongitude();
                            Location location = new Location("provederNA");
                            location.setLatitude(latitude);
                            location.setLongitude(longitude);
                            fetchAddressFromLatLong(location);
                        }
                    }
                }, Looper.getMainLooper());
    }

    /**
     * Permet de traduire la longitude et lattitude en adresse précise
     * @param location
     */
    public void fetchAddressFromLatLong(Location location){
        Intent intent = new Intent(context, FetchAddressIntentService.class);
        intent.putExtra(Constantes.RECEIVER,resultReceiver);
        intent.putExtra(Constantes.LOCATION_DATA_EXTRA,location);
        activity.startService(intent);
    }
}
