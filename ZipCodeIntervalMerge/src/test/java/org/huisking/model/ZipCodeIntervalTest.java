package org.huisking.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;

public class ZipCodeIntervalTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private ZipCodeInterval californiaZips = new ZipCodeInterval(90001, 96162);
    private ZipCodeInterval placerCountyZips = new ZipCodeInterval(95650, 95670);

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @Test
    public void zipCodeIntervalConstructor_whenEndValueIsGreaterThanStartValue_throwsRuntimeExceptionWithMessage() {
        String exceptionMessage = "Invalid interval parameters: Zip code end range value of 95660 must be greater than start range value of 95663";

        exception.expect(RuntimeException.class);
        exception.expectMessage(equalTo(exceptionMessage));

        ZipCodeInterval badInterval = new ZipCodeInterval(95663, 95660);
    }

    @Test
    public void zipCodeIntervalConstructor_whenNegativeValueIsPassed_throwsRuntimeExceptionWithMessage() {
        String exceptionMessage = "Invalid interval parameters: [-95660, -95663] Zip Codes cannot be negative values";

        exception.expect(RuntimeException.class);
        exception.expectMessage(equalTo(exceptionMessage));

        ZipCodeInterval badInterval = new ZipCodeInterval(-95663, -95660);
    }

    @Test
    public void contains_whenIntervalContainsSpecifiedZipCode_returnTrue() {
        Integer penrynZip = 95663;
        assertTrue(placerCountyZips.contains(penrynZip));
    }

    @Test
    public void contains_whenIntervalIntersectsSpeifiedZipCodeRange_returnTrue() {
        assertTrue(californiaZips.intersects(placerCountyZips));
    }

    @Test
    public void toString_correctlyDisplaysZeroPaddedZipCodes(){
        ZipCodeInterval shortZipInterval = new ZipCodeInterval(0,1001);
            assertTrue(shortZipInterval.toString().equals("[00000,01001]"));
    }

}