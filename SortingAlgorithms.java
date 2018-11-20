/**
 

Java program to demonstrate the run time of different sorting algorithms
sorting arrays of various sizes. Algorithms used in this program are: Selection
Sort,Insertion Sort (both taken from the text book chapter 7 "ARRAYS", and a method
arrays.sort which is a method from java.util.Arrays class.  

Measuring time table for sorting algorithms in seconds/milliseconds:

Array Size		1,000 | 10,000 | 100,000
________________________________________
Insertion Sort |0.003 |0.061   | 5.425

Selection Sort |0.005 | 0.108  | 7.276

Arrays.sort()  |0.004 |0.006   | 0.027


**/

import java.util.*; //import in order to use Arrays class

public class SortingAlgorithms{
	     
	    private static final int ARRAYSIZE = 100000; //constant 

        static void insertionSort(int[] A) {
        	// Sort the array A into increasing order.
        	int itemsSorted; // Number of items that have been sorted so far.
        	for (itemsSorted = 1; itemsSorted < A.length; itemsSorted++) {
        	// Assume that items A[0], A[1], ... A[itemsSorted-1]
        	// have already been sorted. Insert A[itemsSorted]
        	// into the sorted part of the list.
        		int temp = A[itemsSorted]; // The item to be inserted.
        		int loc = itemsSorted - 1; // Start at end of list.
        		while (loc >= 0 && A[loc] > temp) {
		        	A[loc + 1] = A[loc]; // Bump item from A[loc] up to loc+1.
		        	loc = loc - 1; // Go on to next location.
		        	}
        	A[loc + 1] = temp; // Put temp in last vacated space.
        	}
        	}
        
        private static void selectionSort(int[] A) {
     	   
            // Find the largest item among A[0], A[1], ...,
            // A[lastPlace], and move it into position lastPlace 
            // by swapping it with the number that is currently 
            // in position lastPlace.
    	    for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {
    	         
    	        int maxLoc = 0;  // Location of largest item seen so far.
    	      
    	        for (int j = 1; j <= lastPlace; j++) {
    	            if (A[j] > A[maxLoc]) {
    	                // Since A[j] is bigger than the maximum we've seen
    	                // so far, j is the new location of the maximum value
    	                // we've seen so far.
    	                maxLoc = j;  
    	            }
    	        }
    	      
    	        int temp = A[maxLoc];  // Swap largest item with A[lastPlace].
    	        A[maxLoc] = A[lastPlace];
    	        A[lastPlace] = temp;
    	      
    	    }  // end of for loop
    	   
    	}

        
        public static void main(String[] args)
        {
        	    
        		int[] intArray = new int[ARRAYSIZE]; //ARRAYSIZE constant 
        		//which determine the size of the array
                
                
                for (int i=0; i<intArray.length; i++) //loop which append random numbers to intArray
                {
                	intArray[i] = (int)(Integer.MAX_VALUE * Math.random());
                	
                }
                
                //create two copies of intArray in order to sort them with different methods
                int[] ArrayCopy = Arrays.copyOf(intArray, intArray.length);
                int[] ArrayCopy2 = Arrays.copyOf(intArray, intArray.length);
                
                //we use these variables to measure the time it take the algorithms to sort the arrays
        		long startTime = System.currentTimeMillis();
        		//insertionSort performed on intArray
        		insertionSort(intArray);
        		long runTime = System.currentTimeMillis() - startTime;	
        		System.out.println(runTime/1000.0);
        		
        		//Arrays.sort performed on ArrayCopy;
        		startTime = System.currentTimeMillis();
        		Arrays.sort(ArrayCopy);
        		runTime = System.currentTimeMillis() - startTime;	
        		System.out.println(runTime/1000.0);
        		
        		//selectionSort performed on ArrayCopy2;
        		startTime = System.currentTimeMillis();
        		selectionSort(ArrayCopy2);
        		runTime = System.currentTimeMillis() - startTime;	
        		System.out.println(runTime/1000.0);
                
                }
}