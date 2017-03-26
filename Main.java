import java.util.Scanner;

public class Main {
  public static int Main() {
    Driver d = new Driver();
    Scanner s = new Scanner(System.in);
    int input;
    d.PrintTitle();
    d.DisplayVirtualZoo();
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
      System.out.print("4. Exit program");
      System.out.print("\n");
      System.out.print("Masukkan pilihan : ");
      input = s.nextInt();
      if (input == 1) {
        System.out.print("\n");
        d.PrintAllAnimal();
      }
      else if (input == 2) {
        System.out.print("\n");
        d.HitungMakanan();
      }
      else if (input == 3) {
        System.out.print("\n");
        d.TourVirtualZoo();
      }
      else if (input == 4) {}
      else {
        System.out.print("\n");
        System.out.print("input pilihan salah, ulangi kembali");
        System.out.print("\n");
      }
    } while (input != 4);
    return 0;
  }
}