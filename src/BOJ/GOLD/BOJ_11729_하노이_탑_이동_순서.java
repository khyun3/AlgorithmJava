package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729_하노이_탑_이동_순서 {
    static int count;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //원판의 개수, from , aux, to
        hanoi(N, 1, 2, 3);
        sb.insert(0, count + "\n");
        System.out.println(sb);
    }

    private static void hanoi(int n, int from, int aux, int to) {
        //기저 : 원판이 하나 남았을 때 무조건 to로 이동시킨다.
        if(n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            count++;
            return;
        }

        //step 1 : N - 1개의 원판을 모두 출발지(from)에서 보조 장대(aux)로 이동 시킨다.
        hanoi(n - 1, from, to, aux);
        //step 2 : 마지막 남은 원판을 목적지(to)로 이동 시킨다.
        sb.append(from).append(" ").append(to).append("\n");
        count++;
        //step 3 : N - 1개의 원판을 보조 장대(aux)에서 목적지(to)로 이동 시킨다.
        hanoi(n - 1, aux, from, to);
    }
}
