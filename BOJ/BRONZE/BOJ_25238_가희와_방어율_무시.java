package BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25238_가희와_방어율_무시 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double armor = Double.parseDouble(st.nextToken()); //방어도
        double era = Double.parseDouble(st.nextToken()); //방어율
        System.out.print(armor - armor * era / 100 >= 100 ? 0 : 1);
    }
}
