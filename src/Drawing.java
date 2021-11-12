import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Drawing extends JPanel implements MouseInputListener {
    private Color c;
    private ArrayList<Figure> listFig = new ArrayList<>();
    private String fig;
    private int x;
    private int y;

    public void setC(Color c) {
        this.c = c;
    }

    public void setFig(String fig) {
        this.fig = fig;
    }

    public Drawing(){
        super();
        this.setBackground(Color.white);
        this.c = Color.red;
        this.fig = "Carre";
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.x= e.getX();
        this.y= e.getY();
        System.out.println(c);
        switch(fig){
            case "Carre":
                listFig.add(new Carre(this.c,new Point(x,y)));
                break;
            case "Rectangle":
                listFig.add(new Rectangle(this.c,new Point(x,y)));
                break;
            case "Ellipse":
                listFig.add(new Ellipse(this.c,new Point(x,y)));
                break;
            case "Cercle":
                listFig.add(new Cercle(this.c,new Point(x,y)));
                break;
        }
        System.out.println(fig);


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        listFig.get(listFig.size()-1).setBoundingBox(Math.abs(y-e.getY()),Math.abs(x-e.getX()));
        if(e.getX()<x && e.getY()<y){
            listFig.get(listFig.size()-1).setP0(new Point(e.getX(),e.getY()));
        }
        else if(e.getX()<x && e.getY()>y){
            listFig.get(listFig.size()-1).setP0(new Point(e.getX(),y));
        }
        else if(e.getX()>x && e.getY()<y){
            listFig.get(listFig.size()-1).setP0(new Point(x,e.getY()));
        }
        System.out.println(e.getY());
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Figure f : listFig) {
            f.draw(g);
        }
    }
}
