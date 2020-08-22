import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        int data;

        FileReader fis = new FileReader("data.txt");
        FileWriter fos = new FileWriter("newData.txt");
        while ((data = fis.read()) != -1) {
            fos.write(data);
        }
        fos.flush();
        fis.close();
        fos.close();

    }
}
