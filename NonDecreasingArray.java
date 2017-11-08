class NonDecreasingArray {
	public boolean checkPossibilityOrig(int[] nums) {
		if(nums.length < 2)
			return true;

		boolean muligan = nums[0] > nums[1];
		if(muligan)
			nums[0] = nums[1];
		int cur = nums[0];

		for(int i=1; i<nums.length-1; i++) {
			if((nums[i] > nums[i+1] && nums[i] >= cur)
				|| (nums[i] <= nums[i+1] && nums[i] < cur)) {
				if(muligan)
					return false;
				muligan = true;
				if(nums[i] == cur)
					nums[i+1] = cur;
				else if(nums[i+1] < cur)
					nums[i+1] = nums[i];
				else
					nums[i] = cur;
			}
			cur = nums[i];
		}

		return true;
	}

	public boolean checkPossibility(int[] nums) {
		if(nums.length < 2)
			return true;

		boolean muligan = nums[0] > nums[1];
		if(muligan)
			nums[0] = nums[1];
		int cur = nums[0];

		for(int i=1; i<nums.length-1; i++) {
			if(nums[i] > nums[i+1] == nums[i] >= cur) {
				if(muligan)
					return false;
				muligan = true;
				if(nums[i] == cur)
					nums[i+1] = cur;
				else if(nums[i+1] < cur)
					nums[i+1] = nums[i];
				else
					nums[i] = cur;
			}
			cur = nums[i];
		}

		return true;
	}

	public boolean checkPossibilityElegant(int[] nums) {
		int cnt = 0;
		if(nums[0] > nums[1]) {
			cnt++;
			nums[0] = nums[1];
		}
		int cur = nums[0];

		for(int i=1; i<nums.length-1 && cnt <= 1; i++) {
			if(nums[i] > nums[i+1] == nums[i] >= cur) {
				cnt++;
				if(nums[i] == cur)
					nums[i+1] = cur;
				else if(nums[i+1] < cur)
					nums[i+1] = nums[i];
				else
					nums[i] = cur;
			}
			cur = nums[i];
		}

		return cnt<=1;
	}
}
