package mergesort;

public class MergeSort {

	public static void main(String[] args) {
		int[] array1 = {11,43,87,27,54,8,32,71,44,12};
		
		
		showArray(array1);
//		array1 = split(array1, 0, array1.length - 1);
		mergeSort(array1);
		showArray(array1);
		
	}
	
	public static void showArray(int[] theArray) {
		int index;
		
		System.out.printf("[");
		for(index=0;index<theArray.length;index++) {
			if(index!=0) {
				System.out.printf(", ");
			}
			System.out.printf("%d",theArray[index]);
		}
		System.out.printf("]\n");
	}
	

	
	private static void mergeSort(int[] theArray, int left, int right) {
		//**************************************************************
		//*  Recursive Merge Sort                                      *
		//*------------------------------------------------------------*
		//*  1. Divide or partition the array section into 2 halves.   *
		//*  2. Create a subArray for each partition (half)            *
		//*  3. Merge the two subArrays to create one sorted array     *
		//*  4. Replace the original array section with the merged     *
		//*     array.                                                 *
		//**************************************************************
		if(right >= left) {
			int mid = (right - left ) / 2;
			int nextMid = mid + 1;
			mergeSort(theArray, left, mid);
			mergeSort(theArray, nextMid, right);
		}
	}
	
	public static void mergeSort(int[] array) {
		//**********************************************
		//*  Class Wrapper for the recursive mergeSort *
		//**********************************************
		mergeSort(array,0,array.length-1);
	}
	
	public static int[] split(int[] array, int left, int right) {
		int[] newArray = new int[right - left];
		int count = 0;
		for(int i = left; i < right; i++) {
			newArray[count] = array[i];
			count++;
		}
		return newArray;
	}
}
