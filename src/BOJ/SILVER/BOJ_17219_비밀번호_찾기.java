package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_17219_비밀번호_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());//사이트 비밀번호
        int M = Integer.parseInt(st.nextToken());//찾을 사이트

        HashMap<String, String> pwdMap = new HashMap<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            pwdMap.put(st.nextToken(), st.nextToken());
        }

        while(M -- > 0) {
            sb.append(pwdMap.get(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }
}
