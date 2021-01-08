package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {
	
	//컨베이어 벨트 2개
	static LinkedList<int []> belt = new LinkedList<>();
	static int N, K, kCnt, nCnt, lCnt; //컨베이어 벨트의 수(x2), 내구도 0의 칸의 마지노선을 정하는K, 벨트칸의 내구도가 0인 개수를 기억할 kCnt
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		//벨트의 칸 수와 내구도가 0인 칸의 개수 K를 입력받는다.
		N = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken());
		nCnt = N;
		
		st = new StringTokenizer(br.readLine()," ");
		//벨트의 위치에 내구도를 입력함
		for (int i = 0; i < 2*N; i++) {
			belt.add(new int [] {0, Integer.parseInt(st.nextToken())});
		}
		System.out.println(moveBelt());
	}
	static int moveBelt() {
		while(kCnt!=K) {
			//1.
			//올라가는 위치 2N -> 1
			belt.add(0, belt.pollLast()); //마지막을 1번에 올린다.
			
			//내려가는 위치 N에 로봇이 있다면 땅으로 내린다.
			int [] nBelt = belt.get(N-1);
			if(nBelt[0]==1) {
				nBelt[0] = 0; 	//로봇을 땅에 내린다.
				lCnt--;
			}
			//2 로봇을 이동시킨다.
			//이동은 2군대로 나눈다. N~0까지, 2*N ~ N+1까지
			//위쪽 컨테이너 로봇을 이동시켜야 하는지 판단
			for (int i = N-2; i>=0; i--) {
				moveRobot(i);
			}
			//아래쪽 컨테이너 로봇을 이동시켜야 하는지 판단
			for (int i = 2*N-1; i >=N ; i--) {
				moveRobot(i);
			}
			//3로봇을 올린다.
			nBelt = belt.get(0);
			if(nCnt>0 && nBelt[0]==0 && nBelt[1] > 0) {
				nCnt--;
				lCnt++;
				nBelt[0] = 1;
				nBelt[1]--;
			}
			if(nCnt==0 && lCnt==0) break;
		}
		return kCnt;
	}
	static void moveRobot(int i) {
		int [] curr = belt.get(i);
		
		//로봇이 해당칸에 존재하는가?
		if(curr[0] != 1) return;
		
		//올라가는 위치인가?
		if(i==2*N-1) {
			int [] first = belt.get(0);
			//나의 위치 내구도가 1이상이고, 1번 위치에 로봇이없고, 1번 위치의 내구도가 1이상이면 
			if(curr[1] > 0 && first[0] == 0 && first[1] > 0) {
				curr[1]--;	//나의 위치의 내구도를 1 감소하고
				first[1]--; //올라가는 칸의 내구도를 1감소한다.
				first[0] = 1; //마지막을 1번에 올린다.
				curr[0] = 0; //마지막칸위치에 있던 로봇을 제거
				//내구도가 0이 되었는지 확인한다.
				if(curr[1] == 0) kCnt++;
				if(first[1] == 0) kCnt++;
			}
		}
		else {
			//해당 칸에 로봇이 존재한다면
			//2-1.  내가 위치한 칸의 내구도가 1이상인가? 앞칸에 로봇이 있는가? 앞칸의 내구도가 1이상인가?
			int [] next = belt.get(i+1);
			if(curr[1] >0 && next[0] == 0 && next[1] > 0) {
				curr[1]--;
				next[1]--;
				next[0] = 1;
				curr[0] = 0;
				if(curr[1] == 0) kCnt++;
				if(next[1] == 0) kCnt++;
			}
		}
	}
}
