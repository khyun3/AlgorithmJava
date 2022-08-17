package SPROUT;

import java.util.Scanner;

public class BOJ_15964_이상한_기호 {
    public static void main(String[] args) {
        // A＠B = (A+B)×(A-B)
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        System.out.println((A + B) * (A - B));
    }
}
