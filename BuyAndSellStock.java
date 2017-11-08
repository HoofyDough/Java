class BuyAndSellStock {
	public int maxProfit(int[] prices) {
		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;
		int profit = 0;
		for(int i=0; i<prices.length; i++) {
			if(prices[i] < low) {
				low = prices[i];
				high = Integer.MIN_VALUE;
			}
			else if(prices[i] > high) {
				high = prices[i];
				profit = Math.max(profit, high-low);
			}
		}

		return profit;
	}

	public int maxProfit2(int[] prices) {
		Integer currentStockPrice = null;
		int profit = 0;
		for(int i=0; i<prices.length-1; i++) {
			if(currentStockPrice == null) {
				if(prices[i] < prices[i+1])
					currentStockPrice = prices[i];
			} else {
				if(prices[i] > prices[i+1]) {
					profit += (prices[i] - currentStockPrice);
					currentStockPrice = null;
				}
			}
		}

		if(currentStockPrice != null)
			profit += (prices[prices.length-1] - currentStockPrice);

		return profit;
	}
}