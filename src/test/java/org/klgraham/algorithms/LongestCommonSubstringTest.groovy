package org.klgraham.algorithms

import spock.lang.Specification

class LongestCommonSubstringTest extends Specification {

	def "Can find the LCS when the LCS is a substring of one of the strings" () {
		given: "two strings"
		def a = "at this turning point of history there manifest themselves side by side and often mixed and entangled together a magnifficent"
		def b = "extendend tangled together a magnificent manefold virgin forest like upgrowth and upstriving a kind of tro"

		expect: "that we can get the LCS"
		LongestCommonSubstring.search(a, b) == "tangled together a magnif"
	}

	def "Can find the LCS when the LCS equals one of the input strings" () {
		given: "two strings"
		def a = "we're on easy street"
		def b = "on easy street"

		expect: "that we can get the LCS"
		LongestCommonSubstring.search(a, b) == b
	}
}
