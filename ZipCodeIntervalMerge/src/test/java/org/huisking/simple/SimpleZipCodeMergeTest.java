package org.huisking.simple;

import org.huisking.ZipCodeInterval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by chuisking on 6/7/2017.
 */
public class SimpleZipCodeMergeTest {
    @Test
    public void mergeZipList_whenReferenceDataIsMerged_returnsCorrectResult() throws Exception {

        ArrayList<ZipCodeInterval> referenceArray  = Arrays.asList( { new ZipCodeInterval(94133,94133),
                new ZipCodeInterval(94200,94299),
                new ZipCodeInterval(94226,94399)});

        ArrayList<ZipCodeInterval> expectedResult = Arrays.asList({new ZipCodeInterval(94133,94133),
               new ZipCodeInterval(94200,94399)});

        SimpleZipCodeMerge simpleZipCodeMerge = new SimpleZipCodeMerge(referenceArray);
        ArrayList<ZipCodeInterval> result = simpleZipCodeMerge.mergeZipList();

       // AssertTrue(Arrays.deepEquals(referenceArray,expectedResult));
    }

}