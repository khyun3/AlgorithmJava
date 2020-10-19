package D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D4_10888_음식배달 {
	static int T, N, cnt, answer;
	static List<int []> hList; //집 위치
	static List<int []> bList; //음식 배달집 위치

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			hList = new ArrayList<>(); //집 위치
			bList = new ArrayList<>(); //음식 배달집 위치
			answer = Integer.MAX_VALUE;
			cnt = 0;
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 1; j <= N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					
					//집
					if(tmp == 1) {
						hList.add(new int [] {i,j});
					}
					//음식 배달집
					else if(tmp !=0) {
						bList.add(new int [] {i,j,tmp});
						cnt++;
					}
				}
			}

			//음식 배달집을 선택(subset)
			subSet(0, new ArrayList<int []>());
			System.out.println("#"+t+" "+answer);
		}
	}

	private static void subSet(int start, ArrayList<int []> list) {
		
		if(start==cnt) {
			if(list.size()!=0){
				answer = Math.min(answer, distance(list));
			}
			return;
		}
		
		list.add(bList.get(start));
		subSet(start+1, list); //포함
		list.remove(bList.get(start));
		subSet(start+1, list); //미포함
	}

	private static int distance(ArrayList<int[]> list) {
		//배달 거리 + 운영비
		int dist = 0;
		//배달거리
		for (int i = 0; i < hList.size(); i++) { //각 집에서
			int [] h = hList.get(i);
			int min = Integer.MAX_VALUE;
			
			for (int j = 0; j < list.size(); j++) { //선택된 가장 가까운 지점 찾기
				int [] b = list.get(j);
				min = Math.min(min, (Math.abs(h[0] - b[0]) + Math.abs(h[1]-b[1]))); 	//|r1-r2| + |c1-c2|
			}
			dist +=min;
		}
		
		//운영비
		for (int[] i : list) {
			dist +=i[2];
		}
		return dist;
	}
}