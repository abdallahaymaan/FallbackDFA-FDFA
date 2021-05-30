package acl_task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class state {
	int name;
	int next0;
	int next1;
	Boolean goal;
	String action;

//	int [] eClosure;
	public state(int name, int next0, int next1, String action, Boolean goal) {
		this.name = name;
		this.next0 = next0;
		this.next1 = next1;
		this.goal = goal;
		this.action = action;
//		this.eClosure = eClosure;
	}
}

public class fdfa {
	List<state> states;

	public fdfa(String s) {
		String[] first_split = s.split("#");
		String[] goal_states = first_split[1].split(",");
		String[] statesArray = first_split[0].split(";");
		String[] currStateArray;
		this.states =new ArrayList<state>();
		for (int i = 0; i < statesArray.length; i++) {
			currStateArray = statesArray[i].split(",");
			boolean isCurrStateGoal = check(goal_states, currStateArray[0]);
			state new_state = new state(Integer.parseInt(currStateArray[0]), Integer.parseInt(currStateArray[1]),
					Integer.parseInt(currStateArray[2]), currStateArray[3], isCurrStateGoal);
			states.add(new_state);
		}

	}

	public void run(String s) {
		String result = "";
		Stack<state> currStack;
		int r = 0;
		int l = 0;
		state lastState;
		state newState;
		state firstPop = null;
		while (r<s.length()) {
			currStack = new Stack<state>();
			currStack.push(states.get(0));
			lastState = states.get(0);
			state poppedState = lastState;
			while (l < s.length()) {
				l++;

				if (Character.getNumericValue(s.charAt(l - 1)) == 0) {
					newState = states.get(lastState.next0);
				} else {
					newState = states.get(lastState.next1);
				}
				currStack.push(newState);
				lastState = newState;

				

			}
			if (l == s.length()) {
				
				while(l>=r) {
					l--;
					poppedState = currStack.pop();
					if(l == s.length()-1) {
						firstPop = poppedState;
					}
					if(poppedState.goal) {
						result+= poppedState.action;
						l++;
						r=l;
						break;
					}
					if(l==r) {
						result+= firstPop.action;
						r=s.length();
						l=r;
						break;
					}
				}

			}

		}
		System.out.println(result); 
	}

	private static boolean check(String[] arr, String valueToCheck) {
		for (String element : arr) {

			if (Integer.parseInt(element) == Integer.parseInt(valueToCheck)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		fdfa fdfa1 = new fdfa("0,2,1,A;1,1,2,B;2,3,4,C;3,4,5,D;4,5,5,E;5,5,2,F#3,5");
		fdfa1.run("010");
		fdfa1.run("1100");
		fdfa1.run("1000");
		fdfa1.run("01011");
		fdfa1.run("110011");
		
		System.out.println();
		System.out.println();
		fdfa fdfa2 = new fdfa("0,1,2,A;1,2,4,B;2,3,5,C;3,4,3,D;4,5,6,E;5,6,0,F;6,3,6,G#1,6");
		fdfa2.run("110011");
		fdfa2.run("000");
		fdfa2.run("111");
		fdfa2.run("1100");
		fdfa2.run("1101000");
		
//		System.out.println();
//		System.out.println();
//		fdfa fdfa3 = new fdfa("0,1,0,A;1,1,2,B;2,1,3,C;3,4,3,D;4,4,4,E#1,3");
//		fdfa3.run("01011010");
//		fdfa3.run("10001");
//		fdfa3.run("1010");
//		fdfa3.run("0111");
//		fdfa3.run("111");
//		
//		System.out.println();
//		System.out.println();
//		fdfa fdfa4 = new fdfa("0,0,1,A;1,3,2,B;2,3,2,C;3,4,3,D;4,3,4,E#2,4");
//		fdfa4.run("111");
//		fdfa4.run("1010000");
//		fdfa4.run("10100001");
//		fdfa4.run("000110");
//		fdfa4.run("001");
	}

}
