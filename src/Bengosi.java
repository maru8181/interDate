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
                String line7 = Util.hankaku(line6);
                String line8 = Util.henkan(line7);
                String line9 = Util.kingaku(line8);
                String line10 = Util.space(line9);
                String line11 = Util.kaigyou(line10);
                String line12 = Util.haiten(line11);
                String line13 = line12.replaceAll("-[０-９]-", "");
                String line14 = line13.replaceAll("-[0-9]{2,}-", "");

                sb.append(line14);
            }

            fw.write(sb.toString());
            fw.flush();
            br.close();
            fw.close();
        }
    }
}
