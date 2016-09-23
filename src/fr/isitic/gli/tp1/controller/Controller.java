package fr.isitic.gli.tp1.controller;

import fr.isitic.gli.tp1.model.Item;
import fr.isitic.gli.tp1.model.TableModel;
import fr.isitic.gli.tp1.view.Vue;

/**
 * Created by tp15009314 on 16/09/16.
 */
public class Controller implements IController{
    private Vue vue;
    private TableModel tableModel;

    public Controller() {

    }

    public void clickShape(int i){
            vue.changeShape(i);
    }

    public Vue getVue() {
        return vue;
    }

    public void setVue(Vue vue) {
        this.vue = vue;
    }

    public void clickButton(int i, String button) {
       switch(button){
           case "right" :
               if(i <= 0)i+=vue.getShapes().length;
               vue.changeShape((i-1)%vue.getShapes().length);
               break;
           case "left" :
               vue.changeShape((i+1)%vue.getShapes().length);
                break;
           case "add":
             //  tableModel.addItem();
               break;
           case "remove":
               tableModel.removeItem(i);
               break;
           default:
               System.err.println("Erreur controller");
       }
    }
/*
    public void clickButton(int i, String button) {
        if (button == "right") {
            if(i <= 0)i+=vue.getShapes().length;
            vue.changeShape((i-1)%vue.getShapes().length);
        } else if (button == "left") {

            vue.changeShape((i+1)%vue.getShapes().length);
        } else {
            System.err.println("Erreur controller");
        }
    }*/
}
