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

/** Class Mesinkar untuk membaca karakter
 * dari file eksternal
 * @author M.Ferdi Ghozali/13515014
 * @version 1.0, March 2017
 */
public class Mesinkar {
  private char CC;
  private int CI = -1;
  private boolean EOP;
  private boolean d_next = false;
  private char c_tamp;
  private char Mark = '.';
  public static FileReader input_stream = null;
  /**Constructor
   * @see java.lang.reflect.Constructor
   */
  public Mesinkar() {
  }
  /**Mendapatkan karakter CC
   * 
   * @return char CC
   */
  public final char GetCC() {
    return CC;
  }
  /** Mendapatkan token
   * @return integer token
   */
  public final int GetCI() {
    return CI;
  }
  /** Mengecek akhir file atau bukam
   * @return boolean true bila akhir file
   */
  public final boolean GetEOF() {
    return (EOP);
  }
  /** Mengecek akhir program atau bukam
   * @return boolean true bila akhir program
   */
  public final boolean IsEOP() {
    EOP = (CC == Mark);
    return (EOP);
  }
  /** Mesin siap dioperasikan. Pita disiapkan untuk dibaca.
    */
  public final void START() {
    try {
      input_stream = new FileReader("VirtualZoo.txt");
    } 
    catch(IOException error) {
    } 
    
    ADV();
  }


  /** Pita dimajukan satu karakter. 
   */
  public final void ADV()  {
    ReadChar();
    while ((CC == ' ' || CC == 13 || CC == 10 )&& !GetEOF()) {
      ReadChar();
    }
  }
  /** Membaca karakter
   */
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