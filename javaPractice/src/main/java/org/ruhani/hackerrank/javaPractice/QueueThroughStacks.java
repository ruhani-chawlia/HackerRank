package org.ruhani.hackerrank.javaPractice;

/**
=================
Problem statement
=================
Implement a queue using two stacks. Then process q queries, where each query is one of 
the following 3 types:
	1 x: Enqueue element x into the end of the queue.
	2: Dequeue the element at the front of the queue.
	3: Print the element at the front of the queue.
============	
Input Format
============
The first line contains a single integer, q, denoting the number of queries. 
Each line i of the q subsequent lines contains a single query in the form described in the 
problem statement above. All three queries start with an integer denoting the query type, 
but only query 1 is followed by an additional space-separated value, x, 
denoting the value to be enqueued.	
========================
Author -- Ruhani Chawlia
Date -- 18-Nov-2017
=======================
**/

import java.util.EmptyStackException;
import java.util.Scanner;

public class QueueThroughStacks {
	
	public static class MyQueue<T> {
		
		/** defining stack class with element and operations */
		@SuppressWarnings("hiding")
		class Stack<T> {
			
			/** elements in a stack */
			public class Element<T> {
				private T data; //data value of the element
				private Element<T> next; //next element in the stack
				
				Element(T data) {
					this.data = data;
				}
			}
			
			private Element<T> top; //top element of the stack
			
			/** operations that can be performed on a stack */
			/** method to check if the stack is empty */
			public boolean isStackEmpty() {
				return top == null;
			}
			
			/** method to add an element into the stack */
			public void push(T value) {
				Element<T> newElement = new Element<T>(value);
				if(!isStackEmpty())
					newElement.next = top;
				top = newElement;
			}
			
			/** method to remove an element from the stack */
			public T pop() {
				if(isStackEmpty())
					throw new EmptyStackException() ;
				T oldData = top.data;
				top = top.next;
				return oldData;
			}
			
			/** View the element at the top of the stack */
			public T peek() {
				if(isStackEmpty())
					throw new EmptyStackException() ;
				return top.data;
			}
		}
		
		// creating two stacks 
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();
        
        /** Push the element into newest stack */
        public void enqueue(T value) { 
        	stackNewestOnTop.push(value);
        }

        /** View the element from oldest stack.
         *  If the oldest stack is empty, pop elements from newest stack and push them into oldest stack
         *  so that the new entries are in reverse order in oldest stack,
         *  and then view the top element from the oldest stack */
        public T peek() {
        	if(stackOldestOnTop.isStackEmpty()) {
        		while(!stackNewestOnTop.isStackEmpty()) {
        			stackOldestOnTop.push(stackNewestOnTop.pop());          	
        		}
        	}
        	return stackOldestOnTop.peek();
        }

        /** Pop the element from oldest stack.
         *  If the oldest stack is empty, pop elements from newest stack and push them into oldest stack
         *  so that the new entries are in reverse order in oldest stack,
         *  and then view the top element from the oldest stack */
        public T dequeue() {   
        	if(stackOldestOnTop.isStackEmpty()) {
        		while(!stackNewestOnTop.isStackEmpty()) {
        			stackOldestOnTop.push(stackNewestOnTop.pop());          	
        		}
        	}
            return stackOldestOnTop.pop();
        }
    }

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
	}

}
