class CanIWin {
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		if((maxChoosableInteger*(maxChoosableInteger+1))/2 < desiredTotal)
			return false;

		int pool = 0, i = 0;
		while(maxChoosableInteger+pool < desiredTotal) {
			i++;
			pool += i;
		}
		return i%2 == 0;
	}
}