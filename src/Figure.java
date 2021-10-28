import java.awt.*;
import java.awt.Graphics;


public abstract class Figure {
    protected Color c;
    private Point p0;

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
