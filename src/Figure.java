import java.awt.*;
import java.awt.Graphics;
import java.io.Serializable;


public abstract class Figure implements Serializable {
    private static final long serialVersionUID = -6465015581713613484L;
    // random number used for serializable object to be used on different laptop or different version
    // otherwise a different serialVersionUID is generated

    protected Color c;  // figure color
    protected Point p0; // figure origin

    public abstract void setBoundingBox(int heightBB, int widthBB);
    public abstract void draw(Graphics g);


    public Figure(Color c, Point p){
        this.c =c;
        this.p0 = p;
    }

    @Override
    public String toString(){
        return this.c +" , "+ this.p0;
    }

}
