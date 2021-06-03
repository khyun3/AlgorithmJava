public class 키패드누르기 {
	public static void main(String[] args) {

		solution(new int [] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left");
		solution(new int [] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},"left");
		solution(new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right");
		
	}
    static public String solution(int[] numbers, String hand) {
        String answer = "";

        	int [][] loc = new int [][] {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
        	int [] left = new int [] {3,0};
        	int [] right = new int [] {3,2};
        	StringBuilder sb = new StringBuilder();
        	
        	for (int i = 0; i < numbers.length; i++) {
        		switch(numbers[i]) {
        		case 1: case 4: case 7:
        			setLocation("L",sb, left, loc, numbers[i]);
        			break;
        		
        		case 3: case 6: case 9:
        			setLocation("R",sb, right, loc, numbers[i]);
        			break;

        		default:
        			//나머지 2,5,8,0
        			int l = dist(left[0], left[1], loc[numbers[i]][0], loc[numbers[i]][1]);
        			int r = dist(right[0], right[1], loc[numbers[i]][0], loc[numbers[i]][1]);

        			//오른손 잡이면
        			if(l==r) {
        				if(hand.equals("right")) {
        					setLocation("R",sb, right, loc, numbers[i]);
        				}
        				else {
        					setLocation("L",sb, left, loc, numbers[i]);
        				}
        			}
        			else if(l>r) {
        				setLocation("R",sb, right, loc, numbers[i]);
        			}
        			else {
        				setLocation("L",sb, left, loc, numbers[i]);
        			}
        			break;
        		}
			}
        	answer = sb.toString();
        	System.out.println(answer);
        return answer;
    }
    static void setLocation(String s, StringBuilder sb, int [] hand ,int [][] loc, int number) {
    	sb.append(s);
    	hand[0] = loc[number][0];
    	hand[1] = loc[number][1];
    }
	static int dist(int x1,int y1, int x2, int y2) {
		int distance = 0;
		//손 => x1, y1
		//누를 버튼 좌표 => x2, y2
		distance = Math.abs(x1-x2)+Math.abs(y1-y2);
		return distance; 
	}  
}
