// Dylan Wright
// APCS2 pd5
// HW09 -- Mergers and Acquisitions
// 2016-03-06

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  
  In order to unshuffle a deck of cards using the method we discussed in class, we code two functions.
The first function will be a helper function which takes two lists which returns a third, sorted list through comparing the first card in the two inputted lists one at a time until all cards have been compared.
The second function will be our main recursive function which takes a list as an input and checks if it's length is 1. If it is, it returns the list. If it's not, it uses the helper function returns the sorted combination of recursing the first and second halves of the list through itself.
  ======================================*/

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
        int[] retList = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        
        while (i < a.length && j < b.length) {
            if (b[j] < a[i]) {
                retList[k] = b[j];
                k++;
                j++;
            }
            else {
                retList[k] = a[i];
                k++;
                i++;
            }
        }
        
        if (i < a.length) {
            while (i < a.length) {
                retList[k] = a[i];
                k++;
                i++;
            }
        }
        else {
            while (j < b.length) {
                retList[k] = b[j];
                k++;
                j++;
            }
        }
        
        return retList;
        
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
        if (arr.length == 1) {return arr;}
        
        int[] uno = new int[arr.length / 2];
        int[] dos = new int[(arr.length / 2) + (arr.length % 2)];
        for (int i = 0; i < arr.length / 2; i++) {
            uno[i] = arr[i];
        }
        for (int j = arr.length/2; j >= arr.length / 2 && j < arr.length; j++) {
            dos[j - arr.length/2] = arr[j];
        }
        return merge(sort(uno), sort(dos));
        
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	
	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

    
	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
    /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort
