package org.huisking.simple;

import org.huisking.model.ZipCodeInterval;

import java.util.*;

public class SimpleZipCodeMerge {

    private ArrayDeque<ZipCodeInterval> result = new ArrayDeque<>();

    public ArrayList<ZipCodeInterval> mergeZipList(List<ZipCodeInterval> listToProcess){

        // Sort Interval List by Lower Bound
        listToProcess.sort(Comparator.comparing(ZipCodeInterval::getLowerBoundZipCode).thenComparing(ZipCodeInterval::getUpperBoundZipCode));

        // Push the first interval onto the stack
        result.push(listToProcess.get(0));

        // Iterate through the remainder of the list (starting at the 2nd item)
        // determine if the current interval (on the stack) has an intersection with
        // "next" in process interval.  If so, update the upper bound on the current
        // increasing the interval, else, the current interval is complete, and push
        // the in process interval onto the stack for the next comparison.
        for (int i =1; i<listToProcess.size(); i++)
        {
            ZipCodeInterval current = result.peek();
            ZipCodeInterval next = listToProcess.get(i);
            if(current.intersects(next)){
                current.setUpperBoundZipCode(next.getUpperBoundZipCode());
            }
            else{
                result.push(next);
            }
        }

        // Create the result list by popping from the end of the stack
        // to provide and ordered zip code interval list.
        ArrayList<ZipCodeInterval> mergedIntervals = new ArrayList<>();
        while (!result.isEmpty())
        {
            mergedIntervals.add(result.removeLast());
        }
        return mergedIntervals;
    }

}
