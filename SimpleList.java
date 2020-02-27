package cse360assign2;

/**
 * This class keeps track of up to 10 integers in a list which can be modified as needed.
 */
public class SimpleList {
	private int list[];
	private int count;
	
	/**
	 * Constructor initializes list and count. Count is set to 0 at the start.
	 */
	public SimpleList(){
		list = new int[10];
		count = 0;
	}
	
	/**
	 * Adds an element to start of the list. Other elements are shifted right.
	 * If the list is full, rightmost element is removed.
	 * @param newNum the new number to be added into the list
	 */
	public void add(int newNum) {
		for(int i = count-1; i >= 0; i--)
			if(i != list.length - 1) //Prevents IndexOutOfBounds error
				list[i+1] = list[i]; //Shifts list to the right
		
		list[0] = newNum;
		
		if(count < list.length) //Prevents count from being greater then list length
			count++;
	}
	
	/**
	 * Removes an element from the list. Shifts list accordingly such that there are no
	 * gaps in the list
	 * @param num number to be removed from the list
	 */
	public void remove(int num) {
		for(int i = 0; i < count; i++) {
			if(list[i] == num) {
				for(int j = i; j < count - 1; j++)//Shifts list left to remove n
					list[j] = list[j+1];
				
				count--;
				break;
			}
		}
	}
	
	/**
	 * Returns the value stored in count.
	 * @return only returns count.
	 */
	public int count() {
		return count;
	}
	
	/**
	 * Puts the elements of the list into a string with spaces in between each number.
	 */
	public String toString() {
		String ret = "";
		
		for(int i = 0; i < count - 1; i++) //puts all numbers in ret except for last one
			ret += list[i] + " ";
		
		ret += list[count-1]; //puts last element in ret without extra space
		
		return ret;
	}
	
	/**
	 * Finds a number in the list.
	 * @param num number to be found
	 * @return returns the index of the number if found. If no match is found, returns -1
	 */
	public int search(int num) {
		for(int i = 0 ; i < count; i++)
			if(list[i] == num)
				return i;
		
		return -1; //n not found in list
	}
}