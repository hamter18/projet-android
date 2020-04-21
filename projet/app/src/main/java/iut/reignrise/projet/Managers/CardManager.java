/**Importation du package */
package iut.reignrise.projet.Managers;

/**Autres importations*/
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.DefaultItemAnimator;
import iut.reignrise.projet.Adapters.CardStackAdapter;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;
import java.util.ArrayList;

/**
 * Classe permettant d'initialiser le Swipe des cartes
 */
public class CardManager {
    /**
     * Permet d'initialiser le swipe des cartes et les paramètres du manager
     * @param manager
     */
    public void initialiserSwipeCartes(CardStackLayoutManager manager){
        ArrayList<Direction> directions = new ArrayList<Direction>();
        directions.add(Direction.Left);
        directions.add(Direction.Right);
        manager.setStackFrom(StackFrom.None);
        manager.setVisibleCount(3);
        manager.setTranslationInterval(8.0f);
        manager.setScaleInterval(0.95f);
        manager.setSwipeThreshold(0.3f);
        manager.setMaxDegree(20.0f);
        manager.setDirections(directions);
        manager.setCanScrollHorizontal(true);
        manager.setSwipeableMethod(SwipeableMethod.Manual);
        manager.setOverlayInterpolator(new LinearInterpolator());
    }

    /**
     * Permet de parametrer la cardStackView pour le swipe de cartes
     * @param cardStackView
     * @param adapter
     * @param manager
     */
    public void parametrerSwipe(CardStackView cardStackView, CardStackAdapter adapter, CardStackLayoutManager manager){
        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);
        cardStackView.setItemAnimator(new DefaultItemAnimator());
    }

}
