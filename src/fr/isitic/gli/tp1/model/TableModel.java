package fr.isitic.gli.tp1.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tp15009314 on 21/09/16.
 */
public class TableModel extends AbstractTableModel {

    private final String[] entetes = { "Titre", "Description", "Valeur"};
    IModel adapter;
    List<Item> items = new ArrayList<Item>();
    public TableModel(IModel adapter) {
        this.adapter = adapter;
        items.addAll(adapter.getItems());
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return entetes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {

            case 0:
                return items.get(rowIndex).getTitre();

            case 1:
                return items.get(rowIndex).getIntitule();

            case 2:

                return items.get(rowIndex).getValeur();

           default:
               throw new IllegalArgumentException();
        }
    }
    @Override
    public String getColumnName(int columnIndex) {
        return entetes[columnIndex];
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return Integer.class;

            default:
                return Object.class;
        }
    }

    public void addItem(Item item) {
        items.add(item);
        fireTableRowsInserted(items.size() -1, items.size() -1);
        adapter.addItem(item);
        adapter.notifierObserver("");
    }

    public void removeItem(int rowIndex) {

        adapter.removeItem(items.get(rowIndex));
        items.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
        adapter.notifierObserver("");

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true; //Toutes les cellules éditables
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(aValue != null){
            Item item = items.get(rowIndex);

            switch(columnIndex){
                case 0:
                    item.setTitre((String)aValue);
                    break;
                case 1:
                    item.setIntitule((String)aValue);
                    break;
                case 2:
                    item.setValeur((int)aValue);
                    break;
            }
            adapter.notifierObserver("update");
        }
    }

}
