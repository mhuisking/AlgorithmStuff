# ZipCode Interval Merge

Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

Given:
  A range may be provided in arbitrary order
  Ranges may or may not overlap

Assumptions:

 * US Zip codes are positive integers
 * A range must contain a start and end zip code
 * The end zip code must be greater than or equal to the start zipcode
 * Intervals can never overlap
 * Printable zipcode ranges will be in the form of [nnnnn, nnnnn] Left zero padded if applicable.
 * When two ranges are compared, the intersection exists when the ranges lower bound zipcode is less than or equal to the compared upper bound zip code *and* the upper bound zipcode is greater than or equal to the compared lower bound zipcode -- the intersection shows that an overlap exists.

ZipCode FAQ:  http://www.zipboundary.com/zipcode_faqs.html

Basic Algorithm:

* Sort the collection of ranges
* Iterate, compare add to result

Efficient Algorithm

* Add to balanced tree
* Traverse, evaluate, reduce

