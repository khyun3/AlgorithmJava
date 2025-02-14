package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286_절대값_힙 {
    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> absoluteHeap = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if(abs1 > abs2) {
                return 1;
            }
            else if(abs1 == abs2){
                return Integer.compare(o1, o2);
            }
            else {
                return -1;
            }
        });

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            //x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산
            int x = Integer.parseInt(br.readLine());
            switch (x){
                case 0 :
                    if(absoluteHeap.isEmpty()){
                        //만약 배열이 비어 있는 경우인데 절댓값이 가장 작은 값을 출력하라고 한 경우에는 0을 출력
                        sb.append("0\n");
                    }
                    else {
                        //x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거
                        sb.append(absoluteHeap.poll()).append("\n");
                    }
                    break;
                default:
                    absoluteHeap.add(x);
                    break;
            }
        }
        System.out.println(sb);
    }
}
