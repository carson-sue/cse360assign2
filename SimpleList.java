package cse360assign2;

import java.util.Arrays;

/**
 * This class holds an array of integers that varies in size as needed.
 * Methods include adding to start or end of array, remove element, print array,
 * search for an element, return first/last element, return array size, and return
 * number of elements in the array.
 */
public class SimpleList {
	private int list[];
	private int count;
	
	/**
	 * Constructor initializes list and count. Count is set to 0 at the start.
	 * List is initialized with size of 10.
	 */
	public SimpleList(){
		list = new int[10];
		count = 0;
	}
	
	/**
	 * Adds an element to start of the list. Other elements are shifted right.
	 * If the list is full, array size is increased by 50% before adding new element.
	 * @param newNum The new number to be added into the list
	 */
	public void add(int newNum) {
		if(count == list.length) {
			int newSize = (int)(list.length*1.5);
			list = Arrays.copyOf(list, newSize); //Recreates array with new increased size
		}
		
		for(int i = count-1; i >= 0; i--) {
			list[i+1] = list[i]; //Shifts list to the right
		}
		list[0] = newNum;
		count++;
	}
	
	/**
	 * Adds an element to end of the list.
	 * If the list is full, array size is increased by 50% before adding new element.
	 * @param newNum The new number to be added into the list.
	 */
	public void append(int newNum) {
		if(count == list.length) {
			int newSize = (int)(list.length*1.5);
			list = Arrays.copyOf(list, newSize);
		}
		
		list[count] = newNum;
		count++;
	}
	
	/**
	 * Removes an element from the list. Shifts list accordingly such that there are no
	 * gaps in the list. If 25% or more of the array is empty, the overall array size
	 * is decreased by 25%.
	 * @param num The number to be removed from the list.
	 */
	public void remove(int num) {
		boolean removed = false;
		double percentEmpty = 1 - ((double)(count)/(double)(list.length));
		
		for(int i = 0; i < count; i++) {
			if(list[i] == num && !removed) { //Boolean prevents multiple instances of an element from being removed.
				for(int j = i; j < count - 1; j++) {
					list[j] = list[j+1]; //Shifts list left to remove n
				}
				count--;
				removed = true;
			}
		}
		
		if(percentEmpty >= 0.25) {
			int newSize = (int)(list.length*0.75);
			list = Arrays.copyOf(list, newSize); //Recreates array with new decreased size
		}
			
	}
	
	/**
	 * Puts the elements of the list into a string with spaces in between each number.
	 */
	public String toString() {
		String ret = "";
		
		for(int i = 0; i < count - 1; i++) { //puts all numbers in ret except for last one
			ret += list[i] + " ";
		}
		ret += list[count-1]; //puts last element in ret without extra space
		
		return ret;
	}
	
	/**
	 * Finds a number in the list.
	 * @param num Number to be found.
	 * @return Returns the index of the number if found. If no match is found, returns -1.
	 */
	public int search(int num) {
		int index = -1;
		boolean found = false;
		
		for(int i = 0 ; i < count; i++)
		{
			if(list[i] == num && !found) { //If there are multiple instances of an element, only returns first instance
				index = i;
				found = true;
			}
		}
		
		return index;
	}
	
	/**
	 * Returns the first element in the list.
	 * @return Returns first element or -1 if array is empty.
	 */
	public int first() {
		if(count == 0) {
			return -1;
		}
		else {
			return list[0];
		}
	}
	
	/**
	 * Returns the last element in the list.
	 * @return Returns last element or -1 if array is empty.
	 */
	public int last() {
		if(count == 0) {
			return -1;
		}
		else {
			return list[count-1];
		}
	}
	
	/**
	 * Returns the value stored in count.
	 * @return Only returns count.
	 */
	public int count() {
		return count;
	}
	
	/**
	 * Returns total size of list.
	 * @return Returns array length.
	 */
	public int size() {
		return list.length;
	}
}
