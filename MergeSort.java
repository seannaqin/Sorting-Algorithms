
public class MergeSort implements ISorter {
	
	public MergeSort() {
	}
	
	public SortStats sort(int[] a) {
		long time = System.nanoTime();
		int[] counter = new int[2];
		// Call recursive method
		sortMain(a, 0, a.length-1, counter); 
		return new SortStats(a, "Merge", counter[0], counter[1], System.nanoTime() - time);
	}
	
	// Recursive method that splits the arrays and then calls a merge method
	private void sortMain(int[] a, int first, int last, int[] counter) {
		// Base case to make sure there are still numbers to split
		if (first < last) {
			int middle = first + (last-first) / 2;
			
			// Left half of split
			sortMain(a, first, middle, counter);
			// Right half of split
			sortMain(a, middle+1, last, counter);
			
			// Merge arrays
			merger(a, first, middle, last, counter);
		}
		
	}
	
	private void merger(int[] a, int first, int middle, int last, int[] counter) {
		
		// Create temporary left and right arrays
		int[] left = new int[middle-first+1];
		int[] right = new int[last-middle];
		
		// Fill in temporary arrays
		for (int i = 0; i < left.length; i++) {
			left[i] = a[first + i];
			counter[1]++;
		}
		for (int i = 0; i < right.length; i++) {
			right[i] = a[i+middle+1];
			counter[1]++;
		}
		
		int leftI = 0;
		int rightI = 0;
		int finalI = first;
		
		// When there are still integers in both arrays, compare and sort
		while (leftI < left.length && rightI < right.length) {
			counter[0]++;
			if (left[leftI] <= right[rightI]) {
				a[finalI] = left[leftI];
				leftI++;
			}
			else {
				a[finalI] = right[rightI];
				rightI++;
			}
			finalI++;
			counter[1]++;
		}
		
		while (leftI < left.length) {
			a[finalI] = left[leftI];
			finalI++;
			leftI++;
			counter[1]++;
		}
		
		while (rightI < right.length) {
			a[finalI] = right[rightI];
			finalI++;
			rightI++;
			counter[1]++;
		}

	}
}
