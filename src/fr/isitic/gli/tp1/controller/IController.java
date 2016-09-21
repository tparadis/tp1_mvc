package fr.isitic.gli.tp1.controller;

import fr.isitic.gli.tp1.view.Vue;

/**
 * Created by tp15009314 on 16/09/16.
 */
public interface IController {

    void clickShape(int i);

    public Vue getVue();

    public void setVue(Vue vue);

    void clickButton(int i, String button);
}
