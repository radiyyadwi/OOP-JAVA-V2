//File : Animal.java
//Nama : Radiyya Dwisaputra
//NIM : 13515023

package virtualzoo.animal;

import virtualzoo.util.point.Point;
/** Class yang menjadi base class dari kelas turunan real animal
 * @author Radiyya Dwisaputra/13515023
 * @version 1.0, March 2017
 */

public class Animal {
  private char symbol;
  private boolean tamed;
  private String foodType;
  private String deskripsi;
  private String className;
  private double weight;
  private double foodPerDay;
  private String[] animalType = new String[3];
  private String speciesName;
  private String[] enemyList;
  private Point position;
  private int nenemy = 0;
  /**
   * Constructor object Animal.
   * @see java.lang.reflect.Constructor
   */

  public Animal() {
    Animal x = new Animal('a');
  }
  /**Constructor.
    * Mengisi atribut Animal sesuai parameter  
    * @param animalcode kode animal yang ingin dimasukkan
    */

  public Animal(char animalcode) {
    enemyList = new String[20];
    symbol = animalcode;
    position = new Point(-1,-1);
    tamed = true;
    switch (animalcode) {
      case 'a' : {
        speciesName = "Angsa";
        weight = 5.1;
        foodType = "Omnivore";
        addAnimalType("Flying");
        addAnimalType("Land");
        className = "Aves";
        deskripsi = "Aves merupakan kelas kelompok hewan vertebrata yang memiliki"
          + " bulu dan sayap";
      } break;
      case 'b' : {
        speciesName = "BerangBerang";
        weight = 27;
        foodType = "Herbivore";
        addAnimalType("Land");
        addAnimalType("Water");
        className = "Mammal";
        deskripsi = "Mammalia merupakan kelas hewan vertebrata yang ciri utama "
          + "nya memiliki kelenjar susu";
      } break;
      case 'c' : {
        speciesName = "BurungCekakak";
        weight = 0.1;
        foodType = "Omnivore";
        addAnimalType("Flying");
        className = "Aves";
        deskripsi = "Aves merupakan kelas kelompok hewan vertebrata yang memiliki"
          + " bulu dan sayap";
      } break;
      case 'e' : {
        speciesName = "ElangBotak";
        weight = 4;
        foodType = "Carnivore";
        addAnimalType("Flying");
        className = "Aves";
        deskripsi = "Aves merupakan kelas kelompok hewan vertebrata yang memiliki"
          + " bulu dan sayap";
      } break;
      case 'f' : {
        speciesName = "Fossa";
        weight = 10.0;
        foodType = "Carnivore";
        addAnimalType("Land");
        className = "Mammal";
        deskripsi = "Mammalia merupakan kelas hewan vertebrata yang ciri utama "
          + "nya memiliki kelenjar susu";
        tamed = false;
        addEnemy("Kiwi");
        addEnemy("Kungkang");
        addEnemy("Okapi");
        addEnemy("Yak");
      } break;
      case 'g' : {
        speciesName = "IkanSungutGanda";
        weight = 32;
        foodType = "Carnivore";
        addAnimalType("Water");
        className = "Actinopterygii";
        deskripsi = "Actinopterygii adalah ikan yang memiliki sirip kipas";
      } break;    
      case 'h' : {
        speciesName = "HiuGoblin";
        weight = 210;
        foodType = "Carnivore";
        addAnimalType("Water");
        className = "Chondrichtyes";
        deskripsi = "Chondrichthyes merupakan ikan dengan tulang rawan";
        tamed = false;
        addEnemy("IkanCupang");
        addEnemy("IkanKalajengking");
        addEnemy("IkanSungutGanda");
      } break;
      case 'i' : {
        speciesName = "IkanCupang";
        weight = 0.03;
        foodType = "Carnivore";
        addAnimalType("Water");
        className = "Actinopterygii";
        deskripsi = "Actinopterygii adalah ikan yang memiliki sirip kipas";
      } break;
      case 'j' : {
        speciesName = "BurungJulang";
        weight = 10;
        foodType = "Herbivore";
        addAnimalType("Flying");
        className = "Aves";
        deskripsi = "Aves merupakan kelas kelompok hewan vertebrata yang memiliki" 
          + " bulu dan sayap";
      } break;
      case 'k' : {
        speciesName = "Kungkang.h";
        weight = 10.0;
        foodType = "Omnivore";
        addAnimalType("Land");
        className = "Mammal";
        deskripsi = "Mammalia merupakan kelas hewan vertebrata yang ciri utama "
          + "nya memiliki kelenjar susu";
      } break;
      case 'l' : {
        speciesName = "IkanKalajengking";
        weight = 0.3;
        foodType = "Omnivore";
        addAnimalType("Water");
        className = "Actinopterygii";
        deskripsi = "Actinopterygii adalah ikan yang memiliki sirip kipas";
      } break;
      case 'n' : {
        speciesName = "Narwhal";
        weight = 1000;
        foodType = "Carnivore";
        addAnimalType("Water");
        className = "Mammal";
        deskripsi = "Mammalia merupakan kelas hewan vertebrata yang ciri utama "
          + "nya memiliki kelenjar susu";
      } break;
      case 'o' : {
        speciesName = "Okapi";
        weight = 250;
        foodType = "Herbivore";
        addAnimalType("Land");
        className = "Mammal";
        deskripsi = "Mammalia merupakan kelas hewan vertebrata yang ciri utama "
          + "nya memiliki kelenjar susu";        
      } break;
      case 'p' : {
        speciesName = "Platypus";
        weight = 2;
        foodType = "Carnivore";
        addAnimalType("Water");
        addAnimalType("Land");
        className = "Mammal";
        deskripsi = "Mammalia merupakan kelas hewan vertebrata yang ciri utama "
          + "nya memiliki kelenjar susu";    
      } break;
      case 'r' : {
        speciesName = "Orca";
        weight = 7700;
        foodType = "Carnivore";
        addAnimalType("Water");
        className = "Mammal";
        deskripsi = "Mammalia merupakan kelas hewan vertebrata yang ciri utama "
          + "nya memiliki kelenjar susu";
        tamed = false;
        addEnemy("HiuGoblin");
        addEnemy("IkanCupang");
        addEnemy("IkanKalajengking");
        addEnemy("IkanSungutGanda");
      } break;
      case 's' : {
        speciesName = "SemutPanda";
        weight = 0.1;
        foodType = "Herbivore";
        addAnimalType("Land");
        className = "Insect";
        deskripsi = "Insect merupakan hewan avertebrata yang terdiri dari 3 "
          + "bagian tubuh, dan bernafas dengan trakea";
      } break;
      case 't' : {
        speciesName = "TikusMondokBerhidungBintang";
        weight = 0.1;
        foodType = "Carnivore";
        addAnimalType("Water");
        addAnimalType("Land");
      } break;
      case 'u' : {
        speciesName = "Undan";
        weight = 5;
        foodType = "Carnivore";
        addAnimalType("Flying");
        className = "Aves";
        deskripsi = "Aves merupakan kelas kelompok hewan vertebrata yang memiliki"
          + " bulu dan sayap";
      } break;
      case 'w' : {
        speciesName = "Kiwi";
        weight = 2.4;
        foodType = "Omnivore";
        addAnimalType("Land");
        className = "Aves";
        deskripsi = "Aves merupakan kelas kelompok hewan vertebrata yang memiliki"
          + " bulu dan sayap";
      } break;
      case 'y' : {
        speciesName = "Yak";
        weight = 500;
        foodType = "Herbivore";
        addAnimalType("Land");
        className = "Mammal";
        deskripsi = "Mammalia merupakan kelas hewan vertebrata yang ciri utama "
          + "nya memiliki kelenjar susu";
      } break;
      default : {
      } break;
    }
    foodPerDay = weight / 4;
  }
  /**
   * Mengubah posisi animal.  
   * @param p posisi yang diinginkan
   */

