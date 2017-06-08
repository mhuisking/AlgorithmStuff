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

ZipCode FAQ: [ http://www.zipboundary.com/zipcode_faqs.html]( http://www.zipboundary.com/zipcode_faqs.html)

### Basic/Naive Algorithm #1 List/Deque Based  *O(n Log n)* :
   Time complexity of the method is O(nLogn) which is for sorting. Once the array of intervals is sorted, merging takes linear time.

* Sort the collection of ranges
* Iterate, compare, add to result

### Basic/Naive Algorithm #2 Sorted Double List Based *O(n Log n)* :
   Time complexity of the method is O(nLogn) which is for sorting. Once the lists of intervals are sorted, merging takes linear time.
Additional benefit is that the ranges remain "immutable" no manipulation of values once constructed.
* Split and sort the collection of ranges into two lists
* Iterate, compare, add to result



### Interval Tree based Algorithm -- possible *O(log n)* :
Interval Trees discussed in *Introduction to Algorithms (CLRS)* 3rd Edition Chapter 14.3, pg. 348

* Add to balanced tree
* Traverse, evaluate, reduce

Complexity can be reduced from O(log n + k log n) to  O(log n) total time: 

*Implemented naively, the runtime of this algorithm is O(log n + k log n), where n is the number of intervals and k is the number of intervals removed during this process (since you have to do n deletes). However, you can speed this up to O(log n) by using the following trick. Since the deletion process always deletes nodes in a sequence, you can use a successor search for the endpoint to determine the end of the range to remove. Then, you can splice the subrange to remove out of the tree by doing two tree split operations and one tree join operation. On a suitable balanced tree (red-black or splay, for example), this can be done in O(log n) total time, which is much faster if a lot of ranges are going to get subsumed.*  [https://stackoverflow.com/questions/14545695/merge-ranges-in-intervals]([https://stackoverflow.com/questions/14545695/merge-ranges-in-intervals](https://stackoverflow.com/questions/14545695/merge-ranges-in-intervals "templatetypedef's Comment") -- comment from templatetypedef (Stanford Lecturer)


