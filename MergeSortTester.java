/*======================================
  class MergeSortTester

  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>

  BIG-OH CLASSIFICATION OF ALGORITHM:
  <INSERT YOUR EXECUTION TIME CATEGORIZATION OF MERGESORT HERE>

  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 
  n=10      time: 
  n=100     time: 
  ...
  n=<huge>  time: 

  ANALYSIS:
  Check out the spreadsheet!
  https://docs.google.com/spreadsheets/d/1KqSE1IYFunyiY7RVLekWfOxiTnT00nnH9K2a-tu0rqk/edit?usp=sharing
  ======================================*/

public class MergeSortTester 
{

    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...>
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
