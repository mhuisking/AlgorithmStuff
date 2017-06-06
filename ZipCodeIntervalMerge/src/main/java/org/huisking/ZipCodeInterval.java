package org.huisking;


public class ZipCodeInterval {

    private Integer lowerBoundZipCode;
    public Integer upperBoundZipCode;

    public ZipCodeInterval(Integer lowerBoundZipCode, Integer upperBoundZipCode) {
        this.lowerBoundZipCode = lowerBoundZipCode;
        this.upperBoundZipCode = upperBoundZipCode;
    }


    /**
     * Determines if the interval contains a given zipcode.
     *
     * @param zipCode Point that is queried for containment in interval
     * @return True if the zipCode falls in this interval (inclusive)
     */
    public boolean contains(int zipCode) {
        return zipCode >= lowerBoundZipCode && zipCode <= upperBoundZipCode;
    }

    /**
     * Determines if this interval intersects another interval.
     *
     * @param comparedInterval The interval to compare
     * @return True if "this" overlaps with the comparedInterval
     */
    public boolean intersects(ZipCodeInterval comparedInterval) {
        return lowerBoundZipCode <= comparedInterval.upperBoundZipCode && upperBoundZipCode >= comparedInterval.lowerBoundZipCode;
    }

    @Override
    public String toString() {
        String.format("[%05d,%05d]", lowerBoundZipCode, upperBoundZipCode)
    }

}
