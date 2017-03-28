//File: Zoo.java
//Author: David Theosaksomo
//NIM: 13515131
package virtualzoo.zoo;
import virtualzoo.cell.Cell;

/** @class Zoo
  * Kelas zoo memiliki atribut  
  * matriks Cell dimana 1 cell merepresentasikan sebuah petak 1x1m
  */
public class Zoo {
  private final int default_size = 100;
  private final int height;
  private final int width;
  private Cell[][] zoo_map;

  public Zoo(){
    this.width = default_size;
    this.height = default_size;
    zoo_map = new Cell[height][width];
  }
  /** @brief constructor.
    * Menciptakan Zoo sesuai dengan konfigurasi pada file eksternal
    * @param filePath lokasi file eksternal
    */
  public Zoo(int width, int height){
    this.width = width;
    this.height = height;
    zoo_map = new Cell[height][width]; 
  }
  public Cell GetZooElmt(int i, int j){
    return zoo_map[i][j];
  }
  public void SetZooElmt(int i, int j, Cell elmt){
    zoo_map[i][j] = elmt;
  }
};
