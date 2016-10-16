package org.klgraham.puzzles;

/**
 *  *** Interview Cake, problem 1 ***

 Suppose we could access yesterday's stock prices as a list, where:

 The indices are the time in minutes past trade opening time, which was 9:30am local time.
 The values are the price in dollars of Apple stock at that time.
 So if the stock cost $500 at 10:30am, stock_prices_yesterday[60] = 500.

 Write an efficient function that takes stock_prices_yesterday and returns the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.

 test on [10, 7, 5, 8, 11, 9], answer should be 6
 If I test on [10, 7, 5, 8, 11, 9, 3, 2, 1], the answer should still be 6

 @author Kenneth Graham
 */
public class AppleStocks {

    public static int getMaxProfit(int[] stockPricesYesterday) throws IllegalArgumentException{
        if (stockPricesYesterday.length < 2) {
            throw new IllegalArgumentException("Need at least two stock prices in the list.");
        }

        int lowestPrice = stockPricesYesterday[0];
        int bestProfit = stockPricesYesterday[1] - stockPricesYesterday[0];

        for (int i = 0; i < stockPricesYesterday.length; i++) {
            int price = stockPricesYesterday[i];
            int possibleProfit = price - lowestPrice;

            lowestPrice = Math.min(price, lowestPrice);
            bestProfit = Math.max(possibleProfit, bestProfit);
        }
        return bestProfit;
    }
}
