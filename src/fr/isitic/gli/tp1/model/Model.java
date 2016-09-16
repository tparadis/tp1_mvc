package fr.isitic.gli.tp1.model;

import java.util.List;

/**
 * Created by tp15009314 on 16/09/16.
 */
public class Model {

    private String titre;
    private List<Item> items;

    public Model(String titre, List<Item> items) {
        this.titre = titre;
        this.items = items;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
