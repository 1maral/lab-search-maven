package edu.grinnell.csc207;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import edu.grinnell.csc207.util.SearchUtils;

/**
 * Tests of our search methods.
 *
 * @author Alyssa
 * @author Maral
 * @author Samuel A. Rebelsky
 */
public class TestSearch {
  // +---------+-----------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * A string version of a call to binary search.
   *
   * @param values
   *   The array.
   * @param val
   *   The value we're searching for.
   *
   * @return
   *   The string "binarySearch(values, val)"
   */
  String bsCall(int[] values, int val) {
    return String.format("binarySearch(%s, %d)", Arrays.toString(values), val);
  } // bsCall

  /**
   * Assert that a search for a particular value finds the value at an
   * expected index.
   *
   * @param expected
   *   The expected index.
   * @param values
   *   The array we're searching.
   * @param val
   *   The value we're searching for.
   */
  void assertBinarySearchFinds(int expected, int[] values, int val) 
      throws Exception {
    assertEquals(expected, SearchUtils.binarySearch(values, val),
        () -> bsCall(values, val));
  } // assertBinarySearchFinds(int, int[], int)

  /**
   * Assert that a search for a particular value finds the value.
   * @param values
   *   The array we're searching.
   * @param val
   *   The value we're searching for.
   */
  void assertBinarySearchFinds(int[] values, int val) throws Exception {
    assertEquals(val, values[SearchUtils.binarySearch(values, val)],
        () -> String.format("values[%s]", bsCall(values, val)));
  } // assertBinarySearchFinds(int[], int)

  /**
   * Assert that a search for a particular value fails (hopefully, because 
   * the value * is not in the array).
   *
   * @param values
   *   The array we're searching.
   * @param val
   *   The value we're searching for.
   */
  void assertBinarySearchFails(int[] values, int val) throws Exception {
    assertThrows(Exception.class,
        () -> SearchUtils.binarySearch(values, val),
        () -> bsCall(values, val));
  } // assertBinarySearchFails()

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * Searching the empty array should fail.
   */

  @Test
  void testBinarySearchEmpty() throws Exception {
    assertBinarySearchFails(new int[] { }, 0);
  } // testSearchEmpty()

  /**
   * Searching in a one-element array.
   */
  @Test
  void testBinarySearchOne() throws Exception {
    assertBinarySearchFinds(0, new int[] { 5 }, 5);
    assertBinarySearchFails(new int[] { 5 }, 0);
    assertBinarySearchFails(new int[] { 5 }, 10);
  } // testBinarySearchOne()

  /**
   * Searching in a two-element array.
   */
  @Test
  void testBinarySearchTwo() throws Exception {
    assertBinarySearchFinds(0, new int[] { 7, 11 }, 7);
    assertBinarySearchFinds(1, new int[] { 7, 11 }, 11);
    assertBinarySearchFails(new int[] { 7, 11 }, 0);
    assertBinarySearchFails(new int[] { 7, 11 }, 10);
    assertBinarySearchFails(new int[] { 7, 11 }, 20);
  } // testBinarySearchTwo()

  /**
   * Searching with duplicates. (    assertBinarySearchFails(new int[] { }, 0);
int[] { 1, 1, 1, 2, 2, 3 }, 3);
  } // testBinarySearchDups()

  /**
   * Searching in a three-element array.
   */
  @Test
  void testBinarySearchThree() throws Exception {
    assertBinarySearchFinds(2, new int[] { 1, 2, 7, 11 }, 7);
    assertBinarySearchFinds(2, new int[] { -1, 7, 11, 12, 575 }, 11);
    assertBinarySearchFails(new int[] { 1, 2, 7, 11 }, 0);
    assertBinarySearchFails(new int[] { 33, -10, 7, 11 }, 10);
    assertBinarySearchFails(new int[] { -20, 7, 11 }, 20);
  } // testBinarySearchTwo()

  @Test
  void testLoop() throws Exception{
    int[] vals = new int[32];
    for (int i=0; i<32; i++) {
      vals[i] = 2*i;
    }
    for (int j=0; j<32; j++){
      assertBinarySearchFinds(j, vals, 2*j);
      assertBinarySearchFails(vals, (2*j)+1);
    }
  }

} // class TestSearch
