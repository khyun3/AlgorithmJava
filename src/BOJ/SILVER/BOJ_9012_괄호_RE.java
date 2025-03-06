package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_9012_괄호_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int T = 0; T < N; T++) {
            String input = br.readLine();
            sb.append(checkVPS(input.toCharArray())).append("\n");
        }
        System.out.println(sb);
    }

    private static String checkVPS(char[] input) {
        Deque<Character> stack = new ArrayDeque<>();

        //1. ')'가 나오면 무조건 stack 에 '('가 1개 이상 존재해야 한다.
        for (char c : input) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
