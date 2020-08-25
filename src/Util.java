public class Util {

    // すべての数字を半角にするメソッド
    public static String hankaku(String sentakusi) {
        StringBuilder sb2 = new StringBuilder();

        for(int i = 0; i < sentakusi.length(); i++){
            char c = sentakusi.charAt(i);
            if('０' <= c && c <= '９') {
                c =(char)(c -'０'+'0');
            }
            sb2.append(c);
        }
        return sb2.toString();
    }

    // 1桁の数字は全角，2桁以上の数字は半角にするメソッド
    public static String henkan(String hankaku) {
        StringBuilder sb3 = new StringBuilder();

        for(int i = 0; i < hankaku.length(); i++){
            char c = hankaku.charAt(i);

            if((i == 0) && (hankaku.length() >= 2)) {
                char c_af = hankaku.charAt(i+1);
                
                if(('0' <= c && c <= '9') && !('0' <= c_af && c_af <= '9')) {
                    c =(char)(c -'0'+'０');
                }

            }else if((i == hankaku.length()-1) && (hankaku.length() >= 2)) {
                char c_fr = hankaku.charAt(i-1);

                if(('0' <= c && c <= '9') && !('0' <= c_fr && c_fr <= '9')) {
                    c =(char)(c -'0'+'０');
                }

            }else if(((i > 0) && (i < hankaku.length()-1)) && (hankaku.length() >= 2)) {
                char c_af = hankaku.charAt(i+1);
                char c_fr = hankaku.charAt(i-1);

                if(('0' <= c && c <= '9') && !(('0' <= c_fr && c_fr <= '9') || ('0' <= c_af && c_af <= '9'))) {
                    c =(char)(c -'0'+'０');
                }

            }else if(hankaku.length() == 1) {

                if('0' <= c && c <= '9') {
                    c =(char)(c -'0'+'０');
                }
            }
            sb3.append(c);
        }
        return sb3.toString();
    }
    
    // 金額を半角数字にするメソッド    [0-9]{1,3},[0-9]{3} を金額と判定
    public static String kingaku(String sentakusi) {
        StringBuilder sb4 = new StringBuilder();

        for(int i = 0; i < sentakusi.length(); i++){
            char c = sentakusi.charAt(i);

            if((i <= sentakusi.length()-5) && (sentakusi.length() >= 5)) {
                char c_af = sentakusi.charAt(i+1);
                char c_af2 = sentakusi.charAt(i+2);
                char c_af3 = sentakusi.charAt(i+3);
                char c_af4 = sentakusi.charAt(i+4);

                if(('０' <= c && c <= '９') && (c_af == '，') && ('0' <= c_af2 && c_af2 <= '9') && ('0' <= c_af3 && c_af3 <= '9') && ('0' <= c_af4 && c_af4 <= '9')) {
                    c =(char)(c -'０'+'0');
                }
            }

            if((i >= 1) && (i <= sentakusi.length()-4) && (sentakusi.length() >= 5)) {
                char c_bf = sentakusi.charAt(i-1);
                char c_af = sentakusi.charAt(i+1);
                char c_af2 = sentakusi.charAt(i+2);
                char c_af3 = sentakusi.charAt(i+3);

                if((('０' <= c_bf && c_bf <= '９') || ('0' <= c_bf && c_bf <= '9')) && (c == '，') && ('0' <= c_af && c_af <= '9') && ('0' <= c_af2 && c_af2 <= '9') && ('0' <= c_af3 && c_af3 <= '9')) {
                    c = ',';
                }
            }

            sb4.append(c);
        }
        return sb4.toString();
    }

    // 選択肢の間にスペースを入れるメソッド    ．[ア-オ]{2,} で選択肢と判定
    public static String space(String sentakusi) {
        StringBuilder sb5 = new StringBuilder();

        for(int i = 0; i < sentakusi.length(); i++){
            char c = sentakusi.charAt(i);

            if((i >= 2) && (i <= sentakusi.length()-1) && (sentakusi.length() >= 3)) {
                char c_bf2 = sentakusi.charAt(i-2);
                char c_bf = sentakusi.charAt(i-1);

                if((c_bf2 == '．') && ('ア' <= c_bf && c_bf <= 'オ') && ('ア' <= c && c <= 'オ')) {
                    sb5.append(' ');
                }
            }

            sb5.append(c);
        }
        return sb5.toString();
    }

    // 選択肢を改行して、前にスペースを入れるメソッド    [ア-コ]．または[０-９]． を選択肢と判定
    public static String kaigyou(String sentakusi) {
        StringBuilder sb6 = new StringBuilder();

        for(int i = 0; i < sentakusi.length(); i++){
            char c = sentakusi.charAt(i);

            if((i >= 0) && (i < sentakusi.length()-1) && (sentakusi.length() >= 2)) {
                char c_af = sentakusi.charAt(i+1);

                if((('ア' <= c && c <= 'コ') || ('１' <= c && c <= '９')) && (c_af == '．')) {

                    if((c == 'ア') || (c == '１')) {
                        sb6.append('\n');
                    }
                    sb6.append('\n');
                    sb6.append('　');
                }
            }

            sb6.append(c);
        }
        return sb6.toString();
    }

}