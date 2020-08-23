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
            String line8 = Zenkaku(line7);

            sb.append(line8);
            System.out.print(line8);
        }

        //金額 [0-9],[0-9]{2,} 後で調整
        String str = sb.toString();
        String str2 = str.replace("。１、", "。\n\n　１、");
        String str3 = str2.replace("２、", "\n　２、");
        String str4 = str3.replace("３、", "\n　３、");
        String str5 = str4.replace("４、", "\n　４、");

        fw.write(str5);
        fw.flush();

        br.close();
        fw.close();
    }

    public static String Zenkaku(String hankaku) {
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < hankaku.length(); i++){
            char c = hankaku.charAt(i);
            if('0' <= c && c <= '9') {
                c =(char)(c -'0'+'０');
            }
            sb2.append(c);
        }
        return sb2.toString();
    }
}
