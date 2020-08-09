import java.util.ArrayList;
import java.util.List;

// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub {
	private long[] a; // ref to array a
	private int nElems; // number of data items
	// --------------------------------------------------------------

	public ArrayBub(int max) // constructor
	{
		a = new long[max]; // create the array
		nElems = 0; // no items yet
	}

	// --------------------------------------------------------------
	public void insert(long value) // put element into array
	{
		a[nElems] = value; // insert it
		nElems++; // increment size
	}

	// --------------------------------------------------------------
	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(a[j] + " "); // display it
		System.out.println("");
	}

	// --------------------------------------------------------------
	public double bubbleSort() {
		long startTime = System.nanoTime();

		int out, in;

		for (out = nElems - 1; out > 1; out--) // outer loop (backward)
			for (in = 0; in < out; in++) // inner loop (forward)
				if (a[in] > a[in + 1]) // out of order?
					swap(in, in + 1); // swap them

		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out
				.println("\n********\nExecution time in milliseconds : " + (double) timeElapsed / 1000000.00 + "\n********\n");

		return (double) timeElapsed / 1000000.00;
	} // end bubbleSort()
	// --------------------------------------------------------------

	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
	// --------------------------------------------------------------
} // end class ArrayBub
////////////////////////////////////////////////////////////////
// insertSort.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
// --------------------------------------------------------------

class ArrayIns {
	private long[] a; // ref to array a
	private int nElems; // number of data items
	// --------------------------------------------------------------

	public ArrayIns(int max) // constructor
	{
		a = new long[max]; // create the array
		nElems = 0; // no items yet
	}

	// --------------------------------------------------------------
	public void insert(long value) // put element into array
	{
		a[nElems] = value; // insert it
		nElems++; // increment size
	}

	// --------------------------------------------------------------
	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(a[j] + " "); // display it
		System.out.println("");
	}

	// --------------------------------------------------------------
	public double insertionSort() {
		long startTime = System.nanoTime();

		int in, out;

		for (out = 1; out < nElems; out++) // out is dividing line
		{
			long temp = a[out]; // remove marked item
			in = out; // start shifts at out
			while (in > 0 && a[in - 1] >= temp) // until one is smaller,
			{
				a[in] = a[in - 1]; // shift item to right
				--in; // go left one position
			}
			a[in] = temp; // insert marked item
		} // end for

		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out
				.println("\n********\nExecution time in milliseconds : " + (double) timeElapsed / 1000000.00 + "\n********\n");

		return (double) timeElapsed / 1000000.00;
	} // end insertionSort()
	// --------------------------------------------------------------
} // end class ArrayIns
////////////////////////////////////////////////////////////////
// selectSort.java
// demonstrates selection sort
// to run this program: C>java SelectSortApp
////////////////////////////////////////////////////////////////

class ArraySel {
	private long[] a; // ref to array a
	private int nElems; // number of data items
	// --------------------------------------------------------------

	public ArraySel(int max) // constructor
	{
		a = new long[max]; // create the array
		nElems = 0; // no items yet
	}

	// --------------------------------------------------------------
	public void insert(long value) // put element into array
	{
		a[nElems] = value; // insert it
		nElems++; // increment size
	}

	// --------------------------------------------------------------
	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(a[j] + " "); // display it
		System.out.println("");
	}

	// --------------------------------------------------------------
	public double selectionSort() {
		long startTime = System.nanoTime();

		int out, in, min;

		for (out = 0; out < nElems - 1; out++) // outer loop
		{
			min = out; // minimum
			for (in = out + 1; in < nElems; in++) // inner loop
				if (a[in] < a[min]) // if min greater,
					min = in; // we have a new min
			swap(out, min); // swap them
		} // end for(out)

		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out
				.println("\n********\nExecution time in milliseconds : " + (double) timeElapsed / 1000000.00 + "\n********\n");

		return (double) timeElapsed / 1000000.00;
	} // end selectionSort()
	// --------------------------------------------------------------

	private void swap(int one, int two) {
		long temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
	// --------------------------------------------------------------
} // end class ArraySel
////////////////////////////////////////////////////////////////

