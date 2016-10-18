package org.klgraham.puzzles

import spock.lang.Specification

/**
 * Created by klogram on 10/18/16.
 */
class HighestProductOfIntsTest extends Specification {

    def "Can compute the highest product of 3 ints"() {
        given: "three arrays with identical elements"
        expect: "the highest product of three elements for each array is 3,400"
        3400 == HighestProductOfInts.findHighestProduct(3, arrayOfInts)

        where:
        arrayOfInts << [[-10, 10, 4, -34, 6] as int[],
                        [6, -10, 10, 4, -34] as int[],
                        [4, 6, -10, 10, -34] as int[]]
    }

    def "Can compute the highest product of 4 ints"() {
        given: "three arrays with identical elements"
        expect: "the highest product of four elements for each array is 71,400"
        71400 == HighestProductOfInts.findHighestProduct(4, arrayOfInts)

        where:
        arrayOfInts << [[-10, 10, 4, -34, 6, 5, -35] as int[],
                        [-10, 10, 4, -34, 6, -35, 5] as int[],
                        [-34, -10, 10, 4, 6, 5, -35] as int[]]
    }

    def "Can compute the highest product of 5 ints"() {
        given: "two arrays with identical elements"
        expect: "the highest product of five elements for each array is 357,000"
        357000 == HighestProductOfInts.findHighestProduct(5, arrayOfInts)

        where:
        arrayOfInts << [[-10, 10, 4, -34, 6, 5, -35] as int[],
                        [-35, -34, -10, 10, 4, 6, 5] as int[]]
    }
}
