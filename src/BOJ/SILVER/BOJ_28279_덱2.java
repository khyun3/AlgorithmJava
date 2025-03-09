package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_28279_덱2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int t = 0; t < N; t++) {
            String[] input = br.readLine().split(" ");
            Integer command = Integer.parseInt(input[0]);
            Integer x = input.length == 2 ? Integer.parseInt(input[1]) : null;
            operate(deque, answer, command, x);
        }
        System.out.print(answer);
    }

    static void operate(ArrayDeque<Integer> deque, StringBuilder answer, Integer command, Integer x) {
        switch (command) {
            case 1:
                deque.push(x);
                break;
            case 2:
                deque.add(x);
                break;
            case 3:
                if(!deque.isEmpty()) {
                    answer.append(deque.pollFirst()).append("\n");
                } else {
                    answer.append(-1).append("\n");
                }
                break;
            case 4:
                if(!deque.isEmpty()) {
                    answer.append(deque.pollLast()).append("\n");
                } else {
                    answer.append(-1).append("\n");
                }
                break;
            case 5:
                answer.append(deque.size()).append("\n");
                break;
            case 6:
                if(deque.isEmpty()) {
                    answer.append(1).append("\n");
                } else {
                    answer.append(0).append("\n");
                }
                break;
            case 7:
                if(!deque.isEmpty()) {
                    answer.append(deque.peekFirst()).append("\n");
                } else {
                    answer.append(-1).append("\n");
                }
                break;
            case 8:
                if(!deque.isEmpty()) {
                    answer.append(deque.peekLast()).append("\n");
                } else {
                    answer.append(-1).append("\n");
                }
                break;
        }
    }
}
