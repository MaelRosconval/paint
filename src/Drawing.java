import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Drawing extends JPanel {
    private Color c;
    private ArrayList<Figure> listFig = new ArrayList<Figure>();
    private Figure fig;

    public void setC(Color c) {
        this.c = c;
    }

    public void setFig(Figure fig) {
        this.fig = fig;
    }

    public Drawing(){
        super();
        this.setBackground(Color.white);
        this.c = Color.black;
        this.fig = new Rectangle(this.c,new Point(0,0));
    }
}
