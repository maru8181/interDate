import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {
        // int data;

        FileReader fr = new FileReader("data.txt");
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("newData.txt");
        StringBuilder sb = new StringBuilder();

        String line = null;


        while((line = br.readLine()) != null) {
            System.out.println(line);
            String line2 = line.replace(" ", "");
            String line3 = line2.replace("　", "");

        // }
        
        // while ((data = br.read()) != -1) {
        //     char charData = (char)data;

        //     // 10 = 改行, 32 = スペース, 12288 = 全角スペース
        //     // 改行、スペースをとばす
        //     if(data == 10 || data == 32 || data == 12288){
        //         continue;
        //     }
            
        //     // 44 = "," , 12289 = "、" 
        //     // "," を "、" に変換
        //     if(data == 44) {
        //         data = 12289;
        //     }

        //     // 12304 = "【"
        //     // "【" の前に改行を入れる
        //     if(data == 12304) {
        //         data = 10;
        //         fw.write(data);
        //         data = 12304;
        //     }

        //     // 12305 = "】"
        //     // "】" の後に改行を入れる
        //     // 全角スペースで、問題文の先頭を段落づけ
        //     if(data == 12305) {
        //         fw.write(data);
        //         data = 10;
        //         fw.write(data);
        //         fw.write(data);
        //         data = 12288;
        //     }

        //     // 48 = "0" , 57 = "9" , 65296 = "０"
        //     // +65248 することで、半角数字を全角数字に変換
        //     if(48 <= data && data <= 57) {
        //         data += 65248;
        //     }
            sb.append(line3);
            // System.out.println(line);
            // System.out.println(charData);
        }
        String str = sb.toString();
        fw.write(str);

        fw.flush();
        br.close();
        fw.close();

    }
}
