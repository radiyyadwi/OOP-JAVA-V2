package virtualzoo.animal;
import virtualzoo.util.point.Point;

public class Animal{
  private char symbol;
  private boolean tamed;
  private String food_type;
  private String deskripsi;
  private String class_name;
  private double weight;
  private double food_per_day;
  private String[] animal_type = new String[3];
  private String species_name;
  private String[] enemy_list;
  private Point position;
  private int nenemy = 0;

  /** @brief Constructor.
    */
  public Animal() {
    Animal X = new Animal ('a');
  }

  /** @brief Constructor.
    * Mengisi atribut Animal sesuai parameter  
    * @param symbol simbol animal pada zoo
    * @param pos posisi animal
    * @param weight berat animal
    * @param food makanan yang dibutuhkan animal

    */

  public Animal(char animalcode) {
    enemy_list = new String[20];
    symbol = animalcode;
    position = new Point(-1,-1);
    tamed = true;
    switch(animalcode)
    {
      case 'a' : {
      species_name = "Angsa";
      weight = 5.1;
      food_type = "Omnivore";
      AddAnimalType("Flying");
      AddAnimalType("Land");
      class_name = "Aves";
      deskripsi = "Aves merupakan kelas kelompok hewan vertebrata yang memiliki bulu dan sayap";
    
    }break;
    case 'b' : {
      species_name = "BerangBerang";
      weight = 27;
      food_type = "Herbivore";
      AddAnimalType("Land");
      AddAnimalType("Water");
      class_name = "Mammal";
      deskripsi = "Mammalia merupakan kelas hewan vertebrata yang ciri utama nya memiliki kelenjar susu";

  
    }break;
    case 'c' : {
      species_name = "BurungCekakak";
      weight = 0.1;
      food_type = "Omnivore";
      AddAnimalType("Flying");
      class_name = "Aves";
      deskripsi = "Aves merupakan kelas kelompok hewan vertebrata yang memiliki bulu dan sayap";
    

    }break;
    case 'e' : {
      species_name = "ElangBotak";
      weight = 4;
      food_type = "Carnivore";
      AddAnimalType("Flying");
      class_name = "Aves";
      deskripsi = "Aves merupakan kelas kelompok hewan vertebrata yang memiliki bulu dan sayap";
    
    }break;
    case 'f' : {
      species_name = "Fossa";
      weight = 10.0;
      food_type = "Carnivore";
      AddAnimalType("Land");
      class_name = "Mammal";
      deskripsi = "Mammalia merupakan kelas hewan vertebrata yang ciri utama nya memiliki kelenjar susu";
      tamed = false;
      AddEnemy("Kiwi");
      AddEnemy("Kungkang");

      AddEnemy("Okapi");

      AddEnemy("Yak");


    }break;
    case 'g' : {
      species_name = "IkanSungutGanda";
      weight = 32;
      food_type = "Carnivore";
      AddAnimalType("Water");
      class_name = "Actinopterygii";
      deskripsi = "Actinopterygii adalah ikan yang memiliki sirip kipas";
    
    }break;
    case 'h' : {
      species_name = "HiuGoblin";
      weight = 210;
      food_type = "Carnivore";
      AddAnimalType("Water");
      class_name = "Chondrichtyes";
      deskripsi = "Chondrichthyes merupakan ikan dengan tulang rawan";
      tamed = false;
      AddEnemy("IkanCupang");
      AddEnemy("IkanKalajengking");
      AddEnemy("IkanSungutGanda");
      
    }break;
    case 'i' : {
      species_name = "IkanCupang";
      weight = 0.03;
      food_type = "Carnivore";
      AddAnimalType("Water");
      class_name = "Actinopterygii";
      deskripsi = "Actinopterygii adalah ikan yang memiliki sirip kipas";
    
    }break;
    case 'j' : {
      species_name = "BurungJulang";
      weight = 10;
      food_type = "Herbivore";
      AddAnimalType("Flying");
      class_name = "Aves";
      deskripsi = "Aves merupakan kelas kelompok hewan vertebrata yang memiliki bulu dan sayap";
    
    }break;
    case 'k' : {
      species_name = "Kungkang";
      weight = 10.0;
      food_type = "Omnivore";
      AddAnimalType("Land");
      class_name = "Mammal";
      deskripsi = "Mammalia merupakan kelas hewan vertebrata yang ciri utama nya memiliki kelenjar susu";

    }break;
    case 'l' : {
      species_name = "IkanKalajengking";
      weight = 0.3;
      food_type = "Omnivore";
      AddAnimalType("Water");
      class_name = "Actinopterygii";
      deskripsi = "Actinopterygii adalah ikan yang memiliki sirip kipas";
    }break;
    case 'n' : {
      species_name = "Narwhal";
      weight = 1000;
      food_type = "Carnivore";
      AddAnimalType("Water");
      class_name = "Mammal";
      deskripsi = "Mammalia merupakan kelas hewan vertebrata yang ciri utama nya memiliki kelenjar susu";

    }break;
    case 'o' : {
      species_name = "Okapi";
      weight = 250;
      food_type = "Herbivore";
      AddAnimalType("Land");
      class_name = "Mammal";
      deskripsi = "Mammalia merupakan kelas hewan vertebrata yang ciri utama nya memiliki kelenjar susu";

    }break;
    case 'p' : {
      species_name = "Platypus";
      weight = 2;
      food_type = "Carnivore";
      AddAnimalType("Water");
      AddAnimalType("Land");
      class_name = "Mammal";
      deskripsi = "Mammalia merupakan kelas hewan vertebrata yang ciri utama nya memiliki kelenjar susu";

    }break;
    case 'r' : {
      species_name = "Orca";
      weight = 7700;
      food_type = "Carnivore";
      AddAnimalType("Water");
      class_name = "Mammal";
      deskripsi = "Mammalia merupakan kelas hewan vertebrata yang ciri utama nya memiliki kelenjar susu";

      tamed = false;
      AddEnemy("HiuGoblin");
      AddEnemy("IkanCupang");
      AddEnemy("IkanKalajengking");
      AddEnemy("IkanSungutGanda");
    }break;
    case 's' : {
      species_name = "SemutPanda";
      weight = 0.1;
      food_type = "Herbivore";
      AddAnimalType("Land");
      class_name = "Insect";
      deskripsi = "Insect merupakan hewan avertebrata yang terdiri dari 3 bagian tubuh, dan bernafas dengan trakea";
      
    }break;
    case 't' : {
      species_name = "TikusMondokBerhidungBintang";
      weight = 0.1;
      food_type = "Carnivore";
      AddAnimalType("Water");
      AddAnimalType("Land");
    }break;
    case 'u' : {
      species_name = "Undan";
      weight = 5;
      food_type = "Carnivore";
      AddAnimalType("Flying");
      class_name = "Aves";
      deskripsi = "Aves merupakan kelas kelompok hewan vertebrata yang memiliki bulu dan sayap";
    
    }break;
    case 'w' : {
      species_name = "Kiwi";
      weight = 2.4;
      food_type = "Omnivore";
      AddAnimalType("Land");
      class_name = "Aves";
      deskripsi = "Aves merupakan kelas kelompok hewan vertebrata yang memiliki bulu dan sayap";
    
    }break;
    case 'y' : {
      species_name = "Yak";
      weight = 500;
      food_type = "Herbivore";
      AddAnimalType("Land");
      class_name = "Mammal";
      deskripsi = "Mammalia merupakan kelas hewan vertebrata yang ciri utama nya memiliki kelenjar susu";
      }break;
    default : {

      }break;
    }
    food_per_day = weight/4;
  }
 

