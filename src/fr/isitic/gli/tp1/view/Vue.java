package fr.isitic.gli.tp1.view;

import fr.isitic.gli.tp1.controller.IController;
import fr.isitic.gli.tp1.model.Adapter;
import fr.isitic.gli.tp1.model.IModel;
import fr.isitic.gli.tp1.model.Item;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JComponent;


public class Vue extends JComponent implements MouseListener
{
    Graphics2D g2d;
    IModel adapter;
    IController controller;
    Random rand = new Random();

    String mTexte;

    Shape[] shapes ;
    Color[] colors;

    public Vue(IModel im, IController ic) {
        mTexte = new String("Hello");
        adapter = im;
        controller = ic;
        addMouseListener(this);
        init();
        initVue();
    }

    public void init(){

        shapes = new Shape[this.adapter.getItems().size()];
        colors = new Color[this.adapter.getItems().size()];
        Random rand = new Random();
        for(int i = 0 ; i < this.adapter.getItems().size(); i++) {
            colors[i] = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
        }
    };


    public void initVue(){


        Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
        arc.setFrame(100, 150, 200, 200);
        double total = 0;
        for(Item it : this.adapter.getItems()){
            total+=it.getValeur();
        }
        double currentValue = 0;
        int angleDepart = 0;
        int i = 0;
        for(Item it : this.adapter.getItems()) {
            angleDepart = (int) (currentValue * 360 / total);
            int arcAngle = (int) (it.getValeur() * 360 / total);
            shapes[i] = new Arc2D.Double(100, 150, 200, 200, angleDepart, arcAngle, Arc2D.PIE);
            currentValue += it.getValeur();
            i++;
        }
    }

    public void paint(Graphics g) {


        int i = 0;
        for(Shape sh : shapes){
            g.setColor(colors[i]);
            ((Graphics2D) g).draw(sh);
            g.setColor(colors[i]);
            ((Graphics2D) g).fill(sh);

            i++;
            drawCenteredCircle((Graphics2D) g,250,50,100);
            g.setColor(Color.black);
            g.drawRect(50,50,100,100);
            g.setColor(Color.white);
            g.fillRect(50,50,100,100);
        }
    }




    public void drawCenteredCircle(Graphics2D g, int x, int y, int r) {
        x = x-(r/2);
        y = y-(r/2);
        g.fillOval(x,y,r,r);
        g.setColor(Color.blue);
        g.drawString("Budget \n 1000",250,50);

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
    public void mouseClicked(MouseEvent e) {
        initVue();
        for (int i = 0; i < shapes.length; i++) {
            Shape shape = shapes[i];
            if (shape.contains(e.getPoint())) {
                System.out.println("x :" + e.getX() + "y: "+ e.getY());
                Arc2D arc = (Arc2D) shapes[i];
                shapes[i] = new Arc2D.Double(0, 50, 400, 400, arc.getAngleStart(), arc.getAngleExtent(), Arc2D.PIE);
            }
        }
        // et renvoyer vers le controlleur
        mTexte = "Mouse at "+e.getX()+"x"+e.getY();
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
