package BRONZE;

import java.util.Scanner;

public class BOJ_18512_점프점프2 {

    static int X;
    static int Y;
    static int H1;
    static int H2;
    static boolean[] road;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 보폭
        X = sc.nextInt();
        Y = sc.nextInt();
        H1 = sc.nextInt();
        H2 = sc.nextInt();
        int np1 = H1;// 새로운 위치
        int np2 = H2;

        road = new boolean[10001];

        while (true) {
            if (np1 >= 10000) {
                break;
            }
            road[np1] = true;
            np1 = np1 + X;

        }
        while (true) {
            if (np2 >= 10000) {
                System.out.println(-1);
                break;
            }
            if (road[np2] == true) {
                break;
            }
            np2 = np2 + Y;
        }
        if (np2 <= 10000) {
            System.out.println(np2);//흔적 발견한 장소 출력
        }
    }
}