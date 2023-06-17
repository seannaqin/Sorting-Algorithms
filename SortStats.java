
public class SortStats implements ISortStats {
	
	private int[] a = new int[5];
	private String algorithm;
	private int numItems;
	private int compare;
	private int moves;
	private long time;
	
	public SortStats(int[] a, String algorithm, int compare, int moves, long time) {
		this.a = a;
		this.algorithm = algorithm;
		this.numItems = a.length;
		this.compare = compare;
		this.moves = moves;
		this.time = time;
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public int getNumItems() {
		return numItems;
	}

	public int getNumComparisons() {
		return compare;
	}

	public int getNumMoves() {
		return moves;
	}

	public long getNumNanoseconds() {
		return time;
	}
	
	public String toString() {
		String print = "Algorithm \t: " + algorithm;
		print += "\nNumItems \t: " + numItems;
		print += "\nNumComparisons \t: " + compare;
		print += "\nNumMoves \t: " + moves;
		print += "\nNumNanoseconds \t: " + time;
		return print;
	}

}