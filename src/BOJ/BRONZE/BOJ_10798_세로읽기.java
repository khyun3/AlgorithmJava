package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10798_세로읽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] words = new char[5][];
        int maxLen = 1;
        for (int t = 0; t < 5; t++) {
            words[t] = br.readLine().toCharArray();
            maxLen = Math.max(maxLen, words[t].length);
        }
        System.out.print(solution(words, maxLen));
    }

    static String solution(char[][] words, int maxLen) {
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < maxLen; c++) {
            for (int r = 0; r < 5; r++) {
                if (words[r].length > c) {
                    sb.append(words[r][c]);
                }
            }
        }
        return sb.toString();
    }
}