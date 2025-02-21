package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11005_진법변환2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");

        int n = Integer.parseInt(tokens[0]);
        int b = Integer.parseInt(tokens[1]);

        System.out.print(solution(n, b));

    }

    static String solution(int n, int b) {
        StringBuilder sb = new StringBuilder();

        while (true) {
            int r = n % b;
            n /= b;
            sb.append(convertToChar(r));
            if (n < b) {
                sb.append(convertToChar(n));
                break;
            }
        }
        String answer = sb.reverse().toString();
        if(answer.charAt(0) == '0') {
            return answer.substring(1);
        }
        return answer;
    }

    static char convertToChar(int v) {
        if (v > 9) {
            return (char) (v + 55);
        } else {
            return (char) (v + 48);
        }
    }
}
