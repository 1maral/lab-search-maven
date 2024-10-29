package edu.grinnell.csc207.util;

import java.util.function.Predicate;

/**
 * Assorted utilities for searching structures.
 *
 * @author Alyssa Ryan
 * @author Maral Bat-Erdene
 * @author Samuel A. Rebelsky (starter code)
 */
public class SearchUtils {
  public static int countIt = 0;
  public static int countR = 0;
  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * Search for val in values, return the index of an instance of val.
   *
   * @param values
   *   A sorted array of integers
   * @param val
   *   An integer we're searching for
   * @return
   *   index, an index of val (if one exists)
   * @throws Exception
   *   If there is no i s.t. values[i] == val
   * @pre
   *   values is sorted in increasing order.  That is, values[i] <=
   *   values[i+1] for all reasonable i.
   * @post
   *   values[index] == val
   */
  static int iterativeBinarySearch(int[] vals, int val) throws Exception {
    int lb = 0;
    int ub = vals.length-1;
    int midpoint;
    while (lb<ub && lb != ub) {
      countIt++;
      midpoint = (ub-lb)/2 + lb;
      if(vals[midpoint] == val){
        return midpoint;
      } else if (vals[midpoint] < val) {
        lb = midpoint + 1;
      } else {
        ub = midpoint - 1;
      } // else/if
    }
    if(lb == ub && vals[lb] == val){
      return lb;
    }
    throw new Exception();
  } // iterativeBinarySearch

  /**
   * Search for val in values, return the index of an instance of val.
   *
   * @param values
   *   A sorted array of integers
   * @param val
   *   An integer we're searching for
   * @return
   *   index, an index of val (if one exists)
   * @throws Exception
   *   If there is no i s.t. values[i] == val
   * @pre
   *   values is sorted in increasing order.  That is, values[i] <=
   *   values[i+1] for all reasonable i.
   * @post
   *   values[index] == val
   */
  static int recursiveBinarySearch(int[] vals, int val) throws Exception {
    return recursiveHelper(vals, val, 0, vals.length - 1);
  } // recursiveBinarySearch

  static int recursiveHelper(int[] vals, int val, int lb, int ub) throws Exception {
    countR++;
    int midpoint = (ub - lb)/2;
    midpoint += lb;
    if (lb > ub){
      throw new Exception("Not found");
    } // if/else
    if (vals[midpoint] == val) {
      return midpoint;
    } else if (vals[midpoint] < val) {
      return recursiveHelper(vals, val, midpoint + 1, ub);
    } else {
      return recursiveHelper(vals, val, lb, midpoint - 1);
    } // else/if
  } // recursiveHelper



  /**
   * Search for val in a subarray of values, return the index of an 
   * instance of val.
   *
   * @param values
   *   A sorted array of integers
   * @param lb
   *   The lower bound of the area of interest (inclusive)
   * @param ub
   *   The upper bound of the area of interest (exclusive)
   * @param val
   *   An integer we're searching for
   * @return
   *   index, an index of val (if one exists)
   * @throws Exception
   *   If there is no i between lb and ub s.t. values[i] == val
   * @pre
   *   values is sorted in increasing order.  That is, values[i] <=
   *   values[i+1] for all reasonable i.
   * @post
   *   values[index] == val
   */
  static int rbsHelper(int[] vals, int lb, int ub, int val) throws Exception {
    return 0;   // STUB
  } // rbsHelper

  // +----------------+----------------------------------------------
  // | Public methods |
  // +----------------+

  /**
   * Search values for the first value for which pred holds.
   *
   * @param <T> 
   *   The type of values we're examining
   * @param values
   *   The iterable we're searching
   * @param pred
   *   The predicate used to determine whether or not the value is
   *   acceptable
   * 
   * @return the first mathcing    assertBinarySearchFails(new int[] { }, 0);
 element.
   *
   * @throws Exception
   *   If no matching value is found.
   */
  public static <T> T search(Iterable<T> values, Predicate<? super T> pred) throws Exception{
    for(T i : values){
      if(pred.test(i)){
        return i;
      }
    }
    throw new Exception();
  } // search(Iterable<T>, Predicate<? super T>)

  /**
   * Search for val in values, return the index of an instance of val.
   *
   * @param values
   *   A sorted array of intege    assertBinarySearchFails(new int[] { }, 0);

   *   index, an index of val (if one exists)
   * @throws Exception
   *   If there is no i s.t. values[i] == val
   * @pre
   *   values is sorted in inc    assertBinarySearchFails(new int[] { }, 0);

   *   values[index] == val
   */
  public static int binarySearch(int[] vals, int val) throws Exception {
    // return 0;
    // return iterativeBinarySearch(vals, val);
    return recursiveBinarySearch(vals, val);
  } // binarySearch

} // class SearchUtils
