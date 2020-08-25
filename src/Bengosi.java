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
                String line20 = line6.replace("（参照", "\n\n　（参照");

                String line21 = Util.hankaku(line20);
                String line22 = Util.henkan(line21);
                String line23 = Util.kingaku(line22);
                String line24 = Util.space(line23);
                String line25 = Util.kaigyou(line24);
                String line26 = Util.haiten(line25);
                String line50 = Util.marubatu(line26);

                String line51 = line50.replaceAll("-[０-９]-", "");
                String line100 = line51.replaceAll("-[0-9]{2,}-", "");

                sb.append(line100);
            }

            String str = sb.toString();
            String str2 = str.replace("【会話】教授：", "\n\n　【会話】\n　教　授：");
            String str3 = str2.replace("。学生", "。\n　学生");
            String str4 = str3.replace("。教授：", "。\n　教　授：");
            String strFinal = str4.replace("【語句群】\n\n　ア", "\n\n　【語句群】\n\n　ア");

            fw.write(strFinal);
            fw.flush();
            br.close();
            fw.close();
        }
    }
}
