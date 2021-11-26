import java.io.Serializable;

public class Point implements Serializable {
    private static final long serialVersionUID = -6465015581713613484L;
    // random number used for serializable object to be used on different laptop or different version
    // otherwise a different serialVersionUID is generated

    private int x;
    private int y;

    public int getX(){
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public String toString(){
        return "(" + this.x + "," + this.y + ")";
    }

    public Point(){
        this.x =0;
        this.y =0;
    }

    public Point(int a, int b){
        this.x =a;
        this.y =b;
    }
}
