package BRONZE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1009_분산처리 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		int data[][] = {{10}, {1}, {2,4,8,6}, {3,9,7,1}, {4,6}, {5}, {6}, {7,9,3,1}, {8,4,2,6}, {9,1}};
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken())%10;
			int b = Integer.parseInt(st.nextToken());
			
			bw.write(Integer.toString(data[a][(b-1)%data[a].length]));
			bw.write('\n'); 
		}
		bw.flush();
	}
}