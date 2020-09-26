package SILVER;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//1 북 서북 서 4242
//2 서 남서 남 2323
//3 남 동남 동 3131
//4 동 북동 북 1414

public class BOJ_2477_참외밭 {
	static int N;
	static String [] d = {"4242","2323","3131","1414"}; 
	static List<int []> list = new LinkedList<>();
	static List<Integer> rc = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb;
		N = sc.nextInt(); //1m^2 당 참외 수
		int [][] map =new int[6][2];

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				map[i][j] = sc.nextInt();
				
				if(i<4 && j==1) list.add(new int [] {map[i][0],map[i][1]});
				else if(i>=4 && j==1) rc.add(map[i][1]);
			}
		}
		for (int i = 0; i < 6; i++) {
			sb = new StringBuilder();
			
			for (int j = 0; j < 4; j++) {
				int[] tmp = list.get(j);
				sb.append(tmp[0]);
			}
			for (int j = 0; j < 4; j++) {
				if(sb.toString().equals(d[j])) {
					int[] r = list.get(1);
					int[] c = list.get(2); 
					System.out.println(N*(rc.get(0)*rc.get(1)-r[1]*c[1]));
					return;
				}
			}
			rc.remove(0);
			int [] a = list.get(0);
			rc.add(a[1]);
			list.remove(0);
			list.add(map[(i+4)%6]);
		}
	}
}