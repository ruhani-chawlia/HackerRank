package org.ruhani.hackerrank.javaPractice;

/** Colleen is turning n years old! 
 * Therefore, she has  candles of various heights on her cake, and candle  has height_i . 
 * Because the taller candles tower over the shorter ones, Colleen can only blow out the tallest candles.
 * Given the  for each individual candle, find and print the number of candles she can successfully blow out.
 * */


import java.util.Scanner;

public class BirthdayCakeCandles {
	
	
	/* Method to calculate
	 * the number of tallest candles
	 * */
	static int birthdayCakeCandles(int n, int[] ar) {
		int result = 0;
		
		if(n>=1 && n<=Math.pow(10, 5)) { //constraint on the number of candles
			int maxHeight = 0;
			
			/* Find the maximum height 
			 * from the array
			 * */
			for(int i=0; i<ar.length; i++) {
				if(ar[i]>=1 && ar[i]<=Math.pow(10, 7)) { //constraint on the height of candle
					if(ar[i]>maxHeight) {
						maxHeight = ar[i];
					}
				}
			}
			
			/* Find the number of candles 
			 * with the maximum height
			 * */
			for(int i=0; i<ar.length; i++) {
				if(ar[i] == maxHeight) {
					++result ;
				}
			}
			
			
		}
		return result;
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in); //input the number of candles
        int n = in.nextInt(); //read the input
        int[] ar = new int[n]; //create an array with size equal to the number of candles
        
        //input the height of each candle and store it in the array
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        
        //get the number of tallest candles and print it
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
        
        in.close();
	}    
}
