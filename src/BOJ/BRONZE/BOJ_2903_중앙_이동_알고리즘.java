package BOJ.BRONZE;

import java.util.Scanner;

public class BOJ_2903_중앙_이동_알고리즘 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    //lineCount = 2(초기 가로,새로 라인수)
    //lineCount + 2^(n-1)
    //n=1, 2+2^(1-1) = 3
    //n=2, 3+2^(2-1) = 5
    //n=3, 5+2^(3-1) = 9
    //n=4, 9+2^(4-1) = 17
    //n=5, 17+2^(5-1) = 1089
    static int solution(int n) {
        int lineCount = 2;
        for (int i = 1; i <= n; i++) {
            lineCount += (int) Math.pow(2d, i-1);
        }
        return lineCount * lineCount;
    }
}
