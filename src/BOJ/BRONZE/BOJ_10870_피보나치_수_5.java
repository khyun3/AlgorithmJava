package BOJ.BRONZE;

import java.util.Scanner;

public class BOJ_10870_피보나치_수_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] fibo = new int [21];
        fibo[1] = 1;
        for (int i = 2; i <= 20; i++) {
            fibo[i] = fibo[i-2] + fibo[i-1];
        }

        System.out.print(fibo[sc.nextInt()]);
    }
}
