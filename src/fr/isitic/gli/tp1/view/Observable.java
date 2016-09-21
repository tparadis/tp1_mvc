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

    public void notifierObserver (){
        for (IObservateur o : observateurs){
            o.notifier();
        }
    }

    public Observable(List<IObservateur> observateurs) {
        this.observateurs = observateurs;
    }

    public void AddObservateur(IObservateur o) {
        observateurs.add(o);
    }

    public void RemoveObservateur(IObservateur o) {
        observateurs.remove(o);
    }

    public List<IObservateur> getObservateurs() {
        return observateurs;
    }

    public void setObservateurs(List<IObservateur> observateurs) {
        this.observateurs = observateurs;
    }
}
