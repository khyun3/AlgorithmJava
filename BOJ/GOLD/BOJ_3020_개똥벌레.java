package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3020_개똥벌레 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int [] cave = new int [N];
		
		for (int i = 0; i < N; i++) {
			cave[i] = Integer.parseInt(br.readLine());
		}
		
		//h를 어떻게 사용할 것인가?
		binarySerach(cave, N, H);
		
	}

	private static void binarySerach(int[] cave, int n, int h) {
		int first=h, last=0, mid=0;
		
		while(first>=last) {
			mid = (first+last)/2;
			
			
			
		}
		
	}
}
