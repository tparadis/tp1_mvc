package fr.isitic.gli.tp1.model;

/**
 * Created by tp15009314 on 16/09/16.
 */
public class Item {

    private String titre;
    private String intitule;
    private int valeur;

    public Item(String titre, String intitule, int valeur) {
        this.titre = titre;
        this.intitule = intitule;
        this.valeur = valeur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}
