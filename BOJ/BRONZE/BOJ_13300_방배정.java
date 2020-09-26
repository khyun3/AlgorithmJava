package BRONZE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13300_방배정 {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int [][] students = new int[2][6]; //6개 학년, 성별
		
		int room = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken())-1;
			students[gender][grade]++;
		}//입력 끝
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				if(students[i][j]%K==0) {
					room+=students[i][j]/K;
				}
				else {
					room+=students[i][j]/K+1;
				}
			}
		}
		System.out.println(room);
	}
}