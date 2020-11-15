import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main (String args [])
    throws IOException {
    FileReader f;
    f = new FileReader ("testo.txt");

    BufferedReader b;
    b = new BufferedReader (f);

    String s = "";
    int count = 0;
    while (true) {
      s = b.readLine();
      if (s == null)
        break;
      System.out.println (s);
      System.out.println(s.length());
    }
  }
}