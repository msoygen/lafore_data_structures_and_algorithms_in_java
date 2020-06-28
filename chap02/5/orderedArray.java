import java.util.Random;

// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray {
   private long[] a; // ref to array a
   private int nElems; // number of data items
   // -----------------------------------------------------------

   public OrdArray(int max) // constructor
   {
      a = new long[max]; // create array
      nElems = 0;
   }

   // -----------------------------------------------------------
   public int size() {
      return nElems;
   }

   // -----------------------------------------------------------
   public int find(long searchKey) {
      int lowerBound = 0;
      int upperBound = nElems - 1;
      int curIn;

      while (true) {
         curIn = (lowerBound + upperBound) / 2;
         if (a[curIn] == searchKey)
            return curIn; // found it
         else if (lowerBound > upperBound)
            return nElems; // can't find it
         else // divide range
         {
            if (a[curIn] < searchKey)
               lowerBound = curIn + 1; // it's in upper half
            else
               upperBound = curIn - 1; // it's in lower half
         } // end else divide range
      } // end while
   } // end find()
     // -----------------------------------------------------------

   public void insert(long value) // put element into array
   {
      boolean isCurInSet = false;
      int lowerBound = 0;
      int upperBound = nElems - 1;
      int curIn;

      while (!isCurInSet) {
         curIn = (lowerBound + upperBound) / 2;
         if (lowerBound > upperBound)
            isCurInSet = true; // can't find it
         else // divide range
         {
            if (a[curIn] < value)
               lowerBound = curIn + 1; // it's in upper half
            else
               upperBound = curIn - 1; // it's in lower half
         } // end else divide range
      } // end while

      for (int k = nElems; k > lowerBound; k--) // move bigger ones up
         a[k] = a[k - 1];
      a[lowerBound] = value; // insert it
      nElems++; // increment size
   } // end insert()
     // -----------------------------------------------------------

   public boolean delete(long value) {
      int j = find(value);
      if (j == nElems) // can't find it
         return false;
      else // found it
      {
         for (int k = j; k < nElems; k++) // move bigger ones down
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

   public void merge(OrdArray source1, OrdArray source2) {
      int source1Size = source1.size() + 1;
      int source2Size = source2.size() + 1;
      int biggerSize, smallerSize;

      if (source1Size > source2Size) {
         biggerSize = source1Size;
         smallerSize = source2Size;

         for (int i = 0; i < smallerSize; i++) {
            long valSource1 = source1.getValueByIndex(i);
            long valSource2 = source2.getValueByIndex(i);
            System.out.println("val1Source: " + valSource1 + "\t" + "val2Source: " + valSource2 + "\t");
            if (valSource1 < valSource2) {
               insert(valSource1);
            }else{
               insert(valSource2);
            }
         }
   
         for (int i = smallerSize + 1; i < biggerSize; i++) {
            long valSource1 = source1.getValueByIndex(i);
               insert(valSource1);
         }
      } else {
         biggerSize = source2Size;
         smallerSize = source1Size;

         for (int i = 0; i < smallerSize; i++) {
            long valSource1 = source1.getValueByIndex(i);
            long valSource2 = source2.getValueByIndex(i);
            if (valSource1 < valSource2) {
               insert(valSource1);
            }else{
               insert(valSource2);
            }
         }
   
         for (int i = smallerSize + 1; i < biggerSize; i++) {
            long valSource2 = source2.getValueByIndex(i);
               insert(valSource2);
         }
      }

   }

   public long getValueByIndex(int index) {
      return a[index];
   }

} // end class OrdArray
  ////////////////////////////////////////////////////////////////

class OrderedApp {
   public static void main(String[] args) {
      int maxSize = 100; // array size
      OrdArray sourceArr1, sourceArr2, destArr; // reference to arrays
      sourceArr1 = new OrdArray(maxSize); // create the first source array
      sourceArr2 = new OrdArray(maxSize); // create the second source array
      destArr = new OrdArray(maxSize); // create the destination array
      Random rand = new Random();

      // generate arrays with random value and length
      for (int i = 0; i < rand.nextInt(100); i++) {
         sourceArr1.insert(Math.abs(rand.nextLong()) % 50); // inserts random positive values between 0 - 49
      }
      for (int i = 0; i < rand.nextInt(100); i++) {
         sourceArr2.insert(Math.abs(rand.nextLong()) % 50); // inserts random positive values between 0 - 49
      }

      System.out.println("Source Array 1: ");
      sourceArr1.display();
      System.out.println("Source Array 2: ");
      sourceArr2.display();

      destArr.merge(sourceArr1, sourceArr2);

      System.out.println("Destination Array 1: ");
      destArr.display();
   } // end main()
} // end class OrderedApp
