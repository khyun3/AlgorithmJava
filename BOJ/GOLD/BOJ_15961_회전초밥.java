package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_15961_회전초밥 {
	static int N,d,k,c, cnt, max=0; //접시 수, 초밥 가지수, 연속으로 먹는 접시, 쿠폰(초밥 번호)
	static int[] belt, checked;
	static Queue<Integer> que = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		belt = new int[N];
		checked = new int[d];
		cnt = 1;
		//쿠폰 초밥을 먼저 먹었다고 친다.
		checked[c-1]++;
		
		for (int i = 0; i < N; i++) {		
			belt[i] = Integer.parseInt(br.readLine())-1;
			
			
			if(i<k) {
				que.offer(belt[i]);        //접시를 que에 먼저 넣어둔다(최초 검사할 거)
				if(checked[belt[i]]==0) {
					cnt++;
				}
				checked[belt[i]]++;        //먹은 초밥을 체크한다.
											// 1 1 2 3 c : 5
											
				//System.out.println(cnt);
			}
		}
		max = cnt;		      //max값에 현재 먹은 초밥의 수를 넣는다.		
		//System.out.println(Arrays.toString(checked));

		for (int i = k; i < N+k-1; i++) {
			
			int btmp, qtmp;
			if(cnt>k || cnt==d || N==k) break; //가지를 친다.
			
			qtmp = que.poll(); //큐에서 가장 앞 친구를 뺀다.
			
			if(checked[qtmp]>1) { //다음 조합을 보기 위해 처음으로 먹은 초밥의 체크를 푼다.
				checked[qtmp]--; 			//	|1 2 3 4 5|
			}else if(checked[qtmp] == 1) { //ch |2 1 1 0 1|
				checked[qtmp]--;
				cnt--;
			}
			
			btmp = i%N;
			que.offer(belt[btmp]);
			
			if(checked[belt[btmp]]==0) { //먹은 초밥이 아니라면
				checked[belt[btmp]]++; 
				cnt++;
			}else {
				checked[belt[btmp]]++;
			}
			max = Math.max(cnt, max);
			//System.out.println(Arrays.toString(checked));
		}
		System.out.println(max);
	}
}