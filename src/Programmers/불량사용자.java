package Programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;

public class 불량사용자 {
	static String [] select;
	static boolean [] isSelected;
	static TreeSet<String> treeSet;
	public static void main(String[] args) {
		solution(new String [] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String [] {"fr*d*", "abc1**"});
		solution(new String [] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String [] {"*rodo", "*rodo", "******"});
		solution(new String [] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String [] {"fr*d*", "*rodo", "******", "******"});
	}
	static public int solution(String[] user_id, String[] banned_id) {
	       int answer = 0;
	       
	       select = new String[banned_id.length];
	       treeSet = new TreeSet<>();
	       isSelected = new boolean [user_id.length];
	       permutation(0, user_id, banned_id);
	       
	       System.out.println("answer : "+treeSet.size());
	       
	       return answer = treeSet.size();
	}
	static void permutation(int cnt, String [] user_id, String [] banned_id) {
		if(cnt==banned_id.length) {
			
			LinkedList<String> tmp = new LinkedList<>();
			for (String s : select) {
				tmp.add(s);
			}
			
			Collections.sort(tmp);
			StringBuilder sb = new StringBuilder();
			for (String s : tmp) {
				sb.append(s);
			}
			treeSet.add(sb.toString());
//			System.out.println(Arrays.toString(select));
			System.out.println("트리셋 원소 : "+treeSet);
			
			return;
		}
		for (int i = 0; i < user_id.length; i++) {
			if(isSelected[i] || !check(user_id[i],banned_id[cnt])) continue;
			select[cnt] = user_id[i]; 
			isSelected[i] = true;
			permutation(cnt+1, user_id, banned_id);
			isSelected[i] = false;
		}
	}
	static boolean check(String uid, String bid) {
		//1. 길이가 같아야 한다.
	    if(uid.length() == bid.length()) {
	    	//2. *처리 안한 문자의 위치가 동일해야 한다.
	    	//3. 만약 모든 문자가 *이라면 길이가 같으면 된다.
	    	char [] uidTmp = uid.toCharArray();
	    	char [] bidTmp = bid.toCharArray();
	    	
	    	for (int i = 0; i < uid.length(); i++) {
	    		if(uidTmp[i]==bidTmp[i] || bidTmp[i]=='*') continue;
	    		else return false; 
			}
	    }
	    else {
	    	return false;
	    }
		return true; 
	}
}
