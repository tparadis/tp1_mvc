package fr.isitic.gli.tp1.view;

import fr.isitic.gli.tp1.controller.IController;
import fr.isitic.gli.tp1.model.Adapter;
import fr.isitic.gli.tp1.model.IModel;
import fr.isitic.gli.tp1.model.Item;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;


public class Vue extends JComponent implements MouseListener
{
    Graphics2D g2d;
    IModel adapter;
    IController controller;

    String mTexte;

    public Vue(IModel im, IController ic) {
        mTexte = new String("Hello");
        adapter = im;
        controller = ic;
        addMouseListener(this);
    }

    class Slice {
        double value;
        Color color;
        public Slice(double value, Color color) {
            this.value = value;
            this.color = color;
        }
    }
//public
    //for(Item item i)
    
    Slice[] slices = {
            new Slice(5, Color.black),
            new Slice(33, Color.green),
            new Slice(20, Color.yellow),
            new Slice(15, Color.red)
    };

    public void paint(Graphics g) {
        drawPie((Graphics2D) g, getBounds(), slices);
    }

    void drawPie(Graphics2D g, Rectangle area, Slice[] slices) {
        double total = 0.0D;
        for (int i = 0; i < slices.length; i++) {
            total += slices[i].value;
        }
        double curValue = 0.0D;
        int startAngle = 0;
        for (int i = 0; i < slices.length; i++) {
            startAngle = (int) (curValue * 360 / total);
            int arcAngle = (int) (slices[i].value * 360 / total);
            g.setColor(slices[i].color);
            g.fillArc(area.x, area.y, area.width, area.height,
                    startAngle, arcAngle);
            curValue += slices[i].value;
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension d = getSize();

        g2d = (Graphics2D) g;


        g2d.setColor(Color.RED);
        Rectangle2D rect2D = new Rectangle(0+10, 0+10, d.width-10, d.height-10);
        g2d.fill(rect2D);


        g2d.setFont(new Font("Arial", Font.BOLD, 14));
        g2d.setColor(Color.WHITE);

        // TODO: utilisation des données du IModel pour l'affichage
        g2d.drawString( mTexte , 20, 34);


    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        // TODO Auto-generated method stub

        // TODO: vérifier si un quartier de camembert a été selectionné
        // et renvoyer vers le controlleur
        mTexte = "Mouse at "+arg0.getX()+"x"+arg0.getY();
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }


    public void notifyView(IModel imodel) {

    }
}
