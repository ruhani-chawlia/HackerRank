package org.ruhani.hackerrank.javaPractice;

/**
 *Given two strings, a and b, that may or may not be of the same length, 
 * determine the minimum number of character deletions required to make a and b anagrams. 
 * Any characters can be deleted from either of the strings.
 */

import java.util.Scanner;

public class MakingAnagrams {
	
	public static int numberNeeded(String first, String second) {
		
		int minDeletions = 0;
		
		if((first.length()>=1 && first.length()<=Math.pow(10, 4)) && (second.length()>=1 && second.length()<=Math.pow(10, 4))
				&& first.toLowerCase().equals(first) && second.toLowerCase().equals(second)){
			
			//identify the characters present in the first string but not in the second, and then deleting them from the first string
			for(int i=0; i<first.length(); i++) {
				
				int numOccurrencesInFirst = 0;
				int numOccurrencesInSecond = 0;
				
				/*If a character is common between the first and second string,
				 * calculate the deletions once so that this step doesn't 
				 * have to be repeated while scanning the second string
				 * */
				if(second.contains(Character.toString(first.charAt(i)))) {
					if(i == first.indexOf(first.charAt(i))) {
						for(int index=first.indexOf(first.charAt(i)); index>=0; index=first.indexOf(first.charAt(i), index+1)) {
							++numOccurrencesInFirst;
							//System.out.println("index for " + first.charAt(i) + " in " + first + " = " + index);
						}
					
						for(int index=second.indexOf(first.charAt(i)); index>=0; index=second.indexOf(first.charAt(i), index+1)) {
							++numOccurrencesInSecond;
							//System.out.println("index for " + first.charAt(i) + " in " + second + " = " + index);
						}
						if(numOccurrencesInFirst != numOccurrencesInSecond) {
							minDeletions += Math.abs(numOccurrencesInFirst - numOccurrencesInSecond);
							//System.out.println("Deletion = " + minDeletions);
						}
					}
				}
				
				/*Calculate the deletions for characters present in only the first string and not the second
				 * */
				else if(!second.contains(Character.toString(first.charAt(i)))) {	
					if(i == first.indexOf(first.charAt(i))) {
						for(int index=first.indexOf(first.charAt(i)); index>=0; index=first.indexOf(first.charAt(i), index+1)) {
							++minDeletions;
							//System.out.println("index for " + first.charAt(i) + " in " + first + " = " + index);
						}
						//System.out.println("Deletion = " + minDeletions);
					}
				}
				
			}	
			
			
			//identify the characters present in the second string but not in the first, and then deleting them from the second string
			for(int i=0; i<second.length(); i++) {
				
				/*Since the deletions for common characters has already been calculated previously,
				 * here, we'll calculate the deletions for characters present in the second string and not in the first
				 * */
				if(!first.contains(Character.toString(second.charAt(i)))) {
					if(i == second.indexOf(second.charAt(i))) {
						for(int index=second.indexOf(second.charAt(i)); index>=0; index=second.indexOf(second.charAt(i), index+1)) {
							++minDeletions;
							//System.out.println("index for " + second.charAt(i) + " in " + second + " = " + index);
						}
						//System.out.println("Deletion = " + minDeletions);
					}
				}	
			}
			
			//System.out.println("Minimum deletions = " + minDeletions);
			
		}
	      return minDeletions;
    }

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //input two strings
        String a = in.next(); //read the first string
        String b = in.next(); //read the second string
        in.close(); //close the scanner 
        System.out.println(numberNeeded(a, b)); 
    }

}