  public void setPosition(Point p) {
    position.setX(p.getX());
    position.setY(p.getY());
  }
  /** Mendapatkan type makanan hewan.
   * @return type makanan dari hewan
   */

  public String getFoodType() {
    return foodType;
  }
  /** Menghasilkan deskripsi tentang animal.
    * 
    * @return deskripsi hewan 
    */

  public String getDeskripsi() {
    return deskripsi;
  }
  /** Menghasilkan nama kelas animal.
    * @return kelas animal
    */

  public String getClassName() {
    return className;
  }
  /** Menghasilkan posisi animal.
    * @return Point posisi animal berada
    */

  public Point getPosition() {
    return position;
  }
  /** Memperoleh nama spesies dari animal.
    * @return String nama species dari hewan 
    */

  public String getSpeciesName() {
    return speciesName;
  }
  /** Memperoleh jumlah makanan dari animal.
   *  @return jumlah makanan dalam double
   */

  public double getFoodNum() {
    return foodPerDay;
  }
  /** Mengecek hewan merupakan musuh atau bukan.
   *  @return true bila merupakan musuh selain itu tidak
   */

  public boolean isEnemy(String animal) {
    int i = 0;
    boolean found = false;

    while (i < 20 && !found) {
      if (animal == enemyList[i]) {
        found = true;
      }
      i++;
    }
    return found;
  }
  /** Mengembalikan apakah hewan jinak.
   * @return boolean true bila hewan jinak
   */

  public boolean isTamed() {
    return tamed;
  }
  /** Cara interaski hewan dengan pengunjung.
   */

