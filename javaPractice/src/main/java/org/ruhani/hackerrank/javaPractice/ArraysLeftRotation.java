package org.ruhani.hackerrank.javaPractice;

/** 
 * Given an array of n integers and a number, d, perform d left rotations on the array. 
 * Then print the updated array as a single line of space-separated integers.*/

/**
 * autohor -- Ruhani 
 * */
import java.util.Scanner ;

public class ArraysLeftRotation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); //input the number of integers and number of left rotations to be performed
        int n = in.nextInt(); //read the number of integers
        int k = in.nextInt(); //read the number of left rotations to be performed
        int a[] = new int[n]; //create an array with size equal to the number of integers input earlier
        
        //input the integers and store them in an array
        for(int a_i=0; a_i < n; a_i++){
        	int input = in.nextInt();
        	if(input>=1 && input<=Math.pow(10, 6))
        		a[a_i] = input;
        }
        
        in.close(); //closing the scanner as we're done reading inputs
        
        //getting the final state of the array after left rotating the elements
        if(n>=1 && n<=Math.pow(10, 5)) { //constraint # 1
        	if(k>=1 && k<=n) { //constraint # 2
        		
        		for(int i=k; i<n; i++) {
        			System.out.print(a[i] + " ");
        		}
        		
        		for(int i=0; i<k; i++)
        			System.out.print(a[i] + " ");
        	}
        }
        

	}

}
