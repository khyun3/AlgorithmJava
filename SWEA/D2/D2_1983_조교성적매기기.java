package D2;
import java.util.Arrays;
import java.util.Scanner;

public class D2_1983_조교성적매기기 {

	    static String[] grade = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };
	 
	    public static void main(String[] args) throws Exception {
	        Scanner sc = new Scanner(System.in);
	        StringBuilder sb;
	        int T = sc.nextInt();
	 
	        for (int t = 1; t <= T; t++) {
	            sb = new StringBuilder();
	            sb.append("#").append(t).append(" ");
	            int N = sc.nextInt();
	            int K = sc.nextInt() - 1;
	            float tots;
	            float[] score = new float[N];
	            float p = 0;
	 
	            for (int i = 0; i < N; i++) {
	                tots = 0;
	                tots += sc.nextInt() * 0.35;
	                tots += sc.nextInt() * 0.45;
	                tots += sc.nextInt() * 0.20;
	                score[i] = tots;
	                if (i == K)
	                    p = score[i];
	            }
	            Arrays.sort(score);//오름차순
	            for (int i = N-1; i>=0; i--) {
	                if (score[i] == p) {
	                    sb.append(grade[(N-i-1)/(N/10)]);	
	                }
	            }
	            System.out.println(sb.toString());
	        }
	        sc.close();
	    }
	}