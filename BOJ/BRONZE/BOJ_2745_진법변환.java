package BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// | 36^4 | 36^3 | 36^2  | 36^1  | 36^0  |
// |Z(35) |Z(35) | Z(35) | Z(35) | Z(35) |
// 36^4 * Z + ... 36^0 * Z = 60466175

public class BOJ_2745_진법변환 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        int[] numArr = getNumArr(tokenizer.nextToken());
        int zin = Integer.parseInt(tokenizer.nextToken());

        int k = zin;
        int answer = 0;
        for(int i = 0; i < numArr.length; i++) {
            k = i == 0 ? 1 : k * zin;
            answer += k * numArr[i];
        }
        System.out.println(answer);
    }
    public static int[] getNumArr(String numStr) {
        int len = numStr.length();
        int[] numArr = new int[len];

        for (int i = 0; i < len; i++) {
            int m = 48;
            if(numStr.charAt(i) >= 65) {
                m = 55;
            }
            numArr[len - i - 1] = numStr.charAt(i) - m;
        }
        return numArr;
    }
}
