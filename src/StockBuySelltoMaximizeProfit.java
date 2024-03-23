public class StockBuySelltoMaximizeProfit {
    public static int maxProfit(int[] prices) {
        int maxPro=0;
        int minSofar=prices[0];
        for(int i=0;i<prices.length;i++){
            minSofar=Math.min(prices[i],minSofar);
            int profit=prices[i]-minSofar;
            maxPro=Math.max(profit,maxPro);
        }
        return maxPro;
    }

    public static void main(String[] args) {
        int arr[]={7,1,5,3,6,4};
        System.out.println("The max profit is "+maxProfit(arr));
    }
}
