class ClosestPalindrome {
	public String nearestPalindromic(String n) {
		char[] nArr = n.toCharArray();
		int lo = (n.length()-1)/2, hi = (int)Math.ceil(nArr.length/2);

		char[] firstStr = solvePalindrome(nArr.clone(), lo, hi);
		int firstSol = calculateDiff(lo, nArr, firstStr);
		System.out.println(firstSol);
		// Too lazy to alter array so using String -> 
		// Integer to change value.
		int nVal = Integer.parseInt(n);
		nVal = (firstSol > 0) 
			? (nVal -= Math.pow(10,hi))
			: (nVal += Math.pow(10,hi));

		System.out.println(nVal);
		char[] secondStr = solvePalindrome(Integer.toString(nVal).toCharArray().clone(), lo, hi);
		int secondSol = calculateDiff(lo, nArr, firstStr);

		return firstSol < secondSol ? new String(firstStr) : new String(secondStr);
	}

	private char[] solvePalindrome(char[] nArr, int lo, int hi) {
		while(lo >= 0) {
			nArr[hi] = nArr[lo];
			lo--;
			hi++;
		}
		return nArr;
	}

	private int calculateDiff(int middle, char[] original, char[] sol) {
		int diff = 0;
		for(int i=0; i<original.length; i++) {
			diff += (Character.getNumericValue(sol[i])-Character.getNumericValue(original[i])) 
				* Math.pow(10,original.length-middle-i);
		}
		return diff;
	}
}