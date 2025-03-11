package BOJ.SILVER;

import java.io.*;
import java.util.ArrayDeque;

public class BOJ_24511_queuestack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //1
        int N = Integer.parseInt(br.readLine());
        //2
        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");

        //4 큐스택을 넣을 deque을 만든다.
        ArrayDeque<Integer> queueStack = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            //큐일때만 queueStack에 값을 넣는다.
            if (A[i].equals("0")) {
                queueStack.add(Integer.parseInt(B[i]));
            }
        }
        int M = Integer.parseInt(br.readLine());
        String[] C = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            queueStack.push(Integer.parseInt(C[i]));
            bw.write(queueStack.pollLast() + " ");
        }
        bw.flush();
        bw.close();
    }
}
