package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18310_안테나 {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int [] houses = new int [2000001];
		int max = 0;
		int min = Integer.MAX_VALUE;
		long dist = 0;
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		while(st.hasMoreTokens()) {
			int tmp = Integer.parseInt(st.nextToken());
			houses[tmp]++;
			max = Math.max(max, tmp);
			min = Math.min(min, tmp);
		}
		
		//가장 앞에있는 집에 설치했을 때
		for (int i = min; i <= max; i++) {
			dist += houses[i]*(i-1);
		}
		
		System.out.println(search(houses, N, min, max, dist));
	}
	private static int search(int[] houses, int N, int min, int max, long dist) {
		int answer = min;
		int bMin = min;
		int leftCnt = houses[min]; //오른쪽 개수
		int rightCnt = N-leftCnt;  //왼쪽 개수
		long distTmp = dist;
		int i = 0;
		
		for (i = min+1; i <= max; i++) {
			//집이 있는 위치로 이동하자
			if(houses[i] != 0) {
				distTmp = dist - (i-bMin)*rightCnt + (i-bMin)*leftCnt;
			
				bMin = i;
				rightCnt -= houses[i];
				leftCnt += houses[i];
				if(dist>distTmp) {
					dist = distTmp;
					answer = i;
				}
				else {
					return answer;
				}
			}
		}
		return answer;
	}
}