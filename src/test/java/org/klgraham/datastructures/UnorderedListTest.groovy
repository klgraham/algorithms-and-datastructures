package org.klgraham.datastructures

import spock.lang.Specification
/**
 * Description of file content.
 *
 * @author kgraham
 * 10/4/16
 */
class UnorderedListTest extends Specification {

	def "Can add an item to the front of the list"() {
		given: "an initial list and an data to add to the head"
		def list = new UnorderedList("initial data")
		def item2 = "second data added"

		when: "an data is added to the front of the list"
		list.add(0, item2)

		then: "the head of the list is the data second data added"
		item2.equals(list.getHead().getData())
	}

	def "Can add an item to the end of the list"() {
		given: "an initial list and an data to add to the end"
		def list = new UnorderedList("initial data")
		def item2 = "second data added"

		when: "an data is added to the end of the list"
		list.add(item2)

		then: "the head of the list is the data second data added"
		item2.equals(list.pop())
	}

	def "Can add an item at an arbitrary position"() {
		given: "an initial list"
		def list = new UnorderedList<Double>(0)
		list.add(1)
		list.add(2)
		list.add(3)
		list.add(4)
		list.add(5)

		when: "an data is added to an arbitrary position and later removed"
		list.add(3, 7)

		then: "we get the expected data"
		list.pop(3) == 7.0
	}

	def "Can remove the first instance of the desired item"() {
		given: "an initial list with two duplicated items"
		def list = new UnorderedList<String>("a")
		list.add("b")
		list.add("c")
		list.add("d")
		list.add("e")
		list.add("c")

		when: "the first duplicate is removed"
		list.remove("c")

		then: "we can get the expected index of the remaining data"
		list.index("c") == 4
	}

	def "Can find an item in the list"() {
		given: "a list"
		def list = new UnorderedList<Integer>(0)
		list.add(1)
		list.add(2)
		list.add(3)
		list.add(4)
		list.add(5)

		expect: "we can search for things in the list"
		list.find(d) == d
		list.find(6) == null

		where:
		d << [1, 2, 3, 4, 5]
	}
}
