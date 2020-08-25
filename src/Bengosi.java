import java.io.*;

public class Bengosi {
    public static void main(String[] args) throws Exception {

        File dir = new File("../beforeFile");
        File[] list = dir.listFiles();

        for(int i = 0; i < list.length; i++) {

            FileReader fr = new FileReader(list[i].toString());
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("../changedFile/[new]" + list[i].getName());
            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = br.readLine()) != null) {
                String line2 = line.replace(" ", "");
                String line3 = line2.replace("　", "");
                String line4 = line3.replace("\n", "");
                String line5 = line4.replace(",", "，");
                String line6 = line5.replace("〔", "\n\n\n〔");
                String line10 = line6.replace("（参照", "\n\n　（参照");

                String line11 = Util.hankaku(line10);
                String line12 = Util.henkan(line11);
                String line13 = Util.kingaku(line12);
                String line14 = Util.space(line13);
                String line15 = Util.kaigyou(line14);
                String line16 = Util.haiten(line15);
                String line20 = Util.marubatu(line16);

                String line21 = line20.replaceAll("-[０-９]-", "");
                String lineFinal = line21.replaceAll("-[0-9]{2,}-", "");

                sb.append(lineFinal);
            }

            fw.write(sb.toString());
            fw.flush();
            br.close();
            fw.close();
        }
    }
}
