package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_12789_도키도키_간식드리미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1. N은 필요없어서 입력받고 버림.
        br.readLine();

        //2. 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //현재 간식을 받을 번호
        int current = 1;

        Deque<Integer> line = new ArrayDeque<>();
        while (st.hasMoreTokens()) {
            //간식을 받으러 온 번호
            int in = Integer.parseInt(st.nextToken());
            //3. 반대편 라인에 현재 간식을 받을 번호 맞다면
            //   간식을 받을 현재 번호 업데이트
            current = checkLine(line, current);
            //4. 간식을 받을 현재 번호가 아니라면 line에 넣음
            if (in != current) {
                line.push(in);
            } else { //5. 현재 간식을 받을 번호가 맞다면 간식을 줌.
                current++;
            }
        }
        //line에 서있는 사람들에게 간식을 줌.
        checkLine(line, current);
        System.out.println(line.isEmpty() ? "Nice" : "Sad");
    }

    static int checkLine(Deque<Integer> line, int current) {
        while (true) {
            if (!line.isEmpty() && line.peek() == current) {
                line.pop();
                current++;
            } else {
                break;
            }
        }
        return current;
    }
}