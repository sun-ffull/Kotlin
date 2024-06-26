import java.io.*;

public class JavaFilePrinter {
    public void readFile() throws IOException {
        File currentFile = new File(".");
        File file = new File(currentFile.getAbsolutePath() + "/a.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            System.out.println(br.readLine());
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
