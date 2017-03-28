//File: Point.java
//Author: David Theosaksomo
//NIM: 13515131
package virtualzoo.util.point;
//Kelas Point
public class Point {

    protected int x;//absis
    protected int y;//ordinat
    //ctor,cctor,dtor
    public Point() {
      this.x = 0;
      this.y = 0;
    }
    public Point(int x,int y) {
      this.x = x;
      this.y = y;
    }
    //getter
    public int GetX() {
      return x;
    }
    public int GetY() {
      return y;
    }
    //setter
    public void SetX(int x) {
      this.x = x;
    }
    public void SetY(int y) {
      this.y = y;
    }
}

