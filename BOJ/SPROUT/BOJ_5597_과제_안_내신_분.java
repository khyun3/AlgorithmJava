package SPROUT;

import java.io.IOException;
import java.util.*;
//TreeMap과 다를바 없음
public class BOJ_5597_과제_안_내신_분 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        boolean [] isSummit = new boolean[31];
        for (int i = 0; i < 28; i++) {
            isSummit[sc.nextInt()] = true;
        }
        for(int i = 1; i < 31; i++) {
            if(!isSummit[i]){
                System.out.println(i);
            }
        }
    }
}
