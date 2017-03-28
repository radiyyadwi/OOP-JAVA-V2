// File : Cell.java
// Author : Prama Legawa Halqavi (13515132)

package virtualzoo.cell;

import java.util.Scanner;
/**
 * Class yang menunjukkan Cell
 * @author Prama Legawa Halqavi/13515132
 * @version 1.0, March 2017
 */

public class Cell {
  protected final String fachabtype;
  protected final String facilityname; // * @param nama fasilitas
  protected static final String DEFNAME = "";
  protected static final String Nil_String = "Nil";
  protected static final int DEFSIZE = 10;
  protected static final int defaultMaxPengunjung = 10;
  protected final int maxPengunjung; // * @brief nama restoran
  protected String cellType;
  protected String[] pilihan; // * @brief array of menu
  protected int jumlahPengunjung = 0; // * @brief jumlah pengunjung
  protected int npilihan = 0;
  /** Constructor.
   *  @see java.lang.reflect.Constructor
   */

  public Cell() {
    this("Road");
  }
  /** Constructor dengan parameter.
   *  @param type menunjukan type cell
   */

  public Cell(String type) {
    this.fachabtype = type;
    this.maxPengunjung = defaultMaxPengunjung;
    this.facilityname = DEFNAME;
    pilihan = new String[20];
    if (type == "Park" || type == "Restaurant" 
        || type == "Road" || type == "Entrance" 
        || type == "Exit") {
      cellType = "Facility";
    } else {
      if (type == "Water" || type == "Land" || type == "Air") {
        cellType = "Habitat";
      }
    }
  }
  /** Menyetting tipe dari cell.
   * @param tipe menunjukan tipe yang akan diset
   */

  public void setCellType(String tipe) {
    cellType = tipe;
  }
  /** Menghasilkan type dari cell.
   * @return String type cell
   */

  public String getCellType() {
    return cellType;
  }
  /** Menambahkan pilihan yang ada.
    * @param pilihanx pilihan yang ingin ditambahkan
    */

  public void addPilihan(String pilihanx) {
    pilihan[npilihan] = pilihanx;
    npilihan++;
  }
  /** Menghasiklan type dari habitat.
   * @return String type habitat
   */

  public String getFacHabType() {
    return fachabtype;
  }
  /** Mencetak cage di map.
   */

  public void render(boolean oncage) {
    if (oncage) {
      if (fachabtype == "Park") {
        System.out.print("P");
      } else if (fachabtype == "Restaurant") {
        System.out.print("R");
      } else if (fachabtype == "Road") {
        System.out.print(" ");
      } else if (fachabtype == "Entrance") {
        System.out.print("E");
      } else if (fachabtype == "Exit") {
        System.out.print("X");
      } else if (fachabtype == "Water") {
        System.out.print("W");
      } else if (fachabtype == "Land") {
        System.out.print("L");
      } else if (fachabtype == "Air") {
        System.out.print("A");
      }
    } else {
      render();
    }
  }
  /** Menuliskan symbol yang mewakili hewan.
   */

  public void render() {
    if (fachabtype == "Park") {
      System.out.print("P");
    } else if (fachabtype == "Restaurant") {
      System.out.print("R");
    } else if (fachabtype == "Road") {
      System.out.print(" ");
    } else if (fachabtype == "Entrance") {
      System.out.print("E");
    } else if (fachabtype == "Exit") {
      System.out.print("X");
    } else if (fachabtype == "Water") {
      System.out.print("w");
    } else if (fachabtype == "Land") {
      System.out.print("l");
    } else if (fachabtype == "Air") {
      System.out.print("a");
    }
  }
  /** Memasuki map zoo yang ada.
   */

  public void enter() {
    Scanner s = new Scanner(System.in);
    if (fachabtype == "Park") {
      System.out.print("\n");
      System.out.print("Di Park ini terdapat wahana: ");
      System.out.print("\n");
      for (int i = 0; i < npilihan; i++) {
        System.out.print(i + 1);
        System.out.print(".  ");
        System.out.print(pilihan[i]);
        System.out.print("\n");
      }
      int x;
      System.out.print("Masukkan pilihan anda: ");
      x = s.nextInt();
      while (x < 1 || x > npilihan) {
        System.out.print("Inputan salah, ulangi: ");
        x = s.nextInt();
      }
      System.out.print("Anda naik ");
      System.out.print(pilihan[x - 1]);
      System.out.print(", sangat seru hingga anda ingin naik lagi!");
      System.out.print("\n");
    } else {
      if (fachabtype == "Restaurant") {
        System.out.print("\n");
        System.out.print("Pilihan Menu: ");
        System.out.print("\n");
        for (int i = 0; i < npilihan; i++) {
          System.out.print(i + 1);
          System.out.print(".  ");
          System.out.print(pilihan[i]);
          System.out.print("\n");
        }
        int x;
        System.out.print("Masukkan pilihan anda: ");
        x = s.nextInt();
        while (x < 1 || x > npilihan) {
          System.out.print("Inputan salah, ulangi: ");
          x = s.nextInt();
        }
        System.out.print("Anda memesan ");
        System.out.print(pilihan[x - 1]);
        System.out.print(", rasanya lezat");
        System.out.print("\n");
      }
    }
  }
  /** Menghapus pilihan yang ada.
   * @param pilihanx pilihan yang ingin dihapus
   */

  public void delPilihan(String pilihanx) {
    int i = 0;
    boolean found = false;
    while (i < DEFSIZE && !found) {
      if (pilihanx == pilihan[i]) {
        found = true;
      } else {
        i++;
      }
    }
    if (found) {
      for (i = 0; i < DEFSIZE - 1;i++) {
        pilihan[i] = pilihan[i + 1];
      }
      npilihan--;
    }
  }
}