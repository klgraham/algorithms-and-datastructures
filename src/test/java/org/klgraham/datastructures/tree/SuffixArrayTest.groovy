package org.klgraham.datastructures.tree

import spock.lang.Specification


class SuffixArrayTest extends Specification {

	def "Can create a properly sorted suffix array" () {
		given: "a string"
		def s = "banana"

		and: "its suffix array"
		def suffixArray = new SuffixArray(s)

		expect: "the suffixes are in sorted order"
		suffixArrayIsSorted(suffixArray)
	}

	private boolean suffixArrayIsSorted(SuffixArray s) {
		def previousSuffix = s.getSuffix(0)
		def result = true

		for (int i = 1; i < s.length(); i++) {
			result &= previousSuffix.isBefore(s.getSuffix(i))
		}

		result
	}
}
