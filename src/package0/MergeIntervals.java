package package0;

import base.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jingshanyin on 3/9/17.
 * 56. Merge Intervals
 *
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {
            return result;
        }
        Collections.sort(intervals, new Comparator<Interval>() {

            @Override
            public int compare(Interval i, Interval j) {
                if (i.start != j.start) {
                    return i.start - j.start;
                } else {
                    return j.end - i.end;
                }
            }
        });
        Interval current = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval temp = intervals.get(i);
            if (current.end >= temp.start) {
                current = new Interval(current.start, temp.end);
            } else {
                result.add(current);
                current = temp;
            }
        }
        return result;
    }
}
