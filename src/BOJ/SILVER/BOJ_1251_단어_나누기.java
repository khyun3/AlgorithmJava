package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1251_단어_나누기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int len = word.length();
        String result = "";
        for (int i = 1; i < len-1; i++) {
            String a = word.substring(0, i);
            for (int j = i+1; j < len; j++) {
                String b = word.substring(i, j);
                String c = word.substring(j, len);
                String asb = reverse(a)+reverse(b)+reverse(c);
                if(i == 1 && j == 2) {
                    result = asb;
                }
                int comp = result.compareTo(asb);
                if(comp > 0) {
                    result = asb;
                }
            }
        }
        System.out.println(result);
    }

    static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c: str.toCharArray()) {
            sb.insert(0, c);
        }
        return sb.toString();
    }
}
