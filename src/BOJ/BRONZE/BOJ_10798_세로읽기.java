package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10798_세로읽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] words = new char[5][15];
        for (int t = 0; t < 5; t++) {
            String inputLine = br.readLine();
            for (int c = 0; c < 15; c++) {
                if (inputLine.length() > c) {
                    words[t][c] = inputLine.charAt(c);
                }
            }
        }
        System.out.print(solution(words));
    }

    static String solution(char[][] words) {
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < 15; c++) {
            for (int r = 0; r < 5; r++) {
                if (words[r][c] != '\u0000') { //\u0000 << char 초기 값
                    sb.append(words[r][c]);
                }
            }
        }
        return sb.toString();
    }
}
