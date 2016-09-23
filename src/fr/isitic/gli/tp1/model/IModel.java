package fr.isitic.gli.tp1.model;

import fr.isitic.gli.tp1.view.IObservateur;

import java.util.List;

/**
 * Created by tp15009314 on 16/09/16.
 */
public interface IModel {
    public void addItem(Item item);

    public void removeItem(Item item);

    public String getTitre();

    public void setTitre(String titre);

    public List<Item> getItems();

    public void notifierObserver(String action);


    public void addObservateur(IObservateur o);

    public void removeObservateur(IObservateur o);
}