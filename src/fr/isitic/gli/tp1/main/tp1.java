package fr.isitic.gli.tp1.main;

import fr.isitic.gli.tp1.controller.AddAction;
import fr.isitic.gli.tp1.controller.Controller;
import fr.isitic.gli.tp1.controller.RemoveAction;
import fr.isitic.gli.tp1.model.*;
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
        List<Item> items = new ArrayList<Item>();
        Item item1 = new Item("loyer","un logement c'est pas gratuit", 150);
        Item item2 = new Item("nourriture","il faut manger pour vivre", 170);
        Item item3 = new Item("loisirs","texte bidon", 90);
        Item item4 = new Item("divers","blablabla", 190);

        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);

        Model model = new Model("Budget",items);
        Controller controller = new Controller();
        Adapter adapter = new Adapter(model);
        TableModel tableModel = new TableModel(adapter);
        JButton left = new JButton("<") ;
        JButton right = new JButton(">");
        JButton add = new JButton(new AddAction(tableModel)) ;

        JTable table = new JTable(tableModel);
        JButton remove = new JButton(new RemoveAction(tableModel,table));

        table.setAutoCreateRowSorter(true);
        Vue vue = new Vue(adapter,controller,right,left) ;

        adapter.addObservateur(vue);
        controller.setVue(vue);

        JFrame frame = new JFrame();

        JScrollPane tablepane = new JScrollPane(table);
        tablepane.setBounds(20,500,360,120);
        left.setBounds(150,400,50,40);
        right.setBounds(200,400,50,40);

        add.setBounds(100,650,100,40);
        remove.setBounds(200,650,100,40);
        frame.add(tablepane);

        frame.add(add);
        frame.add(remove);
        frame.add(left);
        frame.add(right);

        frame.getContentPane().add(vue);
        frame.setSize(400, 700);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

    }
}
