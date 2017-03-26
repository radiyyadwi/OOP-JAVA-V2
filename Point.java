//Kelas Point
public class Point {

    protected int x;//absis
    protected int y;//ordinat
    //ctor,cctor,dtor
    public Point() {
      x = 0;
      y = 0;
    }
    public Point(int x_,int y_) {
      x = x_;
      y = y_;
    }
    //getter
    public int GetX() {
      return x;
    }
    public int GetY() {
      return y;
    }
    //setter
    public void SetX(int x_) {
      x = x_;
    }
    public void SetY(int y_) {
      y = y_;
    }
}
