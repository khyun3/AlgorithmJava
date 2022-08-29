package BRONZE;

import java.util.Scanner;

public class BOJ_3003_킹_퀸_룩_비숍_나이트_폰 {
    public static void main(String[] args) {
        //112228
        Scanner sc = new Scanner(System.in);
        int [] chs = new int [] {1,1,2,2,2,8};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chs.length; i++) {
            sb.append(chs[i] - sc.nextInt()).append(" ");
        }
        System.out.println(sb);
    }
}
