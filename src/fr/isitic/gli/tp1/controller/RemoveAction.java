package fr.isitic.gli.tp1.controller;

import fr.isitic.gli.tp1.model.Item;
import fr.isitic.gli.tp1.model.TableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Created by tp15009314 on 23/09/16.
 */

    public class RemoveAction  extends AbstractAction {
        private TableModel tableModel;
        private JTable table;
        public RemoveAction(TableModel tableModel, JTable table) {
            super("Supprimer");
            this.tableModel = tableModel;
            this.table = table;
        }

        public void actionPerformed(ActionEvent e) {
            int[] selections = table.getSelectedRows();

            for (int i = 0; i < selections.length; i++ )
            tableModel.removeItem(selections[i]);
        }
}
