package mergesort;

public class MergeSort {

	public static void main(String[] args) {
		int[] array1 = {11,43,87,27,54,8,32,71,44,12};
		
		
		showArray(array1);
//		array1 = split(array1, 0, array1.length - 1);
		array1 = mergeSort(array1);
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
	

	
	private static int[] mergeSort(int[] theArray, int left, int right) {
		//**************************************************************
		//*  Recursive Merge Sort                                      *
		//*------------------------------------------------------------*
		//*  1. Divide or partition the array section into 2 halves.   *
		//*  2. Create a subArray for each partition (half)            *
		//*  3. Merge the two subArrays to create one sorted array     *
		//*  4. Replace the original array section with the merged     *
		//*     array.                                                 *
		//**************************************************************
		if(left != right) {
			int mid = (left + right) / 2;
			int nextMid = mid + 1;
			
			int[] leftHalf = mergeSort(theArray, left, mid);
			int[] rightHalf = mergeSort(theArray, nextMid, right);

			return merge(leftHalf, rightHalf);
		}else {
			return split(theArray, left, left);
		}
	}
	
	public static int[] mergeSort(int[] array) {
		//**********************************************
		//*  Class Wrapper for the recursive mergeSort *
		//**********************************************
		return mergeSort(array,0,array.length-1);
	}
	
	public static int[] merge(int[] leftSide, int[] rightSide) {
		int[] newList = new int[leftSide.length + rightSide.length];
		int l = 0, r = 0, count = 0;
		
		while(l < leftSide.length || r < rightSide.length) {
			if(l == leftSide.length) {
				newList[count++] = rightSide[r++];
			}else if( r == rightSide.length) {
				newList[count++] = leftSide[l++];
			}else if(leftSide[l] < rightSide[r]) {
				newList[count++] = leftSide[l++];
			}else {
				newList[count++] = rightSide[r++];
			}
		}
		return newList;
		
	}
	
	public static int[] split(int[] array, int left, int right) {
		int[] newArray = new int[right - left + 1];
		int count = 0;
		for(int i = left; i <= right; i++) {
			newArray[count] = array[i];
			count++;
		}
		return newArray;
	}
}
