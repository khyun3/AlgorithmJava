package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_25501_재귀의_귀재 {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < N; t++) {
            char[] input = br.readLine().toCharArray();
            sb.append(isPalindrome(input))
                    .append(" ").append(count)
                    .append("\n");
            count = 0;
        }
        System.out.print(sb);
    }

    static int recursion(char[] s, int l, int r) {
        count++;
        if (l >= r) {
            return 1;
        } else if (s[l] != s[r]) {
            return 0;
        }
        return recursion(s, l + 1, r - 1);
    }

    static int isPalindrome(char[] s) {
        return recursion(s, 0, s.length - 1);
    }
}
