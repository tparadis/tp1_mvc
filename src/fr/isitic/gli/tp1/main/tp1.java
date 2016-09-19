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

    public static void main(String args[]){
        Item item1 = new Item("loyer","un logement c'est pas gratuit", 150);
        Item item2 = new Item("nourriture","il faut manger pour vivre", 170);
        Item item3 = new Item("loisirs","texte bidon", 90);
        Item item4 = new Item("divers","blablabla", 190);
        List<Item> items = new ArrayList<Item>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        Model model = new Model("Budget",items);
        Controller controller = new Controller();
        Adapter adapter = new Adapter(model);

        Vue vue = new Vue(adapter,controller) ;

        JFrame frame = new JFrame();
        frame.getContentPane().add(vue);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
