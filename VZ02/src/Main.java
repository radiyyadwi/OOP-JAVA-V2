import java.util.Scanner;
import virtualzoo.driver.Driver;
import virtualzoo.util.point.Point;
/** Class untuk menjadi menu program dan menjalankan.
 * keseluruhan program
 * @author David Theosaksomo/13515131
 * @version 1.0 , March 2017
 */

public class Main {
  /** MainProgram.
   *@param args.
   */
  public static void main(String[] args) {
    int x1;
    int x2;
    int y1;
    int y2;
    Driver driver = new Driver();
    Scanner scanner = new Scanner(System.in);
    int input;
    driver.printTitle();
    driver.displayVirtualZoo();
    do {
      System.out.print("\n");
      System.out.print("Pilihan fitur : ");
      System.out.print("\n");
      System.out.print("1. Tampilkan hewan yang ada");
      System.out.print("\n");
      System.out.print("2. Tampilkan jumlah makanan");
      System.out.print("\n");
      System.out.print("3. Tour kebun binatang");
      System.out.print("\n");
      System.out.print("4. Display zoo");
      System.out.print("\n");
      System.out.print("5. Exit program");
      System.out.print("\n");
      System.out.print("Masukkan pilihan : ");
      input = scanner.nextInt();
      if (input == 1) {
        System.out.print("\n");
        driver.printAllAnimal();
      } else {
        if (input == 2) {
          System.out.print("\n");
          driver.hitungMakanan();
        } else {
          if (input == 3) {
            System.out.print("\n");
            driver.tourVirtualZoo();
          } else {
            if (input == 4) {
              System.out.print("Masukan x1: ");
              x1 = scanner.nextInt();
              System.out.print("Masukan y1: ");
              y1 = scanner.nextInt();
              System.out.print("Masukan x2: ");
              x2 = scanner.nextInt();
              System.out.print("Masukan y2: ");
              y2 = scanner.nextInt();
              if (x1 >= 0 && x2 >= 0 && x2 > x1 && y2 > y1) {
                Point titik1 = new Point(x1, y1);
                Point titik2 = new Point(x2, y2);
                driver.displayVirtualZoo(titik1, titik2);
              } else {
                System.out.print("Input salah.");
                System.out.print("\n");
              }
            } else 
              if (input != 5) {
                System.out.print("\n");
                System.out.print("input pilihan salah, ulangi kembali");
                System.out.print("\n");
              }
          }
        }
      }
    } while (input != 5);
  }
}