import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Drawing extends JPanel implements MouseInputListener {
    private Color c;
    private ArrayList<Figure> listFig = new ArrayList<Figure>();
    private String fig;

    public void setC(Color c) {
        this.c = c;
    }

    public void setFig(String fig) {
        this.fig = fig;
    }

    public Drawing(){
        super();
        this.setBackground(Color.white);
        this.c = Color.black;
        this.fig = "Rectangle";
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

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
        int x0= e.getX();
        int y0 = e.getY();
        Figure newFig;
        if(this.fig == "Rectangle"){
            newFig = new Rectangle(this.c,new Point(x0,y0));
            listFig.add(newFig);
        }
        else if(this.fig == "Ellipse"){
            newFig = new Rectangle(this.c,new Point(x0,y0));
            listFig.add(newFig);
        }

        Point pppp = new Point(e.getX(),e.getY());
        System.out.println(pppp);

        Graphics g = this.getGraphics();
        g.setColor(Color.red);
        this.dessiner(g);
        System.out.println(g.getColor());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    public void dessiner(Graphics g){
        for (Figure f : listFig) {
            f.draw(g);
        }
    }
}
