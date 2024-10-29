package edu.grinnell.csc207.experiments;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import edu.grinnell.csc207.util.SearchUtils;

/**
 * Assorted experiments for searching structures.
 *
 * @author Maral
 * @author Alyssa
 * @author Samuel A. Rebelsky (starter code)
 */
public class SearchExperiments {
  /**
   * Run our experimens.
   *
   * @param args
   *   Command-line arguments. Ignored.
   */
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    String[] tmp =
        new String[] { "alpha", "bravo", "charlie", "delta", "echo",
                       "foxtrot", "golf", "hotel", "india",
                       "juliett", "kilo", "lima", "mike",
                       "november", "oscar", "papa", "quebec",
                       "romeo", "sierra", "tango", "uniform",
                       "victor", "whiskey", "xray", "yankee", "zulu" };
    ArrayList<String> strings = new ArrayList<String>(Arrays.asList(tmp));
    try{
      String ex1c = SearchUtils.search(strings, (str)->str.length()<5);
      pen.println("The first string in the list with less than five letters is " + ex1c);
    } catch (Exception e) {
      pen.println("There are no strings with less than five letters");
    }
    try {
      String ex1g = SearchUtils.search(strings, (s) -> s.length() == 6);
      pen.println("The first string of exactly six letters is " + ex1g);
    } catch (Exception e) {
      pen.println("There are no strings of exactly six letters.");
    } // try/catch
    try {
      String ex1u = SearchUtils.search(strings, (s) -> s.contains("u"));
      pen.println("The first string that contains the letter u is " + ex1u);
    } catch (Exception e) {
      pen.println("There are no strings that contain the letter u.");
    } // try/catch

    int ArrayInt[] = new int[1000];

  for (int i = 0; i < 1000; i++) {
      ArrayInt[i] = i;
  }
  int index = SearchUtils.binarySearch(ArrayInt, 999);
  pen.println("the index is found at " + index+"  and counter is " + SearchUtils.countR);
  pen.close();
  } // main(String[])
} // class SearchUtils
