package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16139_인간_컴퓨터_상호작용 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] strArr = br.readLine().toCharArray();

        int n = Integer.parseInt(br.readLine());
        //문자열을 각 알파벳 소문자를 몇개 가지고 있는지 기록해둔다.
        int[][] alpha = calcAlphabetCount(strArr);
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = st.nextToken().charAt(0) - 97;
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if (l == 0) {
                answer.append(alpha[a][r]).append("\n");
            } else {
                answer.append(alpha[a][r] - alpha[a][l - 1]).append("\n");
            }
        }
        System.out.println(answer);
    }

    private static int[][] calcAlphabetCount(char[] strArr) {
        int len = strArr.length;
        int[][] alpha = new int[26][len];

        alpha[strArr[0] - 97][0] = 1;
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j < len; j++) {
                int k = strArr[j] - 97;
                if (i == k) {
                    alpha[i][j] += alpha[i][j - 1] + 1;
                } else {
                    alpha[i][j] += alpha[i][j - 1];
                }
            }
        }
        return alpha;
    }
}
