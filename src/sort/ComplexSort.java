package sort;

/**
 * Complex sort.
 *
 * @author 55jphillip
 */
public class ComplexSort {

    public static void mergeSort(int[] a, String direction) {
        int nElems = a.length;
        int[] workSpace = workSpace = new int[nElems];
        recMergeSort(a, direction, workSpace, 0, nElems - 1);
    }

    public static void recMergeSort(int[] a, String direction, int[] workSpace,
            int lowerBound, int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;
            recMergeSort(a, direction, workSpace, lowerBound, mid);
            recMergeSort(a, direction, workSpace, mid + 1, upperBound);
            merge(a, direction, workSpace, lowerBound, mid + 1, upperBound);
        }
    }

    public static void merge(int[] a, String direction, int[] workSpace,
            int lowPtr, int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (a[lowPtr] < a[highPtr] && direction.equalsIgnoreCase("A")
                    || a[lowPtr] > a[highPtr] && direction.equalsIgnoreCase("D")) {
                workSpace[j++] = a[lowPtr++];
            } else {
                workSpace[j++] = a[highPtr++];
            }
        }
        while (lowPtr <= mid) {
            workSpace[j++] = a[lowPtr++];
        }
        while (highPtr <= upperBound) {
            workSpace[j++] = a[highPtr++];
        }
        for (j = 0; j < n; j++) {
            a[lowerBound + j] = workSpace[j];
        }
    }
//--------------------------------------------------------------------------------

    public static void swap(int A[], int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }

    // Reorganizes the given list so all elements less than the first are 
    // before it and all greater elements are after it.                   
    public static int partition(int A[], int f, int l) {
  
            int pivot = A[f];
            while (f < l) {
                if (A[f] == pivot || A[l] == pivot) {

                }
                while (A[f] < pivot) {
                    f++;
                }
                while (A[l] > pivot) {
                    l--;
                }
                swap(A, f, l);
            
            } 


        return f;
    }

    public static void quickSort(int A[], int f, int l) {

        if (f >= l) {
            return;
        }
        int pivot_index = partition(A, f, l);
        quickSort(A, f, pivot_index);
        quickSort(A, pivot_index + 1, l);

    }

    // Usage: java QuickSort [integer] ...
    // All integers must be distinct
    public static void main(String argv[]) {
        int A[] = new int[argv.length];
        for (int i = 0; i < argv.length; i++) {
            A[i] = Integer.parseInt(argv[i]);
        }

        quickSort(A, 0, argv.length - 1);

        for (int i = 0; i < argv.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

}
