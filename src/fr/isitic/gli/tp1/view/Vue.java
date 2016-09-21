package fr.isitic.gli.tp1.view;

import fr.isitic.gli.tp1.controller.Controller;
import fr.isitic.gli.tp1.controller.IController;
import fr.isitic.gli.tp1.model.Adapter;
import fr.isitic.gli.tp1.model.IModel;
import fr.isitic.gli.tp1.model.Item;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.*;


public class Vue extends JComponent implements MouseListener, ActionListener
{
    Graphics2D g2d;
    IModel adapter;
    IController controller;
    Shape[] shapes ;
    Color[] colors;
    Shape whiteCircle;
    JButton right;
    JButton left;

    int memoShape = -1;

    Random rand = new Random();

    public Vue(IModel im, IController ic) {
        adapter = im;
        controller = ic;
        addMouseListener(this);
        init();
        initVue();
    }

    public Vue(IModel im, IController ic, JButton right, JButton left) {
        adapter = im;
        controller = ic;
        addMouseListener(this);
        this.right = right;
        this.left = left;
        this.right.addActionListener(this);
        this.left.addActionListener(this);
        init();
        initVue();
    }

    public Shape[] getShapes() {
        return shapes;
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

        memoShape = -1;
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

        double total = 0;
        for(Item it : this.adapter.getItems()){
            total+=it.getValeur();
        }

        //attention au for each
        for(int i = 0; i < shapes.length; i++){

            g.setColor(colors[i]);
            ((Graphics2D) g).draw(shapes[i]);
            g.setColor(colors[i]);
            ((Graphics2D) g).fill(shapes[i]);
        }

        g.setColor(Color.white);
        whiteCircle = new Arc2D.Double(125, 175, 150, 150, 0, 360, Arc2D.PIE);
        ((Graphics2D) g).draw(whiteCircle);
        ((Graphics2D) g).fill(whiteCircle);
        g.setColor(Color.black);
        drawCenteredCircle((Graphics2D) g,200,250,100);
        g.setColor(Color.white);
        g.drawString("Budget ",175,250);
        g.drawString(""+total,175,270);

        if(memoShape!=-1){
            g.setColor(Color.white);
            g.drawRect(10,10,250,85);
            g.setColor(Color.black);
            ((Graphics2D) g).fillRect(10,10,250,85);
            g.setColor(Color.white);
            g.drawString(adapter.getItems().get(memoShape).getTitre(),25,25);
            g.drawString(adapter.getItems().get(memoShape).getIntitule(),25,40);
        }

    }

    public void drawCenteredCircle(Graphics2D g, int x, int y, int r) {
        x = x-(r/2);
        y = y-(r/2);
        g.fillOval(x,y,r,r);


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



    }
public void changeShape(int i){
    initVue();
    Arc2D arc = (Arc2D) shapes[i];
    shapes[i] = new Arc2D.Double(75, 125, 250, 250, arc.getAngleStart(), arc.getAngleExtent(), Arc2D.PIE);
    memoShape = i;
    repaint();
}


    @Override
    public void mouseClicked(MouseEvent e) {
        initVue();
        for (int i = 0; i < shapes.length; i++) {
            Shape shape = shapes[i];
            if (shape.contains(e.getPoint()) && !(whiteCircle.contains(e.getPoint()))){
                System.out.println("x :" + e.getX() + "y: "+ e.getY());
                controller.clickShape(i);
                break;
            }
        }
        // et renvoyer vers le controlleur
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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (memoShape != -1) {
            System.out.println(memoShape);
            System.out.println(shapes.length);

            if (actionEvent.getSource() == right) {
                System.out.println("right");
                controller.clickButton(memoShape,"right");
            } else if (actionEvent.getSource() == left) {
                System.out.println("left");
                controller.clickButton(memoShape,"left");

            } else {
                System.err.println("Erreur action");
            }
        }
    }
}
