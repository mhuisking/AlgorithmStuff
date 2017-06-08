package org.huisking.simple;

import org.huisking.model.ZipCodeInterval;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleZipCodeMergeTest {
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

}