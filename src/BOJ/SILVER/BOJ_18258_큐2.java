package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_18258_큐2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            String[] input = br.readLine().split(" ");
            solution(queue, sb, input);
        }
        System.out.println(sb);
    }

    static void solution(Deque<Integer> queue, StringBuilder sb, String[] input) {
        switch (input[0]) {
            //push X: 정수 X를 큐에 넣는 연산이다.
            case "push":
                queue.add(Integer.parseInt(input[1]));
                break;
            //pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            case "pop":
                if (queue.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(queue.pop());
                }
                sb.append("\n");
                break;
            //size: 큐에 들어있는 정수의 개수를 출력한다.
            case "size":
                sb.append(queue.size()).append("\n");
                break;
            //empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
            case "empty":
                sb.append(queue.isEmpty() ? 1 : 0).append("\n");;
                break;
            //front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            case "front":
                if (queue.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(queue.peekFirst());
                }
                sb.append("\n");
                break;
            //back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            case "back":
                if (queue.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(queue.peekLast());
                }
                sb.append("\n");
                break;
        }
    }
}
