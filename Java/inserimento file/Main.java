import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scrittura su un file di nome file.txt
        TextFile out = new TextFile("file.txt",'W');
        try {
            out.toFile("Riga 1");
            out.toFile("Riga 2");
            out.toFile("Riga 3");
        } catch (FileException exception) {
            System.out.println(exception.getMatter());
        }
        out.closeFile();

        //Lettura di cio che e scritto nel file.txt ovvero quello che e stato scritto sopra
        TextFile in = new TextFile("file.txt",'R');
        String line;
        try {
            while(true) {
                line = in.fromFile();
                System.out.println(line);
            }
        } catch (FileException exception) {
            System.out.println(exception.getMatter());
        }
        out.closeFile();
    }
}