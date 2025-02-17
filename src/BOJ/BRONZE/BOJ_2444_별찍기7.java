package BOJ.BRONZE;

import java.util.Scanner;

public class BOJ_2444_별찍기7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        solution(n);
    }

    static void solution(int n) {
        String star = "*";
        String space = " ";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(space.repeat(n - i - 1))
                    .append(star.repeat(2 * i + 1))
                    .append("\n");
        }
        System.out.print(sb);

        sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            sb.append(space.repeat(i))
                    .append(star.repeat(2 * (n - i) - 1))
                    .append("\n");
        }
        System.out.print(sb);
    }
}
