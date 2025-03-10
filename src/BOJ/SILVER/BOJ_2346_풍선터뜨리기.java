package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_2346_풍선터뜨리기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        //1. N을 입력 받는다.
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        //2. 풍선에 적힌 숫자 목록을 입력 받아 몇번째 풍선인지 인덱스와 함께 deque에 넣는다.
        for (int i = 1; i <= N; i++) {
            deque.add(new int[]{i, Integer.parseInt(input[i-1])});
        }
        //3. 첫번째 풍선을 터뜨린다.
        for (int i = 0; i < N; i++) {
            int[] balloon = deque.poll();
            answer.append(balloon[0]).append(" ");
            //4. 마지막 풍선이 남았다면 그냥 터뜨린다.
            if(deque.isEmpty()) {
                break;
            }
            //4. head를 이동시킨다.
            if(balloon[1] > 0) {
                //정방향
                for (int j = 0; j < balloon[1] - 1; j++) {
                    deque.add(deque.pollFirst());
                }
            } else {
                //역방향
                for (int j = 0; j < Math.abs(balloon[1]); j++) {
                    deque.push(deque.pollLast());
                }
            }
        }
        //5. 정답을 출력한다.
        System.out.print(answer);
    }
}
