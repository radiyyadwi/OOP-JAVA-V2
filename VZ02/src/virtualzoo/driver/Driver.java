//File: Driver.java
//Author: David Theosaksomo
//NIM: 13515131

package virtualzoo.driver;

import java.util.Random;
import java.util.Scanner;
import virtualzoo.animal.Animal;
import virtualzoo.cage.Cage;
import virtualzoo.cell.Cell;
import virtualzoo.util.mesinkar.Mesinkar;
import virtualzoo.util.point.Point;
import virtualzoo.util.screencleaner.ScreenCleaner;
import virtualzoo.zoo.Zoo;

/** Class zoo memiliki atribut  matriks Cell dimana 1 cell merepresentasikan .
  * sebuah petak 1x1m
  * @author David Theosaksomo/13515131
  * @version 1.0, March 2017
  */
public class Driver {

  private int height;
  private int width;
  private Zoo virtualZoo;
  private Cage[] cageList;
  private Animal[] animalList;
  private final int maxCage = 20;
  private final int maxAnimal = 100;
  private final int maxAreaInCage = 50;
  private final int defaultHeight = 100;
  private final int defaultWidth = 100;
  private Point guestPos;
  private int nanimal = 0;
  private boolean[] isAdaCage;
  /** Driver program Virtual Zoo.
   * 
   */

