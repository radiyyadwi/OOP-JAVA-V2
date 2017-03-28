//File: Point.java
//Author: David Theosaksomo
//NIM: 13515131

package virtualzoo.util.point;
/** Class Point (absis,ordinat).
 * @author David Theosaksomo/13515131
 * @version 1.0 , March 2017
 */

public class Point {
  protected int absis;//absis
  protected int ordinat;//ordinat
  /** Constructor tanpa parameter.
   * Inisialisasi absis dan ordinat dengan 0;
   *  @see java.lang.reflect.Constructor
   */

  public Point() {
    this.absis = 0;
    this.ordinat = 0;
  }
  /** Constructor dengan parameter.
   * @param x untuk menjadi nilai absis
   * @param y untuk menjadi nilai ordinat
   */

  public Point(int x,int y) {
    this.absis = x;
    this.ordinat = y;
  }

  /** Mendapatkan nilai absis.
   * @return nilai dari absis
   */

  public int getX() {
    return absis;
  }
  /** Mendapatkan nilai ordinat.
   * @return nilai dari ordinat
   */

  public int getY() {
    return ordinat;
  }
  /** Mengubah nilai absis.
   * @param x nilai untuk absis
   */

  public void setX(int x) {
    this.absis = x;
  }
  /** Mengubah nilai ordinat.
   * @param y nilai untuk ordinat
   */

  public void setY(int y) {
    this.ordinat = y;
  }
}