class Bulbs {
	public int bulbsStupid(ArrayList<Integer> a) {
		int count = 0;
		int state = 0;
		for(int i=0; i<a.size(); i++) {
			if(a.get(i) == state) {
				count++;
				state = 1 - state;
			}
		}
		return count;
	}

	public int bulbs(ArrayList<Integer> a) {
		int count = 0;
		for(int i=0; i<a.size(); i++) {
			if(a.get(i) == 0) {
				for(int j=i+1; j<a.size(); j++) {
					if(j != a.size()) {
						a.set(j,a.get(j) == 1 ? 0:1);
					}
				}
				a.set(i,1);
				count++;
			}
			for(Integer bulb:a)
				System.out.print(bulb + " ");
			System.out.println();
		}
		return count;
	}

	public int bulbsTC(ArrayList<Integer> a) {
		int count = 0;
		int bitRep = 0;

		for(Integer val : a) {
			bitRep <<= 1;
			bitRep |= val << 0;
		}



		for(int i=a.size()-1; i>=0; i--) {
			if((bitRep & (1<<i)) == 0) {
				bitRep ^= (int)(Math.pow(2,i)*2)-1;
				count++;
			}
			System.out.println(Integer.toBinaryString(bitRep));
		}
		return count;
	}
}