class SortComparisonApp {
	public static void main(String[] args) {
		int maxSize = 100;
		List<Double> executionTimesBub = new ArrayList<Double>();
		List<Double> executionTimesSel = new ArrayList<Double>();
		List<Double> executionTimesIns = new ArrayList<Double>();

		// array references
		ArrayBub arrBub;
		ArraySel arrSel;
		ArrayIns arrIns;

		// intializing objects with 100 items
		arrBub = new ArrayBub(maxSize);
		arrSel = new ArraySel(maxSize);
		arrIns = new ArrayIns(maxSize);

		for (int j = 0; j < maxSize; j++)
		// fill array with
		{
			// random numbers
			long n = (long) (java.lang.Math.random() * (maxSize - 1));
			arrBub.insert(n);
			arrSel.insert(n);
			arrIns.insert(n);
		}

		// bubble sort
		arrBub.display();
		executionTimesBub.add(arrBub.bubbleSort());
		arrBub.display();

		// selection sort
		arrSel.display();
		executionTimesSel.add(arrSel.selectionSort());
		arrSel.display();

		// insertion sort
		arrIns.display();
		executionTimesIns.add(arrIns.insertionSort());
		arrIns.display();

		maxSize = 10000;

		// intializing objects with 10 000 items
		arrBub = new ArrayBub(maxSize);
		arrSel = new ArraySel(maxSize);
		arrIns = new ArrayIns(maxSize);

		for (int j = 0; j < maxSize; j++)
		// fill array with
		{
			// random numbers
			long n = (long) (java.lang.Math.random() * (maxSize - 1));
			arrBub.insert(n);
			arrSel.insert(n);
			arrIns.insert(n);
		}

		// bubble sort
		arrBub.display();
		executionTimesBub.add(arrBub.bubbleSort());
		arrBub.display();

		// selection sort
		arrSel.display();
		executionTimesSel.add(arrSel.selectionSort());
		arrSel.display();

		// insertion sort
		arrIns.display();
		executionTimesIns.add(arrIns.insertionSort());
		arrIns.display();

		maxSize = 100000;

		// intializing objects with 100 000 items
		arrBub = new ArrayBub(maxSize);
		arrSel = new ArraySel(maxSize);
		arrIns = new ArrayIns(maxSize);

		for (int j = 0; j < maxSize; j++)
		// fill array with
		{
			// random numbers
			long n = (long) (java.lang.Math.random() * (maxSize - 1));
			arrBub.insert(n);
			arrSel.insert(n);
			arrIns.insert(n);
		}

		// bubble sort
		arrBub.display();
		executionTimesBub.add(arrBub.bubbleSort());
		arrBub.display();

		// selection sort
		arrSel.display();
		executionTimesSel.add(arrSel.selectionSort());
		arrSel.display();

		// insertion sort
		arrIns.display();
		executionTimesIns.add(arrIns.insertionSort());
		arrIns.display();

		// print execution times
		System.out.println("\nExecution times in miliseconds:\n");
		System.out.println("100 items");
		System.out.println("---------------------------------------------------------------");
		System.out.println("bubble sort: " + executionTimesBub.get(0) + "\nselection sort: " + executionTimesSel.get(0)
				+ "\ninsertion sort: " + executionTimesIns.get(0));
		System.out.println("---------------------------------------------------------------\n");

		System.out.println("10.000 items");
		System.out.println("---------------------------------------------------------------");
		System.out.println("bubble sort: " + executionTimesBub.get(1) + "\nselection sort: " + executionTimesSel.get(1)
				+ "\ninsertion sort: " + executionTimesIns.get(1));
		System.out.println("---------------------------------------------------------------\n");

		System.out.println("100.000 items");
		System.out.println("---------------------------------------------------------------");
		System.out.println("bubble sort: " + executionTimesBub.get(2) + "\nselection sort: " + executionTimesSel.get(2)
				+ "\ninsertion sort: " + executionTimesIns.get(2));
		System.out.println("---------------------------------------------------------------\n");
	} // end main()
} // end class SortComparisonApp
////////////////////////////////////////////////////////////////