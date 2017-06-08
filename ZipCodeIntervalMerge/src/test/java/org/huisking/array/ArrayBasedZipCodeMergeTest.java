package org.huisking.array;

import org.huisking.model.ZipCodeInterval;
import org.huisking.simple.SimpleZipCodeMerge;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArrayBasedZipCodeMergeTest {
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

}