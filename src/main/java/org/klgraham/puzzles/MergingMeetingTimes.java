package org.klgraham.puzzles;

import java.util.*;

/**
 * Created by klogram on 10/18/16.
 */
public class MergingMeetingTimes {

    public static List<Meeting> condenseMeetingTimes(List<Meeting> meetings) {
        if (meetings.isEmpty()) {
            throw new IllegalArgumentException("Input list must not be empty.");
        }

        if (meetings.size() == 1) {
            return meetings;
        }

        List<Meeting> condensedMeetings = new ArrayList<>(meetings.size());

        // meeting must be sorted, this is O(n log n)
        // if it is guaranteed that the input is sorted, this can be skipped.
        Collections.sort(meetings, new Comparator<Meeting>() {
            public int compare(Meeting m1, Meeting m2)  {
                return m1.start - m2.start;
            }
        });

        // iterating through the list once takes O(n)
        Iterator<Meeting> meetingIterator = meetings.iterator();
        Meeting previousMeeting = meetingIterator.next();

        while (meetingIterator.hasNext()) {
            Meeting currentMeeting = meetingIterator.next();

            if (previousMeeting.overlapsWith(currentMeeting)) {
                previousMeeting = previousMeeting.plus(currentMeeting);
            }
            else {
                condensedMeetings.add(previousMeeting);
                previousMeeting = currentMeeting;
            }
        }
        condensedMeetings.add(previousMeeting);
        return condensedMeetings;
    }

    /**
     * This class provides a simple way to model the problem domain
     */
    public static class Meeting{
        public final int start;
        public final int end;

        public Meeting(int start, int end) {
            // number of 30 min blocks past 9am
            this.start = start;
            this.end = end;
        }

        // A is before B if A ends before B starts
        public boolean isBefore(Meeting m) {
            return this.end < m.start;
        }

        // A is after B if B ends before A starts
        public boolean isAfter(Meeting m) {
            return m.end < this.start;
        }

        // A and B overlap if A is not before or after B
        public boolean overlapsWith(Meeting m) {
            return !this.isBefore(m) && !this.isAfter(m);
        }

        public Meeting plus(final Meeting m) {
            return new Meeting(Math.min(this.start, m.start), Math.max(this.end, m.end));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Meeting meeting = (Meeting) o;

            if (start != meeting.start) return false;
            return end == meeting.end;

        }

        @Override
        public int hashCode() {
            int result = start;
            result = 31 * result + end;
            return result;
        }

        @Override
        public String toString() {
            return String.format("Meeting(%d to %d)", start, end);
        }
    }
}
