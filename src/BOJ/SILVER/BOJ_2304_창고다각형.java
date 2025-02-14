package BOJ.SILVER;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_2304_창고다각형 {
	static class P implements Comparable<P>{
		int h; int l;
		public P(int h, int l) {this.h = h;	this.l = l;}

		@Override
		public int compareTo(P o) {return Integer.compare(this.l, o.l);}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int maxH = 0;
		int maxL = 0;
		int answer = 0;
		List<P> list = new LinkedList<>(); 
		for (int n = 0; n < N; n++) {
			int l = sc.nextInt();
			int h = sc.nextInt();
			
			list.add(new P(h,l));
			if(h>=maxH) {
				maxH = h;
				maxL = l;
			}
		}
		if(N==1) {
			System.out.println(maxH);
			return;
		}
		Collections.sort(list);
		int i=0, j=1;
		int rcnt = 0, lcnt=0;
		boolean check = true;
		for (int k = 0; k < list.size(); k++) {
			if(check) lcnt++;
			else rcnt++;
			if(list.get(k).l==maxL) check = false;
		}
		
		//left->right
		while(lcnt!=0) {	
			P p1 = list.get(i);
			P p2 = list.get(j);
			lcnt--;
			
			if(p1.h <= p2.h) {
				answer +=(p2.l-p1.l)*p1.h;
				i=j;
				j++;
				if(p2.l==maxL)break;
			}
			else j++;
		}
		
		
		i=list.size()-1; j=i-1;
		//right->left	
		while(rcnt!=0) {
			P p1 = list.get(i);
			P p2 = list.get(j);
			rcnt--;
			if(p1.h < p2.h) {
				answer +=((p1.l+1)-(p2.l+1))*p1.h;
				i=j;
				j--;
				if(p2.l==maxL)break;
			}else j--;
			
		}
		System.out.println(answer+maxH);
	}
}