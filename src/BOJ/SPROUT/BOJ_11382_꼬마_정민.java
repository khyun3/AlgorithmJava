package BOJ.SPROUT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11382_꼬마_정민 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");
        Long res = Long.valueOf(0);

        res+= Long.parseLong(st.nextToken())
                + Long.parseLong(st.nextToken())
                + Long.parseLong(st.nextToken());

        System.out.println(res);
    }
}
