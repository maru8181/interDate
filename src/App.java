import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        int data;

        FileReader fis = new FileReader("data.txt");
        FileWriter fos = new FileWriter("newData.txt");
        while ((data = fis.read()) != -1) {
            char charData = (char)data;

            // 10 = 改行, 32 = スペース, 12288 = 全角スペース
            // 改行、スペースをとばす
            if(data == 10 || data == 32 || data == 12288){
                continue;
            }
            
            // 44 = "," , 12289 = "、" 
            // "," を "、" に変換
            if(data == 44) {
                data = 12289;
            }

            // 12304 = "【"
            // "【" の前に改行を入れる
            if(data == 12304) {
                data = 10;
                fos.write(data);
                data = 12304;
            }

            // 12305 = "】"
            // "】" の後に改行を入れる
            // 全角スペースで、問題文の先頭を段落づけ
            if(data == 12305) {
                fos.write(data);
                data = 10;
                fos.write(data);
                fos.write(data);
                data = 12288;
            }

            // 48 = "0" , 57 = "9"
            if(48 <= data && data <= 57) {
                data += 65248;
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
