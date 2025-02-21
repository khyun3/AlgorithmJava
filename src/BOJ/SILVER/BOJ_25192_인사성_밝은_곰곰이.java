package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_25192_인사성_밝은_곰곰이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Set<String> nickNameSet = new HashSet<>();
        int ans = 0;
        for (int t = 0; t < N; t++) {
            String input = br.readLine();
            if (input.equals("ENTER")) {
                ans += nickNameSet.size();
                nickNameSet = new HashSet<>();
            } else {
                nickNameSet.add(input);
            }
        }
        ans += nickNameSet.size();
        System.out.println(ans);
    }
}
