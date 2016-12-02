package org.klgraham.algorithms

import spock.lang.Specification

class LongestCommonSubstringTest extends Specification {

	def "Can find the LCS when the LCS is a substring of one of the strings" () {
		given: "two strings"
		def a = "at this turning point of history there manifest themselves side by side and often mixed and entangled together a magnifficent"
		def b = "extendend tangled together a magnificent manefold virgin forest like upgrowth and upstriving a kind of tro"

		when: "we compute the LCS"
		def lcsInfo = LongestCommonSubstring.search(a, b)

		then: "that we can get the LCS"
		lcsInfo.lcs == "tangled together a magnif"
		lcsInfo.leftStart == 94
		lcsInfo.rightStart == 10
	}

	def "Can find the LCS when the LCS equals one of the input strings" () {
		given: "two strings"
		def a = "we're on easy street"
		def b = "on easy street"

		when: "we compute the LCS"
		def lcsInfo = LongestCommonSubstring.search(a, b)

		then: "we can get the LCS"
		lcsInfo.lcs == b
		lcsInfo.leftStart == 6
		lcsInfo.rightStart == 0
	}
}
