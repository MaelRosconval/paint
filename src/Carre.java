import java.awt.Color;
import java.lang.Math;

public class Carre extends Rectangle{

    public Carre(Color c, Point p){
        super(c,p);
    }

    @Override
    public void setBoundingBox(int length, int width){
        int length1 = Math.min(Math.abs(length), Math.abs(width));

        // we still want to draw in every direction
        if ((width>0) && (length>0)) {
            super.length = length1;
            super.width = length1;
        }
        if ((width<0) && (length>0)){
            super.length = length1;
            super.width = -length1;
        }
        if ((width>0) && (length<0)){
            super.length = -length1;
            super.width = length1;
        }
        if ((width<0) && (length<0)){
                super.length = -length1;
                super.width = -length1;
        }
    }
}
