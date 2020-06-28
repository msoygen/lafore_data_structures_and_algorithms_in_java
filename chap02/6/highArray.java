// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray {
   private long[] a; // ref to array a
   private int nElems; // number of data items
   // -----------------------------------------------------------

   public HighArray(int max) // constructor
   {
      a = new long[max]; // create the array
      nElems = 0; // no items yet
   }

   // -----------------------------------------------------------
   public boolean find(long searchKey) { // find specified value
      int j;
      for (j = 0; j < nElems; j++) // for each element,
         if (a[j] == searchKey) // found item?
            break; // exit loop before end
      if (j == nElems) // gone to end?
         return false; // yes, can't find it
      else
         return true; // no, found it
   } // end find()
     // -----------------------------------------------------------

   public void insert(long value) // put element into array
   {
      a[nElems] = value; // insert it
      nElems++; // increment size
   }

   // -----------------------------------------------------------
   public boolean delete(long value) {
      int j;
      for (j = 0; j < nElems; j++) // look for it
         if (value == a[j])
            break;
      if (j == nElems) // can't find it
         return false;
      else // found it
      {
         for (int k = j; k < nElems; k++) // move higher ones down
            a[k] = a[k + 1];
         nElems--; // decrement size
         return true;
      }
   } // end delete()
     // -----------------------------------------------------------

   public void display() // displays array contents
   {
      for (int j = 0; j < nElems; j++) // for each element,
         System.out.print(a[j] + " "); // display it
      System.out.println("");
   }
   // -----------------------------------------------------------

   public long removeMax() {
      long maxVal = -1;

      for (int i = 0; i < nElems; i++) {
         if (a[i] > maxVal)
            maxVal = a[i];
      }

      delete(maxVal);

      return maxVal;
   }

   public void noDups() {
      int dupsCount = -1;
      for (int i = 0; i < this.nElems; i++) {
         for (int j = this.nElems - 1; j > 0; j--) {
            if (a[i] == a[j] && i != j) {
               a[i] = -1;
               dupsCount++;
               for (int k = i; k < nElems; k++) {
                  a[k] = a[k+1];
               }
            }
         }
      }

      this.nElems -= dupsCount;
   }
} // end class HighArray
  ////////////////////////////////////////////////////////////////

class HighArrayApp {
   public static void main(String[] args) {
      int maxSize = 100; // array size
      HighArray arr; // reference to array
      arr = new HighArray(maxSize); // create the array

      arr.insert(77); // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(66);
      arr.insert(33);

      System.out.println("Array:");
      arr.display();

      arr.noDups();
      System.out.println("No duplicates applied array:");
      arr.display();
   } // end main()
} // end class HighArrayApp