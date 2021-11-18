import java.awt.*;
import java.awt.Graphics;
import java.io.Serializable;


public abstract class Figure implements Serializable {
    protected Color c;

    public void setP0(Point p0) {
        this.p0 = p0;
    }

    protected Point p0; // figure origin

    public Point getP0() {
        return p0;
    }
    public Color getC() {
        return c;
    }

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
