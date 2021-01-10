package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * @author Kihyeon Yun
 * @date 2021. 1. 11.
 * 
 * 배열로 다시풀 것!
 */
public class BOJ_20055_컨베이어벨트위의로봇 {
	//컨베이어 벨트
	static LinkedList<int []> belt = new LinkedList<>();
	//컨베이어 벨트의 수(x2), 내구도 0의 칸의 마지노선을 정하는K, 벨트칸의 내구도가 0인 개수를 기억할 kCnt
	static int N, K, kCnt, step; 
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		//벨트의 칸 수와 내구도가 0인 칸의 개수 K를 입력받는다.
		N = Integer.parseInt(st.nextToken()); 
		K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		//벨트의 위치에 내구도를 입력함
		for (int i = 0; i < 2*N; i++) {
							// 로봇 유무,   벨트 내구도
			belt.add(new int [] {0, Integer.parseInt(st.nextToken())});
		}
		while(K>kCnt) {//4. 내구도 0인 수 체크

			//1. 벨트의 회전
			moveBelt();
			//2. 로봇의 이동
			moveRobot();
			//3. 로봇을 올린다.
			upRobot();
			step++;
		}
		System.out.println(step);
	}
	//벨트의 회전
	static void moveBelt(){
		belt.add(0, belt.pollLast());
		downRobot();
	}
	//로봇의 이동
	static void moveRobot() {
		for (int i = N-2; i >= 0; i--) {
			int [] tmp = belt.get(i);
			if(tmp[0] == 1) {
				int [] nxt = belt.get(i+1); //다음칸에
				if(nxt[0]==0 && nxt[1]>0) { //로봇이 없고 내구도가 0이상이면
					nxt[0]=1;
					tmp[0]=0;
					if(--nxt[1] == 0) kCnt++;
				}
			}
		}
		downRobot();
	}
	
	//로봇을 0번 컨베이어 벨트칸에 올릴지 판단
	static void upRobot() {
		int [] tmp = belt.get(0);
		if(tmp[0] == 0 && tmp[1]>0) {
			tmp[0]=1;
			if(--tmp[1] == 0) kCnt++;
		}
	}
	static void downRobot() {
		int [] tmp = belt.get(N-1);
		if(tmp[0]==1) tmp[0] = 0;	//로봇을 내린다.
	}
//	static void print() {
//		for (int [] is : belt) {
//			System.out.println(Arrays.toString(is)+" ");
//		}
//		System.out.println();
//	}
}
