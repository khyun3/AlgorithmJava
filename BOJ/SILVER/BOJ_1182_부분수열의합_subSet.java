package SILVER;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_1182_부분수열의합_subSet {
	// nCr
	static int N, S, answer;
	static int[] input;
	static int[] numbers;
	static ArrayList<String> list =new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		S = sc.nextInt();

		input = new int[N];
		numbers = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		
		subSet(0, list);
		

		System.out.println(answer);
	}

	private static void subSet(int cnt, ArrayList<String> list) {
		// 기저
		if (cnt == N) {
			int tmp = 0;
			//System.out.println(list.toString());
			if(list.size() != 0) {
				for (String a : list) {
					tmp += Integer.parseInt(a);
				}
				if (tmp == S)
					answer++;
				// System.out.println("R = "+ r +" "+Arrays.toString(numbers));
			}
			return;
		}
		 list.add(input[cnt]+"");
		 subSet(cnt+1, list);	//현재 원소 포함
		 list.remove(input[cnt]+"");
		 subSet(cnt+1, list);	//현재 원소 미포함
	}
}