package SWEA;

import java.util.LinkedList;
import java.util.Scanner;

public class problem1 {
	static class Person{
		char name;    //이름
		int cnt; 	  //걸린 횟수
		boolean fast; //달리기 빠른 사람인가?
		
		public Person(char name, int cnt, boolean fast) {
			this.name = name;
			this.cnt = cnt;
			this.fast = fast;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", cnt=" + cnt + ", fast=" + fast + "]";
		}
	}
									//사람 수				//달리기 빠른 사람			//달리기 빠른 사람 이름		//게임 횟수			//게임의 방향 및 거리
  private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
    // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
	  
	  LinkedList<Person> p = new LinkedList<>();  
	  
	  Person sp = new Person('A', 1, false); //술래
	  int k = 0; //빠른 사람 이름 찾을 변수
	  int pn = numOfAllPlayers-1; //원형으로 앉은 사람들의 수
	  for (int i = 1; i < numOfAllPlayers; i++) {
		  char ctmp = (char)('A'+i);
		  boolean fp = false; 
		 
		  //빠른 사람 체크
		  for (int j = 0; j < numOfQuickPlayers; j++) {
			  if(namesOfQuickPlayers[j] == ctmp) {
				  fp = true;
			  }
		  }
		p.add(new Person(ctmp, 0, fp));
	}//시계 방향으로 원형으로 앉힘
	
	  //게임 시작
	  int move=0;
	for (int i = 0; i < numOfGames; i++) {
		move = (move + numOfMovesPerGame[i])%pn;
		
		//시계 방향
		if(move>=0) {
			Person pt = p.get(move);
			
			if(pt.fast) { //빠른 사람이면 술래가 잡힘
				sp.cnt++; //술래 카운트를 1 올리고, 현재 술래가 다시 술래를 함
			}
			else { //술래가 잡히지 않았음
				p.add(move, sp);
				sp = pt; //술래를 바꿈
				sp.cnt++;
				p.remove(move+1);
			}
		}
		//반시계 방향
		else {
			Person pt = p.get(pn+move);
			
			if(pt.fast) { //빠른 사람이면 술래가 잡힘
				sp.cnt++; //술래 카운트를 1 올리고, 현재 술래가 다시 술래를 함
			}
			else { //술래가 잡히지 않았음
				p.add(pn+move, sp);
				sp = pt; //술래를 바꿈
				sp.cnt++;
				p.remove(pn+move+1);
			}
		}
	}
	StringBuilder sb = new StringBuilder();
	for (Person person : p) {
		sb.append(person.name).append(' ').append(person.cnt).append('\n');
	}
	sb.append(sp.name).append(' ').append(sp.cnt);
	System.out.println(sb);
  }


private static class InputData {
    int numOfAllPlayers;
    int numOfQuickPlayers;
    char[] namesOfQuickPlayers;
    int numOfGames;
    int[] numOfMovesPerGame;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

      inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
      System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

      inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      inputData.numOfMovesPerGame = new int[inputData.numOfGames];
      String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
      for(int i = 0; i < inputData.numOfGames ; i++){
        inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
  }
}