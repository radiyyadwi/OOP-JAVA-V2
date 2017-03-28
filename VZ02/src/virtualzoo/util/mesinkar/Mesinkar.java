// file : mesinkar.java
// Nama : M. Ferdi Ghozali
// NIM : 13515014

package virtualzoo.util.mesinkar;

import java.io.FileReader;
import java.io.IOException;
/** Class Mesinkar untuk membaca karakter.
 * dari file eksternal
 * @author M.Ferdi Ghozali/13515014
 * @version 1.0, March 2017
 */

public class Mesinkar {
  private char cc;
  private int ci = -1;
  private boolean eop;
  private boolean isNext = false;
  private char ccTamp;
  private char mark = '.';
  public static FileReader inputStream = null;
  /**Constructor.
   * @see java.lang.reflect.Constructor
   */

  public Mesinkar() { }
  /**Mendapatkan karakter cc.
   * @return char cc
   */

  public final char getCc() {
    return cc;
  }
  /** Mendapatkan token.
   * @return integer token
   */

  public final int getCi() {
    return ci;
  }
  /** Mengecek akhir file atau bukam.
   * @return boolean true bila akhir file
   */

  public final boolean getEof() {
    return (eop);
  }
  /** Mengecek akhir program atau bukam.
   * @return boolean true bila akhir program
   */

  public final boolean isEop() {
    eop = (cc == mark);
    return (eop);
  }
  /** Mesin siap dioperasikan. Pita disiapkan untuk dibaca.
   */

  public final void start() {
    try {
      inputStream = new FileReader("VirtualZoo.txt");
    } catch (IOException error) {
      System.out.println("salahnih");
    } 
    adv();
  }
  /** Pita dimajukan satu karakter. 
   */

  public final void adv() {
    readChar();
    while ((cc == ' ' || cc == 13 || cc == 10) && !getEof()) {
      readChar();
    }
  }
  /** Membaca karakter.
   */

  private final void readChar() {
    int temp = 0;
    if (isEop()) {
      try {
        inputStream.close();
      } catch (IOException error) {
        System.out.println("Tour akan dimulai. tekan enter untuk melanjutkan");
      } 
    } else {
      if (!isNext) {
        try {
          temp = inputStream.read();
        } catch (IOException error) {
          System.out.println("Tour akan dimulai. tekan enter untuk melanjutkan");
        } 
        cc = (char) temp;
      } else {
        cc = ccTamp;
        isNext = false;
      }
      if (cc == mark) {
        eop = true;
      }
      if (cc == '1' || cc == '2' || cc == '3' || cc == '4' || cc == '5' || cc == '6' || cc == '7' 
          || cc == '8' || cc == '9' || cc == '0') {
        ci = 0;
        while (cc == '1' || cc == '2' || cc == '3' || cc == '4' || cc == '5' || cc == '6' 
            || cc == '7' || cc == '8' || cc == '9' || cc == '0') {
          ci = ci * 10 + (cc - '0');
          cc = '~';
          try {
            temp = inputStream.read(); 
          } catch (IOException error) {
            System.out.println("Tour akan dimulai. tekan enter untuk melanjutkan");
          }           
          cc = (char) temp;
        }
        ccTamp = cc;
        cc = '~';
        isNext = true;
      } else {
        ci = -1;
      }
    }
  }
}