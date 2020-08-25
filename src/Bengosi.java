import java.io.*;

public class Bengosi {
    public static void main(String[] args) throws Exception {

        File dir = new File("../beforeFile");
        File[] list = dir.listFiles();

        // for(int i=0; i<list.length; i++) {
        //     System.out.println(list[i].toString());
        //     System.out.println(list[i].getName()); 
        // }

        for(int i = 0; i < list.length; i++) {

            // FileReader fr = new FileReader("bengosi.txt");
            FileReader fr = new FileReader(list[i].toString());
            BufferedReader br = new BufferedReader(fr);
            // FileWriter fw = new FileWriter("newBengosi.txt");
            FileWriter fw = new FileWriter("../changedFile/[new]" + list[i].getName());
            StringBuilder sb = new StringBuilder();

            String line = null;

            while((line = br.readLine()) != null) {
                String line2 = line.replace(" ", "");
                String line3 = line2.replace("　", "");
                String line4 = line3.replace("\n", "");
                String line5 = line4.replace(",", "，");
                String line7 = line5.replace("〔", "\n\n\n〔");
                // String line7 = line6.replace("〕", "〕\n\n　");
                String line8 = Util.hankaku(line7);
                String line9 = Util.henkan(line8);
                String line10 = Util.kingaku(line9);
                String line11 = Util.space(line10);
                String line12 = Util.kaigyou(line11);
                String line13 = line12.replaceAll("-[０-９]-", "");
                String line14 = line13.replaceAll("-[0-9]{2,}-", "");

                sb.append(line14);
                // System.out.print(line14);
            }

            String str12 = sb.toString();
            // // String str2 = str.replace("）１．", "）\n\n　１．");
            // String str3 = str.replace("１．", "\n\n　１．");
            // String str4 = str3.replace("２．", "\n　２．");
            // String str5 = str4.replace("３．", "\n　３．");
            // String str6 = str5.replace("４．", "\n　４．");
            // String str7 = str6.replace("５．", "\n　５．");
            // String str8 = str7.replace("ア．", "\n\n　ア．");
            // String str9 = str8.replace("イ．", "\n　イ．");
            // String str10 = str9.replace("ウ．", "\n　ウ．");
            // String str11 = str10.replace("エ．", "\n　エ．");
            // String str12 = str11.replace("オ．", "\n　オ．");
            String str13 = str12.replace("：２）", "：２）\n\n　");
            String str14 = str13.replace("：３）", "：３）\n\n　");

            fw.write(str14);
            fw.flush();

            br.close();
            fw.close();
            
        }
    }
}
