import java.util.Random;
//File: Cage.java
//Author: M.Ferdi Ghozali
//NIM: 13515014
public class Cage{
  protected final int id;
  protected String cage_type;
  protected int size_area;
  protected Point area[];
  protected int jumlah_hewan = 0;
  protected final int animal_size = 50;
  protected Animal[] list_of_animal;
  public Cage() {
    id = 0;
  }
  public Cage(int id, Point[] area, int ukuran, String type) {
    this.id = id;
    cage_type = type;
    size_area = ukuran;
    this.area = new Point[size_area];
    for (int i = 0; i < size_area; i++) {
      this.area[i] = new Point(area[i].GetX(),area[i].GetY());
    }
    list_of_animal = new Animal[animal_size];
  }
  public int GetCageSize() {
    return size_area;
  }
  public int GetID() {
    return id;
  }
  public int NumberOfAnimal() {
    return jumlah_hewan;
  }
  public String GetTypeCage() {
    return cage_type;
  }
  public Point GetAreaElmt(int i) {
    return area[i];
  }
  public Animal GetAnimal(int i ) {
    return list_of_animal[i];
  }
  public void InputAnimal(Animal hewan, int area_id) {
    if (Aman(hewan) && (0.3*size_area - (jumlah_hewan+1) > 0) && 
       (hewan.IsTypeThere(cage_type))) {
        if(IsPassAble(area[area_id])) {
          list_of_animal[jumlah_hewan] = hewan;
          jumlah_hewan++;
          hewan.SetPosition(area[area_id]);
        }
    }
  }
  public boolean Aman(Animal hewan) {
    boolean safe = true;
    if (!hewan.IsTamed()){
      for (int i = 0; i<jumlah_hewan; i++) {
        if (hewan.IsEnemy(list_of_animal[i].GetSpeciesName())) {
          safe = false;
          System.out.println("Peletakan Animal: " + hewan.GetSpeciesName() + 
                             " gagal, terdapat hewan yang membahayakan dalam " + 
                             "kandang");
        }
      }
    }
    if (safe) {
      for (int j = 0;j<jumlah_hewan;j++) {
        if (list_of_animal[j].IsEnemy(hewan.GetSpeciesName())) {
          safe = false;
          System.out.println("Peletakan Animal: " + hewan.GetSpeciesName() + 
                             " gagal, terdapat hewan yang membahayakan dalam " + 
                             "kandang");
        }
      }  
    }
    return(safe);
  }
  public boolean IsPassAble(Point p) {
    boolean bener = false;
    for (int i = 0; i < size_area;i++) {
      if ((area[i].GetX() == p.GetX()) && (area[i].GetY() == p.GetY())) {
        bener = true;
      }
    }
    if (bener) {
      for (int  j = 0;j<jumlah_hewan;j++) {
        if ((list_of_animal[j].GetPosition()).GetX() == p.GetX() && 
          (list_of_animal[j].GetPosition()).GetY() == p.GetY()) {
          bener = false;
        }
      }
    }
    return bener;    
  }
  public void MoveAnimal() {
    Random rand = new Random();
   
    for (int i = 0; i < jumlah_hewan;i++){
      
      int dir = rand.nextInt(4) + 1;
      Point P = new Point();
      if (dir==4){
        P.SetY((list_of_animal[i].GetPosition()).GetY()+1);
        P.SetX((list_of_animal[i].GetPosition()).GetX());
      }else 
      if (dir==1){
        P.SetY((list_of_animal[i].GetPosition()).GetY()-1);
        P.SetX((list_of_animal[i].GetPosition()).GetX());      
      }else 
      if (dir==2){
        P.SetY((list_of_animal[i].GetPosition()).GetY());
        P.SetX((list_of_animal[i].GetPosition()).GetX()-1);
      }else 
      if (dir==3){
        P.SetY((list_of_animal[i].GetPosition()).GetY());
        P.SetX((list_of_animal[i].GetPosition()).GetX()+1);
      }
      if (IsPassAble(P)){
        list_of_animal[i].SetPosition(P);
      }
    }
  }
  public void Render() {
    System.out.print(id);
  }
};