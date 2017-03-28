//File: Point.java
//Author: David Theosaksomo
//NIM: 13515131
package virtualzoo.util.point;
/** Class Point (x,y)
 * @author David Theosaksomo/13515131
 * @version 1.0 , March 2017
 */
public class Point {
    protected int x;//absis
    protected int y;//ordinat
    /** Constructor tanpa parameter
     * Inisialisasi x dan y dengan 0;
     *  @see java.lang.reflect.Constructor
     */
    public Point() {
      this.x = 0;
      this.y = 0;
    }
    /** Constructor dengan parameter
     * @param x untuk menjadi nilai absis
     * @param y untuk menjadi nilai ordinat
     */
    public Point(int x,int y) {
      this.x = x;
      this.y = y;
    }
    /** Mendapatkan nilai absis
     * @return nilai dari absis
     */
    public int GetX() {
      return x;
    }
    /** Mendapatkan nilai ordinat
     * @return nilai dari ordinat
     */
    public int GetY() {
      return y;
    }
    /** Mengubah nilai absis
     * @param x nilai untuk absis
     */
    public void SetX(int x) {
      this.x = x;
    }/** Mengubah nilai ordinat
     * @param y  nilai untuk ordinat
     */
    public void SetY(int y) {
      this.y = y;
    }
}

