public class Point {
    private int x;
    private int y;

    public int getX(){
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
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

    public static void main(String[] args){
        Point a1 = new Point();
        Point a2 = new Point(5,2);

        System.out.println(a1);
        System.out.println(a2);
    }



}
