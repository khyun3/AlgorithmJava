package BOJ.BRONZE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25304_영수증 {
    //구매한 물건의 가격과 개수로 계산한 총 금액이 영수증에 적힌 총 그맹과 일치하는지 검사

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //영수증에 작성된 총 금액
        int x = Integer.parseInt(br.readLine());
        byte n = Byte.parseByte(br.readLine());

        int total = 0;
        for (int i = 0; i < n; i++) {
            //구매한 각 물건의 가격과 개수
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            total += a * b;
        }

        if(x == total) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
