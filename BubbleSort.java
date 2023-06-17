
// Swap through each adjacent pair to build a sorted array at the end, and restart at the beginning until sorted
public class BubbleSort implements ISorter {
	
	public BubbleSort() {
	}
	
	public SortStats sort(int[] a) {
		long time = System.nanoTime();
		int compare = 0;
		int moves = 0;
		// Run through array
		for (int i = 0; i < a.length - 1; i++) {
			// Run through unsorted array
			for (int j = 0; j < a.length - 1 - i; j++) {
				compare++;
				if (a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					moves += 3;
				}
			}
		}
		return new SortStats(a, "Bubble", compare, moves, System.nanoTime() - time);
	}
}
