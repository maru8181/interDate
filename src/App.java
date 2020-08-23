import java.io.*;

public class App {
    public static void main(String[] args) throws Exception {

        FileReader fr = new FileReader("data.txt");
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("newData.txt");
        StringBuilder sb = new StringBuilder();

        String line = null;

        while((line = br.readLine()) != null) {
            String line2 = line.replace(" ", "");
            String line3 = line2.replace("　", "");
            String line4 = line3.replace("\n", "");
            String line5 = line4.replace(",", "、");
            String line6 = line5.replace("【", "\n【");
            String line7 = line6.replace("】", "】\n\n　");

        //     // 48 = "0" , 57 = "9" , 65296 = "０"
        //     // +65248 することで、半角数字を全角数字に変換
        //     if(48 <= data && data <= 57) {
        //         data += 65248;

            sb.append(line7);
            System.out.print(line7);
        }

        //金額 [0-9],[0-9]{2,} 後で調整
        String str = sb.toString();
        String str2 = str.replace("。1、", "。\n\n　１、");
        String str3 = str2.replace("2、", "\n　２、");
        String str4 = str3.replace("3、", "\n　３、");
        String str5 = str4.replace("4、", "\n　４、");

        fw.write(str5);
        fw.flush();

        br.close();
        fw.close();
    }
}
