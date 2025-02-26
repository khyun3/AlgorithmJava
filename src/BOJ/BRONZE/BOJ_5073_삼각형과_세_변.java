package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5073_삼각형과_세_변 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        final String TERMINATE = "0 0 0";

        while (true) {
            String input = br.readLine();
            if (TERMINATE.equals(input)) break;
            st = new StringTokenizer(input, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sb.append(solution(a, b, c));
        }
        System.out.print(sb);
    }

    static String solution(int a, int b, int c) {
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "Invalid\n";
        }

        if (a == b && b == c) {
            return "Equilateral\n";
        } else if (a == b || a == c || b == c) {
            return "Isosceles\n";
        } else {
            return "Scalene\n";
        }
    }
}
