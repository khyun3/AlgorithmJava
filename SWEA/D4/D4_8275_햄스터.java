package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D4_8275_햄스터 {
	static int N,X,M, L,R,S,max, answer[], wori[];
	static ArrayList<int []> list;
	static boolean ansOk;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			//테케 입력 N, X, M => 우리수, 최대 마리, 기록의 수
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			//초기화
			max = -1;
			answer = new int [N+1];
			wori = new int [N+1];
			list = new ArrayList<int[]>();
			ansOk = false;
			//기록의 수 만큼 받자 L, R, S => L~R까지는 S마리가 있다.
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim()," ");
				L = Integer.parseInt(st.nextToken());
				R = Integer.parseInt(st.nextToken());
				S = Integer.parseInt(st.nextToken());
				list.add(new int [] {L,R,S});
			}
			solve(1);
			sb.append("#").append(t).append(" ");
			if(ansOk) {
				for (int i = 1; i <= N; i++) {
					sb.append(answer[i]).append(" ");
				}
				sb.append("\n");
			}
			else
				sb.append(-1).append("\n");
		}
		System.out.print(sb);
	}
	private static void solve(int cnt) {
		
		//N까지 왔으면 종료한다.
		if(cnt==N+1) {
			int mTmp = 0;
			for (int[] item : list) {
				int sum = 0;
				for (int i = item[0]; i <= item[1]; i++) {
					sum += wori[i];
				}
				//만약에 S와 같지 않다면 종료한다.
				if(sum!=item[2]) return;
			}
			ansOk = true;
			for (int i = 1; i <= N; i++) {
				mTmp += wori[i];
			}
			//만약에 mTmp가 기존 max보다 더 크다면 변경한다.
			if(max < mTmp) {
				max = mTmp;
				//정답을 저장해둔다.
				for (int i = 1; i <= N; i++) {
					answer[i] = wori[i];
				}
			}
			return;
		}
		//최대 마리수까지
		for (int i = 0; i <= X; i++) { //중복이 가능함 즉, 사용했다 안했다가 필요없음
			wori[cnt] = i;
			solve(cnt+1);
		}
	}
}