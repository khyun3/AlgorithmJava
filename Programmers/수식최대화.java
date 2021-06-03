import java.util.LinkedList;

public class 수식최대화 {
	public static void main(String[] args) {
		
		
		
		long a1 = solution("100-200*300-500+20");// |60420|
		long a2 = solution("50*6-3*2");// |300|
		System.out.println(a1+"  "+ a2);
	}
	static public long solution(String expression) {
	    long answer = 0;
	    //연산자 우선순위 조합
	    // | +,-,* | +,*,- | -,+,* | -,*,+ | *,+,- | *,+,- |
	    
	    //1. 연산자를 기준으로 쪼개서 list에 넣는다.
	    
	    LinkedList<String> list = split(expression);
	    //연산자 우선순위 리스트 생성
	    char [][] operatorPriority = initPriorityArr();
	    
	    //max값은 answer에 저장하자.
	    for (int i = 0; i < operatorPriority.length; i++) {
	    	long tmp = prizeMoney((LinkedList)list.clone(), operatorPriority[i]);
	    	answer = Math.max(answer, Math.abs(tmp));
		}
	    
	    return answer;
	}
	static long prizeMoney(LinkedList<String> list ,char [] operatorPriority) {
		long answer = 0;
		//연산자 우선순위에 따라서 for문을 돌리고
		for (char op : operatorPriority) {
			//해당 연산자부터 계산을 한다.
			for (int i = 0; i < list.size(); i++) {
				String s = list.get(i);
				if(s.equals(Character.toString(op))) {
					long o1 = Long.parseLong(list.get(i-1));
					long o2 = Long.parseLong(list.get(i+1));
					
					
					switch(op) {
					case '+':
						list.add(i+1, Long.toString(o1+o2));
						break;
					case '-':
						list.add(i+1, Long.toString(o1-o2));
						break;
					case '*':
						list.add(i+1, Long.toString(o1*o2));
						break;
					}
					//숫1, +, 숫2 삭제  
					list.remove(i);
					list.remove(i+1);
					list.remove(i-1);
					//앞에서 하나 지워지기 떄문에 --로 크기를 맞추자.
					i--;
				}
			}
		}
		return answer = Long.parseLong(list.get(0));
	}
	static char[][] initPriorityArr(){
		char [][] operatorPriority = new char[][] {{'+','-','*'},
			{'+','*','-'},
			{'-','+','*'},
			{'-','*','+'},
			{'*','+','-'},
			{'*','+','-'}};
			
		return operatorPriority;
	}
	static LinkedList<String> split(String expression) {
		LinkedList<String> list = new LinkedList<>();
		int fIndex = 0;
		//1. 연산자를 기준으로 쪼개자
		for (int i = 0; i < expression.length(); i++) {
			switch(expression.charAt(i)) {
			case '+': case '-': case '*':
				list.add(expression.substring(fIndex == 0 ? 0 : fIndex+1, i));
				list.add(expression.substring(i,i+1));
				fIndex = i;
				break;
			}
		}
		list.add(expression.substring(fIndex == 0 ? 0 : fIndex+1, expression.length()));
		return list; 
	}
}
