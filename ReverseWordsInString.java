import java.util.*;

class ReverseWordsInString {
	public String reverseWords(String s) {
		String temp = "";
		char[] sArr = s.toCharArray(), sol = new char[s.length()];
		int j = sArr.length-1, k = sArr.length-1;

		for(int i=0; i<sArr.length; i++) {
			sol[sArr.length-i-1] = sArr[i];
			if(sArr[i] == ' ') {
				while(j < k) {
					char c = sol[j];
					sol[j] = sol[k];
					sol[k] = c;
					j++;
					k--;
				}
				System.out.println(sol);
				k = i-1;
			}
			j = i-1;
		}

		return new String(sol);
	}

	public String reverseWordsMed(String s) {
		String sol = "", temp = "";
		char[] sArr = s.trim().toCharArray();

		for(int i=0; i<sArr.length; i++) {
			if(sArr[i] == ' ') {
				while(sArr[i] == ' ')
					i++;
				i--;
				sol = temp + " " + sol;
				temp = "";
			} else {
				temp += sArr[i];
			}
		}
		sol = temp + " " + sol;

		return sol.trim();
	}

	public String reverseWordsSlow(String s) {
		Stack<String> stack = new Stack<>();
		String sol = "", temp = "";
		char[] sArr = s.toCharArray();

		for(int i=0; i<sArr.length; i++) {
			if(sArr[i] == ' ' && !temp.isEmpty()) {
				stack.push(temp);
				temp = "";
			} else if(sArr[i] != ' ') {
				temp += sArr[i];
			}
		}
		stack.push(temp);

		while(!stack.isEmpty()) {
			sol += stack.pop() + " ";
		}

		return sol.trim();
	}
}
