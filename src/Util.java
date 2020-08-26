public class Util {

    // すべての数字を半角にするメソッド
    public static String hankaku(String sentakusi) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < sentakusi.length(); i++){
            char c = sentakusi.charAt(i);
            if('０' <= c && c <= '９') {
                c =(char)(c -'０'+'0');
            }
            sb.append(c);
        }
        return sb.toString();
    }

    // 1桁の数字は全角，2桁以上の数字は半角にするメソッド
    public static String henkan(String hankaku) {
        StringBuilder sb = new StringBuilder();

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
            sb.append(c);
        }
        return sb.toString();
    }
    
    // 金額を半角数字にするメソッド    [0-9]{1,3},[0-9]{3} を金額と判定
    public static String kingaku(String sentakusi) {
        StringBuilder sb = new StringBuilder();
        
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

            sb.append(c);
        }
        return sb.toString();
    }

    // 小数を半角数字にするメソッド    [0-9]{1,}.[0-9]{1,} を小数と判定
    public static String syousuu(String sentakusi) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < sentakusi.length(); i++){
            char c = sentakusi.charAt(i);

            if((i <= sentakusi.length()-3) && (sentakusi.length() >= 3)) {
                char c_af = sentakusi.charAt(i+1);
                char c_af2 = sentakusi.charAt(i+2);

                if(('０' <= c && c <= '９') && (c_af == '.') && (('０' <= c_af2 && c_af2 <= '９') || ('0' <= c_af2 && c_af2 <= '9'))) {
                    c =(char)(c -'０'+'0');
                }
            }

            if((i >= 2) && (i <= sentakusi.length()-1) && (sentakusi.length() >= 3)) {
                char c_bf2 = sentakusi.charAt(i-2);
                char c_bf = sentakusi.charAt(i-1);

                if((('０' <= c_bf2 && c_bf2 <= '９') || ('0' <= c_bf2 && c_bf2 <= '9')) && (c_bf == '.') && ('０' <= c && c <= '９')) {
                    c =(char)(c -'０'+'0');
                }
            }

            sb.append(c);
        }
        return sb.toString();
    }

    // 選択肢の間にスペースを入れるメソッド    ．[ア-オ]{2,3} で選択肢と判定
    public static String space(String sentakusi) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < sentakusi.length(); i++){
            char c = sentakusi.charAt(i);

            if((i >= 2) && (i <= sentakusi.length()-1) && (sentakusi.length() >= 3)) {
                char c_bf2 = sentakusi.charAt(i-2);
                char c_bf = sentakusi.charAt(i-1);

                if((c_bf2 == '．') && ('ア' <= c_bf && c_bf <= 'オ') && ('ア' <= c && c <= 'オ')) {
                    sb.append(' ');
                }
            }

            if((i >= 3) && (i <= sentakusi.length()-1) && (sentakusi.length() >= 4)) {
                char c_bf3 = sentakusi.charAt(i-3);
                char c_bf2 = sentakusi.charAt(i-2);
                char c_bf = sentakusi.charAt(i-1);

                if((c_bf3 == '．') && ('ア' <= c_bf2 && c_bf2 <= 'オ') && ('ア' <= c_bf && c_bf <= 'オ') && ('ア' <= c && c <= 'オ')) {
                    sb.append(' ');
                }
            }

            sb.append(c);
        }
        return sb.toString();
    }

    // 選択肢を改行して、前にスペースを入れるメソッド    [ア-ソ]．または[０-９]． を選択肢と判定
    public static String kaigyou(String sentakusi) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < sentakusi.length(); i++){
            char c = sentakusi.charAt(i);

            if((i >= 0) && (i < sentakusi.length()-1) && (sentakusi.length() >= 2)) {
                char c_af = sentakusi.charAt(i+1);

                if((('ア' <= c && c <= 'ソ') || ('１' <= c && c <= '９')) && (c_af == '．')) {

                    if((c == 'ア') || (c == '１')) {
                        sb.append('\n');
                    }
                    sb.append('\n');
                    sb.append('　');
                }
            }

            sb.append(c);
        }
        return sb.toString();
    }

    // 配点の後に改行を入れるメソッド    ：[０-５]）で配点部分と判定
    public static String haiten(String honbun) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < honbun.length(); i++){
            char c = honbun.charAt(i);
            sb.append(c);

            if((i >= 2) && (i < honbun.length()) && (honbun.length() >= 3)) {
                char c_bf = honbun.charAt(i-1);
                char c_bf2 = honbun.charAt(i-2);

                if((c_bf2 == '：') && ('１' <= c_bf && c_bf <= '５') && (c == '）')) {
                    sb.append('\n');
                    sb.append('\n');
                    sb.append('　');
                }
            }
        }
        return sb.toString();
    }

    // 選択肢の○×の後ろにスペースを入れるメソッド    選択肢の○×は [ア-コ][○×][ア-コ] で判定
    public static String marubatu(String sentakusi) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < sentakusi.length(); i++){
            char c = sentakusi.charAt(i);
            sb.append(c);

            if((i >= 1) && (i < sentakusi.length()-1) && (sentakusi.length() >= 3)) {
                char c_bf = sentakusi.charAt(i-1);
                char c_af = sentakusi.charAt(i+1);

                if(('ア' <= c_bf && c_bf <= 'コ') && (c == '○' || c == '×') && ('ア' <= c_af && c_af <= 'コ')) {
                    sb.append('　');
                }
            }
        }
        return sb.toString();
    }

}