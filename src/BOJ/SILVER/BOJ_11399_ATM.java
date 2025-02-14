package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {
	static int N, answer=0;
	static int [] people;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(people);

		
		int temp = 0; 	//메모이제이션(DP)
		for (int i = 0; i < N; i++) { //1 2 3 3 4  1, 1+2 = 3, (1+2+3), (1+2+3)+3
			temp += people[i];
			answer = answer+temp;
		}
		System.out.println(answer);
	}
}