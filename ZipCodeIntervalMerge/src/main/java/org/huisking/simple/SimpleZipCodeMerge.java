package org.huisking.simple;

import org.huisking.ZipCodeInterval;

import java.util.*;

public class SimpleZipCodeMerge {

    private ArrayDeque<ZipCodeInterval> result = new ArrayDeque<>();
    private List<ZipCodeInterval> listToProcess = new ArrayList<>();

    public SimpleZipCodeMerge(List<ZipCodeInterval> zipListToProcess) {
        this.listToProcess = zipListToProcess;
    }

    public ArrayList<ZipCodeInterval> mergeZipList(){

        listToProcess.sort(Comparator.comparing(ZipCodeInterval::getLowerBoundZipCode));

        result.push(listToProcess.get(0));

        for (int i =1; i<listToProcess.size(); i++)
        {
            ZipCodeInterval current = result.peek();
            ZipCodeInterval next = listToProcess.get(i);
            if(current.intersects(next)){
                current.setUpperBoundZipCode(next.getUpperBoundZipCode());
            }
//            if (current.getUpperBoundZipCode() > next.getLowerBoundZipCode())
//            {
//                if (current.getUpperBoundZipCode() < next.getUpperBoundZipCode())
//                    current.setUpperBoundZipCode(next.getUpperBoundZipCode());
//            }
            else{
                result.push(next);
            }


        }
        ArrayList<ZipCodeInterval> mergedIntervals = new ArrayList<>();
        while (!result.isEmpty())
        {
            mergedIntervals.add(result.removeLast());
        }
        return mergedIntervals;
    }

}
