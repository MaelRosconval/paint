import java.awt.*;
import java.awt.Graphics;

public class Ellipse extends Figure{
    protected int length;
    protected int width;

    public Ellipse(Color c,Point p) {
        super(c,p);
        this.width=0;
        this.length =0;
    }
    public void draw(Graphics g){
        g.setColor(c);
        g.fillOval(this.p0.getX(), this.p0.getY(),this.width,this.length);
    }

    public void setBoundingBox(int length, int width){
        this.width = width;
        this.length = length;
    }


}
