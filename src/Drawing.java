import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

public class Drawing extends JPanel implements MouseInputListener {
    private Color c; // Current color
    private ArrayList<Figure> listFig = new ArrayList<>(); // list of figure to draw
    private String fig; // String corresponding to the current figure
    private String drawingName; // name of the current drawing
    private int saved; // boolean which indicates if the drawing has been saved

    // origin point of the current drawing
    private int x0;
    private int y0;

    public void setC(Color c) {
        this.c = c;
    }
    public void setSaved(int saved) {
        this.saved = saved;
    }
    public int getSaved() {
        return saved;
    }
    public void setFig(String fig) {
        this.fig = fig;
    }
    public String getDrawingName(){return this.drawingName;}

    public Drawing(){
        super();
        this.setBackground(Color.white);
        this.c = Color.BLACK;
        this.fig = "Rectangle";
        this.drawingName = null;
        this.saved = 1; // we consider that the drawing is saved by default
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    /* Creation of a new drawing*/
    public void nouveau(){
        if(getSaved()==0){
            JOptionPane info = new JOptionPane();
            int btn = info.showInternalConfirmDialog(info,"File not saved, do you want to save it ?","New file",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
            if(btn==0){
                save();
                listFig.clear();
                drawingName=null;
                repaint();
            }
            else if(btn ==1) {
                setSaved(1);
                listFig.clear();
                drawingName=null;
                repaint();
            }
            else;
        }
        else{
            listFig.clear();
            drawingName=null;
            repaint();
        }

    }

    /* Save the drawing*/
    public void save(){
        try{
            if(drawingName==null){
                drawingName = JOptionPane.showInputDialog(null,"File name : ","Save",JOptionPane.INFORMATION_MESSAGE);

            }
            FileOutputStream fos = new FileOutputStream(drawingName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeInt(this.listFig.size());
            for(Figure f : this.listFig){
                oos.writeObject(f);
            }
            oos.close();
            setSaved(1);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    /* Load a previously saved drawing*/
    public void open(){
        try{
            drawingName = JOptionPane.showInputDialog(null,"File name : ","Open",JOptionPane.INFORMATION_MESSAGE);
            if(getSaved()==0){
                JOptionPane info = new JOptionPane();
                int btnChoisi = info.showInternalConfirmDialog(info,"File not saved, do you want to save it ?","warning",JOptionPane.YES_NO_CANCEL_OPTION);
                if(btnChoisi==0){
                    save();
                    FileInputStream fis = new FileInputStream(drawingName);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    int n = ois.readInt();
                    listFig.clear();
                    for(int i=0;i<n;i++){
                        Figure f= (Figure) ois.readObject();
                        listFig.add(f);
                    }
                    ois.close();
                    repaint();
                }
                else if(btnChoisi ==1){
                    setSaved(1);
                    FileInputStream fis = new FileInputStream(drawingName);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    int n = ois.readInt();
                    listFig.clear();
                    for(int i=0;i<n;i++){
                        Figure f= (Figure) ois.readObject();
                        listFig.add(f);
                    }
                    ois.close();
                    repaint();
                }
                else;
            }
            else{

                FileInputStream fis = new FileInputStream(drawingName);
                ObjectInputStream ois = new ObjectInputStream(fis);
                int n = ois.readInt();
                listFig.clear();
                for(int i=0;i<n;i++){
                    Figure f= (Figure) ois.readObject();
                    listFig.add(f);
                }
                ois.close();
                repaint();
            }
        }
        catch (Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"File does not exist","File not found",JOptionPane.INFORMATION_MESSAGE);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {

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
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.x0= e.getX();
        this.y0= e.getY();
        switch(fig){
            case "Carre":
                listFig.add(new Carre(this.c,new Point(x0,y0)));
                break;
            case "Rectangle":
                listFig.add(new Rectangle(this.c,new Point(x0,y0)));
                break;
            case "Ellipse":
                listFig.add(new Ellipse(this.c,new Point(x0,y0)));
                break;
            case "Cercle":
                listFig.add(new Cercle(this.c,new Point(x0,y0)));
                break;
        }
        setSaved(0);
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        listFig.get(listFig.size()-1).setBoundingBox((-y0+e.getY()),(-x0+e.getX()));
        repaint();


    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Figure f : listFig) {
            f.draw(g);
        }
    }
}
