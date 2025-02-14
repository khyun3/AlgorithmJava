package BOJ.GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_16235_나무재테크 {
	static class Cell{
		int energy; //땅 양분
		int addedEnegy; //겨울에 추가되는 양분의 양
		ArrayList<Integer> trees = new ArrayList<>();
		
		public Cell(int addedEnegy) {
			this.energy = 5;
			this.addedEnegy = addedEnegy;
			this.trees = new ArrayList<>();
		}

	}
	static int dir[][] = new int [][] {{-1,1},{-1,0},{-1,-1},{0,1},{0,-1},{1,1},{1,0},{1,-1}};
	static int N, M, K, x,y,z, energyMap[][];
	static Cell map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken()); //N*N 땅
		M = Integer.parseInt(st.nextToken()); //M개의 나무
		K = Integer.parseInt(st.nextToken()); //K년
		
		map = new Cell[N][N];
		energyMap = new int [N][N];
		
		//r과 c는 1부터 시작한다.
		//가장 처음에 양분은 모든 칸에 5만큼 들어있다.
		//각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
		//같은 1×1 크기의 칸에 여러 개의 나무가 심어져 있을 수도 있다.
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = new Cell(Integer.parseInt(st.nextToken()));
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			x = Integer.parseInt(st.nextToken())-1; //r
			y = Integer.parseInt(st.nextToken())-1; //c
			z = Integer.parseInt(st.nextToken());	//나이
			
			map[x][y].trees.add(z);
		}
		//각 셀의 나무를 나이순으로 정렬
		
		sort();		
//		print();
		
		//loop
		for (int i = 0; i < K; i++) {
			spring();
			summer();
			autumn();
			winter();
		}		
		System.out.println(getAnswer());
	}
	static void spring() {
		//1. 봄에는 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
		//1-1. 하나의 칸에 여러 개의 나무가 있다면, 나이가 어린 나무부터 양분을 먹는다.
		//1-2. 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ArrayList<Integer> removeList = new ArrayList<>();
				
				for (int t = 0; t < map[i][j].trees.size(); t++) {
					int currTree = map[i][j].trees.get(t);
					
					if(currTree <= map[i][j].energy) {
						map[i][j].energy -= currTree;
						map[i][j].trees.set(t, currTree+1);
					}
					else {
						removeList.add(t);
						energyMap[i][j]+=currTree/2;
					}
				}
				
				if(removeList.size()>0) {
					Collections.sort(removeList);
					for (int re = removeList.size()-1; re >= 0; re--) {
						int index = removeList.get(re);
						map[i][j].trees.remove(index);
					}
				}
				
			}
		}
	}
	static void summer() {
		//2. 여름에는 봄에 죽은 나무가 양분으로 변하게 된다. 
		//	 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다. 소수점 아래는 버린다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j].energy += energyMap[i][j];
				energyMap[i][j] = 0;
			}
		}
	}
	static void autumn() {
		//3. 가을에는 나무가 번식한다.
		//번식하는 나무는 나이가 5의 배수이어야 하며, 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
		//상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				for (int t = 0; t < map[i][j].trees.size(); t++) {
					if(map[i][j].trees.get(t) % 5 == 0) {
						for (int d = 0; d < 8; d++) {
							int nr = i + dir[d][0];
							int nc = j + dir[d][1];
							if(!check(nr, nc)) continue;
							map[nr][nc].trees.add(1);
						}
					}
				}
			}
		}
		//다시 나이순으로 정렬
		sort();
		
	}
	static void winter() {
		//4. 겨울에는 S2D2가 땅을 돌아다니면서 땅에 양분을 추가한다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j].energy += map[i][j].addedEnegy;
			}
		}
	}
	static int getAnswer() {
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				answer += map[i][j].trees.size();
			}
		}
		return answer;
	}
	static void sort() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Collections.sort(map[i][j].trees);
			}
		}
	}
	static boolean check(int nr, int nc){
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}
}
