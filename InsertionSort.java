
// Swap each consecutive pair and cover all pairs behind if possible to bring the smallest numbers to the front first
public class InsertionSort implements ISorter {
	
	public InsertionSort() {
	}
	
	public SortStats sort(int[] a) {
		long time = System.nanoTime();
		int compare = 0;
		int moves = 0;
		// Run through array
		for (int i = 0; i < a.length - 1; i++) {
			int j = i;
			// Check and swap until there are no more integers to the left
			while (j >= 0) {
				compare++;
				// Swap if the next term is smaller than the current
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					moves += 3;
				}
				j--;
			}
		}
		
		return new SortStats(a, "Insertion", compare, moves, System.nanoTime() - time);
	}
}