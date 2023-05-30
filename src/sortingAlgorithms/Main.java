package sortingAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    	
	//method to create an array from console input
	public static int[] getInput() 
	{	
		Scanner scan = new Scanner(System.in);
		
		//receive array length from scanner and create array of corresponding length
		System.out.println("Please enter length of the array:");
		int[] array = new int[scan.nextInt()];

		//receive integer values and assign them to the array
		for (int i = 0; i < array.length; i++) {
			System.out.printf("Integer at Index %d: ", i);
			array[i] = scan.nextInt();
		}
		return array;
	}
	
	//method to find the maximum value (k) in an array
	public static int findMaxValue (int[] array)
	{
		//set initial value to smallest possible integer
		int maxValue = Integer.MIN_VALUE;
		
		//iterate over the array and assign maxValue in case maxValue < array[i]
		for (int i=0; i<array.length; i++)
		{
			if (array[i]>maxValue)
			{
				maxValue=array[i];
			}
		}
		return maxValue;
	}
	
	//method to print an array to the console
	public static void print(String prefix, int[] array) 
	{
		System.out.println("\n");
		System.out.println(prefix);
		System.out.println(Arrays.toString(array));
	}
	
	public static void main (String []args)
	{
		//store console input to "inputArray"
		int[] inputArray = getInput();
		
		//print input array
		print("Input Array:",inputArray);
		
		//print sorted array with Counting Sort (method counting sort returns new array)
		try
		{
			print("Sorted Array (Counting Sort):", Sort.countingSort(inputArray, findMaxValue(inputArray)));
		}
		catch(Exception e)
		{
			System.out.println("\n");
			System.out.println("Sorted Array (Counting Sort):");
			System.out.println("invalid input: Counting Sort works only for Integers btw. 0 and k");
		}
		
		//print sorted array with Quick Sort (method quick sort sorts "inputArray")
		Sort.quickSort(inputArray, 0, inputArray.length-1);
		print("Sorted Array (Quick Sort):",inputArray);
	
	}

}
