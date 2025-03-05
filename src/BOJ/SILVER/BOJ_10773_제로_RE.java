package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_10773_제로_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        int answer = 0;

        for (int t = 0; t < N; t++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                deque.pop();
            } else {
                deque.push(num);
            }
        }
        for (Integer num : deque) {
            answer += num;
        }

        System.out.print(answer);
    }
}
