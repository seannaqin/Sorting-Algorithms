
/* Seanna Qin P.1
 * Programming Assignment #13, 4/24/23
 * The purpose of this program is to test different sorting algorithms against varying lengths and arrangements
 * of integer arrays.
 */

import java.util.*;

public class Program {
	static BubbleSort bubble = new BubbleSort();
	static SelectionSort selection = new SelectionSort();
	static InsertionSort insertion = new InsertionSort();
	static MergeSort merge = new MergeSort();
	
	public static void main(String[] args) {
		diffSize();
		System.out.println();
		sorted();
		System.out.println();
		backwards();
	}
	
	// Test arrays from sizes ranging 2 to 4096, doubling in size
	public static void diffSize() {
		Random r = new Random();
		Check checker = new Check();
		for (int i = 2; i <= 4096; i *= 2) { 
			int[] test = new int[i];
			// Create test array
			for (int j = 0; j < i; j++) {
				test[j] = r.nextInt(10000);
			}
			// Sort the copy and reset
			int[] copy = createNew(test);
			System.out.println(bubble.sort(copy).toString());
			System.out.println(checker.isInOrder(copy));
			
			copy = createNew(test);
			System.out.println(selection.sort(copy).toString());
			System.out.println(checker.isInOrder(copy));
			
			copy = createNew(test);
			System.out.println(insertion.sort(copy).toString());
			System.out.println(checker.isInOrder(copy));
			
			copy = createNew(test);
			System.out.println(merge.sort(copy).toString());
			System.out.println(checker.isInOrder(copy));
		}
	}
	// Test an already sorted array
	public static void sorted() {
		int[] test = new int[4096];
		Check checker = new Check();
		
		for (int i = 0; i < test.length; i++) {
			test[i] = i;
		}
		
		int[] copy = createNew(test);
		System.out.println(bubble.sort(copy).toString());
		System.out.println(checker.isInOrder(copy));
		
		System.out.println(selection.sort(copy).toString());
		System.out.println(checker.isInOrder(copy));
		
		System.out.println(insertion.sort(copy).toString());
		System.out.println(checker.isInOrder(copy));
		
		System.out.println(merge.sort(copy).toString());
		System.out.println(checker.isInOrder(copy));
	}
	
	// Test a reverse sorted array
	public static void backwards() {
		int[] test = new int[4096];
		Check checker = new Check();
		
		for (int i = 0; i < test.length; i++) {
			test[i] = test.length - i;
		}
		
		int[] copy = createNew(test);
		System.out.println(bubble.sort(copy).toString());
		System.out.println(checker.isInOrder(copy));

		copy = createNew(test);
		System.out.println(selection.sort(copy).toString());
		System.out.println(checker.isInOrder(copy));
		
		copy = createNew(test);
		System.out.println(insertion.sort(copy).toString());
		System.out.println(checker.isInOrder(copy));
		
		copy = createNew(test);
		System.out.println(merge.sort(copy).toString());
		System.out.println(checker.isInOrder(copy));
	}
	
	private static int[] createNew(int[] a) {
		int[] copy = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			copy[i] = a[i];
		}
		return copy;
	}
}
