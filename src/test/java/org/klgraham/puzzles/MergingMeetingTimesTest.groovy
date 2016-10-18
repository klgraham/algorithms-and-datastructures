package org.klgraham.puzzles

import spock.lang.Specification

/**
 * Created by klogram on 10/18/16.
 */
class MergingMeetingTimesTest extends Specification {

    def "Can condense meetings when meetings overlap" () {
        given: "a list of meeting time ranges"
        def meetings = [new MergingMeetingTimes.Meeting(0, 1), new MergingMeetingTimes.Meeting(3, 5),
                        new MergingMeetingTimes.Meeting(4, 8), new MergingMeetingTimes.Meeting(10, 12),
                        new MergingMeetingTimes.Meeting(9, 10)]

        expect:
        MergingMeetingTimes.condenseMeetingTimes(meetings).equals(condensedMeetings)

        where:
        condensedMeetings << [[new MergingMeetingTimes.Meeting(0, 1),
                              new MergingMeetingTimes.Meeting(3, 8),
                              new MergingMeetingTimes.Meeting(9, 12)]]
    }

    def "Can condense meetings when adjacent meetings don't quite overlap" () {
        given: "a list of meeting time ranges"
        def meetings = [new MergingMeetingTimes.Meeting(1, 2), new MergingMeetingTimes.Meeting(2, 3)]

        expect:
        MergingMeetingTimes.condenseMeetingTimes(meetings).equals(condensedMeetings)

        where:
        condensedMeetings << [[new MergingMeetingTimes.Meeting(1, 3)]]
    }

    def "Can condense meetings when a later meeting is subsumed by an earlier one" () {
        given: "a list of meeting time ranges"
        expect:
        MergingMeetingTimes.condenseMeetingTimes(meetings).equals(condensedMeetings)

        where:
        meetings << [[new MergingMeetingTimes.Meeting(1, 5), new MergingMeetingTimes.Meeting(2, 3)],
                     [new MergingMeetingTimes.Meeting(1, 10), new MergingMeetingTimes.Meeting(2, 6),
                      new MergingMeetingTimes.Meeting(3, 5), new MergingMeetingTimes.Meeting(7, 9)]]
        condensedMeetings << [[new MergingMeetingTimes.Meeting(1, 5)], [new MergingMeetingTimes.Meeting(1, 10)]]
    }

    def "Can condense meetings regardless of order of input list" () {
        given: "a list of meeting time ranges"
        def meetings = [new MergingMeetingTimes.Meeting(4, 8), new MergingMeetingTimes.Meeting(10, 12),
                        new MergingMeetingTimes.Meeting(0, 1), new MergingMeetingTimes.Meeting(3, 5),
                        new MergingMeetingTimes.Meeting(9, 10)]

        expect:
        MergingMeetingTimes.condenseMeetingTimes(meetings).equals(condensedMeetings)

        where:
        condensedMeetings << [[new MergingMeetingTimes.Meeting(0, 1),
                               new MergingMeetingTimes.Meeting(3, 8),
                               new MergingMeetingTimes.Meeting(9, 12)]]
    }
}
