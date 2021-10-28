import java.awt.Color;
import java.lang.Math;

public class Cercle extends Ellipse{

    public Cercle(Color c, Point p){
        super(c,p);
    }

    @Override
    public void setBoundingBox(int length, int width){
        super.length = Math.max(length,width);
        super.width = Math.max(length,width);
    }

    @Override
    public String toString(){
        return super.width +" , "+super.length;
    }

    static public void main(String[] args){
        Cercle c1 =new Cercle(Color.RED,new Point(100,100));
        Cercle c2 =new Cercle(Color.RED,new Point(200,100));

        c1.setBoundingBox(100,50);
        c2.setBoundingBox(10,30);

        System.out.println(c1);
        System.out.println(c2);


    }
}
