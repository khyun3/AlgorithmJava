package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class D4_2115_벌꿀채취 {
	static int N, M, C, max, map[][], bSum, aSum;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			max = 0;
			map = new int [N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			sol();
		sb.append('#').append(t).append(' ').append(max).append('\n');
		}//TC end
		System.out.print(sb);
	}
	private static void sol() {
		LinkedList<Integer> aList = new LinkedList<>(); //1번 일꾼
		LinkedList<Integer> bList = new LinkedList<>(); //2번 일꾼
		int r1=0, c1=0, r2=0, c2=0;

		for (int i = 0; i < (N*N-N*(M-1))-(N-M); i++) { // 1번 일꾼 이동
			aSum = 0;
			
			if(aList.isEmpty()) {
				for (c1 = 0; c1 < M; c1++) {
					aList.offer(map[r1][c1]);
				}
			}else {
				if(c1!=N) {
					aList.poll();
					aList.offer(map[r1][c1++]);
				}
				else {
					aList.clear();
					r1++;
					for (c1 = 0; c1 < M; c1++) {
						aList.offer(map[r1][c1]);
					}
				}
			}
			maxProfit(aList, new ArrayList<String>(),0,1);			
			bList.clear();
			r2 = r1;
			int flag = 0;
			while(r2!=N || c2!=N) { // 2번 일꾼 이동
				bSum = 0;
				if(flag++==0 && bList.isEmpty()) {
					if(N-c1>=M) { //만약에 1번 일꾼 꿀통이 남은 가로 열보다 많으면 다음 행으로
						for (c2 = c1; c2<c1+M; c2++) { //그 행 그대로
							bList.offer(map[r2][c2]);
						}
					}
					else if(++r2!=N){
						for (c2 = 0; c2 <M; c2++) { // 다음 행으로
							bList.offer(map[r2][c2]);
						}
					}
					else break;
					
				}else {
					if(c2!=N) {
						bList.poll();
						bList.offer(map[r2][c2++]);
					}
					else if(++r2!=N){
						bList.clear();
						c2=0;
						for (c2 = 0; c2 < M; c2++) {
							bList.offer(map[r2][c2]);
						}
					}
					else break;
				}
				if(!bList.isEmpty()) {
					maxProfit(bList, new ArrayList<String>(),0,2);
					max = Math.max(max, aSum+bSum);
				}
			}
		}		
	}
	private static void maxProfit(LinkedList<Integer> aList, ArrayList<String> arr, int cnt, int type) {
		
		if(cnt==M) {
			int tmp = 0, sumtmp=0, ctmp = 0;
			for (String s : arr) {
				tmp = Integer.parseInt(s);
				ctmp +=tmp;
				sumtmp += tmp*tmp;
				if(ctmp>C) return;
			}
			if(type==1)
				aSum = Math.max(aSum, sumtmp);
			else
				bSum = Math.max(bSum, sumtmp);
			return;
		}
		arr.add(aList.get(cnt)+"");
		maxProfit(aList,arr,cnt+1, type);
		arr.remove(aList.get(cnt)+"");
		maxProfit(aList,arr,cnt+1, type);
	}
}