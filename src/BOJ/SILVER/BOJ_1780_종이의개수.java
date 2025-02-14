package BOJ.SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {
	static int answer[] = new int [3];
	static int paper[][];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		//N을9로 나눈 것
		paper = new int [N][N]; //2187 * 2187 = 4,782,969 *4 = 19,131,876 = 1.9MB
		int check = 0;
		boolean allOk = true;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
				if(i==0 && j==0) check = paper[i][j];
				if(paper[i][j]!=check) allOk = false;
			}
		}
		if(!allOk)
			solve(0,0, N/3, N/3 ,N/3);
		else
			answer[check+1]++;
		
		System.out.println(answer[0]+"\n"+answer[1]+"\n"+answer[2]);
	}
								//시작r, c		//끝 지점
	private static void solve(int r, int c, int r2, int c2, int size) {
//		if(size==0) {
//			System.out.println("추가된 것은? : "+paper[r][c]);
//			answer[paper[r][c]+1]++;
//			return;
//		}
//		//9개의 section
//		 int sr = r;
//		 int sc = c;
//		 int er = r2;
//		 int ec = c2;
//		for (int i = 0; i < 9; i++) {
//			boolean check = true;
//			
//			 if(i!=0 && i%3==0) {//3번, 6번
//				sr += size; //시작 행은 아래로
//				sc = c;		//시작 열은 그대로
//				er += size;	//끝 행은 아래로
//				ec = r2;	//끝 열은 그대로
//			}
//			else if(i!=0){ //1,2,4,5,7,8번
//				 sc+= size;	//시작 행은 오른쪽으로
//				 ec+= size;	//끝 행은 오른쪽으로
//			}
////			 System.out.println("sr : "+sr +"  sc : "+sc+"  er : "+er+"  ec : "+ec);
//			int isOk = paper[sr][sc];
//			a:for (int j = sr; j < er; j++) {
//				for (int k = sc; k < ec; k++) {
//					if(paper[j][k] == isOk) continue;
//					else {
//						check = false;
//						break a;					
//					}
//				}
//			}
//			if(check) {
//				answer[isOk+1]++;
//			}
//			else {
//				solve(sr,sc, sr+size/3, sc+size/3, size/3);
//			}
//		}
	}
}