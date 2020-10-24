package SILVER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15658_연산자끼워넣기 {
	static int tot = 0;
	static int min=Integer.MAX_VALUE, max=0;
	static int [] num;
	static List<Character> op;
	static boolean [] selected;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		num = new int [N];
		op = new ArrayList<>();
		
		//숫자 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}//숫자 입력 끝
		
		// 연산자 입력
		st = new StringTokenizer(br.readLine());
		int R = 0;
		for (int i = 0; i < 4; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			R +=tmp;
			for (int j = 0; j < tmp; j++) {
				if(i==0)
					op.add('+');
				else if(i==1)
					op.add('-');
				else if(i==2)
					op.add('*');
				else
					op.add('/');
			}
			
		}//연산자 입력 끝

		selected = new boolean[R];
		nPr(0, R, N-1, new char [N-1]);
		System.out.println(max+"\n"+min);
	}

	private static void nPr(int cnt, int n, int r, char [] arr) {
		if(cnt==r) {
			tot++;
			int sum = num[0];
			
			for (int i = 0; i < r; i++) {
				switch(arr[i]) {
				case '+':
					sum +=num[i+1];
					break;
				case '-':
					sum -=num[i+1];
					break;
				case '*':
					sum *=num[i+1];
					break;
				case '/':
					sum /=num[i+1];
					break;
				}
			}
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			System.out.println(Arrays.toString(arr) +" "+ tot +"  "+ min+"  "+ max);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(selected[i]) continue;
			
			arr[cnt] = op.get(i);
			selected[i] = true;
			nPr(cnt+1, n, r, arr);
			selected[i] = false;
		}
	}
}
