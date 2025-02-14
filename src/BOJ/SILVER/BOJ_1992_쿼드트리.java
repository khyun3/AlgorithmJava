package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1992_쿼드트리 {
	static int N;
	static char[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		divAndCon(0,0,N);
		System.out.println(sb.toString());
	}
	private static void divAndCon(int nr, int nc, int s) {
		//기저
		if(s==1) { //1칸까지 왔으면 해당 숫자 1or0을 stringBuilder에 추가
			sb.append(map[nr][nc]);
			return;
		}
		boolean check = true;
		L:for (int i = 0; i < s; i++) { //해당 칸수만큼 같은 색인지 확인
			for (int j = 0; j < s; j++) {
				if(map[nr][nc] != map[nr+i][nc+j]) { //모두 같은 색이 아니라면
					check= false;
					sb.append('('); //같은 색이 아니라면 열어준다.
					break L;
				}
			}
		}
		if(check) {
			if(map[nr][nc] == '1') { //모두 같은 색일 때,
				sb.append("1");
			}
			else {sb.append("0");}
		}
		else {
			int w = s/2;
			divAndCon(nr, nc, w);
			divAndCon(nr, nc+w, w);
			divAndCon(nr+w, nc, w);
			divAndCon(nr+w, nc+w, w);
			sb.append(')'); //끝이면 닫아준다.
		}
	}
}