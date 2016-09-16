package fr.isitic.gli.tp1.main;

import fr.isitic.gli.tp1.controller.Controller;
import fr.isitic.gli.tp1.model.Adapter;
import fr.isitic.gli.tp1.model.IModel;
import fr.isitic.gli.tp1.model.Item;
import fr.isitic.gli.tp1.model.Model;
import fr.isitic.gli.tp1.view.Vue;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tp15009314 on 16/09/16.
 */
public class tp1 {

    class Slice {
        double value;
        Color color;
        public Slice(double value, Color color) {
            this.value = value;
            this.color = color;
        }
    }

    public static void main(String args[]){
        Item item1 = new Item("loyer","un logement c'est pas gratuit", 350);
        Item item2 = new Item("nourriture","il faut manger pour vivre", 150);
        Item item3 = new Item("loisirs","changements d'air", 50);
        List<Item> items = new ArrayList<Item>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        Model model = new Model("Budget",items);
        Controller controller = new Controller();
        Adapter adapter = new Adapter(model);

        Vue vue = new Vue(adapter,controller) ;

        JFrame frame = new JFrame();
        frame.getContentPane().add(vue);
        frame.setSize(500, 500);
        frame.setVisible(true);

    }
}
