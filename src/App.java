import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        int data;

        FileReader fis = new FileReader("data.txt");
        FileWriter fos = new FileWriter("newData.txt");
        while ((data = fis.read()) != -1) {
            // char charData = (char)data;

            // 10 = 改行, 32 = スペース
            if(data == 10 || data == 32){
                continue;
            }
            
            fos.write(data);
            // System.out.println(data);
            // System.out.println(charData);
        }
        fos.flush();
        fis.close();
        fos.close();

    }
}