  public Driver() {
    virtualZoo = new Zoo(defaultWidth,defaultHeight);
    guestPos = new Point(-1,-1);
    Mesinkar msk = new Mesinkar();
    //Baca File dan Inisialisasi Zoo;
    msk.start();
    width = msk.getCi();
    msk.adv();
    msk.adv();
    height = msk.getCi();
    msk.adv();
    cageList = new Cage [maxCage];
    animalList = new Animal [maxAnimal];
    //Ciptakan variabel temporary
    int[] ukuranCage = new int [maxCage];
    for (int i = 0; i < maxCage; i++) {
      ukuranCage[i] = 0;
    }
    isAdaCage = new boolean [maxCage];
    for (int i = 0; i < maxCage; i++) {
      isAdaCage[i] = false;
    }
    Point[][] areaList = new Point[maxCage][maxAreaInCage];
    for (int i = 0; i < maxCage; i++) {
      for (int j = 0; j < maxAreaInCage; j++) {
        areaList[i][j] = new Point();
      }  
    }
    String[] cageType = new String [maxCage];
    for (int i = 0; i < maxCage; i++) {
      cageType[i] = new String(".");
    }
    int[][] animalIndex = new int [height + 1][width + 1];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        animalIndex[i][j] = -1;
      }
    }

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        switch (msk.getCc()) {
          case 'A' : {
            Cell a = new Cell("Air");
            virtualZoo.setZooElmt(i,j,a);
          }
          break;
          case 'L' : {
            Cell b = new Cell("Land");
            virtualZoo.setZooElmt(i,j,b);
          }
          break;
          case 'W' : {
            Cell c = new Cell("Water");
            virtualZoo.setZooElmt(i,j,c);
          }
          break;
          case 'P' : {
            Cell d = new Cell("Park");
            d.addPilihan("RollerCosty");
            d.addPilihan("PutingBeliung");
            d.addPilihan("RumahZombie");

            virtualZoo.setZooElmt(i,j,d);
          }
          break;
          case 'R' : {
            Cell e = new Cell("Restaurant");
            e.addPilihan("Nasi Bakar dengan sayur bayam");
            e.addPilihan("Steak Daging Asap dengan wortel ");
            e.addPilihan("Es Krim Pakai Brokoli");
            virtualZoo.setZooElmt(i,j,e);
          }
          break;
          case '_' : {
            Cell f = new Cell("Road");
            virtualZoo.setZooElmt(i,j,f);
          }
          break;
          case 'E' : {
            Cell g = new Cell("Entrance");
            virtualZoo.setZooElmt(i,j,g);
          }
          break;
          case 'X' : {
            Cell h = new Cell("Exit");
            virtualZoo.setZooElmt(i,j,h);
          }
          break;
          default : {
          }
        }

        //Jika Cell merupakan Habitat
        if (msk.getCc() == 'A' || msk.getCc() == 'L' || msk.getCc() == 'W') {
          //Tambahkan Cage
          char tm = msk.getCc();
          msk.adv();
          int num = msk.getCi();
          //Jika ada cage
          if (num > 0) {  
            num--;
            //Jika Cage untuk id tersebut belum dibuat
            if (!isAdaCage[num]) {
              isAdaCage[num] = true;
              switch (tm) {
                case 'A' : {
                  cageType[num] = "Air";
                }
                break;
                case 'L' : {
                  cageType[num] = "Land";
                }
                break;
                case 'W' : {
                  cageType[num] = "Water";
                }
                break;
                default : {                
                }
              }
            }
            if ((tm == 'A' && cageType[num] == "Air") || (tm == 'L' 
                && cageType[num] == "Land") || (tm == 'W' 
                && cageType[num] == "Water")) {
              areaList[num][ukuranCage[num]].setX(j);
              areaList[num][ukuranCage[num]].setY(i);
              ukuranCage[num] ++;
              //Pembacaan Animal
              msk.adv();
              if (msk.getCc() != '-') {
                animalList[nanimal] = new Animal(msk.getCc());
                animalIndex[i][j] = nanimal;
                nanimal++;
              }
            } else {
              msk.adv();
            }
          }
        }
        msk.adv();
      }  
    }
    //Alokasi cage sesuai data file eksternal
    for (int i = 0; i < maxCage; i++) {
      if (isAdaCage[i]) {
        cageList[i] = new Cage(i + 1, areaList[i], ukuranCage[i], cageType[i]);
      }
    }
    //Isicage dengan animal sesuai pembacaan file eksternal
    for (int i = 0; i < maxCage; i++) {
      if (isAdaCage[i]) {
        for (int j = 0; j < cageList[i].getCageSize(); j++) {
          int m = cageList[i].getAreaElmt(j).getX();
          int n = cageList[i].getAreaElmt(j).getY();
          //Ada animal di posisi itu
          if (animalIndex[n][m] >= 0 && animalIndex[n][m] < nanimal) {
            //Masukkan hewan kedalam cage
            cageList[i].inputAnimal(animalList[animalIndex[n][m]],j);
          }
        }
      }
    }
  }
  /** Menampilkan Zoo diatas layar dengan method render..
    */

  public void displayVirtualZoo() {
    Point up = new Point(0,0);
    Point down = new Point(width - 1,height - 1);
    displayVirtualZoo(up,down);
  }
  /** Menampilkan Zoo diatas layar dengan method render..
   * @param upleft kordinat atas kiri
   * @param downright kordinat bawah kanan
   */

  public void displayVirtualZoo(Point upleft, Point downright) {
    //Inisialisasi variabel antara
    int[][] cageMatrix = new int[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        cageMatrix[i][j] = -1;
      }
    }
    Point [][] animalMatrix = new Point[height][width];
    for (int i = 0;i < height; i++) {
      for (int j = 0;j < width;j++) {
        animalMatrix[i][j] = new Point(-1,-1);
      }
    }
    //Variabel char cage dan animal
    for (int i = 0; i < maxCage; i++) {
      if (isAdaCage[i]) {
        for (int j = 0; j < cageList[i].getCageSize(); j++) {
          int m = cageList[i].getAreaElmt(j).getX();
          int n = cageList[i].getAreaElmt(j).getY();
          cageMatrix[n][m] = i;
        }
        for (int j = 0; j < cageList[i].numberOfAnimal(); j++) {
          int m = cageList[i].getAnimal(j).getPosition().getX();
          int n = cageList[i].getAnimal(j).getPosition().getY();
          animalMatrix[n][m].setX(i);
          animalMatrix[n][m].setY(j);
        }
      }
    }
    //Create Garis Horizontal
    for (int k = upleft.getX() * 4; k < (downright.getX() + 1) * 4; k++) {
      System.out.print("_");
    }
    System.out.println('_');

    for (int i = upleft.getY(); i < downright.getY() + 1; i++) {
      for (int k = upleft.getX() * 4; k < (downright.getX() + 1) * 4; k++) {
        if (k % 4 == 0) {
          System.out.print("|");
        } else if (k % 4 == 1) {
          System.out.print(" ");
        } else if (k % 4 == 2) {
          // Jika ada kandang
          if (cageMatrix[i][k / 4] >= 0) {
            virtualZoo.getZooElmt(i,k / 4).render(true);
          } else {
            virtualZoo.getZooElmt(i,k  / 4).render();
          }
        } else {
          System.out.print(" ");
        }
      }
      System.out.println('|');
      for (int k = upleft.getX() * 4; k < (downright.getX() + 1) * 4; k++) {
        if (k % 4 == 0) {
          System.out.print('|');
        } else if (k % 4 == 2) {  
          if (i == guestPos.getY() && k / 4 == guestPos.getX()) {
            System.out.print("&");
          } else if (animalMatrix[i][k / 4].getX() >= 0) {
            cageList[animalMatrix[i][k / 4].getX()]
            .getAnimal(animalMatrix[i][k / 4].getY()).render();
          } else {
            System.out.print("_");
          } 
        } else {
          System.out.print("_");
        }
      }
      System.out.println('|');
    }
  }
  /** Menghitung jumlah makanan seluruh hewan.
   */

  public void hitungMakanan() {
    double daging = 0;
    double sayur = 0;
    double omni = 0;
    //hitung makanan masing-masing
    for (int i = 0; i < maxCage; i++) {
      if (isAdaCage[i]) {
        for (int j = 0; j < cageList[i].numberOfAnimal(); j++) {
          String type = cageList[i].getAnimal(j).getFoodType();
          double foodnum = cageList[i].getAnimal(j).getFoodNum();
          if (type == "Omnivore") {
            omni += foodnum;
          } else if (type == "Carnivore") {
            daging += foodnum;
          } else if (type == "Herbivore") {
            sayur += foodnum;
          } else {
            System.out.println("Tipe tidak dikenali");
          } 
        }
      }
    }
    System.out.println("Untuk memberi makan binatang di TalkingZoo dalam sehari dibutuhkan:");
    System.out.println(daging + " kg daging,");
    System.out.println(sayur + " kg sayur, dan");
    System.out.println(omni + " kg daging/sayur,");  
  }
  /** Menggerakan hewan.
   */

  public void moveAnimal() {
    for (int i = 0; i < maxCage; i++) {
      if (isAdaCage[i]) {
        cageList[i].moveAnimal();
      }
    }
  }
  /** Mencetak Judul Program Virtual Zoo.
   */

  public void printTitle() {
    System.out.println(" _____     _ _    _               ______        ");    
    System.out.println("|_   _|   | | |  (_)             |___  /            ");
    System.out.println("  | | __ _| | | ___ _ __   __ _     / /  ___   ___  ");
    System.out.println("  | |/ _` | | |/ / | '_ \\ / _` |   / /  / _ \\ / _ \\ ");
    System.out.println("  | | (_| | |   <| | | | | (_| | ./ /__| (_) | (_) |");
    System.out.println("  \\_/\\__,_|_|_|\\_\\_|_| |_|\\__, | \\_____/\\___/ \\___/ ");
    System.out.println("                           __/ |                    ");
    System.out.println("                          |___/   ");
    System.out.println("========================================================");  
  }
  /** Secara acak memilih salah satu Entrance, kemudian membuat sebuah .
    * jalur tour yang menampilkan serangkaian
    * experience yang akan dialami pengunjung  berdasarkan interaksi dengan
    * hewan-hewan yang dilalui tour tersebut. 
    */

  public void tourVirtualZoo() {
    Point[] entranceList = new Point[10];
    int nentrance = 0;
    //Mendata Entrance yang ada
    for (int i = 0;i < height; i++) {
      for (int j = 0;j < width; j++) {
        if (virtualZoo.getZooElmt(i,j).getCellType() == "Facility") {
          if (virtualZoo.getZooElmt(i,j).getFacHabType() == "Entrance") {
            entranceList[nentrance] = new Point(j,i);
            nentrance++;
          }
        }
      }
    }
    //Inisialisasi variabel closed
    boolean[][] isClosed = new boolean [height][width];
    for (int i = 0;i < height; i++) {
      isClosed[i] = new boolean[width];
    }
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        isClosed[i][j] = false;
      }
    }
    //Secara random memilih entrance
    Random rand = new Random();
    int n = rand.nextInt(nentrance);
    guestPos.setX(entranceList[n].getX());
    guestPos.setY(entranceList[n].getY());
    isClosed[guestPos.getY()][guestPos.getX()] = true;
    ScreenCleaner screenCleaner = new ScreenCleaner();
    screenCleaner.clearScreen();
    displayVirtualZoo();
    System.out.println("Tour akan dimulai. tekan enter untuk melanjutkan");
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
    boolean noway = false;
    boolean isExit = false;
    //Loop hingga mencapai exit atau tidak ada road lagi
    while (!noway && !isExit) {
      //pilih arah secara random
      Point dest = new Point(guestPos.getX(),guestPos.getY());
      int dir = rand.nextInt(4) + 1;
      int t = 0;
      boolean isroad = false;
      //cari arah yang valid
      while ((((dest.getY() < 0 || dest.getX() < 0 || dest.getY() >= height 
              || dest.getX() >= width) ? true : 
                isClosed[dest.getY()][dest.getX()]) || !isroad) && t <= 4) {
        if (dir == 4) {
          dest.setY(guestPos.getY() + 1);
          dest.setX(guestPos.getX());
        } else if (dir == 1) {
          dest.setY(guestPos.getY() - 1);
          dest.setX(guestPos.getX());
        } else if (dir == 2) {
          dest.setY(guestPos.getY());
          dest.setX(guestPos.getX() - 1);
        } else if (dir == 3) {
          dest.setY(guestPos.getY());
          dest.setX(guestPos.getX() + 1);
        }
        t++;
        dir = dir % 4 + 1;
        isroad = false;
        if ((dest.getY() < 0 || dest.getX() < 0 || dest.getY() >= height 
            || dest.getX() >= width) ? false : true) {
          if (virtualZoo.getZooElmt(dest.getY(),dest.getX()).getCellType() 
              == "Facility") {
            if (virtualZoo.getZooElmt(dest.getY(),dest.getX()).getFacHabType() 
                  == "Road" 
                  || virtualZoo.getZooElmt(dest.getY(),dest.getX()).getFacHabType() 
                  == "Exit") {
              isroad = true;
            }
          }
        }
      }
      if (t > 4) {
        noway = true;
      } else {
        if (virtualZoo.getZooElmt(guestPos.getY(),guestPos.getX())
            .getCellType() == "Facility") {
          if (virtualZoo.getZooElmt(guestPos.getY(),guestPos.getX())
              .getFacHabType() == "Exit") {
            isExit = true;
          }
        }
      }
      if (!noway && !isExit) {
        guestPos.setX(dest.getX());
        guestPos.setY(dest.getY());
        isClosed[guestPos.getY()][guestPos.getX()] = true;
        screenCleaner.clearScreen();
        moveAnimal();
        displayVirtualZoo();
        //Variabel pointer ke animal yang ada di cage yang bersisian di sebelah
        Animal[] nearbyAnimal = new Animal [maxAnimal];
        int nearAnimal = 0;
        //Variabel menyimpan data facility yang bersebelahan dengan posisi player
        Cell[] nearbyFacility = new Cell[4];
        int nearFac = 0;
        //Coba untuk setiap arah
        for (dir = 1; dir <= 4; dir++) {
          if (dir == 4) {
            dest.setY(guestPos.getY() + 1);
            dest.setX(guestPos.getX());
          } else if (dir == 1) {
            dest.setY(guestPos.getY() - 1);
            dest.setX(guestPos.getX());
          } else if (dir == 2) {
            dest.setY(guestPos.getY());
            dest.setX(guestPos.getX() - 1);
          } else if (dir == 3) {
            dest.setY(guestPos.getY());
            dest.setX(guestPos.getX() + 1);
          }
          if (dest.getY() < 0 || dest.getX() < 0 || dest.getY() >= height 
              || dest.getX() >= width) {
            //donothinng
          } else if (virtualZoo.getZooElmt(dest.getY(),dest.getX())
              .getCellType() == "Facility") {  
            String type = virtualZoo.getZooElmt(dest.getY(),dest.getX()).getFacHabType();
            if (type != "Road" && type != "Entrance" && type != "Exit") {
              //Cari apakah facility dengan jenis tersebut sudah ada
              int k = 0;
              boolean exist = false;
              while (k < nearFac && !exist) {
                if (nearbyFacility[k].getFacHabType() 
                    == virtualZoo.getZooElmt(dest.getY(),dest.getX())
                    .getFacHabType()) {
                  exist = true;
                }
                k++;
              }
              if (!exist) {
                nearbyFacility[nearFac] = virtualZoo.getZooElmt(dest.getY(),dest.getX());
                nearFac++;  
              }
            }
          } else if (virtualZoo.getZooElmt(dest.getY(),dest.getX())
                    .getCellType() == "Habitat") {
            //Cari apakah ada kandang di habitat  itu
            boolean found = false;
            int i = 0;
            while (i < maxCage && !found) {
              if (isAdaCage[i]) {  
                int j = 0;
                while (j < cageList[i].getCageSize() && !found) {
                  if (cageList[i].getAreaElmt(j).getX() == dest.getX() 
                      && cageList[i].getAreaElmt(j).getY() == dest.getY()) {
                    found = true;
                  } else {
                    j++;
                  }
                }
              }
              if (!found) {
                i++;
              }
            }
            //Ada cage, data ada animal apa saja 
            if (found) {
              //Telusuri animal
              for (int j = 0; j < cageList[i].numberOfAnimal(); j++) {
                String animalspeci = cageList[i].getAnimal(j).getSpeciesName();
                //cari apakah spesies animal sudah ada di list
                int k = 0;
                boolean exist = false;
                while (k < nearAnimal && !exist) {
                  if (nearbyAnimal[k].getSpeciesName() == animalspeci) {
                    exist = true;
                  }
                  k++;
                }  
                //Tambahkan animal jika belum ada
                if (!exist) {
                  nearbyAnimal [nearAnimal] = cageList[i].getAnimal(j);
                  nearAnimal++;
                }                
              }
            }
          }
        }
        int x = 0;
        //Tampilkan pilihan
        while (x != 1) {
          n = 1;
          System.out.println("Pilihan aksi: ");
          System.out.println(n + ". Lanjut Tour");
          n++;
          for (int i = 0; i < nearAnimal; i++) {
            System.out.println(n + ". Interaksi dengan " 
                + nearbyAnimal[i].getSpeciesName());
            n++;
          }
          for (int i = 0; i < nearFac;i++) {
            System.out.println(n + ". Masuk ke " 
                + nearbyFacility[i].getFacHabType());
            n++;
          }
          System.out.println("Masukkan pilihan: ");
          x = scanner.nextInt();
          while (x < 1 || x >= n) {
            System.out.print("Pilihan salah. Ulangi: ");
            x = scanner.nextInt();
          }
          if (x != 1) {  
            if (x <= nearAnimal + 1) {
              System.out.print(nearbyAnimal[x - 2].getSpeciesName() + ": ");
              nearbyAnimal[x - 2].interact();
              System.out.println();
              nearbyAnimal[x - 2].deskripsi();
              System.out.println();
              System.out.println();
            } else {
              nearbyFacility[x - nearAnimal - 2].enter();
              System.out.println();
            }
          }
        }
      }
    }
    System.out.println("\nTour selesai.");
  }
  /** Mencetak seluruh hewan dalam map.
   */

  public void printAllAnimal() {
    int count = 0;
    for (int i = 0; i < maxCage; i++) {
      if (isAdaCage[i]) {
        for (int j = 0; j < cageList[i].numberOfAnimal(); j++) {
          count++;
          System.out.println(count + "." + cageList[i].getAnimal(j).getSpeciesName());
        }
      }
    }
  }
}