  public void SetPosition(Point P) {
    position.SetX(P.GetX());
    position.SetY(P.GetY());
}

  public String GetFoodType() {
    return food_type;
  }

  public String GetDeskripsi() {
    return deskripsi;
  }

  public String GetClassName() {
    return class_name;
  }

  public Point GetPosition() {
    return(position);
  }

  public String GetSpeciesName() {
    return species_name;
  }

  public double GetFoodNum() {
    return food_per_day;
  }
 
  public boolean IsEnemy(String animal) {
    int i=0;
    boolean found=false;

    while(i<20 && !found)
    {
      if (animal==enemy_list[i])
      {
        found=true;
      }
      i++;
    }
    return found;
  }

  public boolean IsTamed() {
    return tamed;
  }
 
  public void Interact() {
  switch(symbol)
  {
    case 'a' :{
    }break;
    case 'b' :{
      System.out.println ( "sungai kotor gini gimana mbikin bendungan nya coba? -_- ");

    }break;
    case 'c' :{
      System.out.println ( "Hi I'm Kingfisher Bird! ");
      System.out.println ( "I can fly at 40km/h top speed ");
    }break;
    case 'e' :{
      System.out.println("wuss");
      System.out.println("aku hewan pemangsa yang kuat bahkan karena kekuatankku aku dijadikan simbol negara Amerika Serikat ");

    }break;
    case 'f' :{
      System.out.println ( "Hi I'm Fossa! ");
      System.out.println ( "I am found nowhere else except on the island of Madagascar ");

    }break;
    case 'g' :{
      System.out.println("Halo aku ikan di bawah laut dalam lho, aku punya lampu supaya aku bisa tetap melihat di kegelapan");

    }break;
    case 'h' :{
      System.out.println ( "I can extend my jaws!");

    }break;
    case 'i' :{
      System.out.println ( "Ikan, ikan apa yang paling jelek??");
      try {
        Thread.sleep(2000);
      } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
      System.out.println ("I...kan kamu jelek");
      try {
        Thread.sleep(1000);
      } catch(InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
      System.out.println ( "maap.." );
    }break;
    case 'j' :{
      System.out.println("Hai, aku burung berukuran besar, dan aku memiliki paruh yang besar ");

    }break;
    case 'k' :{
      System.out.println ( "Hi I'm Sloth! ");
      System.out.println ( "I pass my time by sleeping and eating ");

    }break;
    case 'l' :{
      System.out.println ( "Hi I'm Scorpion Fish! ");
      System.out.println ( "I am able to stun my prey with my venom before eating it ");

    }break;
    case 'n' :{
      System.out.println ( "Unicorn may be not real, but i'm real!");

    }break;
    case 'o' :{
      System.out.println( "nguuut");
      System.out.println( "aku hewan yang unik lhooo, aku memiliki badan perpaduan antara jerapah dan zebra");  

    }break;
    case 'p' :{
      System.out.println ( "Sebenarnya aku adalah perry");

    }break;
    case 'r' :{
      System.out.println ( "Orca itu lumba lumba lhoo bukan paus~");

    }break;
    case 's' :{
        System.out.println ( "Aku bukan semut, tetapi lebah!");
    }break;
    case 't' :{
      System.out.println ( "Hidung bintangku sebenarnya adalah alat sensor yang dapat mendeteksi gelombang seismic");

    }break;
    case 'u' :{
      System.out.println("Aku merupakan Burung Undan, banyak yang memanggilku burung Pelikan, aku suka banget sama kamu eh maksudku ikan");

    }break;
    case 'w' :{
      System.out.println ( "aku gak gendut, cuman agak bulet dikit.." );
    }break;
    case 'y' :{
      System.out.println ( "Hi I'm Yak! ");
      System.out.println ( "I am usually found in the mountainous regions of central Asia ");

    }break;
}
}

  public void Deskripsi() {
    System.out.print (GetSpeciesName());
    System.out.print (" termasuk dalam kelas ");
    System.out.print (GetClassName());
    System.out.println (".");
    System.out.print (GetDeskripsi());
  }


  /** @brief  menambahkan type hewan dengan Land, Water atau Flying
    * @param  type tipe hewan antara "Land", "Water" atau "Flying"
  */
  public void AddAnimalType(String type) {
    if(animal_type[0]!="Flying" && animal_type[0]!="Land" && animal_type[0]!="Water")
    {
      animal_type[0]=type;
    }
    else if(animal_type[1]!="Flying" && animal_type[1]!="Land" && animal_type[1]!="Water")
    {
     animal_type[1]=type;
    }
    else if(animal_type[2]!="Flying" && animal_type[2]!="Land" && animal_type[2]!="Water")
    {
     animal_type[2]=type;
    }
  }

  public void AddEnemy(String animalname) {
    if(nenemy < 19)
    {
      enemy_list[nenemy] = animalname;
      nenemy++;
    }
  }

  public boolean IsTypeThere(String S) {
    boolean found = false;
    boolean ubah = false;
    if (S == "Air"){
      S = "Flying";
      ubah = true;
    }
    for (int i = 0;i<3;i++){
      if (animal_type[i] == S){
        found = true;
      }
    }
    if (ubah){
      S = "Air";
    } 
    return(found);
  }

  public void Render()
  {
    System.out.print(symbol);
  }
}
