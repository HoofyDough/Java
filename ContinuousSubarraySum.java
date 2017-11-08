class ContinuousSubarraySum {
	public boolean checkSubarraySum(int[] nums, int k) {
		// [23,2,4,6,7], k=6
        //       j i
		if(nums.length < 2)
			return false;

		HashMap hm = new HashMap();

		for(int i=1; i<nums.length; i++) {
			int sum = nums[i];
			for(int j=i-1; j>=0; j--) {
				sum += nums[j];
				if((k != 0 && sum%k == 0) || sum == 0)
					return true;
			}
		}

		return false;
	}

	public String returnStr() {
		return "Hello World";
	}

	public boolean checkSubarraySum(int[] nums, int k) {
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
	    int runningSum = 0;
	    for (int i=0;i<nums.length;i++) {
	        runningSum += nums[i];
	        if (k != 0) runningSum %= k;
	        Integer prev = map.get(runningSum);
	        if (prev != null) {
	            if (i - prev > 1) return true;
	        }
	        else map.put(runningSum, i);
	    }
	    return false;
	}


}