package BOJ.SPROUT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9086_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String str = br.readLine();
            int len = str.length();
            sb.append(str.charAt(0)).append(str.charAt(len-1)).append("\n");
        }
        System.out.print(sb.toString());
    }
}
