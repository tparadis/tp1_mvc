package fr.isitic.gli.tp1.model;

import fr.isitic.gli.tp1.controller.Controller;
import fr.isitic.gli.tp1.view.Vue;

import java.util.List;

/**
 * Created by tp15009314 on 16/09/16.
 */
public class Adapter implements IModel {
    private Model model;

    public Adapter(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public void addItem(Item i ) {
        model.getItems().add(i);
        //// TODO: 19/09/16
        //this.notifierObserver();
    }

    @Override
    public void removeItem(Item i) {
        model.getItems().add(i);
    }

    @Override
    public String getTitre() {
       return model.getTitre();
    }

    @Override
    public void setTitre(String titre) {
        model.setTitre(titre);
    }

    @Override
    public List<Item> getItems() {
        return model.getItems();
    }

    @Override
    public void setItems(String titre) {
        model.setTitre(titre);

    }
}
