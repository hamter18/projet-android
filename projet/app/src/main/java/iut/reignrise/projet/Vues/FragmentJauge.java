/**Importation du package */
package iut.reignrise.projet.Vues;

/**Autres importations*/
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import iut.reignrise.projet.R;

/**
 * Classe gérant les fragments des jauges
 */
public class FragmentJauge extends Fragment {

    public static final String EXTRA_PARAM_1 = "extra_param_1";
    private TextView textProgressBar;
    private ProgressBar barreDeJauge;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_jauge, container, false);
        textProgressBar = (TextView) v.findViewById(R.id.textProgressBar);
        barreDeJauge = (ProgressBar) v.findViewById(R.id.barreDeJauge);
        barreDeJauge.setMax(100);
        String param1 = getArguments().getString(EXTRA_PARAM_1);
        textProgressBar.setText(param1);
        return v;
    }

    public static FragmentJauge newInstance(String param) {
        Bundle args = new Bundle();
        args.putString(EXTRA_PARAM_1, param);
        FragmentJauge fragment = new FragmentJauge();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * méthode gérant la mise à jour des jauges
     * @param jauge
     * @param statusJauge
     * @param dommage
     * @return
     */
    private Integer miseAjourJauge(ProgressBar jauge, Integer statusJauge, Integer dommage) {
        statusJauge = statusJauge + dommage;
        if(statusJauge < 0){
            statusJauge = 0;
        }
        jauge.setProgress(statusJauge);
        return statusJauge;
    }

    /**
     * méthode métant à jour une jauge
     * @param statusJauge
     * @param dommage
     * @return
     */
    public Integer updateJauge (Integer statusJauge, Integer dommage){
        return miseAjourJauge(barreDeJauge, statusJauge, dommage);
    }
}
