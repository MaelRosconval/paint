import java.awt.Color;
import java.awt.Graphics;


public class Rectangle extends Figure {
    protected int length;
    protected int width;

    public Rectangle(Color c, Point p) {
        super(c,p);
        this.width = 50;
        this.length =50;
    }

    public void setBoundingBox(int length, int width){
        this.width = width;
        this.length = length;
    }

    public void draw(Graphics g){
        g.fillRect(this.p0.getX(), this.p0.getY(),this.width,this.length);
    };

    public static void main(String[] args){
        Rectangle r1 = new Rectangle(Color.RED,new Point(5,150));
        Rectangle r2 = new Rectangle(Color.BLACK, new  Point(100,6));

        System.out.println(r1);
    }

}
