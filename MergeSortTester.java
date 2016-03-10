// Team Bestestestes -- Derek Lin, Richard Lin, Dylan Wright
// APCS2 pd5
// HW11 -- Wrapping It Up
// 2016-03-10

/*======================================
  class MergeSortTester

  ALGORITHM:
  
  In order to unshuffle a deck of cards using the method we discussed in class, we code two functions.
  
  The first function will be a helper function which takes two lists which returns a third, sorted list through comparing the first card in the two inputted lists one at a time until all cards have been compared.
  
  The second function will be our main recursive function which takes a list as an input and checks if it's length is 1. If it is, it returns the list. If it's not, it uses the helper function returns the sorted combination of recursing the first and second halves of the list through itself.

  BIG-OH CLASSIFICATION OF ALGORITHM:
  
  My trio's runtime classification of mergeSort was n log n.
  This is because the runtime classification of our merge(a, b) was n. Merge(a, b) contained loops which went through each element in the list one at a time, without containing anything such as loops within loops.
  Additionally our main function, sort(a), has a runtime classification of log n. Sort(a) splits the list up binarily, thereby giving sort(a) its runtime classification of log n.
  Finally, seeing as our main function sort(a) contains our recursive call of merge(sort(a), sort(b)), we must multiply the orders of merge and sort, thereby giving us our runtime classification of n log n.

  Mean execution times for dataset of size n:
  Batch size: 10
  n=1         time: 708022.4
  n=10        time: 20698.3
  n=100       time: 166383.3
  n=1000      time: 1170408.8
  n=10000     time: 4609792.6
  n=100000    time: 63623278.2
  n=1000000   time: 350262237.2
  n=10000000  time: 3586086893

  ANALYSIS:
  Check out the spreadsheet!
  https://docs.google.com/spreadsheets/d/1KqSE1IYFunyiY7RVLekWfOxiTnT00nnH9K2a-tu0rqk/edit?usp=sharing
  ======================================*/

public class MergeSortTester 
{

    /******************************
     * execution time analysis 
     
     We have a first for loop to increment up the powers of ten from 0 to 7. We then create an array of the corresponding size, and have a second for loop to fill up the array via Math.random(). Then we store the time in nano seconds, run the merge sort, and then store the time in nano seconds again. We print the difference in those times.
     ******************************/
    public static void main( String[] args ) 
    {
        //Starts at magnitude 0, goes to magnitude 7 (in powers of 10)
        System.out.println();
        for (int mag = 0; mag < 8; mag++) { //mag for magnitude
            int length = (int) Math.pow(10,mag);
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                arr[i] = (int) (1050 * Math.random());
            }
            long beforeTest = System.nanoTime();
            MergeSort.sort(arr);
            long afterTest = System.nanoTime();


            System.out.println(afterTest-beforeTest);
        }   
	    
    }//end main

}//end class
