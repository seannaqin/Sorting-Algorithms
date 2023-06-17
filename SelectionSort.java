
// Sort by choosing the lowest value and swapping it with the lowest unsorted position
public class SelectionSort implements ISorter {
	
	public SelectionSort() {
	}
	
	public SortStats sort(int[] a) {
		long time = System.nanoTime(); 
		int index = 0;
		int compare = 0;
		int moves = 0;
		// Running through array
		for (int j = 0; j < a.length - 1; j++) {
			// Index for minimum integer
			index = j;
			// Find minimum integer
			for (int i = j+1; i < a.length; i++) {
				compare++;
				if (a[i] < a[index]) {
					index = i;
				}
			}
			// Add 2 moves if there is a swap, one for each integer during swap
			if (a[index] != a[j]) {
				moves += 3;
			}
			int temp = a[index];
			a[index] = a[j];
			a[j] = temp;
		}
		
		return new SortStats(a, "Selection", compare, moves, System.nanoTime() - time);
	}
}
