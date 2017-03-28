//File: Driver.java
//Author: David Theosaksomo
//NIM: 13515131
package virtualzoo.driver;
import java.util.Scanner; 
import java.util.Random;
import virtualzoo.animal.Animal;
import virtualzoo.cage.Cage;
import virtualzoo.cell.Cell;
import virtualzoo.util.mesinkar.Mesinkar;
import virtualzoo.util.point.Point;
import virtualzoo.util.screencleaner.ScreenCleaner;
import virtualzoo.zoo.Zoo;

/** Class zoo memiliki atribut  matriks Cell dimana 1 cell merepresentasikan 
  * sebuah petak 1x1m
  * @author David Theosaksomo/13515131
  * @version 1.0, March 2017
  */
public class Driver {

  private int height;
  private int width;
  private Zoo virtual_zoo;
  private Cage[] cage_list;
  private Animal[] animal_list;
  private final int max_cage = 20;
  private final int max_animal = 100;
  private final int max_area_in_cage = 50;
  private final int default_height = 100;
  private final int default_width = 100;
  private Point guest_pos;
  private int n_animal = 0;
  private boolean[] is_ada_cage;
  /** Driver program Virtual Zoo
   * 
   */
  public Driver(){
    virtual_zoo = new Zoo(default_width,default_height);
    guest_pos = new Point(-1,-1);
    Mesinkar msk = new Mesinkar();
      //Baca File dan Inisialisasi Zoo;
    msk.START();

    width = msk.GetCI();
    msk.ADV();
    msk.ADV();
    height = msk.GetCI();
    msk.ADV();

    cage_list = new Cage [max_cage];
    animal_list = new Animal [max_animal];

    //Ciptakan variabel temporary
    int[] ukuran_cage = new int [max_cage];
    for (int i = 0; i < max_cage; i++) {
      ukuran_cage[i] = 0;
    }
    is_ada_cage = new boolean [max_cage];
    for (int i = 0; i < max_cage; i++) {
      is_ada_cage[i] = false;
    }
    Point[][] area_list = new Point[max_cage][max_area_in_cage];
    for (int i = 0; i < max_cage; i++) {
      for (int j = 0; j < max_area_in_cage; j++) {
        area_list[i][j] = new Point();
      }  
    }
    String[] cage_type = new String [max_cage];
    for (int i = 0; i < max_cage; i++) {
      cage_type[i] = new String(".");
    }
    int[][] animal_index = new int [height+1][width+1];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        animal_index[i][j] = -1;
      }
    }

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        switch(msk.GetCC())
				{
					case 'A' :
						{
						Cell A = new Cell("Air");
						virtual_zoo.SetZooElmt(i,j,A);
						}
					break;
					case 'L' :
					{
						Cell B = new Cell("Land");
						
						virtual_zoo.SetZooElmt(i,j,B);
					}
					break;
					case 'W' :
					{
						Cell C = new Cell("Water");
						virtual_zoo.SetZooElmt(i,j,C);
					}
					break;
					case 'P' :
					{
						Cell D = new Cell("Park");
						D.AddPilihan("RollerCosty");
						D.AddPilihan("PutingBeliung");
						D.AddPilihan("RumahZombie");

						virtual_zoo.SetZooElmt(i,j,D);
					}
					break;
					case 'R' :
					{
						Cell E = new Cell("Restaurant");

						E.AddPilihan("Nasi Bakar dengan sayur bayam");
						E.AddPilihan("Steak Daging Asap dengan wortel ");
						E.AddPilihan("Es Krim Pakai Brokoli");

						virtual_zoo.SetZooElmt(i,j,E);
					}
					break;
					case '_' :
					{
						Cell F = new Cell("Road");

						virtual_zoo.SetZooElmt(i,j,F);
					}
					break;
					case 'E' :
					{
						Cell G = new Cell("Entrance");

						virtual_zoo.SetZooElmt(i,j,G);
					}
					break;
					case 'X' :
					{
						Cell H = new Cell("Exit");
						
						virtual_zoo.SetZooElmt(i,j,H);
					}
					break;
				}

				//Jika Cell merupakan Habitat
				if(msk.GetCC() == 'A' || msk.GetCC() == 'L' || msk.GetCC() == 'W')
				{

					//Tambahkan Cage
					char tm = msk.GetCC();
					msk.ADV();

					int num = msk.GetCI();
					//Jika ada cage
					if(num >0)
					{	
						num--;
						//Jika Cage untuk id tersebut belum dibuat
						if(!is_ada_cage[num])
						{
							is_ada_cage[num] = true;
							switch(tm)
							{
								case 'A' :
								{
									cage_type[num] = "Air";
								}
								break;
								case 'L' :
								{
									cage_type[num] = "Land";
									
								}
								break;
								case 'W' :
								{
									cage_type[num] = "Water";
									
								}
								break;
								
							}
						}
						if((tm == 'A' && cage_type[num] == "Air") || (tm == 'L' && 
                cage_type[num] == "Land") || (tm == 'W' && 
                cage_type[num] == "Water"))
						{
							area_list[num][ukuran_cage[num]].SetX(j);
							area_list[num][ukuran_cage[num]].SetY(i);
							ukuran_cage[num] ++;

							//Pembacaan Animal
							msk.ADV();
							
							if(msk.GetCC() != '-')	
							{
								
								animal_list[n_animal] = new Animal(msk.GetCC());
								animal_index[i][j] = n_animal;
								n_animal++;
							}

							

						}
						else
							{
								msk.ADV();
							}
							
					}
				}
        msk.ADV();
      }  
    }
        //Alokasi cage sesuai data file eksternal
    for (int i = 0; i < max_cage; i++) {
      if (is_ada_cage[i]) {
        cage_list[i] = new Cage(i+1, area_list[i], ukuran_cage[i], cage_type[i]);
      }
    }

    //Isicage dengan animal sesuai pembacaan file eksternal
    for (int i = 0; i < max_cage; i++) {
      if (is_ada_cage[i]) {
        for (int j = 0; j < cage_list[i].GetCageSize(); j++) {
          int m = cage_list[i].GetAreaElmt(j).GetX();
          int n = cage_list[i].GetAreaElmt(j).GetY();
          //Ada animal di posisi itu
          if (animal_index[n][m] >= 0 && animal_index[n][m] < n_animal) {
            //Masukkan hewan kedalam cage
            cage_list[i].InputAnimal(animal_list[animal_index[n][m]],j);
          }
        }
      }
    }


  }
   /** Menampilkan Zoo diatas layar dengan method render.
     */
  public void DisplayVirtualZoo(){
    Point up = new Point(0,0);
    Point down = new Point(width-1,height-1);
    DisplayVirtualZoo(up,down);
  }
  /** Menampilkan Zoo diatas layar dengan method render.
   * @param upleft kordinat atas kiri
   * @param downright kordinat bawah kanan
   */
  public void DisplayVirtualZoo(Point upleft, Point downright){
     //Inisialisasi variabel antara
    int[][] cage_matrix = new int[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        cage_matrix[i][j] = -1;
      }
    }
    Point [][] animal_matrix = new Point[height][width];
    for (int i = 0;i < height; i++) {
      for (int j = 0;j<width;j++) {
        animal_matrix[i][j] = new Point(-1,-1);
      }
    }
    //Variabel char cage dan animal
    for (int i = 0; i < max_cage; i++) {
      if (is_ada_cage[i]) {
        for (int j = 0; j < cage_list[i].GetCageSize(); j++) {
          int m = cage_list[i].GetAreaElmt(j).GetX();
          int n = cage_list[i].GetAreaElmt(j).GetY();
          cage_matrix[n][m] = i;
        }
        for (int j = 0; j < cage_list[i].NumberOfAnimal(); j++) {
          int m = cage_list[i].GetAnimal(j).GetPosition().GetX();
          int n = cage_list[i].GetAnimal(j).GetPosition().GetY();
          animal_matrix[n][m].SetX(i);
          animal_matrix[n][m].SetY(j);
        }
      }
    }
    //Create Garis Horizontal
    for (int k = upleft.GetX() * 4; k < (downright.GetX()+1) * 4; k++) {
      System.out.print("_");
    }
    System.out.println('_');

    for (int i = upleft.GetY(); i < downright.GetY()+1; i++) {
      for (int k = upleft.GetX() * 4; k < (downright.GetX()+1) * 4; k++) {
        if (k % 4 == 0) {
          System.out.print("|");
        }
        else
        if (k % 4 == 1) {
            System.out.print(" ");
        }
        else
        if (k % 4 == 2) {
          // Jika ada kandang
          if (cage_matrix[i][k/4] >= 0) {
            
            virtual_zoo.GetZooElmt(i,k/4).Render(true);
          }
          else {
            virtual_zoo.GetZooElmt(i,k /4).Render();
          }
        }
        else {
        System.out.print(" ");
        }
      }
        System.out.println('|');

      for (int k = upleft.GetX() * 4; k < (downright.GetX()+1) * 4; k++) {
        if (k % 4 == 0) {
          System.out.print('|');
        }
        else
        if (k % 4 == 2) {  
          if (i == guest_pos.GetY() && k/4 == guest_pos.GetX()) {
            System.out.print("&");
          }
          else
          if (animal_matrix[i][k/4].GetX() >= 0)
            cage_list[animal_matrix[i][k/4].GetX()].GetAnimal(animal_matrix[i][k/4].GetY()).Render();
          else {
            System.out.print("_");
          } } else {
        System.out.print("_");
        }
      }
        System.out.println('|');
    }
  }
  /** Menghitung jumlah makanan seluruh hewan
   */
  public void HitungMakanan(){
    double daging = 0;
    double sayur = 0;
    double omni = 0;
    //hitung makanan masing-masing
    for (int i = 0; i < max_cage; i++) {
      if (is_ada_cage[i]) {
        for (int j = 0; j < cage_list[i].NumberOfAnimal(); j++) {
          String type = cage_list[i].GetAnimal(j).GetFoodType();
          double foodnum = cage_list[i].GetAnimal(j).GetFoodNum();
          if (type == "Omnivore") {
            omni += foodnum;
          }
          else if (type == "Carnivore"){
            daging += foodnum;
          }
          else if (type == "Herbivore") {
            sayur += foodnum;
          }
          else {
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
  /** Menggerakan hewan
   */
  public void MoveAnimal(){
    for (int i = 0; i < max_cage; i++) {
      if (is_ada_cage[i]) {
        cage_list[i].MoveAnimal();
      }
    }
  }
  /** Mencetak Judul Program Virtual Zoo
   */
  public void PrintTitle(){
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
   /** Secara acak memilih salah satu Entrance, kemudian membuat sebuah 
     * jalur tour yang menampilkan serangkaian
     * experience yang akan dialami pengunjung  berdasarkan interaksi dengan
     * hewan-hewan yang dilalui tour tersebut. 
     */
  public void TourVirtualZoo(){
    Point[] entrance_list = new Point[10];

    int n_entrance = 0;
    //Mendata Entrance yang ada
    for (int i = 0;i < height; i++) {
      for (int j = 0;j < width; j++) {
        if (virtual_zoo.GetZooElmt(i,j).GetCellType() == "Facility") {
          if (virtual_zoo.GetZooElmt(i,j).GetFacHabType() == "Entrance") {
          entrance_list[n_entrance] = new Point(j,i);
          n_entrance++;
          }
        }
      }
    }
    //Inisialisasi variabel closed
    boolean[][] is_closed = new boolean [height][width];
    for (int i = 0;i < height; i++) {
      is_closed[i] = new boolean[width];
    }
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        is_closed[i][j] = false;
      }
    }
    //Secara random memilih entrance
    Random rand = new Random();
    int n = rand.nextInt(n_entrance);
    guest_pos.SetX(entrance_list[n].GetX());
    guest_pos.SetY(entrance_list[n].GetY());
    is_closed[guest_pos.GetY()][guest_pos.GetX()] = true;
    ScreenCleaner screen_cleaner = new ScreenCleaner();
    screen_cleaner.ClearScreen();
    DisplayVirtualZoo();
    System.out.println("Tour akan dimulai. tekan enter untuk melanjutkan");
    Scanner scanner = new Scanner(System.in);
    scanner.nextLine();
    

    boolean noway = false;
    boolean is_exit = false;
    //Loop hingga mencapai exit atau tidak ada road lagi
    while (!noway && !is_exit)
    {
      //pilih arah secara random
      Point dest = new Point(guest_pos.GetX(),guest_pos.GetY());
      int dir = rand.nextInt(4) +1;
      int t = 0;
      boolean isroad =false;
      //cari arah yang valid
      while ((((dest.GetY() <0 || dest.GetX() <0 || dest.GetY()>=height || 
                dest.GetX()>= width) ? true : 
                is_closed[dest.GetY()][dest.GetX()]) || !isroad)&& t <=4)
      {
        if (dir == 4) {
          dest.SetY(guest_pos.GetY()+1);
          dest.SetX(guest_pos.GetX());
        } else 
        if (dir == 1) {
          dest.SetY(guest_pos.GetY()-1);
          dest.SetX(guest_pos.GetX());

        } else 
        if (dir==2) {
          dest.SetY(guest_pos.GetY());
          dest.SetX(guest_pos.GetX()-1);
        } else 
        if (dir==3) {
        dest.SetY(guest_pos.GetY());
          dest.SetX(guest_pos.GetX()+1);
        }
        t++;
        dir = dir % 4 + 1;
        isroad = false;
        if ((dest.GetY() <0 || dest.GetX() <0 || dest.GetY()>=height || 
           dest.GetX() >= width) ? false : true)
        if (virtual_zoo.GetZooElmt(dest.GetY(),dest.GetX()).GetCellType() 
          == "Facility") {
          if (virtual_zoo.GetZooElmt(dest.GetY(),dest.GetX()).GetFacHabType() 
              == "Road" || 
              virtual_zoo.GetZooElmt(dest.GetY(),dest.GetX()).GetFacHabType() 
              == "Exit" ) {
            isroad = true;
          }
        }
      }
      if (t > 4) {
        noway = true;
      }
      else {
          if (virtual_zoo.GetZooElmt(guest_pos.GetY(),guest_pos.GetX()).GetCellType() 
              == "Facility") {
            if (virtual_zoo.GetZooElmt(guest_pos.GetY(),guest_pos.GetX()).GetFacHabType() 
                == "Exit") {
              is_exit = true;
            }
          }
      }
      if (!noway && !is_exit) {
        guest_pos.SetX(dest.GetX());
        guest_pos.SetY(dest.GetY());
        is_closed[guest_pos.GetY()][guest_pos.GetX()] = true;
        screen_cleaner.ClearScreen();
        MoveAnimal();
        DisplayVirtualZoo();
        //Variabel pointer ke animal yang ada di cage yang bersisian di sebelah
        Animal[] nearby_animal = new Animal [max_animal];
        int near_animal =0;
        //Variabel menyimpan data facility yang bersebelahan dengan posisi player
        Cell[] nearby_facility = new Cell[4];
        int nearfac = 0;
        //Coba untuk setiap arah
        for (dir = 1; dir <= 4; dir++) {
          if (dir == 4) {
          dest.SetY(guest_pos.GetY()+1);
          dest.SetX(guest_pos.GetX());
          } else 
          if (dir == 1) {
            dest.SetY(guest_pos.GetY()-1);
            dest.SetX(guest_pos.GetX());
          } else 
          if (dir == 2) {
            dest.SetY(guest_pos.GetY());
            dest.SetX(guest_pos.GetX()-1);
          } else 
          if (dir == 3) {
            dest.SetY(guest_pos.GetY());
            dest.SetX(guest_pos.GetX()+1);
          }
          if (dest.GetY() < 0 || dest.GetX() < 0 || dest.GetY() >= height || 
              dest.GetX() >= width) {
            //donothinng
          }
          else
          if (virtual_zoo.GetZooElmt(dest.GetY(),dest.GetX()).GetCellType() 
              == "Facility") {  
            String type = virtual_zoo.GetZooElmt(dest.GetY(),dest.GetX()).GetFacHabType();
            if (type != "Road" && type != "Entrance" && type != "Exit") {
              //Cari apakah facility dengan jenis tersebut sudah ada
              int k = 0;
              boolean exist = false;
              while (k < nearfac && !exist) {
                if (nearby_facility[k].GetFacHabType() == 
                  virtual_zoo.GetZooElmt(dest.GetY(),dest.GetX()).GetFacHabType()) {
                  exist = true;
                }
                k++;
              }
              if (!exist) {
                nearby_facility[nearfac] = virtual_zoo.GetZooElmt(dest.GetY(),dest.GetX());
                nearfac++;  
              }
            }
          }
          else
          if (virtual_zoo.GetZooElmt(dest.GetY(),dest.GetX()).GetCellType() == "Habitat")
          {
            //Cari apakah ada kandang di habitat  itu
            boolean found = false;
            int i = 0;
            while ( i < max_cage && !found) {
              if (is_ada_cage[i]) {  
                int j = 0;
                while (j < cage_list[i].GetCageSize() && !found) {
                  if (cage_list[i].GetAreaElmt(j).GetX() == dest.GetX() &&
                      cage_list[i].GetAreaElmt(j).GetY() == dest.GetY()) {
                    found = true;
                  }
                  else {
                    j++;
                  }
                }
              }
              if (!found)
              i++;
            }
            //Ada cage, data ada animal apa saja 
            if (found) {
                //Telusuri animal
                for (int j = 0; j < cage_list[i].NumberOfAnimal(); j++) {
                  String animalspeci = cage_list[i].GetAnimal(j).GetSpeciesName();
                  //cari apakah spesies animal sudah ada di list
                  int k = 0;
                  boolean exist = false;
                  while (k < near_animal && !exist) {
                    if (nearby_animal[k].GetSpeciesName() == animalspeci) {
                      exist = true;
                    }
                    k++;
                  }  
                  //Tambahkan animal jika belum ada
                  if (!exist) {
                    nearby_animal [near_animal] = cage_list[i].GetAnimal(j);
                    near_animal++;
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
          for (int i = 0; i < near_animal; i++) {
            System.out.println(n + ". Interaksi dengan " + 
            nearby_animal[i].GetSpeciesName());
            n++;
          }
          for (int i =0; i<nearfac;i++)
          {
            System.out.println(n + ". Masuk ke " +
            nearby_facility[i].GetFacHabType());
            n++;
          }
          System.out.println("Masukkan pilihan: ");
          x = scanner.nextInt();
          while (x < 1 || x >= n) {
            System.out.print("Pilihan salah. Ulangi: ");
            x = scanner.nextInt();
          }
          if (x !=1 ) {  
            if (x <= near_animal +1) {
              System.out.print(nearby_animal[x-2].GetSpeciesName() + ": ");
               nearby_animal[x-2].Interact();
              System.out.println();
               nearby_animal[x-2].Deskripsi();
              System.out.println();
              System.out.println();
            }
            else {
              nearby_facility[x-near_animal-2].Enter();
              System.out.println();
            }
          }
        }
      }
    }
    System.out.println("\nTour selesai.");
  }
  /** Mencetak seluruh hewan dalam map
   */
  public void PrintAllAnimal(){
    int count = 0;
    for (int i = 0; i < max_cage; i++) {
      if (is_ada_cage[i]) {
        for (int j = 0; j < cage_list[i].NumberOfAnimal(); j++) {
          count++;
          System.out.println(count + "." + cage_list[i].GetAnimal(j).GetSpeciesName());
        }
      }
    }
  }
}
