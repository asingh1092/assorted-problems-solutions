package src.com.singh.Grind75.Array;

public class BestTimeToBuyAndSellStock {

    public static int maxProfitsBrute(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfitsBrute(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfitsBrute(new int[]{7, 6, 4, 3, 1}));
    }
}
