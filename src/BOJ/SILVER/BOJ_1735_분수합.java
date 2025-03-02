package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//BOJ_1735_문제풀이.md 참고
public class BOJ_1735_분수합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1
        String[] input = br.readLine().split(" ");
        int as = Integer.parseInt(input[0]);
        int am = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int bs = Integer.parseInt(input[0]);
        int bm = Integer.parseInt(input[1]);

        //2
        int[] answer = {as*bm + bs*am, am * bm};
        //3
        int gcd = findGCD(answer[0], answer[1]);
        //4,5
        System.out.println(answer[0] / gcd + " " + answer[1] / gcd);
    }

    static int findGCD(int a, int b) {
        while(b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
