package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2559_수열 {
	static int N, K, MAX = 0; //N은 온도를 측정한 전체 날짜의 수, K는 합을 구하기 위한 연속적인 날짜의 수
	static int arr[];
	//queue로 풀기
	static Queue<Integer> que = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//초기 K개를 que에 넣는다.
		for (int i = 0; i < K; i++) {
			que.offer(arr[i]);  //     |que| 3 | -2 | 
			MAX += arr[i];
		}
		
		//K이후부터					
		int tmp = MAX;			    
		for (int i = K; i < N; i++) { //|que| -2 | -4 |
			tmp -= que.poll();     //하나 뺴기
			que.offer(arr[i]);     //하나 넣기
			tmp +=arr[i];	  	   //tmp에 더하기
			if(tmp>MAX) MAX = tmp; //비교하기
		}
		System.out.println(MAX);
	}
}