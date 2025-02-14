package BOJ.SPROUT;

import java.util.Scanner;

public class BOJ_2420_사파리월드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long domainA = sc.nextLong();
        long domainB = sc.nextLong();
        long res = Math.abs(domainA - domainB);
        System.out.println(res);
    }
}
