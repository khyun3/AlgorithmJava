package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_28278_스택2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> stack = new ArrayDeque<>();
        for (int t = 0; t < N; t++) {
            command(stack, sb, br.readLine());
        }
        System.out.print(sb);
    }

    static void command(Deque<Integer> stack, StringBuilder sb, String input) {
        String[] tokens = input.split(" ");
        int op = Integer.parseInt(tokens[0]);
        Integer printNumber = null;
        switch (op) {
            case 1:
                stack.push(Integer.parseInt(tokens[1]));
                break;
            case 2:
                printNumber = stack.isEmpty() ? -1 : stack.pop();
                break;
            case 3:
                printNumber = stack.size();
                break;
            case 4:
                printNumber = stack.isEmpty() ? 1 : 0;
                break;
            case 5:
                printNumber = stack.isEmpty() ? -1 : stack.peek();
                break;
        }
        if (printNumber != null) {
            sb.append(printNumber).append("\n");
        }
    }
}
