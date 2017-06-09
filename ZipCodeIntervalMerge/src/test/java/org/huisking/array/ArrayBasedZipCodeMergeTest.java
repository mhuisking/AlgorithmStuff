package org.huisking.array;

import org.huisking.model.ZipCodeInterval;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.huisking.FileUtils.getIntervalListFromResourceFile;
import static org.junit.Assert.*;

public class ArrayBasedZipCodeMergeTest {

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
    public void mergeUsingArrays_whenReferenceDataIsMerged_returnsCorrectResult() throws Exception {
        List<ZipCodeInterval> referenceArray  = Arrays.asList( new ZipCodeInterval[]{ new ZipCodeInterval(94133,94133),
                new ZipCodeInterval(94200,94299),
                new ZipCodeInterval(94226,94399)});

        List<ZipCodeInterval> expectedResult = Arrays.asList(new ZipCodeInterval[]{new ZipCodeInterval(94133,94133),
                new ZipCodeInterval(94200,94399)});

        ArrayBasedZipCodeMerge arrayBasedZipCodeMerge = new ArrayBasedZipCodeMerge();
        List<ZipCodeInterval> result = arrayBasedZipCodeMerge.mergeUsingArrays(referenceArray);

        assertTrue(expectedResult.equals(result));
    }

    @Test
    public void mergeUsingArrays_whenPassedAllZips_returnsAllZips() throws Exception {
        ArrayBasedZipCodeMerge arrayBasedZipCodeMerge = new ArrayBasedZipCodeMerge();
        List<ZipCodeInterval> result = arrayBasedZipCodeMerge.mergeUsingArrays(allZipList);

        assertTrue(allZipMergeResult.equals(result));
    }
}