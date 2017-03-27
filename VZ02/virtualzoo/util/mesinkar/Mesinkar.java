// Nama : M. Ferdi Ghozali
// NIM : 13515014
package virtualzoo.util.mesinkar;
import java.util.*;
import java.io.FileReader;
import java.io.IOException;

/* File: mesinkar.h */
/* Definisi Mesin Karakter */
/* State Mesin */
// extern char CI;
// extern char CC;
// extern bool EOP;
  // static ifstream pita;

public class Mesinkar {
  private char CC;
  private int CI = -1;
  private boolean EOP;
  private boolean d_next = false;
  private char c_tamp;
  private char Mark = '.';
  public static FileReader input_stream = null;
  public Mesinkar() {
  }
  public final char GetCC() {
    return CC;
  }
  public final int GetCI() {
    return CI;
  }
  public final boolean GetEOF() {
    return (EOP);
  }
  public final boolean IsEOP() {
    EOP = (CC == Mark);
    return (EOP);
  }
  /* Mesin siap dioperasikan. Pita disiapkan untuk dibaca.
  Karakter pertama yang ada pada pita posisinya adalah pada jendela.
  I.S. : sembarang
  F.S. : CToken adalah karakter pertama pada pita
        Jika CToken != MARK maka EOP akan padam (false)
        Jika CToken = MARK maka EOP akan menyala (true) */
  public final void START() {
    try {
      input_stream = new FileReader("virtualzoo/map/VirtualZoo.txt");
    } 
    catch(IOException error) {
    } 
    
    ADV();
  }


  /* Pita dimajukan satu karakter. 
    I.S. : Karakter pada jendela = CToken, CToken != MARK
    F.S. : CToken adalah karakter berikutnya dari CToken yang lama, 
          CToken mungkin = MARK
          Jika  CToken = MARK maka EOP akan menyala (true) */
  public final void ADV()  {
    ReadChar();
    while ((CC == ' ' || CC == 13 || CC == 10 )&& !GetEOF()) {
      ReadChar();
    }
  }

  private final void ReadChar() {
        int temp = 0;
    if (IsEOP()) {
        try {
          input_stream.close();
        } 
        catch(IOException error) {
        } 
    } else {
      if (!d_next) {
        try {
          temp = input_stream.read();
        } 
        catch(IOException error) {
        } 
        CC = (char) temp;
      } else {
        CC = c_tamp;
        d_next = false;
      }
      if (CC == Mark) {
        EOP = true;
      }
      if (CC == '1' || CC == '2' || CC == '3' || CC == '4' || CC == '5' || CC == '6' || CC == '7' || CC == '8' || CC == '9' || CC == '0') {
          CI = 0;
        while (CC == '1' || CC == '2' || CC == '3' || CC == '4' || CC == '5' || CC == '6' || CC == '7' || CC == '8' || CC == '9' || CC == '0') {
          CI = CI * 10 + (CC - '0');
          CC = '~';
        try {
          temp = input_stream.read(); 
        } 
        catch(IOException error) {
        }           
        CC = (char) temp;
        }
        c_tamp = CC;
        CC = '~';
        d_next = true;
      } else {
        CI = -1;
      }
    }
  }
}