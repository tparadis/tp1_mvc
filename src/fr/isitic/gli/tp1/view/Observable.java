package fr.isitic.gli.tp1.view;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tp15009314 on 19/09/16.
 */
public class Observable   {

    private List<IObservateur> observateurs;

    public Observable() {
        this.observateurs = new ArrayList<IObservateur>();
    }

    public void notifierObserver (String action){
        for (IObservateur o : observateurs){
            o.notifier(action);
        }
    }

    public void addObservateur(IObservateur o) {
        observateurs.add(o);
    }

    public void removeObservateur(IObservateur o) {
        observateurs.remove(o);
    }


}
