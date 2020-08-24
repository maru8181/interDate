// import java.io.*;

// public class App {
//     public static void main(String[] args) throws Exception {

//         FileReader fr = new FileReader("data.txt");
//         BufferedReader br = new BufferedReader(fr);
//         FileWriter fw = new FileWriter("newData.txt");
//         StringBuilder sb = new StringBuilder();

//         String line = null;

//         while((line = br.readLine()) != null) {
//             String line2 = line.replace(" ", "");
//             String line3 = line2.replace("　", "");
//             String line4 = line3.replace("\n", "");
//             String line5 = line4.replace(",", "，");
//             String line6 = line5.replace("【", "\n【");
//             String line7 = line6.replace("】", "】\n\n　");
//             String line8 = line7.replaceAll("-[０-９]-", "");
//             String line9 = line8.replaceAll("-[0-9]{2,}-", "");
//             String line10 = Hankaku(line9);
//             String line11 = Zenkaku(line10);
//             String line12 = Kingaku(line11);
//             String line13 = Space(line12);

//             sb.append(line13);
//             System.out.print(line13);
//         }

//         String str = sb.toString();
//         String str2 = str.replace("。１，", "。\n\n　１，");
//         String str3 = str2.replace("２，", "\n　２，");
//         String str4 = str3.replace("３，", "\n　３，");
//         String str5 = str4.replace("４，", "\n　４，");

//         fw.write(str5);
//         fw.flush();

//         br.close();
//         fw.close();
//     }

//     // すべての数字を半角にするメソッド
//     public static String Hankaku(String zenkaku) {
//         StringBuilder sb2 = new StringBuilder();

//         for(int i = 0; i < zenkaku.length(); i++){
//             char c = zenkaku.charAt(i);
//             if('０' <= c && c <= '９') {
//                 c =(char)(c -'０'+'0');
//             }
//             sb2.append(c);
//         }
//         return sb2.toString();
//     }

//     // 1桁の数字は全角、2桁以上の数字は半角にするメソッド
//     public static String Zenkaku(String hankaku) {
//         StringBuilder sb3 = new StringBuilder();

//         for(int i = 0; i < hankaku.length(); i++){
//             char c = hankaku.charAt(i);

//             if((i == 0) && (hankaku.length() >= 2)) {
//                 char c_af = hankaku.charAt(i+1);
                
//                 if(('0' <= c && c <= '9') && !('0' <= c_af && c_af <= '9')) {
//                     c =(char)(c -'0'+'０');
//                 }

//             }else if((i == hankaku.length()-1) && (hankaku.length() >= 2)) {
//                 char c_fr = hankaku.charAt(i-1);

//                 if(('0' <= c && c <= '9') && !('0' <= c_fr && c_fr <= '9')) {
//                     c =(char)(c -'0'+'０');
//                 }

//             }else if(((i > 0) && (i < hankaku.length()-1)) && (hankaku.length() >= 2)) {
//                 char c_af = hankaku.charAt(i+1);
//                 char c_fr = hankaku.charAt(i-1);

//                 if(('0' <= c && c <= '9') && !(('0' <= c_fr && c_fr <= '9') || ('0' <= c_af && c_af <= '9'))) {
//                     c =(char)(c -'0'+'０');
//                 }

//             }else if(hankaku.length() == 1) {

//                 if('0' <= c && c <= '9') {
//                     c =(char)(c -'0'+'０');
//                 }
//             }
//             sb3.append(c);
//         }
//         return sb3.toString();
//     }
    
//     // 金額を半角数字にするメソッド    [0-9]{1,3},[0-9]{3} を金額と判定
//     public static String Kingaku(String zenkaku) {
//         StringBuilder sb4 = new StringBuilder();

//         for(int i = 0; i < zenkaku.length(); i++){
//             char c = zenkaku.charAt(i);

//             if((i <= zenkaku.length()-5) && (zenkaku.length() >= 5)) {
//                 char c_af = zenkaku.charAt(i+1);
//                 char c_af2 = zenkaku.charAt(i+2);
//                 char c_af3 = zenkaku.charAt(i+3);
//                 char c_af4 = zenkaku.charAt(i+4);

//                 if(('０' <= c && c <= '９') && (c_af == '，') && ('0' <= c_af2 && c_af2 <= '9') && ('0' <= c_af3 && c_af3 <= '9') && ('0' <= c_af4 && c_af4 <= '9')) {
//                     c =(char)(c -'０'+'0');
//                 }
//             }

//             if((i >= 1) && (i <= zenkaku.length()-4) && (zenkaku.length() >= 5)) {
//                 char c_bf = zenkaku.charAt(i-1);
//                 char c_af = zenkaku.charAt(i+1);
//                 char c_af2 = zenkaku.charAt(i+2);
//                 char c_af3 = zenkaku.charAt(i+3);

//                 if((('０' <= c_bf && c_bf <= '９') || ('0' <= c_bf && c_bf <= '9')) && (c == '，') && ('0' <= c_af && c_af <= '9') && ('0' <= c_af2 && c_af2 <= '9') && ('0' <= c_af3 && c_af3 <= '9')) {
//                     c = ',';
//                 }
//             }

//             sb4.append(c);
//         }
//         return sb4.toString();
//     }

//     // 選択肢の間にスペースを入れるメソッド    ．[ア-オ]{2,} で選択肢と判定
//     public static String Space(String sentakusi) {
//         StringBuilder sb5 = new StringBuilder();

//         for(int i = 0; i < sentakusi.length(); i++){
//             char c = sentakusi.charAt(i);

//             if((i >= 2) && (i <= sentakusi.length()-1) && (sentakusi.length() >= 3)) {
//                 char c_bf2 = sentakusi.charAt(i-2);
//                 char c_bf = sentakusi.charAt(i-1);

//                 if((c_bf2 == '．') && ('ア' <= c_bf && c_bf <= 'オ') && ('ア' <= c && c <= 'オ')) {
//                     sb5.append(' ');
//                 }
//             }

//             sb5.append(c);
//         }
//         return sb5.toString();
//     }
// }
