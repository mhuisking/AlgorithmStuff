package org.huisking.array;

import org.huisking.model.ZipCodeInterval;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayBasedZipCodeMerge {

    public List<ZipCodeInterval> mergeUsingArrays(List<ZipCodeInterval> intervalListToProcess) {
        List<ZipCodeInterval> result = new ArrayList<>();
        int n = intervalListToProcess.size();

        // Create two sorted lists of the intervals lower and upper bounds
        List<Integer> lowerBoundsList = intervalListToProcess.stream().map(ZipCodeInterval::getLowerBoundZipCode)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> upperBoundsList = intervalListToProcess.stream().map(ZipCodeInterval::getUpperBoundZipCode)
                .sorted()
                .collect(Collectors.toList());

        // Loop through the lists, checking if "one item ahead" in the lower bounds list is greater than
        // the "current" item in the upper bounds list, or if we have reached the end of the upper bound list
        // (the loop control variable i would be one less than "n" -- the number of items in both arrays since
        // we are comparing one item ahead on the upper list)
        for (int i = 0, intervalStartPos = 0; i < n; i++) {
            if (i == n - 1 || lowerBoundsList.get(i + 1) > upperBoundsList.get(i)) {
                result.add(new ZipCodeInterval(lowerBoundsList.get(intervalStartPos), upperBoundsList.get(i)));
                intervalStartPos = i + 1;
            }
        }
        return result;
    }

}
