package org.klgraham.datastructures

import spock.lang.Specification

/**
 * Created by klogram on 10/15/16.
 */
class HashTableTest extends Specification{

    def "Can add items to the hash table"() {
        given: "an empty hash table"
        def h = new HashTable<String>()

        when: "things are added to it"
        h.insert("apple")
        h.insert("Apple")
        h.insert("apqke")

        then:
        noExceptionThrown()
    }

    def "Can move things from the hash table"() {
        given: "a hash table"
        def h = new HashTable<Integer>()
        for (int i = 0; i < 10; i++) {
            h.insert(i)
        }
        h.insert(3)
        h.insert(3)

        when: "we remove things"
        h.delete(0)
        h.delete(7)

        then: "we can show they are no longer in the hash table"
        !h.contains(0)
        !h.contains(7)
    }
}
