package BOJ.BRONZE;

import java.util.Scanner;

public class BOJ_25314_코딩은_체육과목_입니다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        System.out.println(solution(N));
    }

    static String solution(int N) {
        int longCharCount = N / 4;
        return "long ".repeat(longCharCount) + "int";
    }
}
