package org.huisking.model;

public class ZipCodeInterval {
    private Integer lowerBoundZipCode;
    private Integer upperBoundZipCode;


    public ZipCodeInterval(Integer lowerBoundZipCode, Integer upperBoundZipCode) {
        if (upperBoundZipCode < lowerBoundZipCode) {
            throw new RuntimeException(String.format("Invalid interval parameters: Zip code end range value of %05d must be greater than start range value of %05d", upperBoundZipCode, lowerBoundZipCode));
        }
        if (upperBoundZipCode < 0 || lowerBoundZipCode < 0) {
            throw new RuntimeException(String.format("Invalid interval parameters: [%05d, %05d] Zip Codes cannot be negative values", upperBoundZipCode, lowerBoundZipCode));
        }
        this.lowerBoundZipCode = lowerBoundZipCode;
        this.upperBoundZipCode = upperBoundZipCode;
    }

    public Integer getLowerBoundZipCode() {
        return lowerBoundZipCode;
    }

    public void setLowerBoundZipCode(Integer lowerBoundZipCode) {
        this.lowerBoundZipCode = lowerBoundZipCode;
    }

    public Integer getUpperBoundZipCode() {
        return upperBoundZipCode;
    }

    public void setUpperBoundZipCode(Integer upperBoundZipCode) {
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
        return upperBoundZipCode >= comparedInterval.lowerBoundZipCode && lowerBoundZipCode <= comparedInterval.upperBoundZipCode;
    }

    @Override
    public String toString() {
        return String.format("[%05d,%05d]", lowerBoundZipCode, upperBoundZipCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZipCodeInterval that = (ZipCodeInterval) o;

        if (lowerBoundZipCode != null ? !lowerBoundZipCode.equals(that.lowerBoundZipCode) : that.lowerBoundZipCode != null)
            return false;
        return upperBoundZipCode != null ? upperBoundZipCode.equals(that.upperBoundZipCode) : that.upperBoundZipCode == null;
    }

    @Override
    public int hashCode() {
        int result = lowerBoundZipCode != null ? lowerBoundZipCode.hashCode() : 0;
        result = 31 * result + (upperBoundZipCode != null ? upperBoundZipCode.hashCode() : 0);
        return result;
    }


}
