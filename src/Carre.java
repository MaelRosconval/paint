import java.awt.Color;
import java.lang.Math;

public class Carre extends Rectangle{

    public Carre(Color c, Point p){
        super(c,p);
    }

    @Override
    public void setBoundingBox(int length, int width){
        super.length = Math.max(length,width);
        super.width = Math.max(length,width);
    }

    static public void main(String[] args){
        Carre c1 =new Carre(Color.RED,new Point(100,100));
        Carre c2 =new Carre(Color.RED,new Point(200,100));

        c1.setBoundingBox(100,50);
        c2.setBoundingBox(10,30);

    }
}
