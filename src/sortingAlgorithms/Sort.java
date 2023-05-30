package sortingAlgorithms;

public class Sort {
	
	public static int partition (int[]array, int startidx, int endidx)
	{
		//last element of (sub)array becomes pivot
		int pivot = array[endidx];
		//store position of last element <= pivot
		int i = startidx-1;
		//iterate over array and sort into subarrays with elements <= pivot and elements > pivot
		for (int j=startidx; j<=endidx-1; j++)
		{		
			if (array[j]<=pivot)
			{
				i++;
				int temp = array[i];
				array[i]=array[j];
				array[j]=temp;
			}
		}
		//position pivot between the two subarrays
		int temp2=array[i+1];
		array[i+1]=array[endidx];
		array[endidx]=temp2;
		//return position of current pivot
		return i+1;
	}
	
	public static void quickSort(int[]array, int startidx, int endidx)
	{
		//call methods recursively until startidx=endidx
		if (startidx<endidx)
		{
			int pivotPosition = partition(array,startidx,endidx);
			quickSort(array,startidx,pivotPosition-1);
			quickSort(array,pivotPosition+1,endidx);
		}
	}
	
	public static int[] countingSort (int[]array, int maxValue)
	{
		int[] B = new int[array.length];
		int[] C = new int[maxValue+1];
		
		//store occurences of i in C[i]
		for (int i = 0; i<array.length; i++)
		
		{
			C[array[i]]++;
		}
		//store no. of elements <= i in C[i]
		for (int j = 1; j<C.length; j++)
		{
			C[j] += C[j-1];
		}
		//find the correct position in B[] for array[k] and insert values
		for (int k = array.length-1; k >= 0; k--)
		{
			B[C[array[k]]-1] = array[k];
			C[array[k]]--;
		}
		return B;
	}
}
