import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        int data;

        FileReader fis = new FileReader("data.txt");
        FileWriter fos = new FileWriter("newData.txt");
        while ((data = fis.read()) != -1) {
            char charData = (char)data;

            // 10 = 改行, 32 = スペース
            if(data == 10 || data == 32){
                continue;
            }
            
            // 44 = "," , 12289 = "、" 
            if(data == 44) {
                data = 12289;
            }

            // 12304 = "【"
            if(data == 12304) {
                data = 10;
                fos.write(data);
                data = 12304;
            }

            // 12305 = "】"
            if(data == 12305) {
                fos.write(data);
                data = 10;
                fos.write(data);
            }
            
            fos.write(data);
            System.out.println(data);
            System.out.println(charData);
        }
        fos.flush();
        fis.close();
        fos.close();

    }
}
