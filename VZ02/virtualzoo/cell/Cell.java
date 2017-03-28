// File : Cell.java
// Author : Prama Legawa Halqavi (13515132)
package virtualzoo.cell;
import java.util.Scanner;

public class Cell {
  protected final String fachabtype;
  protected final String facilityname; // * @param nama fasilitas
  protected static final String DEFNAME = "";
  protected static final String Nil_String = "Nil";
  protected static final int DEFSIZE = 10;
  protected static final int default_maxpengunjung = 10;
  protected final int maxpengunjung; // * @brief nama restoran
  protected String celltype;
  protected String pilihan[]; // * @brief array of menu
  protected int jumlahpengunjung = 0; // * @brief jumlah pengunjung
  protected int n_pilihan = 0;

  public Cell() {
    this("Road");
  }
  public Cell(String type) {
    this.fachabtype = type;
    this.maxpengunjung = default_maxpengunjung;
    this.facilityname = DEFNAME;
    pilihan = new String[20];
    if (type == "Park" || type == "Restaurant" ||
        type == "Road" || type == "Entrance" ||
        type == "Exit") {
      celltype = "Facility";
    }
    else {
      if (type == "Water" || type == "Land" || type == "Air") {
        celltype = "Habitat";
      }
    }
  }
  public void SetCellType(String tipe) {
    celltype = tipe;
  }
  public String GetCellType() {
    return celltype;
  }
  public void AddPilihan(String _pilihan) {
    pilihan[n_pilihan] = _pilihan;
    n_pilihan++;
  }
  public String GetFacHabType() {
    return fachabtype;
  }
  public void Render(boolean oncage) {
    if (oncage) {
      if (fachabtype == "Park") {
        System.out.print("P");
      }
      else {
        if (fachabtype == "Restaurant") {
          System.out.print("R");
        }
      else { 
        if (fachabtype == "Road") {
          System.out.print(" ");
        }
      else {
        if (fachabtype == "Entrance") {
          System.out.print("E");
        }
      else {
        if (fachabtype == "Exit") {
          System.out.print("X");
        }
      else {
        if (fachabtype == "Water") {
          System.out.print("W");
        }
      else {
        if (fachabtype == "Land") {
          System.out.print("L");
        }
      else {
        if (fachabtype == "Air") {
          System.out.print("A");
        }
      }
      }
      }
      }
      }
      }
      }
    }
    else {
      Render();
    }
  }
  public void Render() {
    if (fachabtype == "Park") {
      System.out.print("P");
    }
    else {
      if (fachabtype == "Restaurant") {
        System.out.print("R");
      }
    else {
      if (fachabtype == "Road") {
        System.out.print(" ");
      } 
    else {
      if (fachabtype == "Entrance") {
        System.out.print("E");
      }
    else {
      if (fachabtype == "Exit") {
        System.out.print("X");
      }
    else {
      if (fachabtype == "Water") {
        System.out.print("w");
      }
    else {
      if (fachabtype == "Land") {
        System.out.print("l");
      }
    else {
      if (fachabtype == "Air") {
        System.out.print("a");
      }
    }
    }
    }
    }
    }
    }
    }
  }
  public void Enter() {
    Scanner s = new Scanner(System.in);
    if (fachabtype == "Park") {
      System.out.print("\n");
      System.out.print("Di Park ini terdapat wahana: ");
      System.out.print("\n");
      for (int i = 0; i < n_pilihan; i++) {
        System.out.print(i + 1);
        System.out.print(".  ");
        System.out.print(pilihan[i]);
        System.out.print("\n");
      }
      int x;
      System.out.print("Masukkan pilihan anda: ");
      x = s.nextInt();
      while (x < 1 || x > n_pilihan) {
        System.out.print("Inputan salah, ulangi: ");
        x = s.nextInt();
      }
      System.out.print("Anda naik ");
      System.out.print(pilihan[x - 1]);
      System.out.print(", sangat seru hingga anda ingin naik lagi!");
      System.out.print("\n");
    }
    else {
      if (fachabtype == "Restaurant") {
        System.out.print("\n");
        System.out.print("Pilihan Menu: ");
        System.out.print("\n");
        for (int i = 0; i < n_pilihan; i++) {
          System.out.print(i + 1);
          System.out.print(".  ");
          System.out.print(pilihan[i]);
          System.out.print("\n");
        }
        int x;
        System.out.print("Masukkan pilihan anda: ");
        x = s.nextInt();
        while (x < 1 || x > n_pilihan) {
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
  /* * @brief menghapus menu yang ada dalam array menu
     * @param nama menu */
  public void DelPilihan(String _pilihan) {
    int i = 0;
    boolean found = false;
    while (i < DEFSIZE && !found) {
      if (_pilihan == pilihan[i]) {
        found = true;
      }
      else {
        i++;
      }
    }
    if (found) {
      for (i = 0; i < DEFSIZE -1;i++) {
        pilihan[i] = pilihan[i+1];
      }
      n_pilihan--;
    }
  }
}