  public void interact() {
    switch (symbol) {
      case 'a' : {
      } break;
      case 'b' : {
        System.out.println("sungai kotor gini gimana mbikin bendungan nya coba?"
            + " -_- ");
      } break;
      case 'c' : {
        System.out.println("Hi I'm Kingfisher Bird! ");
        System.out.println("I can fly at 40km/h top speed ");
      } break;
      case 'e' : {
        System.out.println("wuss");
        System.out.println("aku hewan pemangsa yang kuat bahkan karena "
            + "kekuatankku aku dijadikan simbol negara Amerika Serikat ");
      } break;
      case 'f' : {
        System.out.println("Hi I'm Fossa! ");
        System.out.println("I am found nowhere else except on the island of "
            + "Madagascar ");
      } break;
      case 'g' : {
        System.out.println("Halo aku ikan di bawah laut dalam lho, aku punya "
            + "lampu supaya aku bisa tetap melihat di kegelapan");
      } break;
      case 'h' : {
        System.out.println("I can extend my jaws!");
      } break;
      case 'i' : {
        System.out.println("Ikan, ikan apa yang paling jelek??");
        try {
          Thread.sleep(2000);
        } catch (InterruptedException ex) {
          Thread.currentThread().interrupt();
        }
        System.out.println("I...kan kamu jelek");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException ex) {
          Thread.currentThread().interrupt();
        }
        System.out.println("maap..");
      } break;
      case 'j' : {
        System.out.println("Hai, aku burung berukuran besar, dan aku memiliki "
            + "paruh yang besar ");
      } break;
      case 'k' : {
        System.out.println("Hi I'm Sloth! ");
        System.out.println("I pass my time by sleeping and eating ");
      } break;
      case 'l' : {
        System.out.println("Hi I'm Scorpion Fish! ");
        System.out.println("I am able to stun my prey with my venom before "
            + "eating it ");
      } break;
      case 'n' : {
        System.out.println("Unicorn may be not real, but i'm real!");
      } break;
      case 'o' : {
        System.out.println("nguuut");
        System.out.println("aku hewan yang unik lhooo, aku memiliki badan "
            + "perpaduan antara jerapah dan zebra");  
      } break;
      case 'p' : {
        System.out.println("Sebenarnya aku adalah perry");
      } break;
      case 'r' : {
        System.out.println("Orca itu lumba lumba lhoo bukan paus~");
      } break;
      case 's' : {
        System.out.println("Aku bukan semut, tetapi lebah!");
      } break;
      case 't' : {
        System.out.println("Hidung bintangku sebenarnya adalah alat sensor yang"
            + " dapat mendeteksi gelombang seismic");
      } break;
      case 'u' : {
        System.out.println("Aku merupakan Burung Undan, banyak yang memanggilku "
            + "burung Pelikan, aku suka banget sama kamu eh maksudku ikan");
      } break;
      case 'w' : {
        System.out.println("aku gak gendut, cuman agak bulet dikit..");
      } break;
      case 'y' : {
        System.out.println("Hi I'm Yak! ");
        System.out.println("I am usually found in the mountainous regions of "
            + "central Asia ");
      } break;
      default : {
      }
    }
  }
  /** Menuliskan deskripsi hewan.
   */

  public void deskripsi() {
    System.out.print(getSpeciesName());
    System.out.print(" termasuk dalam kelas ");
    System.out.print(getClassName());
    System.out.println(".");
    System.out.print(getDeskripsi());
  }
  /** Menambahkan tipe hewan. 
  * @param  type tipe hewan antara "Land", "Water" atau "Flying"
  */

  public void addAnimalType(String type) {
    if (animalType[0] != "Flying" && animalType[0] != "Land" 
        && animalType[0] != "Water") {
      animalType[0] = type;
    } else if (animalType[1] != "Flying" && animalType[1] != "Land" 
        && animalType[1] != "Water") {
      animalType[1] = type;
    } else if (animalType[2] != "Flying" && animalType[2] != "Land" 
        && animalType[2] != "Water") {
      animalType[2] = type;
    }
  }
  /** Menambahkan animal enemy ke dalam enemy list. 
  * @param animalname nama hewan yang akan ditambahkan sebagai enemy
  */

  public void addEnemy(String animalname) {
    if (nenemy < 19) {
      enemyList[nenemy] = animalname;
      nenemy++;
    }
  }
  /** Mengecek type yang dimiliki hewan. 
   * @param s type yang akan dicek
   * @return boolean yes bila type itu ada 
   */

  public boolean isTypeThere(String s) {
    boolean found = false;
    boolean ubah = false;
    if (s == "Air") {
      s = "Flying";
      ubah = true;
    }
    for (int i = 0;i < 3;i++) {
      if (animalType[i] == s) {
        found = true;
      }
    }
    if (ubah) {
      s = "Air";
    } 
    return found;
  }
  /** Menuliskan symbol yang mewakili hewan.
   */

  public void render() {
    System.out.print(symbol);
  }
}