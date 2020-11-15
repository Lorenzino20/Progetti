import java.io.*;

public class ConsoleInput {
    BufferedReader reader;

    public ConsoleInput() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int readInt() throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    public double readDuoble() throws IOException {
        return Double.parseDouble(reader.readLine());
    }

    public String readLine() throws IOException {
        return reader.readLine();
    }
}