package org.klgraham.datastructures.list

import org.klgraham.datastructures.list.SimpleLinkedList
import spock.lang.Specification

/**
 * Created by klogram on 10/12/16.
 */
class SimpleLinkedListTest extends Specification{

    def "Can add items to the list" () {
        given:
        def list = new SimpleLinkedList()

        when:
        list.add(1)
        list.add(2)
        list.add(3)

        then:
        noExceptionThrown()
    }

    def "Can find items in the list" () {
        given:
        def list = new SimpleLinkedList()

        and:
        list.add(1)
        list.add(2)
        list.add(3)

        expect:
        makeSingletonList(n) == list.find(n)
        list.find(0) == null

        where:
        n << [1, 2, 3]
    }

    private SimpleLinkedList<Integer> makeSingletonList(Integer n) {
        def list = new SimpleLinkedList<Integer>()
        list.add(n)
        return list
    }

}
