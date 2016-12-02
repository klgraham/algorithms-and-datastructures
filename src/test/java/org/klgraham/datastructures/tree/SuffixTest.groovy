package org.klgraham.datastructures.tree

import spock.lang.Specification;

class SuffixTest extends Specification
{
	def "Can create suffixes correctly"() {
		given: "a string"
			def s = "banana"

		and: "suffixes of the string"
			def a = new Suffix(s, 1) // anana
			def b = new Suffix(s, 3) // ana
			def c = new Suffix(s, 4) // na

		expect: "that the suffix text corresponds to the expected substring"
			a.toString() == "anana"
			b.toString() == "ana"
			c.toString() == "na"
	}

	def "Can get the specified substring or character" () {
		given: "a suffix of a string"
		def s = "abcdefg"
		def suffix = new Suffix(s, 1) // bcdefg

		expect: "we can access the specified character or substring"
		suffix.charAt(3) == "e".chars[0]
		suffix.substring(3) == "bcd"
	}

	def "Can create suffixes and order them lexicographically"() {
		given: "a string"
			def s = "banana"

		and: "three suffixes of the string"
			def a = new Suffix(s, 1) // anana
			def b = new Suffix(s, 3) // ana
			def c = new Suffix(s, 4) // na

		when: "the order of the strings is compared"
			def aIsBeforeB = a.isBefore(b)
			def aIsBeforeC = a.isBefore(c)
			def bIsBeforeC = b.isBefore(c)

		then: "We are able to determine the proper order"
			!aIsBeforeB
			aIsBeforeC
			bIsBeforeC
	}
}
