//File: Zoo.java
//Author: David Theosaksomo
//NIM: 13515131

package virtualzoo.zoo;

import virtualzoo.cell.Cell;
/** Class zoo memiliki atribut  
  * matriks Cell dimana 1 cell merepresentasikan sebuah petak 1x1m
  *  @author David Theosaksomo/13515131
  * @version 1.0 , March 2017
  */

public class Zoo {
  private final int defaultSize = 100;
  private final int height;
  private final int width;
  private Cell[][] zooMap;
  /** Constructor.
   * inisialisasi ukuran lebar dan panjang
   * dengan defaultSize
   * @see java.lang.reflect.Constructor
   */

  public Zoo() {
    this.width = defaultSize;
    this.height = defaultSize;
    zooMap = new Cell[height][width];
  }
  /** Constructor.
    * Menciptakan Zoo sesuai dengan konfigurasi 
    * panjang dan lebar
    * @param width lebar yang diinginkan
    * @param height panjang yang diinginkan
    */
  
  public Zoo(int width, int height) {
    this.width = width;
    this.height = height;
    zooMap = new Cell[height][width]; 
  }
  /** Memperoleh Element pada Zoo.
   * @param i absis element yang mau diperoleh 
   * @param j ordinat element yang mau diperoleh
   * @return menghasilkan bagian dari map
   */

  public Cell getZooElmt(int i, int j) {
    return zooMap[i][j];
  }
  /** Mengubah element Zoo.
   * @param i absis bagian yang ingin diubah
   * @param j ordinat bagian yang ingin diubah
   * @param elmt element yang diinginkan
   */

  public void setZooElmt(int i, int j, Cell elmt) {
    zooMap[i][j] = elmt;
  }
};
