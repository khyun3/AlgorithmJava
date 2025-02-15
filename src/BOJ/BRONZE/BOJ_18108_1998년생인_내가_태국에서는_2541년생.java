package BOJ.BRONZE;

import java.util.Scanner;

// 불기 연도가 주어질 때 이를 서기 연도로 변경하는 문제
public class BOJ_18108_1998년생인_내가_태국에서는_2541년생 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int be = sc.nextInt();
        //서기(A.D.)와 불기(B.E.)의 차이값
        int gap = 543;
        System.out.println(be - gap);
    }
}
