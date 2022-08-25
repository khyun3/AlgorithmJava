package SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//TODO : 다시 풀어보기
//중국인의 나머지 정리
public class BOJ_6064_카잉_달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int N, M, x, y;
        long answer;

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            answer = -1;

            long [] xArr = new long [40001];
            long [] yArr = new long [40001];
            //a = x mod N = Ni + x
            //b = y mod M = yi + y
            for (int i = 0; i < 40001; i++) {
                xArr[i] = N*i + x;
                yArr[i] = M*i + y;
            }

            int xIdx = 0, yIdx = 0;
            while (xIdx != 40000 && yIdx != 40000){
                if(xArr[xIdx] == yArr[yIdx]){
                    answer = xArr[xIdx];
                    break;
                }
                if(xArr[xIdx] <= yArr[yIdx]){
                    xIdx++;
                }
                else {
                    yIdx++;
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
