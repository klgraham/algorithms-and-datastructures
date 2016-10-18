package org.klgraham.puzzles

import spock.lang.Specification

/**
 * Created by klogram on 10/16/16.
 */
class ProductOfAllOtherIntsTest extends Specification {

    def "Can compute expected products for general array"() {
        given:
        def input = [1, 7, 3, 4] as int[]
        def output = [84, 12, 28, 21] as int[]

        expect:
        arrayEquals(ProductOfAllOtherInts.getProductsOfAllIntsExceptAtIndex(input), output)
    }

//    def "Can compute expected products for general array"() {
//        given:
//        def input = listToArray([1, 2, 6, 5, 9], 5)
//        def output = listToArray([540, 270, 90, 108, 60], 5)
//
//        expect:
//        arrayEquals(ProductOfAllOtherInts.getProductsOfAllIntsExceptAtIndex(input), output)
//    }

    def "works when input array has zeroes"() {
        given:
        def input = [1, 7, 3, 4, 0] as int[]
        def output = [0,0,0,0, 84] as int[]

        expect:
        arrayEquals(ProductOfAllOtherInts.getProductsOfAllIntsExceptAtIndex(input), output)
    }

    def boolean arrayEquals(int[] a , int[] b) {
        int n = a.length
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) return false
        }
        return true
    }
}
