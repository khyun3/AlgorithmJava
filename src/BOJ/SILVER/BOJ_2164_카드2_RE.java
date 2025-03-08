package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_2164_카드2_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer numOfCard = Integer.parseInt(br.readLine());
        System.out.println(solution(numOfCard));
    }

    static int solution(Integer numOfCard) {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= numOfCard; i++) {
            que.offer(i);
        }
        while (que.size() > 1) {
            que.poll();
            que.offer(que.poll());
        }
        return que.poll();
    }
}
