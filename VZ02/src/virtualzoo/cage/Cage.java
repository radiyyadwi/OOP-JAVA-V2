//File: Cage.java
//Author: M.Ferdi Ghozali
//NIM: 13515014

package virtualzoo.cage;

import java.util.Random;
import virtualzoo.animal.Animal;
import virtualzoo.util.point.Point;

/**
 * Class yang menunjukkan Cage atau kandang
 * @author M.Ferdi Ghozali/13515014
 * @version 1.0, March 2017
 */

public class Cage {
  protected final int id;
  protected String cageType;
  protected int sizeArea;
  protected Point[] area;
  protected int jumlahHewan = 0;
  protected final int animalSize = 50;
  protected Animal[] listOfAnimal;
  /** Constructor.
  *  @see java.lang.reflect.Constructor
  */

  public Cage() {
    id = 0;
  }
  /** Constructor dengan parameter.
   *  @param id sebagai penanda id Cage
   *  @param area sebagai penanda point yang ada pada Cage
   *  @param ukuran sebagai penanda ukuran Cage
   *  @param type sebagai penanda type Cage
   */

  public Cage(int id, Point[] area, int ukuran, String type) {
    this.id = id;
    cageType = type;
    sizeArea = ukuran;
    this.area = new Point[sizeArea];
    for (int i = 0; i < sizeArea; i++) {
      this.area[i] = new Point(area[i].getX(),area[i].getY());
    }
    listOfAnimal = new Animal[animalSize];
  }
  /**  Menghasilkan nilai dari ukuran Cage.
   * @return ukuran area dari Cage
   */

  public int getCageSize() {
    return sizeArea;
  }
  /** Menghasilkan ID Cage.
   * @return ID dari Cage
  */

  public int getId() {
    return id;
  }
  /** Menghasilkan jumlah hewan pada Cage.
   * @return jumlah hewan yang ada di Cage
   */

  public int numberOfAnimal() {
    return jumlahHewan;
  }
  /** Menghasilkan type Cage.
   * @return type habitat dari Cage
   */

  public String getTypeCage() {
    return cageType;
  }
  /** Menghasilkan Point ke i di dalam Cage.
   * @param i merupakan indeks Point yang akan dicari
   * @return elemen ke i dari area dalam Cage
   */

  public Point getAreaElmt(int i) {
    return area[i];
  }
  /** Menghasilkan Animal ke i pada listOfAnimal.
   * @param i merupakan indeks listOfAnimal yang akan dicari
   * @return Animal indeks ke i dalam Cage
   */

  public Animal getAnimal(int i) {
    return listOfAnimal[i];
  }
  /** Memasukkan Animal ke dalam Cage.
   * @param hewan menunjukkan hewan yang akan dimasukkan
   * @param areaId ID dari area yang akan dimasukkan hewan
   */

  public void inputAnimal(Animal hewan, int areaId) {
    if (aman(hewan) && (0.3 * sizeArea - (jumlahHewan + 1) > 0)
        && (hewan.isTypeThere(cageType))) {
      if (isPassAble(area[areaId])) {
        listOfAnimal[jumlahHewan] = hewan;
        jumlahHewan++;
        hewan.setPosition(area[areaId]);
      }
    }
  }
  /** Mengecek hewan apakah aman bila dimasukkan ke Cage.
   * @param hewan menunjukkan hewan yang akan dimasukkan
   * @return true jika hewan aman untuk masuk dalam cage, selainnya false 
   */

  public boolean aman(Animal hewan) {
    boolean safe = true;
    if (!hewan.isTamed()) {
      for (int i = 0; i < jumlahHewan; i++) {
        if (hewan.isEnemy(listOfAnimal[i].getSpeciesName())) {
          safe = false;
          System.out.println("Peletakan Animal: " 
              + hewan.getSpeciesName() 
              + " gagal, terdapat hewan yang membahayakan dalam kandang");
        }
      }
    }
    if (safe) {
      for (int j = 0;j < jumlahHewan;j++) {
        if (listOfAnimal[j].isEnemy(hewan.getSpeciesName())) {
          safe = false;
          System.out.println("Peletakan Animal: " 
              + hewan.getSpeciesName() 
              + " gagal, terdapat hewan yang membahayakan dalam kandang");
        }
      }  
    }
    return safe;
  }
  /** Mengecek apakah dapat melewati point.
   * @param p merupakan Point yang akan dicek
   * @return apakah Point p bisa dilewati
   */

  public boolean isPassAble(Point p) {
    boolean bener = false;
    for (int i = 0; i < sizeArea;i++) {
      if ((area[i].getX() == p.getX()) && (area[i].getY() == p.getY())) {
        bener = true;
      }
    }
    if (bener) {
      for (int  j = 0;j < jumlahHewan;j++) {
        if ((listOfAnimal[j].getPosition()).getX() == p.getX() 
            && (listOfAnimal[j].getPosition()).getY() == p.getY()) {
          bener = false;
        }
      }
    }
    return bener;    
  }
  /** Menggerakkan Animal.
   */

  public void moveAnimal() {
    Random rand = new Random();
   
    for (int i = 0; i < jumlahHewan;i++) {
      
      int dir = rand.nextInt(4) + 1;
      Point p = new Point();
      if (dir == 4) {
        p.setY((listOfAnimal[i].getPosition()).getY() + 1);
        p.setX((listOfAnimal[i].getPosition()).getX());
      } else if (dir == 1) {
        p.setY((listOfAnimal[i].getPosition()).getY() - 1);
        p.setX((listOfAnimal[i].getPosition()).getX());      
      } else if (dir == 2) {
        p.setY((listOfAnimal[i].getPosition()).getY());
        p.setX((listOfAnimal[i].getPosition()).getX() - 1);
      } else if (dir == 3) {
        p.setY((listOfAnimal[i].getPosition()).getY());
        p.setX((listOfAnimal[i].getPosition()).getX() + 1);
      }
      if (isPassAble(p)) {
        listOfAnimal[i].setPosition(p);
      }
    }
  }
  /** Mencetak ID dari Cage.
   */

  public void render() {
    System.out.print(id);
  }
}