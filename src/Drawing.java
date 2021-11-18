import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

public class Drawing extends JPanel implements MouseInputListener {
    private Color c; // Current color
    private ArrayList<Figure> listFig = new ArrayList<>();
    private String fig; // String corresponding to the current figure
    private int x; //
    private int y;
    private String nomDrawing; // Current drawing useful to load other drawing
    private int saved; // boolean which indicates if the drawing has been saved

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

    public Drawing(){
        super();
        this.setBackground(Color.white);
        this.c = Color.BLACK;
        this.fig = "Rectangle";
        this.nomDrawing = null;
        this.saved = 1;
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
                nomDrawing=null;
                repaint();
            }
            else if(btn ==1) {
                setSaved(1);
                listFig.clear();
                nomDrawing=null;
                repaint();
            }
            else;
        }
        else{
            listFig.clear();
            nomDrawing=null;
            repaint();
        }

    }

    /* Save the drawing*/
    public void save(){
        try{
            if(nomDrawing==null){
                nomDrawing = JOptionPane.showInputDialog(null,"File name : ","Save",JOptionPane.INFORMATION_MESSAGE);

            }
            FileOutputStream fos = new FileOutputStream(nomDrawing);
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
            nomDrawing = JOptionPane.showInputDialog(null,"File name : ","Open",JOptionPane.INFORMATION_MESSAGE);
            if(getSaved()==0){
                JOptionPane info = new JOptionPane();
                int btnChoisi = info.showInternalConfirmDialog(info,"File not saved, do you want to save it ?","warning",JOptionPane.YES_NO_CANCEL_OPTION);
                if(btnChoisi==0){
                    save();
                    FileInputStream fis = new FileInputStream(nomDrawing);
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
                    FileInputStream fis = new FileInputStream(nomDrawing);
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

                FileInputStream fis = new FileInputStream(nomDrawing);
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
        this.x= e.getX();
        this.y= e.getY();
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
        setSaved(0);
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        listFig.get(listFig.size()-1).setBoundingBox((-y+e.getY()),(-x+e.getX()));
    /*    listFig.get(listFig.size()-1).setBoundingBox(Math.abs(y-e.getY()),Math.abs(x-e.getX()));
        if(e.getX()<x && e.getY()<y){
            listFig.get(listFig.size()-1).setP0(new Point(e.getX(),e.getY()));
        }
        else if(e.getX()<x && e.getY()>y){
            listFig.get(listFig.size()-1).setP0(new Point(e.getX(),y));
        }
        else if(e.getX()>x && e.getY()<y){
            listFig.get(listFig.size()-1).setP0(new Point(x,e.getY()));
        }*/
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
