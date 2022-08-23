package SILVER;

import java.util.Scanner;

//TODO : DP로 풀어볼 것
public class BOJ_17626_FOUR_SQUARES {
    static double N;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextDouble();
        int maxSqrt = (int)Math.sqrt(N); //가장큰 제곱근이 넘을 수 없는 수

        //자체가 제곱근 일 때
        if(isEqual(maxSqrt, N)){
            System.out.println(1);
        }
        else {
            solve();
        }
    }
    public static void solve() {
        int [] max = new int [4];
        int [] half = new int [4];
        int [] remain = new int [4];

        max[0] = (int)Math.sqrt(N);
        half[0] = max[0]/2;
        for (int i = max[0]; i >= half[0]; i--) {
            remain[0] = (int)N - i * i;

            max[1] = (int)Math.sqrt(remain[0]);
            half[1] = max[1]/2;
            for (int j = max[1]; j >= half[1]; j--) {
                if(isEqual(j, remain[0])){
                    System.out.print(2);
                    return;
                }
                else {
                    remain[1] = remain[0] - j * j;

                    max[2] = (int)Math.sqrt(remain[1]);
                    half[2] = max[2]/2;
                    for (int k = max[2]; k >= half[2]; k--) {
                        if(isEqual(k, remain[1])){
                            min = Math.min(min, 3);
                        }
                        else {
                            remain[2] = remain[1] - k * k;
                            max[3] = (int)Math.sqrt(remain[2]);
                            half[3] = max[3]/2;
                            for (int l = max[3]; l >= half[3]; l--) {
                                if(isEqual(k, remain[2])){
                                    min = Math.min(min, 4);
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(min);
    }
    public static boolean isEqual(double sqrt, double k) {
        if(Double.compare((sqrt * sqrt), k) == 0){
            return true;
        }
        return false;
    }
}
