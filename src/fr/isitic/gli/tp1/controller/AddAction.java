package fr.isitic.gli.tp1.controller;

import fr.isitic.gli.tp1.model.Item;
import fr.isitic.gli.tp1.model.TableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by tp15009314 on 23/09/16.
 */
public class AddAction  extends AbstractAction {
    private TableModel tableModel;
    public AddAction(TableModel tableModel) {
        super("Ajouter");
        this.tableModel = tableModel;
    }

    public void actionPerformed(ActionEvent e) {
         tableModel.addItem(new Item("Nouveau","description",100));
    }
}