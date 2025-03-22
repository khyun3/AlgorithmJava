package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_4779_칸토어_집합 {
    static StringBuilder sb = new StringBuilder();
    static char[] strArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        while (input != null && !input.isBlank()) {
            int n = (int) Math.pow(3, Integer.parseInt(input));
            strArr = new char[n];

            Arrays.fill(strArr, '-');

            cantorSet(n,0, n);
            print(strArr);

            input = br.readLine();
        }
        System.out.println(sb);
    }

    static void cantorSet(int len, int start, int end) {
        if(len == 1) return;
        int partLen = len / 3;
        //part 1
        cantorSet(partLen, start, start + partLen);
        //part 2
        Arrays.fill(strArr, start + partLen, end - partLen, ' ');
        //part 3
        cantorSet(partLen, end - partLen, end);
    }

    static void print(char[] strArr) {
        for (char c : strArr) {
            sb.append(c);
        }
        sb.append("\n");
    }
}
