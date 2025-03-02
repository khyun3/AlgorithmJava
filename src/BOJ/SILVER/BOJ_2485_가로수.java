package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2485_가로수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //1
        int N = Integer.parseInt(br.readLine());
        int[] trees = new int[N];

        //2
        trees[0] = Integer.parseInt(br.readLine());
        trees[1] = Integer.parseInt(br.readLine());
        int gap = trees[1] - trees[0];
        //3
        for (int i = 2; i < N; i++) {
            trees[i] = Integer.parseInt(br.readLine());
            gap = findGCD(gap, trees[i] - trees[i-1]);
        }
        //4,5
        System.out.println(((trees[N - 1] - trees[0]) / gap) + 1 - N);
    }

    private static int findGCD(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
