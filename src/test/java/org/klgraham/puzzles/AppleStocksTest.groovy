package org.klgraham.puzzles

import spock.lang.Specification

/**
 * Created by klogram on 10/16/16.
 */
class AppleStocksTest extends Specification {

    def "Can compute correct best profit" () {
        given:
        def stockPrices1 =  [10, 7, 5, 8, 11, 9] as int[]
        def stockPrices2 = [10, 7, 5, 8, 11, 9, 3, 2, 1] as int[]

        expect:
        6 == AppleStocks.getMaxProfit(stockPrices1)
        6 == AppleStocks.getMaxProfit(stockPrices2)
    }

    def "If prices always go down, best profit is negative" () {
        given: "decreasing prices"
        def prices = [34, 30, 25, 23, 20, 17, 15, 12, 8, 6, 4, 2, 1] as int[]

        expect:
        AppleStocks.getMaxProfit(prices) >= 0
    }

    def "If prices don't change, best profit is 0"(){
        given: "constant prices"
        def prices = [3,3,3,3,3,3] as int[]

        expect:
        AppleStocks.getMaxProfit(prices) >= 0
    }

    def "Need at least two prices"(){
        given: "constant prices"
        def prices = [3] as int[]

        when:
        AppleStocks.getMaxProfit(prices)

        then:
        thrown(IllegalArgumentException)
    }


}
