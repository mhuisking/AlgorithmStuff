package org.huisking.simple;

import org.huisking.ZipCodeInterval;

import java.util.*;

public class SimpleZipCodeMerge {

    private ArrayDeque<ZipCodeInterval> result = new ArrayDeque<>();
    private ArrayList<ZipCodeInterval> listToProcess = new ArrayList<>();

    public SimpleZipCodeMerge(ArrayList<ZipCodeInterval> zipListToProcess) {
        this.listToProcess = zipListToProcess;
    }

    public ArrayList<ZipCodeInterval> mergeZipList(){

        listToProcess.sort(Comparator.comparing(ZipCodeInterval::getLowerBoundZipCode));

        result.push(listToProcess.get(0));

        for (int i =1; i<listToProcess.size(); i++)
        {
            ZipCodeInterval top = (ZipCodeInterval) result.peek();
            ZipCodeInterval current = listToProcess.get(i);
            if (top.getUpperBoundZipCode() > current.getLowerBoundZipCode())
            {
                if (top.getUpperBoundZipCode() < current.getUpperBoundZipCode())
                    top.setUpperBoundZipCode(current.getUpperBoundZipCode());
            }
            else
                result.push(current);

        }
        ArrayList<ZipCodeInterval> mergedIntervals = new ArrayList<>();
        while (!result.isEmpty())
        {
            mergedIntervals.add(result.removeLast());
        }
        return mergedIntervals;
    }

}
