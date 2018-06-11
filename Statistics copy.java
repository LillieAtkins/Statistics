import java.util.Scanner;

public class Statistics {

static Scanner scan = new Scanner(System.in);
static int length;
static int [] arr;
static int input = 1;
static int get_stats;

	public static void main(String[] args) {
		/*
		 This code calls the getIntegers(), getAverage(), getMax(), getMin(), getRange(), and getMode() 
		 methods in order to allow the user to input as many integers as he or she wants and then get 
		 information (max, min, range, mode, average) about the integers entered. The user can also press
		 0 at any time to enter new integers or press it again to quit.
		 */
		while(input == 1) {
			System.out.println("Enter postive integers(1) or quit(0)? ");
			input = scan.nextInt();
			get_stats = 1;
			if(input==1)
				getIntegers();
			while(get_stats != 0 && input==1) {
				System.out.println("Please choose an option:\n(1) average\n(2) maximum\n(3) minimum\n(4) range\n(5) mode\n(0) quit"); 
				get_stats = scan.nextInt();
				if(get_stats == 1) {
					System.out.println("Average is: " + getAverage(arr));
				}
				
				if(get_stats == 2) {
					System.out.println("Maximum is: " + getMax(arr));
				}
	
				if(get_stats == 3) {
					System.out.println("Minimum is: " + getMin(arr));
				}
					
				if(get_stats == 4) {
					System.out.println("Range is: " + getRange(arr));
				}
					
				if(get_stats== 5) {
					System.out.println("Mode is: " + getMode(arr));	
				}
					
			}
		}
		System.out.println("Goodbye!");
		
		scan.close();
	}
	
	/*
	 The following method takes a set of positive integers in from the user and returns an array.
	 */
	public static int[] getIntegers() {
		System.out.println("How many positive integers would you like to enter? ");
		length = scan.nextInt();
		arr = new int[length];
		for(int i = 1; i <= length; i++) {
			System.out.println("Please enter integer " + i + ":");
			arr[i-1] = scan.nextInt();
		}
		return arr;
	}
	
	
	/*
	 This method takes in an array of positive numbers and computes the average, which is returned as an integer.
	 */
	public static double getAverage(int[] array) {
		double sum = arr[0];
		for(int i = 1; i < length; i++) {
			sum+=arr[i];
		}
		double avg = sum/length;
		return avg;
			
	}
	
	
	/*
	 This method takes in an array of positive numbers and computes the maximum, which is returned as an integer.
	 */
	public static int getMax(int[] array) {
		int max = arr[0];
		for(int i = 1; i < length; i++) {
			if(max < arr[i])
				max = arr[i];
		}
		return max;
		
	}
	
	
	/*
	 This method takes in an array of positive numbers and computes the minimum, which is returned as an integer.
	 */
	public static int getMin(int[] array) {
		int min = arr[0];
		for(int i = 1; i < length; i++) {
			if(min > arr[i])
				min = arr[i];
		}
		return min;
	}
	
	
	/*
	 This method takes in an array of positive numbers and computes the range, which is returned as an integer.
	 */
	public static int getRange(int[] array) {
		int range = getMax(array) - getMin(array);
		return range;
	}
	
	
	/*
	 This method takes in an array of positive numbers and computes the mode, which is returned as an integer.
	 If there are no repeats or there is a tie then any of the integers may be returned.
	 */
	public static int getMode(int[] array) {
		int[] repeats = new int[200];
		for(int i = 0; i < length; i++) {
			repeats[array[i]]++;                           //counts how many repeats are for every number in array
		}
		int most_repeated = repeats[0];                    
		int mode = array[0];                               //in case there is a tie
		for(int j = 0; j < (repeats.length)-1; j++) {      //find which number is repeated the most
			if(most_repeated<repeats[j+1]) {
				most_repeated = repeats[j+1]; 
				mode = j+1;                               //mode is the index of the repeats array
			}
		}
		return mode;
		}

	
}
