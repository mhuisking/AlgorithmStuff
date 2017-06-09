package org.huisking.simple;

import org.huisking.model.ZipCodeInterval;
import org.junit.Before;
import org.junit.Test;

import static org.huisking.FileUtils.getIntervalListFromResourceFile;
import static org.junit.Assert.assertTrue;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SimpleZipCodeMergeTest {

    List<ZipCodeInterval> allZipList;
    List<ZipCodeInterval> allZipMergeResult;

    @Before
    public void setUp() throws Exception {
        //Create a list of all zipcodes from csv
        allZipList = getIntervalListFromResourceFile("AllZipRanges.csv");

        //Create the result list from csv
        allZipMergeResult = getIntervalListFromResourceFile("AllZipsMergeResult.csv");
    }

    @Test
    public void mergeZipList_whenReferenceDataIsMerged_returnsCorrectResult() throws Exception {
        List<ZipCodeInterval> referenceArray  = Arrays.asList( new ZipCodeInterval[]{ new ZipCodeInterval(94133,94133),
                new ZipCodeInterval(94200,94299),
                new ZipCodeInterval(94226,94399)});

        List<ZipCodeInterval> expectedResult = Arrays.asList(new ZipCodeInterval[]{new ZipCodeInterval(94133,94133),
               new ZipCodeInterval(94200,94399)});

        SimpleZipCodeMerge simpleZipCodeMerge = new SimpleZipCodeMerge();
        ArrayList<ZipCodeInterval> result = simpleZipCodeMerge.mergeZipList(referenceArray);

        assertTrue(expectedResult.equals(result));
    }

    @Test
    public void mergeUsingArrays_whenPassedAllZips_returnsAllZips() throws Exception {
        SimpleZipCodeMerge simpleZipCodeMergeZipCodeMerge = new SimpleZipCodeMerge();
        List<ZipCodeInterval> result = simpleZipCodeMergeZipCodeMerge.mergeZipList(allZipList);

        assertTrue(allZipMergeResult.equals(result));
    }

}