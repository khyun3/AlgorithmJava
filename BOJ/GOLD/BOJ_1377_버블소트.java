package GOLD;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//10 1 5 2 3 : 1 10 5 2 3 => 1 5 10 2 3 => 1 5 2 10 3 => 1 5 2 3 10 : i=1
//				true			
//1 5 2 3 10 : 1 5 2 3 10 => 1 2 5 3 10 => 1 2 3 5 10 => 1 2 3 5 10 : i=2
//								true
//1 2 3 5 10 : 1 2 3 5 10 => 1 2 3 5 10 => 1 2 3 5 10 => 1 2 3 5 10 : i=3


//5 3 1 2 : 3 5 1 2 => 3 1 5 2 => 3 1 2 5 : i=1
//			  true
//3 1 2 5 : 1 3 2 5 => 1 2 3 5 => 1 2 3 5 : i=2
//			  true
//1 2 3 5 : 1 2 3 5 => 1 2 3 5 => 1 2 3 5 : i=3

public class BOJ_1377_버블소트 {
	static class Data implements Comparable<Data>{
		int num, idx;
		public Data(int idx, int num) {
			this.idx = idx;
			this.num = num;
		}
		@Override
		public int compareTo(Data o) {
			if(this.num < o.num) return -1;
			else if(this.num==o.num) {
				if(this.idx < o.idx) {return -1;}
				else {return 1;}
			}
			else return 1;
		}
	}
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Data> a = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			a.offer(new Data(i, Integer.parseInt(br.readLine())));
		}
	    int Max = 0;
	    int tmp = 0;
	    for (int i = 0; i < n; i++) {
	    	tmp = a.poll().idx - i;
			if(tmp > 0) {
				Max = Math.max(Max, tmp);
			}
		}
	    System.out.println(Max+1);
	}
}