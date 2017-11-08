class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int leftSum = Integer.MIN_VALUE;

		int ptrL = -1;
		int ptrR = 0;

		while(ptrL != nums.length && ptrR != nums.length) {
			if(leftSum < 0) {
				ptrL = ptrR;
				leftSum = 0;
			}
			maxSum = Math.max(nums[ptrR] + leftSum, maxSum);
			leftSum += nums[ptrR];
			ptrR++;
		}

		return maxSum;
	}

	public int maxProduct(int[] nums) {
		int maxProduct = Integer.MIN_VALUE;
		int currentProduct = 1;
		int ptrL = 0;
		int ptrR = 0;
		boolean isZeroOrEndOfArray = nums[0] == 0;

		while(ptrL < nums.length && ptrR < nums.length) {
			if(!isZeroOrEndOfArray) {
				currentProduct *= nums[ptrR];
				ptrR++;

				if(ptrR == nums.length) {
					isZeroOrEndOfArray = true;
					ptrR--;
				} else if(nums[ptrR] == 0) {
					isZeroOrEndOfArray = true;
					maxProduct = Math.max(maxProduct, 0);
					ptrR--;
				}
			} else {
				if(ptrL > ptrR) {
					currentProduct = 1;
					isZeroOrEndOfArray = false;

					ptrR += 1;
					while(ptrR < nums.length && nums[ptrR] == 0) {
						ptrR++;
					}

					ptrL = ptrR;
					continue;
				} else if(ptrL == ptrR) {
					currentProduct = nums[ptrL];
					ptrL++;
				} else {
					if(nums[ptrL] != 0) {
						currentProduct /= nums[ptrL];
					}
					ptrL++;
				}
			}

			maxProduct = Math.max(maxProduct, currentProduct);
		}


		return maxProduct;
	}
}